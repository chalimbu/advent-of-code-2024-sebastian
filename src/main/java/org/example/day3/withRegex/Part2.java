package org.example.day3.withRegex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            String input = in.nextLine();
            sb.append(input);
        }
        String input = sb.toString();
        int total = 0;
        final String regex = "don\'t\\(\\)|do\\(\\)|mul\\((\\d{1,3}),(\\d{1,3})\\)";
        final Matcher m = Pattern.compile(regex).matcher(input);
        boolean shoultTake = true;
        while (m.find()) {
            String current = m.group(0);
            if (current.equals("do()")) {
                shoultTake = true;
            } else if (current.equals("don't()")) {
                shoultTake = false;
            } else {
                if (shoultTake) {
                    total += Integer.parseInt(m.group(1)) * Integer.parseInt(m.group(2));
                }

            }
        }

        System.out.println(total);
    }
}
