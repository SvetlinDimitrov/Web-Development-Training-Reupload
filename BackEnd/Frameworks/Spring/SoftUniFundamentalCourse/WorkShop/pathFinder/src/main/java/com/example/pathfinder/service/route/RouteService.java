package com.example.pathfinder.service.route;

import com.example.pathfinder.domain.bindingViews.ViewRoute;
import com.example.pathfinder.domain.dtos.RegisterRouteDto;

import java.io.IOException;
import java.util.List;

public interface RouteService {
    List<ViewRoute> getAllRoutesByUserId(Long userId);

    ViewRoute getViewRouteById(Long id);

    void saveRote(RegisterRouteDto registerRouteDto, Long id) throws IOException;

    List<ViewRoute> getAllViewRoutes();

    ViewRoute getMostCommendViewRoute();

    List<ViewRoute> getAllViewRoutesByCategoryConstOriginalId(Integer level);
}
