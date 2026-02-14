package org.example.logger.handlers;

import org.example.logger.LogLevel;
import org.example.logger.observers.LogAppendObserver;

import java.util.List;

public abstract class LogHandler {
    LogHandler nextHandler;
    LogLevel logLevel;

    public void setNextHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }


    public void log(LogLevel level, String message, List<LogAppendObserver> logAppendObserver) {

        if(this.logLevel == level){
            appendLog(message, logAppendObserver);
        }

        if(nextHandler!= null){
            nextHandler.log(level, message, logAppendObserver);
        }

    }

    public abstract void  appendLog(String message , List<LogAppendObserver> logAppendObservers);
}
