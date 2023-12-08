// public class AlexCharlie {
    
// from math import gcd

// #Create / declare function MinimumHealth

// def MinimumHealth(health, n) :

// # Find the GCD of the array elements

// __gcd = 0;

// for i in range(n) :

// __gcd = gcd(__gcd, health[i]);

// return __gcd;

// # Driver code

// if __name__ == "__main__" :

// health = [ 5, 6, 1, 2, 3, 4 ];

// n = len(health);

// print(MinimumHealth(health, n));

// The code will use GCD or greatest common divisor in array, and also we use loop statement to iterate the function until we get the correct result.

// Learn more about python here:

// brainly.com/question/26497128

// #SPJ4
// }
// java

// public class Game {

//    public static int calculateMinInitialHealth(int[] strengths) {

//        int n = strengths.length;

//        int[] dp = new int[n];

//        dp[n-1] = Math.max(0, -strengths[n-1]);

//        for (int i = n - 2; i >= 0; i--) {

//            dp[i] = Math.max(dp[i + 1] - strengths[i], 0);

//        }

//        return dp[0] + 1;

//    }

//    public static void main(String[] args) {

//        int[] strengths = {5, 8, 2, 6, 1, 7}; // Example strengths of players at each level

//        int minInitialHealth = calculateMinInitialHealth(strengths);

//        System.out.println("Minimum initial health for Charlie: " + minInitialHealth);

//    }

// }
import java.util.Arrays;

public class AlexCharlie {

    public static long getMinimumHealth(int[] initialPlayers, int[] newPlayers, int rank) {
        // Concatenate and sort the players in descending order of strength
        int[] allPlayers = new int[initialPlayers.length + newPlayers.length];
        System.arraycopy(initialPlayers, 0, allPlayers, 0, initialPlayers.length);
        System.arraycopy(newPlayers, 0, allPlayers, initialPlayers.length, newPlayers.length);

        Arrays.sort(allPlayers);

        // Reverse the array to get it in descending order
        int n = allPlayers.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = allPlayers[i];
            allPlayers[i] = allPlayers[n - i - 1];
            allPlayers[n - i - 1] = temp;
        }

        // Initialize variables
        long initialHealth = 0;
        long cumulativeStrength = 0;

        // Iterate through the players
        for (int strength : allPlayers) {
            cumulativeStrength += strength;
            // If the rank-th player is reached, update the initial health
            if (cumulativeStrength >= rank) {
                initialHealth = Math.max(initialHealth, cumulativeStrength);
            }
        }

        return initialHealth;
    }

    public static void main(String[] args) {
        // Example usage
        int[] initialPlayers = {1, 2};
        int[] newPlayers = {3, 4};
        int rank = 2;
        long result = getMinimumHealth(initialPlayers, newPlayers, rank);
        System.out.println(result);
    }
}
