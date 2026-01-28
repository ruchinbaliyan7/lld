package org.example.elevator;

import org.example.elevator.Strategy.NearestSelectionStrategy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.example.elevator.Direction.DOWN;
import static org.example.elevator.Direction.UP;

public class Main {

    public static void main(String[] args) {

        ElevatorController controller =
                new ElevatorController(new NearestSelectionStrategy(), 3);

        controller.requestElevator(2, UP);
        controller.requestElevator(4, UP);
        controller.requestElevator(5, UP);
        controller.requestElevator(3, DOWN);
        controller.requestElevator(1, DOWN);
        controller.requestElevator(8, UP);
        controller.requestElevator(1,UP);

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(3);

        for (Elevator elevator : controller.elevatorList) {
            scheduler.scheduleAtFixedRate(
                    elevator::step,
                    0,
                    1,
                    TimeUnit.SECONDS
            );
        }

        scheduler.schedule(() -> {
            System.out.println("Shutting down elevator system...");
            scheduler.shutdown();
        }, 20, TimeUnit.SECONDS);
    }
}
