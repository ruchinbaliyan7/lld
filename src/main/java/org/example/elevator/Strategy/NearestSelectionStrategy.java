package org.example.elevator.Strategy;

import org.example.elevator.Direction;
import org.example.elevator.Elevator;

import java.util.List;

public class NearestSelectionStrategy implements SelectBestElevatorStrategy {

    @Override
    public Elevator selectBest(List<Elevator> elevators, int floor, Direction direction) {

        Elevator elevator = findCommittedToFloor(elevators, floor, direction);
        if (elevator != null) return elevator;

        elevator = findNearestIdle(elevators, floor);
        if (elevator != null) return elevator;

        // Fallback: pick nearest elevator regardless of state
        return findNearestOverall(elevators, floor);
    }

    private Elevator findNearestIdle(List<Elevator> elevators, int floor) {
        Elevator nearest = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            if (e.direction != Direction.IDLE) continue;

            int distance = Math.abs(e.currentFloor - floor);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = e;
            }
        }
        return nearest;
    }

    private Elevator findCommittedToFloor(
            List<Elevator> elevators, int floor, Direction direction) {

        Elevator nearest = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {

            if (e.direction != direction) continue;

            boolean movingTowards =
                    (direction == Direction.UP && e.currentFloor <= floor) ||
                            (direction == Direction.DOWN && e.currentFloor >= floor);

            if (!movingTowards) continue;

            int distance = Math.abs(e.currentFloor - floor);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = e;
            }
        }
        return nearest;
    }

    private Elevator findNearestOverall(List<Elevator> elevators, int floor) {
        Elevator nearest = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            int distance = Math.abs(e.currentFloor - floor);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = e;
            }
        }
        return nearest;
    }
}
