package utopiasCoins;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public static int minCoinsMap(int value) {
        int[] coins = {1, 7, 10, 22};

        Map<Integer, Integer> minNumber = new HashMap<>();
        minNumber.put(0, 0);

        for (int i = 1; i <= value; i++) {
            minNumber.put(i, Integer.MAX_VALUE);
        }

        for (Map.Entry<Integer, Integer> entry : minNumber.entrySet()) {
            if (entry.getKey() != 0) {
                for (int coin : coins) {
                    if (coin <= entry.getKey()) {
                        int x = minNumber.get(entry.getKey() - coin);
                        if (x != Integer.MAX_VALUE && x + 1 < minNumber.get(entry.getKey()))
                            minNumber.replace(entry.getKey(), x + 1);
                    }
                }
            }
        }
        if (minNumber.get(value) == Integer.MAX_VALUE)
            return -1;

        return minNumber.get(value);
    }
}
