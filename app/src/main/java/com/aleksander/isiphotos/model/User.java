package com.aleksander.isiphotos.model;

import lombok.Getter;

/**
 * @author Aleksander
 */

@Getter
public class User {

    private String username;
    private String name;
    private String portfolioUrl;
    private String bio;
    private String location;
    private ProfileImage profileImage;
}
