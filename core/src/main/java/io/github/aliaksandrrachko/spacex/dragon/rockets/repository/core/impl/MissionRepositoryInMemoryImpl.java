package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.impl;

import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.MissionRepository;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.mission.Mission;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.mission.MissionStatus;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.exception.MissionNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class MissionRepositoryInMemoryImpl implements MissionRepository {
    private final Map<String, Mission> missions = new ConcurrentHashMap<>();

    @Override
    public Mission add(String name) {
        Mission mission = new Mission(name, MissionStatus.SCHEDULED);
        Mission existing = missions.putIfAbsent(name, mission);
        return existing == null ? mission : existing;
    }

    @Override
    public Mission assignRocket(String name, String rocketName) {
        return updateMission(name, existing -> existing.getAssignedRocketNames().add(rocketName));
    }

    @Override
    public Mission changeStatus(String name, MissionStatus status) {
        return updateMission(name, existing -> existing.setStatus(status));
    }

    private Mission updateMission(String name, Consumer<Mission> updater) {
        Mission mission = missions.computeIfPresent(name, (key, existing) -> {
            updater.accept(existing);
            return existing;
        });
        if (mission == null) {
            throw new MissionNotFoundException(name);
        }
        return mission;
    }

    @Override
    public List<Mission> getSummary() {
        return missions.values()
            .stream()
            .sorted(
                comparingInt((Mission mission) -> mission.getAssignedRocketNames().size())
                    .reversed()
                    .thenComparing((m1, m2) -> m2.getName().compareTo(m1.getName()))
            )
            .collect(Collectors.toList());
    }
}
