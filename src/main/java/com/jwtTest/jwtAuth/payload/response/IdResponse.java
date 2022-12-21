package com.jwtTest.jwtAuth.payload.response;

public class IdResponse {
    private int message;

    public IdResponse(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }
}
