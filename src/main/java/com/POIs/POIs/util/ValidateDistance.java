package com.POIs.POIs.util;

import com.POIs.POIs.Exceptions.DistanceLessThanOneException;

public class ValidateDistance {
    public static void validateDistance(int distance) {
        if (distance < 1) {
            throw new DistanceLessThanOneException("A distancia não pode ser menor que 1");
        }
    }
}
