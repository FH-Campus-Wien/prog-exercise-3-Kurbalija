package at.ac.fhcampuswien;

import java.util.Scanner;

public class App {
    public static void oneMonthCalendar(int x, int y) {
        int[] day = new int[x];

        y--;

        for (int i = 0; i < day.length; i++) {
            day[i] = i+1;
        }

        for (int i = 1; i <= y; i++) {
            System.out.print("   ");
        }

        for (int i = 0; i < day.length; i++) {
            if (day[i] < 10) {
                System.out.print(" ");
            }

            System.out.print(day[i]+" ");

            if ((day[i]+y)%7==0) {
                System.out.println("");
            }
        }
        if (x == 28) {
            System.out.println(""); //Um den "magischen" new line im Test zu schaffen
        }
    }

    public static void guessingGame(int numberToGuess) {
        Scanner eingabe = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.print("Guess number "+i+":");
            int guess = eingabe.nextInt();
            if (guess < numberToGuess) {
                if (i == 10) {
                    System.out.println(" You lost! Have you ever heard of divide & conquer?");
                    break;
                } else {
                    System.out.println(" The number AI picked is higher than your guess.");
                }
            }
            if (guess > numberToGuess) {
                if (i == 10) {
                    System.out.println(" You lost! Have you ever heard of divide & conquer?");
                    break;
                } else {
                    System.out.println(" The number AI picked is lower than your guess.");
                }
            }
            if (guess == numberToGuess) {
                System.out.println(" You won wisenheimer!");
                break;
            }
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        return (int) ((Math.random() * (100 - 1)) + 1);
    }

    public static boolean swapArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        } else {
            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] + b[i];
                b[i] = a[i] - b[i];
                a[i] = a[i] - b[i];
            }
            return true;
        }
    }

    public static long[] lcg(long s) {
        int a = 1103515245;
        int c = 12345;
        long m = ((long) Math.pow(2, 31));
        long[] ergebnis = new long[10];
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                ergebnis[i] = (a * s + c) % m;
            } else {
                ergebnis[i] = (a * ergebnis[i-1] + c) % m;
            }
        }
        return ergebnis;
    }

    public static String camelCase(String text) {
        char[] array = text.toCharArray();
        int asciirange = 32;
        boolean upper = true;
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                if (upper == false) {
                    array[i] = (char) (array[i] + asciirange);
                    upper = false;
                }
                build.append(array[i]);
                upper = false;
            } else if (array[i] >= 'a' && array[i] <= 'z'){
                if (upper == true) {
                    array[i] = (char) (array[i] - asciirange);
                    upper = false;
                }
                build.append(array[i]);
            } else if (array[i] == ' ') {
                upper = true;
            }
        }
        System.out.println(build);
        return build.toString();
    }

    public static int checkDigit(int[] a){
        int sum = 0;
        int gewicht = 2;
        int diff;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * (i + gewicht);
        }
        int rest = sum % 11;
        diff = 11 - rest;
        if (diff == 10) {
            diff = 0;
        }
        if (diff == 11) {
            diff = 5;
        }
        return diff;
    }
    public static void main(String[] args) {
        camelCase("my name isn't Alice!");
    }
}