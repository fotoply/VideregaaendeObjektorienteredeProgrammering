//import matching_brackets_solution.*;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author erso
 */
public class MatchingBrackets
{
    public boolean checkBrackets(String expression)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if(currentChar == '{' || currentChar == '(' || currentChar == '[') {
                stack.push(currentChar);
            }
            else if(currentChar == '}' || currentChar == ']' || currentChar == ')' ) {
                if(stack.empty()) {
                    return false;
                }
                char popped = stack.pop();
                if(!((popped == '{' && currentChar == '}')
                        || (popped == '(' && currentChar == ')')
                        || (popped=='[' && currentChar == ']'))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        MatchingBrackets pc = new MatchingBrackets();

        Scanner in = new Scanner(System.in);
        String expression = "";
        do{
            System.out.println("Enter an expression with { [ ( ) ] }: ('q' to stop)");
            expression = in.nextLine();
            if(!expression.equalsIgnoreCase("q")){
                boolean b = pc.checkBrackets(expression);
                System.out.println(expression + " has balanced brackets: " + b);
            }
        }while (!expression.equalsIgnoreCase("q"));
    }
}