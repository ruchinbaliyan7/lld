package org.example.elevator.state;

import org.example.elevator.Elevator;

public interface ElevatorState {
    void step(Elevator elevator);
}