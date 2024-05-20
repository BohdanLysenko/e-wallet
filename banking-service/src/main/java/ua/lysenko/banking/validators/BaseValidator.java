package ua.lysenko.banking.validators;

public interface BaseValidator<T> {

    public boolean isValid(T request);
}