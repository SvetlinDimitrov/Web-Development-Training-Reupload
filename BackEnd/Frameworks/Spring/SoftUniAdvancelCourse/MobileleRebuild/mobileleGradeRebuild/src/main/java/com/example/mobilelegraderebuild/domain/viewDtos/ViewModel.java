package com.example.mobilelegraderebuild.domain.viewDtos;

import com.example.mobilelegraderebuild.domain.constants.ModelCategory;
import com.example.mobilelegraderebuild.domain.entity.Brand;
import lombok.*;
import com.example.mobilelegraderebuild.domain.entity.Model;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewModel {

    private String id;
    private String name;
    private ModelCategory category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    private LocalDate created;
    private LocalDate modified;
    private Brand brand;

    public ViewModel(Model model) {
        this.id = model.getId();
        this.name = model.getName();
        this.category = model.getCategory();
        this.imageUrl = model.getImageUrl();
        this.startYear = model.getStartYear();
        this.endYear = model.getEndYear();
        this.created = model.getCreated();
        this.modified = model.getModified();
        this.brand = model.getBrand();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewModel viewModel = (ViewModel) o;
        return Objects.equals(id, viewModel.id) && Objects.equals(name, viewModel.name) && category == viewModel.category && Objects.equals(imageUrl, viewModel.imageUrl) && Objects.equals(startYear, viewModel.startYear) && Objects.equals(endYear, viewModel.endYear) && Objects.equals(created, viewModel.created) && Objects.equals(modified, viewModel.modified) && Objects.equals(brand, viewModel.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, imageUrl, startYear, endYear, created, modified, brand);
    }
}
