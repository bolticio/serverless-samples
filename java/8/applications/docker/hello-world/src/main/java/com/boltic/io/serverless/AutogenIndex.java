package com.boltic.io.serverless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AutogenIndex {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AutogenIndex.class);
        Environment environment = app.run(args).getEnvironment();
        String devMode = Boolean.parseBoolean(environment.getProperty("DEVELOPMENT_MODE", "false")) ? "development" : "production";
        if ("development".equals(devMode)) {
            System.out.println("Listening for events on port " + environment.getProperty("APPLICATION_PORT", "8080") + " in development mode");
        } else {
            System.out.println("Listening for events");
        }
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(Environment environment) {
        return factory -> {
            int port = Integer.parseInt(environment.getProperty("APPLICATION_PORT", "8080"));
            factory.setPort(port);
        };
    }

    @Bean
    public String devMode(Environment environment) {
        return Boolean.parseBoolean(environment.getProperty("DEVELOPMENT_MODE", "false")) ? "development" : "production";
    }

    @RestController
    @RequestMapping("/")
    class ServerController {

        private final Handler handler;
        private final String devMode;

        public ServerController(Handler handler, String devMode) {
            this.handler = handler;
            this.devMode = devMode;
        }

        @GetMapping("/**")
        public ResponseEntity<String> handleRequest() {
            return handler.handle(); // Handler should return ResponseEntity<String>
        }
    }
}
