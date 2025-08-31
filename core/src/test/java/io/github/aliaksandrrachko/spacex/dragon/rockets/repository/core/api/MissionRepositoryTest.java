package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.exception.MissionNotFoundException;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.mission.Mission;
import io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model.mission.MissionStatus;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MissionRepositoryTest {
    private MissionRepository repository;

    @BeforeEach
    void setUp() {
        repository = MissionRepositoryFactory.createInMemory();
    }

    @Test
    void add_ShouldCreateMissionWithScheduledStatus() {
        // given
        String missionName = "Mars Mission";

        // when
        Mission mission = repository.add(missionName);
        
        // then
        assertThat(mission.getName()).isEqualTo("Mars Mission");
        assertThat(mission.getStatus()).isEqualTo(MissionStatus.SCHEDULED);
        assertThat(mission.getAssignedRocketNames()).isEmpty();
    }

    @Test
    void add_ShouldReturnExistingMissionWhenNameAlreadyExists() {
        // given
        String missionName = "Mars Mission";
        Mission first = repository.add(missionName);

        // when
        Mission second = repository.add(missionName);
        
        // then
        assertThat(second).isEqualTo(first);
    }

    @Test
    void assignRocket_ShouldAssignRocketToMission() {
        // given
        String missionName = "Mars Mission";
        String rocketName = "Dragon 1";
        repository.add(missionName);
        
        // when
        Mission mission = repository.assignRocket(missionName, rocketName);
        
        // then
        assertThat(mission.getAssignedRocketNames()).contains(rocketName);
    }

    @Test
    void assignRocket_ShouldThrowExceptionWhenMissionNotFound() {
        // given
        String nonExistentMission = "NonExistent";
        String rocketName = "Dragon 1";

        // when & then
        assertThatThrownBy(() -> repository.assignRocket(nonExistentMission, rocketName))
              .isInstanceOf(MissionNotFoundException.class);
    }

    @Test
    void changeStatus_ShouldUpdateMissionStatus() {
        // given
        String missionName = "Mars Mission";
        repository.add(missionName);
        
        // when
        Mission mission = repository.changeStatus(missionName, MissionStatus.IN_PROGRESS);
        
        // then
        assertThat(mission.getStatus()).isEqualTo(MissionStatus.IN_PROGRESS);
    }

    @Test
    void changeStatus_ShouldThrowExceptionWhenMissionNotFound() {
        // given
        String nonExistentMission = "NonExistent";

        // when & then
        assertThatThrownBy(() -> repository.changeStatus(nonExistentMission, MissionStatus.IN_PROGRESS))
              .isInstanceOf(MissionNotFoundException.class);
    }

    @Test
    void getSummary_ShouldReturnMissionsOrderedByRocketCountThenName() {
        // given
        repository.add("Mars");
        repository.add("Luna1");
        repository.add("Transit");
        
        repository.assignRocket("Transit", "Dragon 1");
        repository.assignRocket("Transit", "Dragon 2");
        repository.assignRocket("Transit", "Dragon 3");
        
        repository.assignRocket("Luna1", "Dragon 4");
        repository.assignRocket("Luna1", "Dragon 5");
        
        // when
        List<Mission> summary = repository.getSummary();
        
        // then
        assertThat(summary).hasSize(3);
        assertThat(summary.get(0).getName()).isEqualTo("Transit"); // 3 rockets
        assertThat(summary.get(1).getName()).isEqualTo("Luna1");   // 2 rockets
        assertThat(summary.get(2).getName()).isEqualTo("Mars");    // 0 rockets
    }

    @Test
    void getSummary_ShouldSortByNameWhenRocketCountIsEqual() {
        // given
        repository.add("Alpha");
        repository.add("Beta");
        
        repository.assignRocket("Alpha", "Dragon 1");
        repository.assignRocket("Beta", "Dragon 2");
        
        // when
        List<Mission> summary = repository.getSummary();
        
        // then
        assertThat(summary).hasSize(2);
        assertThat(summary.get(0).getName()).isEqualTo("Beta");  // Same rocket count, but "Beta" > "Alpha" (descending)
        assertThat(summary.get(1).getName()).isEqualTo("Alpha");
    }
}
