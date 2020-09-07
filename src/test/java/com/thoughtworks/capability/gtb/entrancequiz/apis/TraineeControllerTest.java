package com.thoughtworks.capability.gtb.entrancequiz.apis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

}
