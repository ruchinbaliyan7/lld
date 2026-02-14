package org.example.logger.observers;

public class FileLogAppendObserver  implements LogAppendObserver {
    @Override
    public void append(String message) {
        System.out.println("Writing to file: " + message);
    }
}
