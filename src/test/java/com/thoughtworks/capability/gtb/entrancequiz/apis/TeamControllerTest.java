package com.thoughtworks.capability.gtb.entrancequiz.apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.module.Team;
import com.thoughtworks.capability.gtb.entrancequiz.service.TeamService;
import com.thoughtworks.capability.gtb.entrancequiz.service.TraineeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        TraineeService.resetTrainee();
        TeamService.resetTeam();
    }

    @Test
    public void should_get_team_list_when_post_list() throws Exception {
        mockMvc.perform(post("/team"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(6)))
            .andExpect(jsonPath("$[0].traineeList", hasSize(6)))
            .andExpect(jsonPath("$[1].traineeList", hasSize(6)))
            .andExpect(jsonPath("$[2].traineeList", hasSize(6)))
            .andExpect(jsonPath("$[3].traineeList", hasSize(6)))
            .andExpect(jsonPath("$[4].traineeList", hasSize(6)))
            .andExpect(jsonPath("$[5].traineeList", hasSize(5)));
    }

    @Test
    public void should_change_team_name_when_post_team() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Team team = Team.builder().name("集成更改测试").build();
        mockMvc.perform(
            post("/team/1/name").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(team)))
            .andExpect(status().isOk());
    }

    @Test
    public void should_throw_error_when_post_team_given_wrong_index() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Team team = Team.builder().name("集成更改测试").build();
        mockMvc.perform(post("/team/-1/name").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(team))).andExpect(status().isBadRequest());
    }

    @Test
    public void should_throw_error_when_post_team_given_duplicate_name() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Team team = Team.builder().name("集成冲突测试").build();
        mockMvc.perform(
            post("/team/1/name").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(team)))
            .andExpect(status().isOk());

        mockMvc.perform(
            post("/team/2/name").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(team)))
            .andExpect(status().isConflict());
    }

    @Test
    public void should_get_team_list_when_get_team_list() throws Exception {
        mockMvc.perform(get("/team/list")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(6)));
    }
}
