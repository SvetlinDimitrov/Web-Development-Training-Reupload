package com.example.pathfinder.service.route;

import com.example.pathfinder.repos.RouteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RouteServiceImpl implements RouteService {
    private RouteRepository routeRepository;
}
