package com.example.demopicturesaveanddownload.repos;

import com.example.demopicturesaveanddownload.model.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<PictureEntity , Long> {
}
