package com.example.pathfinder.domain.bindingViews;


import com.example.pathfinder.domain.entity.Picture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewPictures {

    private Long id;
    private String title;
    private String url;

    public ViewPictures(Picture picture) {
        this.id = picture.getId();
        this.title = picture.getTitle();
        this.url = picture.getUrl();
    }
}
