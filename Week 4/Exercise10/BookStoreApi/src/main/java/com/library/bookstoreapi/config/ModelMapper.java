package com.library.bookstoreapi.config;

import org.springframework.context.annotation.Bean;


public class ModelMapper {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
