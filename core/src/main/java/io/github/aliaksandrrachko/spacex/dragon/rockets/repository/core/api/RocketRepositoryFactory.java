package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api;

import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.impl.RocketRepositoryInMemoryImpl;

public class RocketRepositoryFactory {
  public static RocketRepository createInMemory() {
    return new RocketRepositoryInMemoryImpl();
  }
}
