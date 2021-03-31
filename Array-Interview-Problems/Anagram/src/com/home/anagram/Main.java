/*
Anagram problem -
	An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
	Eg - restful - fluster

	The original word or phrase is called the subject
	Any word or phrase that exactly reproduces the letters in another order is an anagram

	Remove all the white space from both the Strings s1 and s2, by passing the string to the replaceAll() method. We are using using regex “\\s” [\\s is regex for whitespace] and replacing it with “”
    s1 = s1.replaceAll(“\\s”, “”);
    s2 = s2.replaceAll(“\\s”, “”);
*/

package com.home.anagram;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static  final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String subject = scanner.nextLine();
        String anagram = scanner.nextLine();

        checkAnagram1(subject,anagram);
    }

    private static void checkAnagram1(String subject, String anagram) {

        subject = subject.replaceAll("\\s","");
        anagram = anagram.replaceAll("\\s","");

        char[] subjectArr = subject.toCharArray();
        char[] anagramArr = anagram.toCharArray();

        Arrays.sort(subjectArr);
        Arrays.sort(anagramArr);

        if (Arrays.equals(subjectArr,anagramArr)){
            System.out.println("Is an Anagram");
        }
        else {
            System.out.println("Not an Anagram");
        }
    }

    private static void checkAnagram2(String subject, String anagram) {

        if(subject.length() != anagram.length()){
            System.out.println("Not an Anagram");
            return;
        }

        int[] arr = new int[26];

        for (int i = 0; i < subject.length(); i++) {

            arr[subject.charAt(i)-97]++;
        }

        for (int i = 0; i < anagram.length(); i++) {

            arr[anagram.charAt(i)-97]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                System.out.println("Not an Anagram");
                return;
            }
        }

        System.out.println("Is an Anagram");
    }
}
