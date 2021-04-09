package com.home.reverseinplace;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static  final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            int element = scanner.nextInt();
            arr[i] = element;
        }

        reverseArrayInPlace(arr);

        scanner.close();
    }

    private static void reverseArrayInPlace(int[] arr) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while(startIndex < endIndex){

            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;

            startIndex++;
            endIndex--;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
