package com.POIs.POIs.util;

import com.POIs.POIs.Exceptions.CoordLessThanZeroException;

public class ValidateCoords {

    public static void validateCoords(int x, int y) {
        if (x < 0 || y < 0) {
            throw new CoordLessThanZeroException("Coordenadas devem ser maiores que 0");
        }
    }
}

