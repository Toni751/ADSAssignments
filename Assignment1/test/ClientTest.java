import calculatorvisitor.CalculatorVisitor;
import customexceptions.MalformedExpressionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import token.Operand;
import token.Operation;
import token.Operator;
import token.Token;

import java.util.ArrayList;

public class ClientTest {

    private Client client;
    private ArrayList<Token> tokenList;

    @BeforeEach
    void setUpClient()
    {
        CalculatorVisitor calculatorVisitor = new CalculatorVisitor();
        client = new Client(calculatorVisitor);

        tokenList = new ArrayList<>();
    }

    @Test
    void evaluateSingleOperandNoOperationExpression() throws MalformedExpressionException
    {
        tokenList.add(new Operand(1));

        Assertions.assertEquals(1, client.evaluateExpression(tokenList));
    }

    @Test
    void evaluateSingleAddOperationExpression() throws MalformedExpressionException
    {
        tokenList.add(new Operand(1));
        tokenList.add(new Operand(2));
        tokenList.add(new Operator(Operation.ADD));

        Assertions.assertEquals(3, client.evaluateExpression(tokenList));
    }

    @Test
    void evaluateSingleSubtractOperationExpression() throws MalformedExpressionException
    {
        tokenList.add(new Operand(7));
        tokenList.add(new Operand(5));
        tokenList.add(new Operator(Operation.SUBTRACT));

        Assertions.assertEquals(2, client.evaluateExpression(tokenList));
    }

    @Test
    void evaluateSingleMultiplyOperationExpression() throws MalformedExpressionException
    {
        tokenList.add(new Operand(7));
        tokenList.add(new Operand(5));
        tokenList.add(new Operator(Operation.MULTIPLY));

        Assertions.assertEquals(35, client.evaluateExpression(tokenList));
    }

    @Test
    void evaluateSingleDivideOperationExpression() throws MalformedExpressionException
    {
        tokenList.add(new Operand(12));
        tokenList.add(new Operand(5));
        tokenList.add(new Operator(Operation.DIVIDE));

        Assertions.assertEquals(2, client.evaluateExpression(tokenList));
    }

    @Test
    void evaluateMultipleOperandsAndMultipleOperatorsExpression() throws MalformedExpressionException
    {
        tokenList.add(new Operand(12));
        tokenList.add(new Operand(5));
        tokenList.add(new Operand(7));
        tokenList.add(new Operand(3));
        tokenList.add(new Operator(Operation.DIVIDE));
        tokenList.add(new Operator(Operation.MULTIPLY));
        tokenList.add(new Operator(Operation.SUBTRACT));

        Assertions.assertEquals(2, client.evaluateExpression(tokenList));
    }

    @Test
    void evaluateMultipleOperandsAndOperatorsExpression() throws MalformedExpressionException
    {
        tokenList.add(new Operand(12));
        tokenList.add(new Operand(5));
        tokenList.add(new Operator(Operation.DIVIDE));
        tokenList.add(new Operand(7));
        tokenList.add(new Operator(Operation.MULTIPLY));
        tokenList.add(new Operand(3));
        tokenList.add(new Operator(Operation.SUBTRACT));

        Assertions.assertEquals(11, client.evaluateExpression(tokenList));
    }

    @Test
    void evaluateExpressionWithNumberOfOperandsLessOrEqualToOperators()
    {
        tokenList.add(new Operand(12));
        tokenList.add(new Operand(5));
        tokenList.add(new Operator(Operation.DIVIDE));
        tokenList.add(new Operator(Operation.MULTIPLY));
        tokenList.add(new Operator(Operation.SUBTRACT));

        Assertions.assertThrows(MalformedExpressionException.class, () -> client.evaluateExpression(tokenList));
    }
}
