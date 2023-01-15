package com.java.chessworkz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@EnableJpaRepositories(basePackages = { "com.java.chessworkz" })
@TestPropertySource(locations = "classpath:test.properties")
class ChessWorkzApplicationTests {

    @Test
    void contextLoads() {
    }

}
