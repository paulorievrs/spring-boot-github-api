package dev.paulorievrs.springapi.model;

import lombok.Data;

@Data
public class GithubUser {
    private String login;
    private String avatar_url;
    private String html_url;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String hireable;
    private String bio;
    private int public_repos;
    private int public_gists;
    private int followers;
    private int following;

}
