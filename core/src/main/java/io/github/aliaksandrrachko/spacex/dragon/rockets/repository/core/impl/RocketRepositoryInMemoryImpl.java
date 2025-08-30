package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.impl;

import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.RocketRepository;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.rocket.Rocket;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.rocket.RocketStatus;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.exception.RocketNotFoundException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class RocketRepositoryInMemoryImpl implements RocketRepository {
  private final Map<String, Rocket> rockets = new ConcurrentHashMap<>();

  @Override
  public Rocket add(String name) {
    Rocket rocket = new Rocket(name, RocketStatus.ON_GROUND);
    return rockets.putIfAbsent(name, rocket);
  }

  @Override
  public Rocket assignToMission(String name, String missionName) {
    Rocket rocket = rockets.computeIfPresent(name, (key, existing) -> {
      existing.setAssignedMissionName(missionName);
      existing.setStatus(RocketStatus.IN_SPACE);
      return existing;
    });
    if (rocket == null) {
      throw new RocketNotFoundException(name);
    }
    return rocket;
  }

  @Override
  public Rocket changeStatus(String name, RocketStatus status) {
    Rocket rocket = rockets.computeIfPresent(name, (key, existing) -> {
      existing.setStatus(status);
      return existing;
    });
    if (rocket == null) {
      throw new RocketNotFoundException(name);
    }
    return rocket;
  }
}
