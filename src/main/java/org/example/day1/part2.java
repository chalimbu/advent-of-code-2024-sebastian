package org.example.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;

public class part2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        System.out.println("input");
        while (in.hasNext()) {
            int input = in.nextInt();
            first.add(input);
            input = in.nextInt();
            second.add(input);
        }
        Collections.sort(first);
        Collections.sort(second);
        for(int i=0;i<first.size();i++){
            System.out.println(first.get(i)+","+second.get(i));
        }
        System.out.println("-"+first.size());
        if (first.size() != second.size()) {
            throw new RuntimeException("list of different size");
        }
        int total = 0;
        int pointerLeft = 0;
        int pointerRight = 0;
        int left;
        int right;
        int count=0;
        int previousLeft=Integer.MIN_VALUE;
        while (pointerLeft < first.size() && pointerRight < second.size()-1) {
            left = first.get(pointerLeft);
            right = second.get(pointerRight);
            while(previousLeft==left && pointerLeft<first.size()-1){
                total += previousLeft*count;
                pointerLeft++;
                left = first.get(pointerLeft);
            }
            while (left < right && pointerLeft<first.size()-1) {
                pointerLeft++;
                left = first.get(pointerLeft);
            }
            // two cases equal or larger on the left
            if(left==right){
                 count = 0;

                while (left == right ) {
                    count++;
                    pointerRight++;
                    right = second.get(pointerRight);
                }
                previousLeft = left;
                total += left * count;

                pointerLeft++;
            }else{
                while (left > right  && pointerRight<first.size()-1) {
                    pointerRight++;
                    right = second.get(pointerRight);
                }
            }

        }
        System.out.println(total);
    }

}
