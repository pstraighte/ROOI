package com.rooi.rooi.dto;

import com.rooi.rooi.entity.Worker;
import lombok.Getter;

@Getter
public class WorkerResponseDto {
    private String worker;

    public WorkerResponseDto(Worker worker) {
        this.worker = worker.getWorker();
    }
}
