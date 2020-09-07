package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.module.Trainee;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TraineeServiceTest {

    @InjectMocks
    TraineeService traineeService;

    @Test
    public void should_return_list_when_get_trainee_list() {
        List<Trainee> traineeList = traineeService.getTraineeList();

        assertEquals(35, traineeList.size());
    }
}
