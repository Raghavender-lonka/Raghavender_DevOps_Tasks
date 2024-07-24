package com.example.SpringHelloWorld;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloService.class)
public class HelloServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Hello World! Welcome to Unity Demo!")))
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Current server time is:")))
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Visit <a href='/greet'>/greet</a> to get a personalized greeting.")));
    }

    @Test
    public void testGreetDefault() throws Exception {
        mockMvc.perform(get("/greet"))
               .andExpect(status().isOk())
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Greetings, Guest!")))
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Welcome to the Spring Boot application. Enjoy your stay!")))
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Visit <a href='/'>Home</a> to go back to the main page.")));
    }

    @Test
    public void testGreetWithName() throws Exception {
        mockMvc.perform(get("/greet").param("name", "John"))
               .andExpect(status().isOk())
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Greetings, John!")))
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Welcome to the Spring Boot application. Enjoy your stay!")))
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Visit <a href='/'>Home</a> to go back to the main page.")));
    }

    @Test
    public void testGreetPathVariable() throws Exception {
        mockMvc.perform(get("/greet/John"))
               .andExpect(status().isOk())
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Greetings, John!")))
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Welcome to the Spring Boot application. Enjoy your stay!")))
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Visit <a href='/'>Home</a> to go back to the main page.")));
    }
}
