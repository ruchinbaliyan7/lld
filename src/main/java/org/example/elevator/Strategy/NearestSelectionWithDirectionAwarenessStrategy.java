package org.example.elevator.Strategy;

import org.example.elevator.Direction;
import org.example.elevator.Elevator;
import org.example.elevator.Request;

import java.util.List;

public class NearestSelectionWithDirectionAwarenessStrategy implements SelectBestElevatorStrategy{
    @Override
    public Elevator selectBest(List<Elevator> elevatorList, int floor, Direction direction) {
        return null;
    }
}
