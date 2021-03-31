/*
Finding duplicates in an array -
	The problem is that we want to find duplicates in a one-dimension array of integers in O(N) running time where the integer values are smaller than the length of the array

	1. Of course we can use the brute-force approach (comparing items with all the rest) but it has O(N^2) running time
	2. We can use HashMap - Traverse the given array and try to insert item in a hashtable with the value as the key. If you can not insert the item it means it is a duplicate
		Problem - not an in-place algorithm, we can do better than this.
	3. Using absolute values - with this approach we can achieve O(N) running time algorithm that is in-place as well

	Solution 3 -
		We can solve this problem in O(N) linear running time without the need for extra memory by using absolute values

			consider all the i items of array T[]:

				check the sign of T[abs(T[i])]:
					if it is positive: T[abs(T[i])] = -T[abs(T[i])]
						flip the sign
					else
						the given i item is a repetition
 */

package com.home.findduplicates;


import java.util.HashMap;
import java.util.Scanner;
import static java.lang.Math.abs;

public class Main {

    private static  final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            int element = scanner.nextInt();
            arr[i] = element;
        }

        FindDuplicates(arr);

        scanner.close();
    }

    private static void FindDuplicates(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[abs(arr[i])] > 0){
                arr[abs(arr[i])] = -arr[abs(arr[i])];
            }
            else {
                System.out.print(abs(arr[i]) + " ");
            }
        }


    }

    private static void FindDuplicatesUsingHashMap(int[] arr) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (!hashMap.containsKey(arr[i])){
                hashMap.put(arr[i], 1);
            }else {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
























