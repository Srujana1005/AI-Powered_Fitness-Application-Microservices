
package com.example.demo;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/users")
public class UserProxyController {

    private final RestClient userServiceRestClient;

    public UserProxyController(RestClient userServiceRestClient) {
        this.userServiceRestClient = userServiceRestClient;
    }

    @PostMapping("/register")
    public ResponseEntity<Map> registerUser(
            @RequestBody Map<String, Object> request) {

        Map response = userServiceRestClient.post()
                .uri("/api/users/register")
                .body(request)
                .retrieve()
                .body(Map.class);

        return ResponseEntity.ok(response);
    }
}
