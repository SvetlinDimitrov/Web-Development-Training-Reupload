package com.example.spring_mapper_exercise.domain.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.example.spring_mapper_exercise.domain.enums.CONSTANTS.*;


@NoArgsConstructor
@Getter
public class GameAddDto {
    private String title;
    private BigDecimal price;
    private BigDecimal size;
    private String trailer;
    private String imageThumbnail;
    private String description;
    private LocalDate releaseDate;

    public GameAddDto(String title, String price, String size, String trailer, String thumbnailURL, String description, String releaseDate) {
        setTitle(title);
        setPrice(price);
        setSize(size);
        setTrailer(trailer);
        setThumbnailURL(thumbnailURL);
        setDescription(description);
        setReleaseDate(releaseDate);
    }

    public void setTitle(String title) {
        boolean upperCaseFirstLatter = Character.isUpperCase(title.charAt(0));
        boolean titleLength = title.length() >= 3 && title.length() <= 100;

        if(upperCaseFirstLatter && titleLength){
            this.title = title;
            return;
        }
        throw new IllegalArgumentException(GAME_CREATION_WRONG_TITLE);
    }

    public void setPrice(String rowPrice) {
        BigDecimal price = new BigDecimal(rowPrice);
        boolean validPrice = price.compareTo(BigDecimal.ZERO) >= 0;
        if(validPrice){
            this.price = price;
            return;
        }
        throw new IllegalArgumentException(GAME_CREATION_WRONG_PRICE);
    }

    public void setSize(String rowSize) {
        BigDecimal size = new BigDecimal(rowSize);
        boolean validSize = size.compareTo(BigDecimal.ZERO) >= 0;
        if(validSize){
            this.size = size;
            return;
        }
        throw new IllegalArgumentException(GAME_CREATION_WRONG_SIZE);
    }

    public void setTrailer(String trailer) {
        if(trailer.length() == 11){
            this.trailer = trailer;
            return;
        }
        throw new IllegalArgumentException(GAME_CREATION_WRONG_TRAILER);
    }

    public void setThumbnailURL(String thumbnailURL) {
        boolean firstCondition = thumbnailURL.startsWith("http://");
        boolean secondCondition = thumbnailURL.startsWith("https://");
        if(firstCondition || secondCondition){
            this.imageThumbnail = thumbnailURL;
            return;
        }
        throw new IllegalArgumentException(GAME_CREATION_WRONG_URL);
    }

    public void setDescription(String description) {
        if(description.length() >= 20){
            this.description = description;
            return;
        }
        throw new IllegalArgumentException(GAME_CREATION_WRONG_DESCRIPTION);
    }

    public void setReleaseDate(String rowReleaseDate) {
        String[] arr = rowReleaseDate.split("-");
        int day = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);
        this.releaseDate = LocalDate.of(year, month, day);
    }
}
