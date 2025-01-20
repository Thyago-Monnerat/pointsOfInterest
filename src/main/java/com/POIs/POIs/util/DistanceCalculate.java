package com.POIs.POIs.util;



public class DistanceCalculate {

    public static double euclideanDistanceFormula(int referenceX, int userX, int referenceY, int userY) {
        double val = Math.pow((userX - referenceX), 2) + Math.pow((referenceY - userY), 2);
        return Math.sqrt(val);
    }

}
