package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api;

import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.mission.Mission;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.mission.MissionStatus;
import java.util.List;

public interface MissionRepository {
    Mission add(String name);

    Mission assignRocket(String name, String rocketName);

    Mission changeStatus(String name, MissionStatus status);

    List<Mission> getSummary();
}
