package com.pl.premier_zone.network;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/external")
public class ExternalApiController {

    private final RestTemplate restTemplate;

    public ExternalApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/wiki")
    public String getClubInfo(@RequestParam String clubName) {
        String url = "https://en.wikipedia.org/api/rest_v1/page/summary/" + clubName.replace(" ", "_");

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "PremierZoneApp/1.0 (contact: marek@example.com)");

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);

            if (response.getBody() != null && response.getBody().containsKey("extract")) {
                return (String) response.getBody().get("extract");
            }
            return "Brak opisu dla: " + clubName;

        } catch (Exception e) {
            return "Błąd podczas pobierania danych z Wikipedii: " + e.getMessage();
        }
    }
}