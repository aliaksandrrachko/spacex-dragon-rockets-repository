package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api;

import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.rocket.Rocket;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.rocket.RocketStatus;

public interface RocketRepository {
  Rocket add(String name);
  Rocket assignToMission(String name, String missionName);
  Rocket changeStatus(String name, RocketStatus status);
}
