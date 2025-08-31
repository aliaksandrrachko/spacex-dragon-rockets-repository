package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.exception;

public class RocketNotFoundException extends EntityNotFoundException {
    public RocketNotFoundException(String rocketName) {
        super("Rocket", rocketName);
    }
}
