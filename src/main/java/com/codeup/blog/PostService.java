package com.codeup.blog;

import org.springframework.stereotype.Service;

@Service
public class PostService {
    protected int favoriteNumber;

    public PostService() {
        favoriteNumber = 99;
    }

    public int getFavoriteNumber(){
        return favoriteNumber;
    }
}
