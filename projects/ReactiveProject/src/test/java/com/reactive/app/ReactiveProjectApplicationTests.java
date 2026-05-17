package com.reactive.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.util.Objects;
import java.util.function.Consumer;

@SpringBootTest
class ReactiveProjectApplicationTests {

	@Test
	void contextLoads() {
	}

    @Test
    void workingWithMono(){
        // Mono -> publisher having 0 or 1 item

//        Mono<Objects> errorMono = Mono.error(new RuntimeException("Error !!"));
//
//        Mono<Objects> m1 = Mono
//                .just("learnig reactive programmming")
//                .then(errorMono)
//                .log();
//
//        // consume mono by subscribing
//        m1.subscribe(System.out::println);
//        errorMono.subscribe(System.out::println);
        System.out.println("Mono Started");

        Mono<String> m1 = Mono
                .just("learnig reactive programmming")
                .log();
        Mono<String> m2 = Mono
                .just("subscribe reactive programmming")
                .log();
        Mono<Integer> m3 = Mono.just(12344);

        // return same mono wuth data
        Mono<String> resultMapMono = m1.map(String::toUpperCase);
        resultMapMono.subscribe(System.out::println);

        // its return another mono
        Mono<String[]> flatMap = m1.flatMap(valueM1 -> Mono.just(valueM1.split(" ")));
        flatMap.subscribe(result -> {
            for (String st : result){
                System.out.println(st);
            }
        });

        // zip and zipWith
//        Mono<Tuple3<String, String,Integer>> tuple2Mono = Mono.zip(m1, m2,m3);
//
//        tuple2Mono.subscribe(data -> {
//            System.out.println(data);
//            System.out.println(data.getT1());
//            System.out.println(data.getT2());
//        });
//
//        Mono<Tuple2<String, String>> tuple2Mono1 = m1.zipWith(m2);
//        tuple2Mono1.subscribe(data -> {
//            System.out.println(data);
//        });
    }

}
