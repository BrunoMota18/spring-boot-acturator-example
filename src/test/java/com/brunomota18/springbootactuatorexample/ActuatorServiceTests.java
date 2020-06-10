package com.brunomota18.springbootactuatorexample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.brunomota18.springbootactuatorexample.controller.HelloWorldController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ActuatorServiceTests {

    @Autowired
    private HelloWorldController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/hello-world", String.class))
                .contains("\"content\":\"Hello Stranger\"");
    }

    @Test
    public void greetingShouldReturnNamedMessage() throws Exception {
        assertThat(
                this.restTemplate.getForObject("http://localhost:" + port + "/hello-world?name=Fulano", String.class))
                        .contains("\"content\":\"Hello Fulano\"");
    }

}
