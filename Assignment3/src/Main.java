import nQueensProblem.Queen;
import utopiasCoins.CoinChange;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        // no solutions for this one
        ArrayList<ArrayList<Integer>> ints = Queen.nQueenList(3);
        Queen.printNicely(ints);
        System.out.println("************************");

        ints = Queen.nQueenList(4);
        Queen.printNicely(ints);
        System.out.println("************************");

        ints = Queen.nQueenList(5);
        Queen.printNicely(ints);

        System.out.println("************************");
        System.out.println("Coin change of 0: " + CoinChange.minCoinsMap(0));

        System.out.println("************************");
        System.out.println("Coin change of 6: " + CoinChange.minCoinsMap(6));

        System.out.println("************************");
        System.out.println("Coin change of 15: " + CoinChange.minCoinsMap(15));

        System.out.println("************************");
        System.out.println("Coin change of 22: " + CoinChange.minCoinsMap(22));

        System.out.println("************************");
        System.out.println("Coin change of 83: " + CoinChange.minCoinsMap(83));

    }
}