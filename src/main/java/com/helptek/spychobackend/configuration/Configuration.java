package com.helptek.spychobackend.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Configuration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper() ;
    }
}
