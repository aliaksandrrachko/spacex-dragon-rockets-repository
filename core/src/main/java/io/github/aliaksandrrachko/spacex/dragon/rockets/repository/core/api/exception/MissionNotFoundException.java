package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.exception;

public class MissionNotFoundException extends RuntimeException {
    public MissionNotFoundException(String message) {
        super(message);
    }
}
