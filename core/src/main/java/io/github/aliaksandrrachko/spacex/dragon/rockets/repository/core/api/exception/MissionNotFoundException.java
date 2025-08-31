package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.exception;

public class MissionNotFoundException extends EntityNotFoundException {
    public MissionNotFoundException(String missionName) {
        super("Mission", missionName);
    }
}
