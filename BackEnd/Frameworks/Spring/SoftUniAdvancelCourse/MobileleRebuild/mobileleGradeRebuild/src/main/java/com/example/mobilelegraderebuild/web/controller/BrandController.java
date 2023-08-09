package com.example.mobilelegraderebuild.web.controller;

import com.example.mobilelegraderebuild.domain.viewDtos.ViewModel;
import com.example.mobilelegraderebuild.service.Model.ModelService;
import com.example.mobilelegraderebuild.web.constants.BaseModelAndView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/brands/all")
@AllArgsConstructor
public class BrandController extends BaseModelAndView {

    private ModelService modelService;

    @GetMapping
    public ModelAndView getAllModels(ModelAndView modelAndView){
        Map<String , List<ViewModel>> brandMap= modelService.getAllModelsWithCorrespondingModels();
        modelAndView.addObject("allBrands" , brandMap);
        modelAndView.setViewName("brands");
        return modelAndView;
    }
}
