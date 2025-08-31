package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api;

import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.impl.RocketRepositoryInMemoryImpl;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RocketRepositoryFactory {
  public static RocketRepository createInMemory() {
    return new RocketRepositoryInMemoryImpl();
  }
}
