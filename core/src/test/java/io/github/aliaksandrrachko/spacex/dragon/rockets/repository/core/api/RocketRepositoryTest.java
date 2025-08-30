package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api;

import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.exception.RocketNotFoundException;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.rocket.Rocket;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.rocket.RocketStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RocketRepositoryTest {
  private RocketRepository repository;

  @BeforeEach
  void setUp() {
    repository = RocketRepositoryFactory.createInMemory();
  }

  @Test
  void add_ShouldCreateRocketWithOnGroundStatus() {
    // given
    String rocketName = "Dragon 1";

    // when
    Rocket rocket = repository.add(rocketName);
    
    // then
    assertThat(rocket.getName()).isEqualTo("Dragon 1");
    assertThat(rocket.getStatus()).isEqualTo(RocketStatus.ON_GROUND);
    assertThat(rocket.getAssignedMissionName()).isNull();
  }

  @Test
  void add_ShouldReturnExistingRocketWhenNameAlreadyExists() {
    // given
    String rocketName = "Dragon 1";
    Rocket first = repository.add(rocketName);

    // when
    Rocket second = repository.add(rocketName);
    
    // then
    assertThat(second).isSameAs(first);
  }

  @Test
  void assignToMission_ShouldAssignRocketAndChangeStatusToInSpace() {
    // given
    String rocketName = "Dragon 1";
    String missionName = "Mars Mission";
    repository.add(rocketName);
    
    // when
    Rocket rocket = repository.assignToMission(rocketName, missionName);
    
    // then
    assertThat(rocket.getAssignedMissionName()).isEqualTo(missionName);
    assertThat(rocket.getStatus()).isEqualTo(RocketStatus.IN_SPACE);
  }

  @Test
  void assignToMission_ShouldThrowExceptionWhenRocketNotFound() {
    // given
    String nonExistentRocket = "NonExistent";
    String missionName = "Mars Mission";

    // when & then
    assertThatThrownBy(() -> repository.assignToMission(nonExistentRocket, missionName))
        .isInstanceOf(RocketNotFoundException.class);
  }

  @Test
  void changeStatus_ShouldUpdateRocketStatus() {
    // given
    String rocketName = "Dragon 1";
    repository.add(rocketName);
    
    // when
    Rocket rocket = repository.changeStatus(rocketName, RocketStatus.IN_REPAIR);
    
    // then
    assertThat(rocket.getStatus()).isEqualTo(RocketStatus.IN_REPAIR);
  }

  @Test
  void changeStatus_ShouldThrowExceptionWhenRocketNotFound() {
    // given
    String nonExistentRocket = "NonExistent";

    // when & then
    assertThatThrownBy(() -> repository.changeStatus(nonExistentRocket, RocketStatus.IN_REPAIR))
        .isInstanceOf(RocketNotFoundException.class);
  }
}
