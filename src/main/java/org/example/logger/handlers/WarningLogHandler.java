package org.example.logger.handlers;

import org.example.logger.LogLevel;
import org.example.logger.observers.LogAppendObserver;

import java.util.List;

public class WarningLogHandler  extends  LogHandler{

    public WarningLogHandler(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void appendLog(String message, List<LogAppendObserver> logAppendObservers) {
        String m = "WARN" + message;

        for(LogAppendObserver logAppendObserver : logAppendObservers){
            logAppendObserver.append(m);
        }
    }
}
