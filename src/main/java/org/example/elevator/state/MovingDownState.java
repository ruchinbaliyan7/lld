package org.example.elevator.state;

import org.example.elevator.Elevator;
import org.example.elevator.Request;

public class MovingDownState implements ElevatorState{
    @Override
    public void step(Elevator elevator) {
        if (!elevator.hasDownRequests()) {
            elevator.setState(new IdleState());
            return;
        }

        Request next = elevator.downRequests.peek();

        if (elevator.currentFloor == next.floor) {
            System.out.println("Lift opened at floor " + elevator.currentFloor + " going DOWN" + elevator.hashCode());
            elevator.downRequests.poll();
        } else {
            elevator.currentFloor--;
        }
    }
}
