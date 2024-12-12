package org.example.day3;

import java.util.Scanner;
import java.util.Stack;

public class Part2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            String input = in.nextLine();
            sb.append(input);
        }
        Stack<Character> stack = new Stack<>();
        String input = sb.toString();
        char[] inputCharacter = input.toCharArray();
        for (int i = inputCharacter.length - 1; i >= 0; i--) {
            stack.push(inputCharacter[i]);
        }


        System.out.println( processCharacter(stack));

    }

    // mul(xx,yy)
// N -> nothing
// m -> start string builders
// mul( -> each character
// x -> start x1 end x2, x state
// , -> ,
// y -> start y1 end y2, y state
// ) -> sums total, restarts at N
// do( -> do character, ( -> q , )-> w
// don't -> chacerters, ( -> e -, ) -> r
    public static long processCharacter(Stack<Character> input) {
        long total = 0;
        Character state = 'N';
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();
        boolean doAdd=true;
        while (!input.isEmpty()) {
            Character current = input.pop();
            switch (state) {
                case 'N':
                    if (current == 'm') {
                        state = 'm';
                    } else if (current == 'd') {
                        state = 'd';
                    }
                    break;
                case 'm':
                    n1 = new StringBuilder();
                    n2 = new StringBuilder();
                    if (current == 'u') {
                        state = 'u';
                    } else if (current == 'm') {
                        state = 'm';
                    } else if (current == 'd') {
                        state = 'd';
                    } else {
                        state = 'N';
                    }
                    break;
                case 'u':
                    if (current == 'l') {
                        state = 'l';
                    } else if (current == 'm') {
                        state = 'm';
                    } else if (current == 'd') {
                        state = 'd';
                    } else {
                        state = 'N';
                    }
                    break;
                case 'l':
                    if (current == '(') {
                        state = '(';
                    } else if (current == 'm') {
                        state = 'm';

                    } else if (current == 'd') {
                        state = 'd';
                    } else {
                        state = 'N';
                    }
                    break;
                case '(':
                    if (isNumber(current)) {
                        state = 'x';
                        n1.append(current);
                    } else if (current == 'm') {
                        state = 'm';

                    } else if (current == 'd') {
                        state = 'd';
                    } else {
                        state = 'N';
                    }
                    break;
                case 'x':
                    if (isNumber(current)) {
                        state = 'x';
                        n1.append(current);
                    } else if (current == 'm') {
                        state = 'm';

                    } else if (current == ',') {
                        state = ',';
                    } else if (current == 'd') {
                        state = 'd';
                    } else {
                        state = 'N';
                    }
                    break;
                case ',':
                    if (isNumber(current)) {
                        state = 'y';
                        n2.append(current);
                    } else if (current == 'd') {
                        state = 'd';
                    } else if (current == 'm') {
                        state = 'm';

                    } else {
                        state = 'N';
                    }
                    break;
                case 'y':
                    if (isNumber(current)) {
                        state = 'y';
                        n2.append(current);
                    } else if (current == 'm') {
                        state = 'm';

                    } else if (current == ')') {
                        state = ')';
                        long number1 = Long.parseLong(n1.toString());
                        long number2 = Long.parseLong(n2.toString());
                        if(doAdd){
                            total += number1 * number2;
                        }

                    } else if (current == 'd') {
                        state = 'd';
                    } else {
                        state = 'N';
                    }
                    break;
                case 'd':
                    if (current == 'm') {
                        state = 'm';
                    } else if (current == 'd') {
                        state = 'd';
                    } else if (current == 'o') {
                        state = 'o';
                    } else {
                        state = 'N';
                    }
                    break;
                case 'o': //two paths on do() or don't()
                    if (current == 'm') {
                        state = 'm';
                    } else if (current == 'd') {
                        state = 'd';
                    } else if (current == '(') {
                        state = 'q';
                    } else if (current == 'n') {
                        state = 'n';
                    } else {
                        state = 'N';
                    }
                    break;
                case 'q': //two paths on do() or don't()
                    if (current == 'm') {
                        state = 'm';
                    } else if (current == 'd') {
                        state = 'd';
                    } else if (current == ')') {
                        doAdd = true;
                        state = 'N';
                    } else {
                        state = 'N';
                    }
                    break;
                case 'n': //two paths on do() or don't()
                    if (current == 'm') {
                        state = 'm';
                    } else if (current == 'd') {
                        state = 'd';
                    } else if (current == '\'') {
                        state = '\'';
                    } else {
                        state = 'N';
                    }
                    break;
                case '\'': //two paths on do() or don't()
                    if (current == 'm') {
                        state = 'm';
                    } else if (current == 'd') {
                        state = 'd';
                    } else if (current == 't') {
                        state = 't';
                    } else {
                        state = 'N';
                    }
                    break;
                case 't': //two paths on do() or don't()
                    if (current == 'm') {
                        state = 'm';
                    } else if (current == 'd') {
                        state = 'd';
                    } else if (current == '(') {
                        state = 'e';
                    } else {
                        state = 'N';
                    }
                    break;
                case 'e': //two paths on do() or don't()
                    if (current == 'm') {
                        state = 'm';
                    } else if (current == 'd') {
                        state = 'd';
                    } else if (current == ')') {
                        doAdd = false;
                        state = 'N';
                    } else {
                        state = 'N';
                    }
                    break;
                default:
                    if (current == 'm') {
                        state = 'm';
                    } else if (current == 'd') {
                        state = 'd';
                    } else {
                        state = 'N';
                    }
            }

        }
        return total;
    }

    public static boolean isNumber(Character c) {
        int n = c - 48;
        if (n >= 0 && n <= 9) {
            return true;
        } else {
            return false;
        }
    }
}
