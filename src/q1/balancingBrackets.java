package q1;

import java.util.Scanner;
import java.util.Stack;

public class balancingBrackets {
    //function to calculate the balanced nature

    static boolean checkingBracketsBalanced(String bracketExpression) {

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<bracketExpression.length();i++)
        {
            char character =bracketExpression.charAt(i);
            if(character== '(' || character== '[' || character== '{')
            {
                stack.push(character);
                continue;
            }

            if(stack.isEmpty())
                return false;

            char c;
            switch(character)
            {
                case '}':
                    c=stack.pop();
                    if(c=='(' || c=='[')
                        return false;
                    break;

                case ')':
                    c=stack.pop();
                    if(c=='{' || c=='[')
                        return false;
                    break;

                case ']':
                    c=stack.pop();
                    if(c=='(' || c=='{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }

    // main
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string of brackets");
        String s1=sc.next();
        //function call
        if(checkingBracketsBalanced(s1)==true)
        {
            System.out.println("the entered string has balanced brackets");
        }
        else
            System.out.println("the entered string do not contain balanced brackets");
    }

}
