package com.tradeit.tradeitinman;
import com.tradeit.tradeitinman.restcontroller.UserRestController;
import org.junit.jupiter.api.*;

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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    /**
     * This test will only work when borsenplatz is available
     * @throws Exception
     */
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

    /**
     * Execute this test when databases are dropped! (only then it works fine)
     * junit should not have a specific run order since this would mean that test cases are
     * dependent on each other. each test should be able to be executed as a standalone test
     *
     * however for testing reasons and implementing a new framework we added a fixed execution
     * order to the junit tests (as well junit does not encourage devs to do this)
     *
     * @throws Exception
     */
    @Test
    @Order(1)
    public void afterDroppingAllTablesTradesShouldBeEmpty() throws Exception{

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/findAllTrades")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8");
        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[]")).andDo((MockMvcResultHandlers.print()));

    }

    @Test
    public void whenTablesAreEmptyAndDataLoaderIsExecutedTradesShouldContainData() throws Exception{

        //init dataset 1
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/dataloader")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8");
        this.mockMvc.perform(builder);

        //init dataset 2 (get requests because data is being posted programmatically -> no post needed)
        builder = MockMvcRequestBuilders.get("/dataloader2")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8");
        this.mockMvc.perform(builder);

        //check if data is correct
        builder = MockMvcRequestBuilders.get("/findAllTrades")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8");
        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("[{\"titel\":\"Microsoft\",\"user\":\"dani el\",\"datum\":\"2020-04-15T22:00:00.000+00:00\",\"invested\":1000,\"take_profit\":125,\"stop_loss\":25,\"preis\":123.78,\"units\":5,\"current\":56.22,\"currentPreis\":180.0,\"calcChange\":\"45.42%\"},{\"titel\":\"AMD\",\"user\":\"dani el\",\"datum\":\"2020-04-15T22:00:00.000+00:00\",\"invested\":1000,\"take_profit\":125,\"stop_loss\":25,\"preis\":42.49,\"units\":5,\"current\":-25.98,\"currentPreis\":16.51,\"calcChange\":\"-61.14%\"}]"))
                .andDo(MockMvcResultHandlers.print());

    }

}