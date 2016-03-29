//import matching_brackets_solution.*;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author erso
 */
public class MatchingBrackets
{
    Stack<Character> stack = new Stack<>();
    public boolean checkBrackets(String expression)
    {
        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '{' || expression.charAt(i) == '(' || expression.charAt(i) == '[') {
                stack.push(expression.charAt(i));
            }
            if(expression.charAt(i) == '}' || expression.charAt(i) == ']' || expression.charAt(i) == ')' ) {
                if(stack.empty()) {
                    return false;
                }
                char popped = stack.pop();
                if(!((popped == '{' && expression.charAt(i) == '}') || (popped == '(' && expression.charAt(i) == ')') || (popped=='[' && expression.charAt(i) == ']'))) {
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