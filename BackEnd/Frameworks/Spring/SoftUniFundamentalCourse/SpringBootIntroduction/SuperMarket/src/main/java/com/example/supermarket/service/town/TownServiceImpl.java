package com.example.supermarket.service.town;

import com.example.supermarket.repos.TownRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TownServiceImpl implements TownService {
    private TownRepository townRepository;
}
