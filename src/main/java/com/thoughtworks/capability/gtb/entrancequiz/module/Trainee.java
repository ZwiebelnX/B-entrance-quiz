package com.thoughtworks.capability.gtb.entrancequiz.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trainee {
    private int id;

    private String name;
}
