package com.example.pathfinder.service.route;

import com.example.pathfinder.domain.bindingViews.ViewRoute;
import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.dtos.RegisterRouteDto;
import com.example.pathfinder.domain.entity.Categorie;
import com.example.pathfinder.domain.entity.Route;
import com.example.pathfinder.repos.RouteRepository;
import com.example.pathfinder.repos.UserRepository;
import com.example.pathfinder.service.category.CategoryService;
import com.example.pathfinder.service.user.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.RouteMatcher;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RouteServiceImpl implements RouteService {
    private RouteRepository routeRepository;
    private UserService userService;
    private CategoryService categoryService;
    private ModelMapper mapper;


    @Transactional
    @Override
    public List<ViewRoute> getAllRoutesByUserId(Long userId) {
        return userService.findById(userId).getRoute()
                .stream()
                .map(r->mapper.map(r, ViewRoute.class))
                .toList();
    }

    @Override
    @Transactional
    public ViewRoute getViewRouteById(Long id) {
        return mapper.map(routeRepository.findById(id).orElseThrow() , ViewRoute.class);
    }

    @Override
    public void saveRote(RegisterRouteDto registerRouteDto, Long id) throws IOException {
        Route routeToSave = mapper.map(registerRouteDto, Route.class);

        routeToSave.setGpxCoordinates(new String(registerRouteDto.getGpxCoordinates().getBytes()));

        routeToSave.setRoles(categoryService.getAllCategories()
                .stream()
                .filter(c->registerRouteDto.getCategories().contains(c.getName()))
                .map(c->mapper.map(c , Categorie.class))
                .collect(Collectors.toSet()));

        routeToSave.setAuthor(userService.findById(id));

        routeRepository.save(routeToSave);

    }

    @Override
    @Transactional
    public List<ViewRoute> getAllViewRoutes() {
        return routeRepository.findAll()
                .stream()
                .map(r->mapper.map(r,ViewRoute.class))
                .toList();
    }

    @Override
    public ViewRoute getMostCommendViewRoute() {
        return null;
    }

    @Override
    @Transactional
    public List<ViewRoute> getAllViewRoutesByCategoryConstOriginalId(Integer level) {
        CategoryConstant categoryConstant = CategoryConstant.values()[level];
        Categorie category = categoryService.findByCategoryConstant(categoryConstant);

        return routeRepository.findAllByCategories(category)
                .stream()
                .map(r->mapper.map(r , ViewRoute.class))
                .toList();
    }
}
