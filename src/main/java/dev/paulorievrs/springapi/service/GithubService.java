package dev.paulorievrs.springapi.service;

import com.google.gson.Gson;
import dev.paulorievrs.springapi.model.GithubUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GithubService {
    private final String baseUrl = "https://api.github.com/users/";

    public String getUser(String username) {
        RestTemplate restTemplate = new RestTemplate();
        String userUrl = baseUrl + username;

        String response = restTemplate.getForObject(userUrl, String.class);

        Gson gson = new Gson();
        GithubUser user = gson.fromJson(response, GithubUser.class);


        return user.getName();
    }
}
