package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.rocket;

import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class Rocket {
    private final @NonNull UUID id;
    private final @NonNull String name;
    private @NonNull RocketStatus status;
    private UUID assignedMissionId;
}
