package com.example.pathfinder.repos;

import com.example.pathfinder.domain.entity.Categorie;
import com.example.pathfinder.domain.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query("select r from Route r join r.roles c where c = :categorie")
    List<Route> findAllByCategories(Categorie categorie);
}
