package org.example.elevator.state;

import org.example.elevator.Elevator;

public class IdleState implements ElevatorState{
    @Override
    public void step(Elevator elevator) {
        if (elevator.hasUpRequests() && elevator.hasDownRequests()) {
            int upDist = Math.abs(elevator.currentFloor - elevator.upRequests.peek().floor);
            int downDist = Math.abs(elevator.currentFloor - elevator.downRequests.peek().floor);

            elevator.setState(upDist <= downDist
                    ? new MovingUpState()
                    : new MovingDownState());

        } else if (elevator.hasUpRequests()) {
            elevator.setState(new MovingUpState());
        } else if (elevator.hasDownRequests()) {
            elevator.setState(new MovingDownState());
        }
    }
}
