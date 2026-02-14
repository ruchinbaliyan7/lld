package org.example.logger;

import org.example.logger.observers.ConsoleLogAppendObserver;
import org.example.logger.observers.FileLogAppendObserver;

public class LoggerApplication {
    public static void main(String[] args) {

        Logger logger = Logger.getLoggerInstance();
        logger.addObserver(new FileLogAppendObserver());
        logger.addObserver(new ConsoleLogAppendObserver());

        logger.info("This is an info message.");
        logger.error("This is an error message");
    }
}
