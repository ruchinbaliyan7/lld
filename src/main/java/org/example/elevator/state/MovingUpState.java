package org.example.elevator.state;

import org.example.elevator.Elevator;
import org.example.elevator.Request;

public class MovingUpState implements ElevatorState{
    @Override
    public void step(Elevator elevator) {
        if (!elevator.hasUpRequests()) {
            elevator.setState(new IdleState());
            return;
        }

        Request next = elevator.upRequests.peek();

        if (elevator.currentFloor == next.floor) {
            System.out.println("Lift opened at floor " + elevator.currentFloor + " going UP"+ elevator.hashCode());
            elevator.upRequests.poll();
        } else {
            elevator.currentFloor++;
        }

    }
}
