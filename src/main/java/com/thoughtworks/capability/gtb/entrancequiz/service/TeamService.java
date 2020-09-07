package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.module.Team;
import com.thoughtworks.capability.gtb.entrancequiz.module.Trainee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private static final List<Team> teamList = new ArrayList<>();

    public List<Team> splitIntoTeam() {
        teamList.clear();
        for (int i = 0; i < 6; i++) {
            teamList.add(Team.builder().name("Team " + (i + 1)).traineeList(new ArrayList<>()).build());
        }
        List<Trainee> traineeList = new ArrayList<>(TraineeService.traineeList);

        int teamIndex = 0;
        while (traineeList.size() > 0) {
            int selectId = (int) Math.round(Math.random() * (traineeList.size() - 1));
            teamList.get(teamIndex).getTraineeList().add(traineeList.get(selectId));
            traineeList.remove(selectId);
            if (teamIndex >= 5) {
                teamIndex = 0;
            } else {
                teamIndex++;
            }
        }

        return teamList;
    }
}
