/*
Jonathan Rodriguez
Date: 10/20/2024
CS 4080
Assignment 2

This utility class contains helper methods, such as reversing a 1D array, 
which is used to handle the row/column manipulations during face rotations.
*/

public class Utils {
    // Utility method to reverse a 1D array
    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }
}
