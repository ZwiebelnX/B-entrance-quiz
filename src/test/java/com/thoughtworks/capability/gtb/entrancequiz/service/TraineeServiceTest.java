package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.module.Trainee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TraineeServiceTest {

    @Mock
    TeamService teamService;

    @InjectMocks
    TraineeService traineeService;

    @BeforeEach
    public void setUp() {
        TraineeService.resetTrainee();
        TeamService.resetTeam();
    }

    @Test
    public void should_return_list_when_get_trainee_list() {
        List<Trainee> traineeList = traineeService.getTraineeList();

        assertEquals(35, traineeList.size());
    }

    @Test
    public void should_add_trainee_and_return_id_when_add_trainee() {
        List<Trainee> traineeList = traineeService.addTrainee(Trainee.builder().name("小明").build());

        assertEquals(36, traineeList.size());
        assertEquals(36, traineeList.get(35).getId());
        assertEquals("小明", traineeList.get(35).getName());
    }

}