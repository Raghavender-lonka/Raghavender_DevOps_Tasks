package com.example.SpringHelloWorld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class HelloService {

    @RequestMapping("/")
    public String index() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        
        return "<html>" +
                "<body>" +
                "<h1>Hello World! Welcome to Unity Demo!</h1>" +
                "<p>This is a simple Spring Boot application.</p>" +
                "<p>Current server time is: " + formattedTime + "</p>" +
                "<p>Visit <a href='/greet'>/greet</a> to get a personalized greeting.</p>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping("/greet")
    public String greet(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return "<html>" +
                "<body>" +
                "<h1>Greetings, " + name + "!</h1>" +
                "<p>Welcome to the Spring Boot application. Enjoy your stay!</p>" +
                "<p>Visit <a href='/'>Home</a> to go back to the main page.</p>" +
                "</body>" +
                "</html>";
    }
    
    @RequestMapping("/greet/{name}")
    public String greetPath(@PathVariable String name) {
        return "<html>" +
                "<body>" +
                "<h1>Greetings, " + name + "!</h1>" +
                "<p>Welcome to the Spring Boot application. Enjoy your stay!</p>" +
                "<p>Visit <a href='/'>Home</a> to go back to the main page.</p>" +
                "</body>" +
                "</html>";
    }

}
