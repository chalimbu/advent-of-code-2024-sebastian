package org.example.day1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Part1 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        System.out.println("input");
        while (in.hasNext()) {
            int input = in.nextInt();
            first.add(input);
            input=in.nextInt();
            second.add(input);
        }
        Collections.sort(first);
        Collections.sort(second);
        if(first.size()!=second.size()){
            throw new RuntimeException("list of different size");
        }
        int total=0;
        for(int i=0;i<first.size();i++){
            total += Math.abs(first.get(i)-second.get(i));
            System.out.println(Math.abs(first.get(i)-second.get(i)));
        }
        System.out.println(total);

    }
}
