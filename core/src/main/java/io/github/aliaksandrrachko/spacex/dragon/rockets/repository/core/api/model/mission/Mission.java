package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.mission;

import lombok.Data;
import lombok.NonNull;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class Mission {
  private final @NonNull String name;
  private @NonNull MissionStatus status;
  private final Set<String> assignedRocketNames = ConcurrentHashMap.newKeySet();
}
