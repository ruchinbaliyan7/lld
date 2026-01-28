package org.example.elevator.Strategy;

import org.example.elevator.Direction;
import org.example.elevator.Elevator;
import org.example.elevator.Request;

import java.util.List;

public interface SelectBestElevatorStrategy {
    Elevator selectBest(List<Elevator> elevatorList, int floor, Direction direction);
}
