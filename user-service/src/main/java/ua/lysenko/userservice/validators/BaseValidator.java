package ua.lysenko.userservice.validators;

public interface BaseValidator<T> {

    public boolean isValid(T request);
}
