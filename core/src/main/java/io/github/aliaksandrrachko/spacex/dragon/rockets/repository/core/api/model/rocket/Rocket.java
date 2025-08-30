package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.rocket;

import lombok.Data;
import lombok.NonNull;

@Data
public class Rocket {
    private final @NonNull String name;
    private @NonNull RocketStatus status;
    private String assignedMissionName;
}
