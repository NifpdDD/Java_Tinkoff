package edu.hw4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ValidationError extends RuntimeException {
    private final String message;

    public ValidationError(String message) {
        super(message);
        this.message = message;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ValidationError that = (ValidationError) obj;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
