package com.thoughtworks.capability.gtb.entrancequiz.apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.module.Trainee;

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
class TraineeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_get_trainee_list_when_get_list() throws Exception {
        mockMvc.perform(get("/trainee/list")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(35)));
    }

    @Test
    public void should_add_trainee_and_return_list_when_post_trainee() throws Exception {
        mockMvc.perform(get("/trainee/list")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(35)));

        ObjectMapper objectMapper = new ObjectMapper();
        Trainee trainee = Trainee.builder().name("小明").build();
        mockMvc.perform(
            post("/trainee").content(objectMapper.writeValueAsString(trainee)).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$", hasSize(36)));
    }

}
