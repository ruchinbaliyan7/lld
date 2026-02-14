package org.example.logger.handlers;

import org.example.logger.LogLevel;
import org.example.logger.observers.LogAppendObserver;

import java.util.List;

public class DebugLogHandler extends LogHandler {
    public DebugLogHandler(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void appendLog(String message, List<LogAppendObserver> logAppendObservers) {
        String m = "DEBUG" + message;


        for(LogAppendObserver logAppendObserver : logAppendObservers){
            logAppendObserver.append(m);
        }
    }
}
