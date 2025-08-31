package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.mission;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Data;
import lombok.NonNull;

@Data
public class Mission {
    private final @NonNull String name;
    private @NonNull MissionStatus status;
    private final Set<String> assignedRocketNames = ConcurrentHashMap.newKeySet();
}
