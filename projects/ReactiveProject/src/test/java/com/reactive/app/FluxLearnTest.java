package com.reactive.app;

import com.reactive.app.service.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FluxLearnTest {

    @Autowired
    private FluxLearnService fluxLearnService;

    @Test
    void testing(){
        this.fluxLearnService.fluxTestingService();
    }

}
