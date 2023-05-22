package com.ltp.globalsuperstore.Configuration;

import com.ltp.globalsuperstore.repository.StoreRepository;
import com.ltp.globalsuperstore.service.StoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfiguration {

    @Bean
    public StoreRepository createStoreRepository(){
        return new StoreRepository();
    }
    @Bean
    public StoreService createStoreService(){
        return new StoreService(createStoreRepository());
    }
}
