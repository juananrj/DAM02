package setmana2.e13;
import java.util.Scanner;


public class Menu {
    private Game game;
    private ConfigGame configGame;
    private Scanner scanner;

    public Menu() {
        this.game = new Game();
        this.configGame = new ConfigGame(game);
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nMain Menu:\n");
            System.out.println("1. Play");
            System.out.println("2. Settings");
            System.out.println("3. Exit\n");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    playGame();
                    break;
                case 2:
                    configGame.configureGame();
                    break;
                case 3:
                    System.out.println("Exiting the game. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private void playGame() {
        System.out.println("Playing.... ");
        System.out.println("Current Game Level: " + game.getCurrentGameLevel());
        System.out.println("Current Number of Players: " + game.getCurrentNumPlayers());
        System.out.println("Game Over.... ");

    }
}
