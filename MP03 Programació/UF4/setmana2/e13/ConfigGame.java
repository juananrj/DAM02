package setmana2.e13;
import java.util.*;

class ConfigGame {
    public static void configure(Game game, Scanner scanner) {
        System.out.print("Enter the number of players (1-4): ");
        int numPlayers = scanner.nextInt();
        game.setPlayers(numPlayers);

        System.out.print("Enter the game level: ");
        int level = scanner.nextInt();
        game.setLevel(level);
    }
}
