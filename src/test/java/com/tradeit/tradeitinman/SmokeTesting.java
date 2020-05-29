package com.tradeit.tradeitinman;
import com.tradeit.tradeitinman.restcontroller.UserRestController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SmokeTesting {

    @Autowired
    private UserRestController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    private MockMvc mockMvc;

    @Test
    public void defaultPage() throws Exception {
        this.restTemplate.withBasicAuth("dani", "dani");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Markets");
    }

    @Test
    public void whenAccessingArtRestControllerAllArtsShouldBeFetched () throws Exception {
        //when pages contains idArt => json content is available
        this.restTemplate.withBasicAuth("dani", "dani");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/Art", String.class).contains("idArt"));
    }

    @Test
    public void whenPuttingABorsenplatzItGetsUpdated () throws Exception {
        this.restTemplate.withBasicAuth("dani", "dani");

        long id = 1;
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.put("/boerse/" + id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(getBorseinJson(1));

        //when pages contains idArt => json content is available
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/Art", String.class).contains("idArt"));
    }

    private String getBorseinJson(long id) {
        return "{\"id\":\"" + id + "\", \"content\":\"test data\"}";
    }

}