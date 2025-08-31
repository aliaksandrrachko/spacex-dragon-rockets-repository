package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RocketRepositoryFactoryTest {

    @Test
    void createInMemory_ShouldReturnRocketRepositoryInstance() {
        // when
        RocketRepository repository = RocketRepositoryFactory.createInMemory();
        
        // then
        assertThat(repository).isNotNull();
    }

    @Test
    void createInMemory_ShouldReturnNewInstanceEachTime() {
        // when
        RocketRepository first = RocketRepositoryFactory.createInMemory();
        RocketRepository second = RocketRepositoryFactory.createInMemory();
        
        // then
        assertThat(first).isNotSameAs(second);
    }
}
