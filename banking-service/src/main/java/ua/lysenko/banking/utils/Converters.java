package ua.lysenko.banking.utils;

import org.modelmapper.Converter;

import java.util.UUID;

public class Converters {

    public static final Converter<UUID, String> UUID_TO_STRING_CONVERTER =
            context -> context.getSource() == null ? null : context.getSource().toString();
}