package com.tcg.plaid;

import org.springframework.stereotype.Service;

@Service
public class PlSer {


    private String accessToken;
    private String itemId;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}

