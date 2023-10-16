package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dtos.SongAddDto;
import com.example.spotifyplaylistapp.model.dtos.SongView;
import com.example.spotifyplaylistapp.model.entity.SongEntity;
import com.example.spotifyplaylistapp.model.entity.UserEntity;
import com.example.spotifyplaylistapp.model.enums.StyleConstant;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongServiceImp {

    private final SongRepository songRepository;
    private final StyleRepository styleRepository;
    private final UserRepository userRepository;

    public void addSong(SongAddDto songAddDto) {
        SongEntity entity = songAddDto.toSongEntity();
        entity.setStyle(styleRepository.findByName(songAddDto.getStyle()).orElseThrow());
        songRepository.save(entity);
    }

    @Transactional
    public Set<SongView> getRockViewSongs() {
        return songRepository.findAll()
                .stream()
                .filter(songEntity -> songEntity.getStyle().getName().equals(StyleConstant.ROCK))
                .map(SongView::new)
                .collect(Collectors.toSet());
    }
    @Transactional
    public Set<SongView> getJazzViewSongs() {
        return songRepository.findAll()
                .stream()
                .filter(songEntity -> songEntity.getStyle().getName().equals(StyleConstant.JAZZ))
                .map(SongView::new)
                .collect(Collectors.toSet());
    }
    @Transactional
    public Set<SongView> getPopViewSongs() {
        return songRepository.findAll()
                .stream()
                .filter(songEntity -> songEntity.getStyle().getName().equals(StyleConstant.POP))
                .map(SongView::new)
                .collect(Collectors.toSet());
    }

    @Transactional
    public void promoteSong(Long songId, Long userId) {
        SongEntity song = songRepository.findById(songId).orElseThrow();
        UserEntity user = userRepository.findById(userId).orElseThrow();

        user.getSongs().add(song);
        List<SongEntity> collect = user.getSongs()
                .stream()
                .distinct()
                .collect(Collectors.toList());
        user.setSongs(collect);
        userRepository.save(user);
    }

    @Transactional
    public void removeAllSongFromUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();

        user.getSongs().clear();
        userRepository.save(user);
    }
}
