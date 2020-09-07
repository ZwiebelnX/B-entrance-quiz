package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.module.Team;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TeamServiceTest {

    @InjectMocks
    private TeamService teamService;

    @Test
    public void should_return_team_list_when_split_into_team() {
        List<Team> teamList = teamService.splitIntoTeam();

        assertEquals(6, teamList.size());
        assertEquals(6, teamList.get(0).getTraineeList().size());
        assertEquals(6, teamList.get(1).getTraineeList().size());
        assertEquals(6, teamList.get(2).getTraineeList().size());
        assertEquals(6, teamList.get(3).getTraineeList().size());
        assertEquals(6, teamList.get(4).getTraineeList().size());
        assertEquals(5, teamList.get(5).getTraineeList().size());
    }
}
