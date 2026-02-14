package org.example.logger.handlers;

import org.example.logger.LogLevel;
import org.example.logger.observers.LogAppendObserver;

import java.util.List;

public class ErrorLogHandler extends  LogHandler {

    public ErrorLogHandler(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void appendLog(String message, List<LogAppendObserver> logAppendObservers) {
        String m = "ERROR" + message;

        for(LogAppendObserver logAppendObserver : logAppendObservers){
            logAppendObserver.append(m);
        }
    }
}
