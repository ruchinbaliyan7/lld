package org.example.logger.observers;

public class ConsoleLogAppendObserver implements LogAppendObserver {
    @Override
    public void append(String message) {
        System.out.println("Writing to console: " + message);
    }
}
