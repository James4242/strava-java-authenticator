package org.jhapps.controllers;

import org.jhapps.StravaAuthenticatorConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @Autowired
    private StravaAuthenticatorConfiguration configuration;

    @RequestMapping("/")
    public ResponseEntity<Void> sendStravaAuthRequest() {
        URI uri = UriComponentsBuilder.fromUriString(configuration.getStravaUri())
                .path("/oauth/authorize")
                .build().toUri();

        String redirectURI = UriComponentsBuilder.fromUriString(configuration.getApplicationUri())
                .path("/exchange_token&approval_prompt=force&scope=read")
                .build().toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("client_id", configuration.getClientID());
        headers.set("response_type", "code");
        headers.set("redirect_uri", redirectURI);
        headers.setLocation(uri);

        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @RequestMapping("/exchange_token")
    public ResponseEntity<String> getToken(@RequestParam("code") String code) {

        if(code.equals("")) {
            throw new RuntimeException("Authorization Code is empty");
        }
        URI uri = UriComponentsBuilder.fromUriString(configuration.getStravaUri())
                .path("/oauth/token")
                .build().toUri();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> map = new HashMap<>();
        map.put("client_id", configuration.getClientID());
        map.put("client_secret", configuration.getClientSecret());
        map.put("code", code);
        map.put("grant_type", "authorization_code");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        return restTemplate.postForEntity(uri, entity, String.class);
    }
}
