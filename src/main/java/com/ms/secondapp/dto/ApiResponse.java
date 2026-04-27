package com.ms.secondapp.dto;

public class ApiResponse {

    private String message;
    private int status;
    private Object data;

    public ApiResponse(String message, int status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    // getters & setters
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }
}