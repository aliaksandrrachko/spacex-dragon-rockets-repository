package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.exception;

public class RocketNotFoundException extends RuntimeException {
  public RocketNotFoundException(String rocketName) {
    super("Rocket not found: " + rocketName);
  }
}
