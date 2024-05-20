package ua.lysenko.userserivce.validators;

import org.hibernate.validator.internal.metadata.facets.Validatable;

public interface BaseValidator<T> {

    public boolean isValid(T request);
}
