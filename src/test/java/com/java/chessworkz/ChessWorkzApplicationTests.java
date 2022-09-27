package com.java.chessworkz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@EnableJpaRepositories(basePackages = {"com.java.chessworkz"})
class ChessWorkzApplicationTests {

    @Test
    void contextLoads() {
    }

}
