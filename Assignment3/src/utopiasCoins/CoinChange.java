package utopiasCoins;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    private Map<Integer, Integer> minNumber = new HashMap<>();

    public int minCoinsMap(int coins[], int m, int V) {

        minNumber.put(0, 0);

        for (int i = 1; i <= V; i++) {
            minNumber.put(i, Integer.MAX_VALUE);
        }
        for (Map.Entry<Integer, Integer> entry : minNumber.entrySet()) {
            if (entry.getKey() != 0) {
                for (int j = 0; j < m; j++) {
                    if (coins[j] <= entry.getKey() && entry.getKey() != 0) {
                        int x = minNumber.get(entry.getKey() - coins[j]);
                        if (x != Integer.MAX_VALUE && x + 1 < minNumber.get(entry.getKey()))
                            minNumber.replace(entry.getKey(), x + 1);
                    }
                }
            }
        }
        if (minNumber.get(V) == Integer.MAX_VALUE)
            return -1;

        return minNumber.get(V);
    }
}
