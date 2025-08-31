package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityType, String entityName) {
        super(entityType + " not found: " + entityName);
    }
}
