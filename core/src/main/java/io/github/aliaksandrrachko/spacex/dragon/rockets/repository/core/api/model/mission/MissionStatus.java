package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.mission;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MissionStatus {
  SCHEDULED("Scheduled"),
  PENDING("Pending"),
  IN_PROGRESS("In Progress"),
  ENDED("Ended");
  
  private final String displayName;
}
