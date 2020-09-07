package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.module.Team;
import com.thoughtworks.capability.gtb.entrancequiz.module.exception.TeamNameConflictException;
import com.thoughtworks.capability.gtb.entrancequiz.module.exception.TeamNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TeamServiceTest {

    @InjectMocks
    private TeamService teamService;

    @BeforeEach
    public void setUp() {
        TraineeService.resetTrainee();
        TeamService.resetTeam();
    }

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

    @Test
    public void should_change_team_name_when_change_team_name_given_team_name()
        throws TeamNameConflictException, TeamNotFoundException {
        TeamService.teamList.clear();
        teamService.splitIntoTeam();
        Team team = Team.builder().name("更改测试").build();
        teamService.changeTeamName(1, team);

        assertEquals("更改测试", TeamService.teamList.get(1).getName());
    }

    @Test
    public void should_throw_exception_when_change_team_name_given_wrong_index() {
        TeamService.teamList.clear();
        teamService.splitIntoTeam();

        Team team = Team.builder().name("更改测试").build();
        assertThrows(TeamNotFoundException.class, () -> teamService.changeTeamName(-1, team));
    }

    @Test
    public void should_throw_exception_when_change_team_name_given_duplicate_name()
        throws TeamNameConflictException, TeamNotFoundException {
        TeamService.teamList.clear();
        teamService.splitIntoTeam();

        Team team = Team.builder().name("更改测试").build();
        teamService.changeTeamName(1, team);

        assertEquals("更改测试", TeamService.teamList.get(1).getName());
        assertThrows(TeamNameConflictException.class, () -> teamService.changeTeamName(2, team));
    }

    @Test
    public void should_get_team_list_when_get_team_list() {
        List<Team> teamList = teamService.getTeamList();
        assertEquals(6, teamList.size());
    }
}
