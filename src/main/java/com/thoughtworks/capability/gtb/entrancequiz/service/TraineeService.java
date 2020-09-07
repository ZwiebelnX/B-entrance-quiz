package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.module.Trainee;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class TraineeService {

    public static final List<Trainee> traineeList = new ArrayList<>();

    private static int nextId = 1;

    public TraineeService() {
        if (traineeList.size() == 0) {
            try {
                File file = new File("defaultList.txt");
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String lineString;
                while ((lineString = bufferedReader.readLine()) != null) {
                    Trainee trainee = Trainee.builder().id(nextId).name(lineString).build();
                    traineeList.add(trainee);
                    nextId++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    public List<Trainee> getTraineeList() {
        return traineeList;
    }

}
