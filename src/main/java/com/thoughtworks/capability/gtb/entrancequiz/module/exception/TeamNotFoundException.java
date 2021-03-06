package com.thoughtworks.capability.gtb.entrancequiz.module.exception;

import org.springframework.http.HttpStatus;

public class TeamNotFoundException extends BusinessBasicException {

    public TeamNotFoundException() {
        super(HttpStatus.BAD_REQUEST, "指定ID的队伍未找到");
    }
}
