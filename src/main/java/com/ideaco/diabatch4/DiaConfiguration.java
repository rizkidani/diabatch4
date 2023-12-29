package com.ideaco.diabatch4;

import com.ideaco.diabatch4.service.FileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiaConfiguration {

    @Bean
    public FileService createFileService(){
        return new FileService();
    }
}
