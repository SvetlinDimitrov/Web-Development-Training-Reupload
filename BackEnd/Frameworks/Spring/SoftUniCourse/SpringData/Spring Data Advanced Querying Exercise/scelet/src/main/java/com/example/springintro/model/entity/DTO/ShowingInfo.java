package com.example.springintro.model.entity.DTO;

import com.example.springintro.model.entity.Enum.AgeRestriction;
import com.example.springintro.model.entity.Enum.EditionType;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Objects;


public class ShowingInfo {


    private String title;

    private AgeRestriction ageRestriction;

    private EditionType editionType;


    private BigDecimal price;

    public ShowingInfo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ShowingInfo(String title, AgeRestriction ageRestriction, EditionType editionType, BigDecimal price) {
        this.title = title;
        this.ageRestriction = ageRestriction;
        this.editionType = editionType;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowingInfo that = (ShowingInfo) o;
        return Objects.equals(title, that.title) && ageRestriction == that.ageRestriction && editionType == that.editionType && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, ageRestriction, editionType, price);
    }
}
