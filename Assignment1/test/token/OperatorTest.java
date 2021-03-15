package token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OperatorTest {

    private Operator operator;

    @BeforeEach
    void setUpOperator()
    {
        operator = new Operator(Operation.ADD);
    }

    @Test
    void operationRetrieved()
    {
        Assertions.assertEquals(Operation.ADD, operator.getOperation());
    }

    @Test
    void operationRetrievedWorksAfterReinitialization()
    {
        operator = new Operator(Operation.MULTIPLY);
        Assertions.assertEquals(Operation.MULTIPLY, operator.getOperation());
    }
}
