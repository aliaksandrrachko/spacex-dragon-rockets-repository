package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.mission;

import lombok.Data;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

@Data
public class Mission {
    private final @NonNull String name;
    private @NonNull MissionStatus status;
    private final Set<String> assignedRocketNames = new HashSet<>();
}
