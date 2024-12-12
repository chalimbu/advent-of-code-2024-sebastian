package org.example.day3;

import java.util.Scanner;
import java.util.Stack;

public class Part1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long total= 0;
        while (in.hasNext()) {
            String input = in.nextLine();
            Stack<Character> stack = new Stack<>();
            char[] inputCharacter = input.toCharArray();
            for(int i = inputCharacter.length-1; i >= 0; i--){
                stack.push(inputCharacter[i]);
            }
            long parcialTotal = processCharacter(stack);
            total += parcialTotal;

        }

        System.out.println(total);

    }

    // mul(xx,yy)
    // N -> nothing
    // m -> start string builders
    // mul( -> each character
    // x -> start x1 end x2, x state
    // , -> ,
    // y -> start y1 end y2, y state
    // ) -> sums total, restarts at N
    public static long processCharacter(Stack<Character> input){
        long total= 0;
        Character state = 'N';
        StringBuilder n1= new StringBuilder();
        StringBuilder n2= new StringBuilder();
        while(!input.isEmpty()){
            Character current = input.pop();
            switch (state){
                case 'N':
                    if(current=='m'){
                        state = 'm';
                    }
                    break;
                case 'm':
                    n1= new StringBuilder();
                    n2= new StringBuilder();
                    if(current=='u'){
                        state = 'u';
                    }else if(current == 'm'){
                        state = 'm';
                    } else{
                        state = 'N';
                    }
                    break;
                case 'u':
                    if(current=='l'){
                        state = 'l';
                    }else if(current == 'm'){
                        state = 'm';
                    } else{
                        state = 'N';
                    }
                    break;
                case 'l':
                    if(current=='('){
                        state = '(';
                    }else if(current == 'm'){
                        state = 'm';

                    }else{
                        state = 'N';
                    }
                    break;
                case '(':
                    if(isNumber(current)){
                        state = 'x';
                        n1.append(current);
                    }else if(current == 'm'){
                        state = 'm';

                    }else{
                        state = 'N';
                    }
                    break;
                case 'x':
                    if(isNumber(current)){
                        state = 'x';
                        n1.append(current);
                    }else if(current == 'm'){
                        state = 'm';

                    }else if(current==','){
                        state = ',';
                    }else {
                        state = 'N';
                    }
                    break;
                case ',':
                    if(isNumber(current)){
                        state = 'y';
                        n2.append(current);
                    }else if(current == 'm'){
                        state = 'm';

                    }else{
                        state = 'N';
                    }
                    break;
                case 'y':
                    if(isNumber(current)){
                        state = 'y';
                        n2.append(current);
                    }else if(current == 'm'){
                        state = 'm';

                    }else if(current==')') {
                        state = ')';
                        long number1 = Long.parseLong(n1.toString());
                        long number2 =  Long.parseLong(n2.toString());
                        total += number1 * number2;
                    }else{
                        state = 'N';
                    }
                    break;
                case ')':
                    if(current=='m'){
                        state = 'm';
                    }else{
                        state = 'N';
                    }
                    break;
                default:
                    if(current == 'm') {
                        state = 'm';
                    }else {
                        state = 'N';
                    }
            }

        }
        return total;
    }

    public static boolean isNumber(Character c){
        int n = c - 48;
        if(n>=0&&n<=9){
            return true;
        }else{
            return false;
        }
    }
}
