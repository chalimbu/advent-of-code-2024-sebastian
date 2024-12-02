package org.example.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int safeReports = 0;
        System.out.println("input");
        while (scanner.hasNext()) {
            String report = scanner.nextLine();
            String[] levels = report.split(" ");
            if (isSafe(levels, 0)) {
                safeReports++;
            }else{
                System.out.println();
                for(int i=0;i<levels.length;i++){
                    System.out.print(levels[i]+"-");
                }
            }
        }
        System.out.println(safeReports);
    }

    public static boolean isSafe(String[] levels, int errorCount) {
        if (levels.length == 1) return true;
        if (levels.length == 0) return true;
        if (errorCount > 1) {
            return false;
        }
        Boolean isIncreasing;
        Integer firstLevel = Integer.parseInt(levels[0]);
        Integer secondLevel = Integer.parseInt(levels[1]);
        if (firstLevel > secondLevel) {
            isIncreasing = false;
        } else {
            isIncreasing = true;
        }
        for (int i = 1; i < levels.length; i++) {
            if (!increaseLimit(isIncreasing, Integer.parseInt(levels[i - 1]), Integer.parseInt(levels[i]))) {
                return  validateAllSpaces(levels,errorCount);
            }
        }
        return true;
    }

    public static boolean validateAllSpaces(String[] levels, int errorCount){
        for(int i=0;i<levels.length;i++){
            if(isSafe(getCopyWithRemoveIndex(levels, i), errorCount + 1)){
                return true;
            }
        }
        return false;
    }

    public static String[] getCopyWithRemoveIndex(String[] levels, int removeIndex) {
        String[] output = new String[levels.length -1];
        int index = 0;
        for (int i = 0; i < levels.length; i++) {
            if (i != removeIndex) {
                output[index] = levels[i];
                index++;
            }
        }
        return output;
    }

    public static boolean increaseLimit(Boolean isIncreasing, int first, int second) {
        int diference = Math.abs(first - second);
        if (isIncreasing) {
            if (first < second && diference > 0 && diference <= 3) {
                return true;
            } else {
                return false;
            }
        } else {
            if (first > second && diference > 0 && diference <= 3) {
                return true;
            } else {
                return false;
            }
        }
    }
}
