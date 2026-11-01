package com.jasveer.Expense_Tracker.exception;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timeStamp;

    public ErrorResponse(int status, String message)
    {
        this.message=message;
        this.status=status;
        this.timeStamp=LocalDateTime.now();
    }

}
