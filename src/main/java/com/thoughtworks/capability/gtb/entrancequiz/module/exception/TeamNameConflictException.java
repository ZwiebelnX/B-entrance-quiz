package com.thoughtworks.capability.gtb.entrancequiz.module.exception;

import org.springframework.http.HttpStatus;

public class TeamNameConflictException extends BusinessBasicException {

    public TeamNameConflictException() {
        super(HttpStatus.CONFLICT, "队名已存在");
    }
}
