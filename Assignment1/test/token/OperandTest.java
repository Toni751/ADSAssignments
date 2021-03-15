package token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OperandTest {

    private Operand operand;
    private int value1;
    private int value2;

    @BeforeEach
    void setUpOperand() {
        value1 = 1;
        value2 = 2;
        operand = new Operand(value1);
    }

    @Test
    void valueRetrieved()
    {
        Assertions.assertEquals(value1, operand.getValue());
    }

    @Test
    void valueRetrievedWorksAfterReinitialization()
    {
        operand = new Operand(value2);
        Assertions.assertEquals(value2, operand.getValue());
    }
}
