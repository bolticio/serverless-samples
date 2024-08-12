package com.boltic.io.serverless;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Handler {
    public ResponseEntity<String> handle() {
        try {
            // Prepare the response JSON
            String responseJson = "{\"message\": \"Hello World\"}";
            return ResponseEntity.ok().body(responseJson);
        } catch (Exception e) {
            // Handle errors
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}
