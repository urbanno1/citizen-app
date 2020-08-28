package com.monycell.edu.citizenapp.exception;

public class ErrorMessage {
    private String message;
    private String description;
    private String showDesc;

    public ErrorMessage(String message, String description, String showDesc) {
        this.message = message;
        this.description = description;
        this.showDesc = showDesc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String isShowDesc() {
        return showDesc;
    }

    public void setShowDesc(String showDesc) {
        this.showDesc = showDesc;
    }
}
