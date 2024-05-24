package ua.lysenko.userservice.textresources;

import lombok.Getter;

@Getter
public enum TextResources {

    LOGIN_SUCCESSFUL("You have successfully logged in");
    private final String message;

    TextResources(String message) {
        this.message = message;
    }
}
