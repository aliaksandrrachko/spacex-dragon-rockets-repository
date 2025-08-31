package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api;

import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.impl.MissionRepositoryInMemoryImpl;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MissionRepositoryFactory {
    public static MissionRepository createInMemory() {
        return new MissionRepositoryInMemoryImpl();
    }
}
