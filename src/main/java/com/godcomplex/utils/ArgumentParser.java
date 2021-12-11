package com.godcomplex.utils;

import java.util.Collection;
import java.util.Optional;

public class ArgumentParser {

    public static Optional<Double> parseDouble(String value) {
        try {
            double result = Double.parseDouble(value);
            return Optional.of(result);
        } catch (NumberFormatException | NullPointerException ex) {
            return Optional.empty();
        }
    }

    public static Optional<Integer> parseInteger(String value) {
        try {
            int result = Integer.parseInt(value);
            return Optional.of(result);
        } catch (NumberFormatException | NullPointerException ex) {
            return Optional.empty();
        }
    }
}
