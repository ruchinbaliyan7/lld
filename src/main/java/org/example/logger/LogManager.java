package org.example.logger;

import org.example.logger.handlers.DebugLogHandler;
import org.example.logger.handlers.ErrorLogHandler;
import org.example.logger.handlers.InfoLogHandler;
import org.example.logger.handlers.LogHandler;

public class LogManager {

    public static LogHandler buildLoggerChain() {
        LogHandler infoLogger = new InfoLogHandler(LogLevel.INFO);
        LogHandler errorLogger = new ErrorLogHandler(LogLevel.ERROR);
        LogHandler debugLogger = new DebugLogHandler(LogLevel.DEBUG);

        infoLogger.setNextHandler(errorLogger);
        errorLogger.setNextHandler(debugLogger);

        return infoLogger;
    }


}
