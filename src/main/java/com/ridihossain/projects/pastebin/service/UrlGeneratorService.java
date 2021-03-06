package com.ridihossain.projects.pastebin.service;


import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlGeneratorService {

    int urlLength = 20;


    public int getUrlLength() {
        return urlLength;
    }

    public void setUrlLength(int urlLength) {
        this.urlLength = urlLength;
    }

    public String generateUrl () {
        Random random = new Random();
        StringBuilder url = new StringBuilder();

        for (int i = 0; i < urlLength; i++) {
            url.append((char) (random.nextInt(90 - 65) + 65));
        }
        return url.toString();
    }


}
