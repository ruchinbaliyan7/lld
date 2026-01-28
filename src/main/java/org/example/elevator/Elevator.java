package org.example.elevator;

import org.example.elevator.exception.InvalidRequestException;
import org.example.elevator.state.ElevatorState;
import org.example.elevator.state.IdleState;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Elevator {

    public int currentFloor = 0;
    public Direction direction ;

    public org.example.elevator.state.ElevatorState state;

    public PriorityQueue<Request> upRequests =
            new PriorityQueue<>(11,Comparator.comparingInt(r -> r.floor));

    public PriorityQueue<Request> downRequests =
            new PriorityQueue<>(11, (a, b) -> b.floor - a.floor);

    public Elevator() {
        this.state = new IdleState();
        this.direction = Direction.IDLE;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public synchronized void step() {
        state.step(this);
    }

    public boolean hasUpRequests() {
        return !upRequests.isEmpty();
    }

    public boolean hasDownRequests() {
        return !downRequests.isEmpty();
    }

    public synchronized void addRequest(Request request) {

        if (request.requestType == RequestType.PICKUP_UP
                || request.requestType == RequestType.DESTINATION) {
            upRequests.add(request);
        } else if (request.requestType == RequestType.PICKUP_DOWN) {
            downRequests.add(request);
        } else {
            throw new InvalidRequestException("Invalid request type");
        }

        step();
    }
}
