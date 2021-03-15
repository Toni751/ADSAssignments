import calculatorvisitor.CalculatorVisitor;
import customexceptions.MalformedExpressionException;
import token.Operand;
import token.Operation;
import token.Operator;
import token.Token;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws MalformedExpressionException {
        CalculatorVisitor calculatorVisitor = new CalculatorVisitor();
        Client client = new Client(calculatorVisitor);

        ArrayList<Token> tokenList = new ArrayList<>();
        tokenList.add(new Operand(7));
        tokenList.add(new Operand(5));
        tokenList.add(new Operator(Operation.MULTIPLY));
        tokenList.add(new Operand(6));
        tokenList.add(new Operator(Operation.ADD));
        tokenList.add(new Operand(10));
        //tokenList.add(new Operand(10));
        tokenList.add(new Operator(Operation.DIVIDE));

        System.out.println("Postfix expression result is: " + client.evaluateExpression(tokenList));
    }
}
