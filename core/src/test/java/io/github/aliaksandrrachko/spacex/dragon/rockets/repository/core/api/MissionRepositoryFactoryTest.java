package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MissionRepositoryFactoryTest {

  @Test
  void createInMemory_ShouldReturnMissionRepositoryInstance() {
    // when
    MissionRepository repository = MissionRepositoryFactory.createInMemory();
    
    // then
    assertThat(repository).isNotNull();
  }

  @Test
  void createInMemory_ShouldReturnNewInstanceEachTime() {
    // when
    MissionRepository first = MissionRepositoryFactory.createInMemory();
    MissionRepository second = MissionRepositoryFactory.createInMemory();
    
    // then
    assertThat(first).isNotSameAs(second);
  }
}
