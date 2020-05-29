package com.tradeit.tradeitinman;
import com.tradeit.tradeitinman.restcontroller.UserRestController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @BeforeAll
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

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

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"idBoersenplatz\":" + id + ",\"name\":\"Hongkong Stock Exchange\",\"kuerzel\":\"HKG\",\"idCountry\":\"China\"}"))
                .andDo(MockMvcResultHandlers.print());
    }

    private String getBorseinJson(long id) {
        return "{\"idBoersenplatz\":\"" + id + "\", \"name\":\"Hongkong Stock Exchange\", \"kuerzel\":\"HKG\", \"idCountry\":\"China\"}";
    }

}