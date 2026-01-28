package org.example.elevator;

import org.example.elevator.Strategy.SelectBestElevatorStrategy;
import org.example.elevator.exception.InvalidRequestException;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    public final List<Elevator> elevatorList;
    private final SelectBestElevatorStrategy selectBestElevatorStrategy;

    public ElevatorController(SelectBestElevatorStrategy strategy, int count) {
        this.elevatorList = new ArrayList<>();
        this.selectBestElevatorStrategy = strategy;

        for (int i = 0; i < count; i++) {
            elevatorList.add(new Elevator());
        }
    }

    public void requestElevator(int floor, Direction direction) {

        validateFloor(floor);

        Elevator elevator =
                selectBestElevatorStrategy.selectBest(elevatorList, floor, direction);

        RequestType requestType =
                direction == Direction.UP
                        ? RequestType.PICKUP_UP
                        : RequestType.PICKUP_DOWN;

        elevator.addRequest(new Request(floor, requestType));
    }

    public void stepAll() {
        for (Elevator elevator : elevatorList) {
            elevator.step();
        }
    }

    private void validateFloor(int floor) {
        if (floor < 0 || floor > 9) {
            throw new InvalidRequestException("Invalid floor request: " + floor);
        }
    }
}
