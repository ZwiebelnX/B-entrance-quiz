package com.thoughtworks.capability.gtb.entrancequiz.module;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Team {

    private int id;

    private String name;

    private List<Trainee> traineeList;

}
