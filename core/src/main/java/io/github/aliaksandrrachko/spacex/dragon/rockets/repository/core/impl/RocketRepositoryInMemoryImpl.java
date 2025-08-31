package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.impl;

import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.RocketRepository;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.rocket.Rocket;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.rocket.RocketStatus;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.exception.RocketNotFoundException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class RocketRepositoryInMemoryImpl implements RocketRepository {
  private final Map<String, Rocket> rockets = new ConcurrentHashMap<>();

  @Override
  public Rocket add(String name) {
    Rocket rocket = new Rocket(name, RocketStatus.ON_GROUND);
    Rocket existing = rockets.putIfAbsent(name, rocket);
    return existing == null ? rocket : existing;
  }

  @Override
  public Rocket assignToMission(String name, String missionName) {
    return updateRocket(name, existing -> {
      existing.setAssignedMissionName(missionName);
      existing.setStatus(RocketStatus.IN_SPACE);
    });
  }

  @Override
  public Rocket changeStatus(String name, RocketStatus status) {
    return updateRocket(name, existing -> existing.setStatus(status));
  }

  private Rocket updateRocket(String name, Consumer<Rocket> updater) {
    Rocket rocket = rockets.computeIfPresent(name, (key, existing) -> {
      updater.accept(existing);
      return existing;
    });
    if (rocket == null) {
      throw new RocketNotFoundException(name);
    }
    return rocket;
  }
}
