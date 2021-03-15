import calculatorvisitor.CalculatorVisitor;
import customexceptions.MalformedExpressionException;
import token.Token;

import java.util.ArrayList;

public class Client
{
    private CalculatorVisitor calculatorVisitor;

    public Client(CalculatorVisitor calculatorVisitor) {
        this.calculatorVisitor = calculatorVisitor;
    }

    public int evaluateExpression(ArrayList<Token> tokenList) throws MalformedExpressionException {
        for (Token token : tokenList) {
            token.accept(calculatorVisitor);
        }
        return calculatorVisitor.getResult();
    }
}
