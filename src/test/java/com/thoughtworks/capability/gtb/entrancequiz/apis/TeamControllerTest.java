package com.thoughtworks.capability.gtb.entrancequiz.apis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
}
