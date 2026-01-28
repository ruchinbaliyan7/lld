package org.example.elevator;


import java.util.Objects;

public class Request {
    public int floor;
    public RequestType requestType;

    public Request(int floor, RequestType requestType) {
        this.floor = floor;
        this.requestType = requestType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return floor == request.floor && requestType == request.requestType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floor, requestType);
    }


}
