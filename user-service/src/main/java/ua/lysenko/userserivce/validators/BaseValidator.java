package ua.lysenko.userserivce.validators;

public interface BaseValidator<T> {

    public boolean isValid(T request);
}
