package com.aleksander.isiphotos.model;


import java.util.Date;

import lombok.Getter;

/**
 * @author Aleksander
 */

@Getter
public class Photo {

    private PhotoUrls urls;
    private int likes;
    private Date created_at;
    private User user;
    private int width;
    private int height;
}
