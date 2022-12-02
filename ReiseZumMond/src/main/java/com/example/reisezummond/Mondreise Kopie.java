package com.example.reisezummond;

public class Mondreise {
    double speedKmh;
    int distanzKm = 384400;

    public Mondreise(double speed) {
        this.speedKmh = speed;
    }

    public double getTravelDurationDays() {
        return (distanzKm / speedKmh) / 24;
    }

    public double getTravelDurationHours() {
        return distanzKm / speedKmh;
    }
}
