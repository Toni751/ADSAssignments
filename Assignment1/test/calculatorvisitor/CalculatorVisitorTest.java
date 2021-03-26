package calculatorvisitor;

import customexceptions.MalformedExpressionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import token.Operand;
import token.Operation;
import token.Operator;

// I've only tested the get result for exceptions/simple cases here, tested it more generally through the client, I hope it's fine
public class CalculatorVisitorTest {

    private CalculatorVisitor calculatorVisitor;

    @BeforeEach
    void setUpCalculatorVisitor()
    {
        calculatorVisitor = new CalculatorVisitor();
    }

    @Test
    void GetResultThrowsExceptionForEmptyStack()
    {
        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void GetResultThrowsExceptionForInvalidExpression()
    {
        calculatorVisitor.visit(new Operand(5));
        calculatorVisitor.visit(new Operator(Operation.ADD));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void GetResultThrowsExceptionForTwoOperandsLeft()
    {
        calculatorVisitor.visit(new Operand(3));
        calculatorVisitor.visit(new Operand(5));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void GetResultThrowsExceptionForDivisionByZero()
    {
        calculatorVisitor.visit(new Operand(5));
        calculatorVisitor.visit(new Operand(0));
        calculatorVisitor.visit(new Operator(Operation.DIVIDE));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void GetResultThrowsExceptionAfterStackNotBecomingEmpty()
    {
        calculatorVisitor.visit(new Operand(1));
        calculatorVisitor.visit(new Operand(2));
        calculatorVisitor.visit(new Operand(3));
        calculatorVisitor.visit(new Operator(Operation.ADD));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void GetResultThrowsExceptionAfterOperationWithNoOperands()
    {
        calculatorVisitor.visit(new Operator(Operation.ADD));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }
}
