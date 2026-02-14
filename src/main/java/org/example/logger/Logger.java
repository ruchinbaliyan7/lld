package org.example.logger;

import org.example.logger.handlers.LogHandler;
import org.example.logger.observers.FileLogAppendObserver;
import org.example.logger.observers.LogAppendObserver;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private final static Logger loggerInstance = new Logger();
    private final static LogHandler loggerHandler = LogManager.buildLoggerChain();
    private final static List<LogAppendObserver> logObservers =  new ArrayList<>();

    private Logger() {}

    public static Logger getLoggerInstance() {
        return loggerInstance;
    }

    private void logMessage(String message, LogLevel level) {
        loggerHandler.log(level, message, logObservers);
    }

    public void info(String message) {
        logMessage(message, LogLevel.INFO);
    }

    public void error(String message) {
        logMessage(message, LogLevel.ERROR);
    }

    public void debug(String message) {
        logMessage(message, LogLevel.DEBUG);
    }

    public void addObserver(LogAppendObserver observer) {
        this.logObservers.add(observer);
    };
}
