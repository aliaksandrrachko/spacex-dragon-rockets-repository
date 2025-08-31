package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.rocket;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RocketStatus {
    ON_GROUND("On ground"),
    IN_SPACE("In space"),
    IN_REPAIR("In repair"),
    IN_BUILD("In build");

    private final String displayName;
}
