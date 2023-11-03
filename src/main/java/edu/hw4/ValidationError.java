package edu.hw4;

import java.util.HashSet;
import java.util.Set;

public class ValidationError extends RuntimeException {

    public ValidationError(String s) {
        super(s);
    }

    public static Set<ValidationError> getValidationError(Animal animal) {
        var errors = new HashSet<ValidationError>();
        if (animal.age() <= 0) {
            errors.add(new ValidationError("age must be greater than zero"));
        }
        if (animal.height() <= 0) {
            errors.add(new ValidationError("height must be greater than zero"));
        }
        if (animal.weight() <= 0) {
            errors.add(new ValidationError("weight must be greater than zero"));
        }
        return errors;
    }
}
