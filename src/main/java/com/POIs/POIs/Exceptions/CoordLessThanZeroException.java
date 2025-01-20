package com.POIs.POIs.Exceptions;

public class CoordLessThanZeroException extends RuntimeException {
    public CoordLessThanZeroException(String message) {
        super(message);
    }
}
