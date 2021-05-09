import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utopiasCoins.CoinChange;

public class CoinTest {

    @Test
    void minimumNumberOfCoinsForValue0(){
        Assertions.assertEquals(0, CoinChange.minCoinsMap(0));
    }

    @Test
    void minimumNumberOfCoinsForValue1(){
        Assertions.assertEquals(1, CoinChange.minCoinsMap(1));
    }

    @Test
    void minimumNumberOfCoinsForValue6(){
        Assertions.assertEquals(6, CoinChange.minCoinsMap(6));
    }

    @Test
    void minimumNumberOfCoinsForValue15(){
        Assertions.assertEquals(3, CoinChange.minCoinsMap(15));
    }

    @Test
    void minimumNumberOfCoinsForValue22(){
        Assertions.assertEquals(1, CoinChange.minCoinsMap(22));
    }

    @Test
    void minimumNumberOfCoinsForValue83(){
        Assertions.assertEquals(5, CoinChange.minCoinsMap(83));
    }
}
