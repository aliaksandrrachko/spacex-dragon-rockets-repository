package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api;

import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.impl.MissionRepositoryInMemoryImpl;

public class MissionRepositoryFactory {
  public static MissionRepository createInMemory() {
    return new MissionRepositoryInMemoryImpl();
  }
}
