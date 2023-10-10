package setmana2.e13;



import java.util.Scanner;

public class ConfigGame {
    private Game game;
    private Scanner scanner;

    public ConfigGame(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    public void configureGame() {
        while (true) {
            System.out.println("\nConfiguration Menu:\n");
            System.out.println("1. Set Number of Players");
            System.out.println("2. Set Game Level");
            System.out.println("3. Return to Main Menu\n");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of players (1-4): ");
                    int numPlayers = scanner.nextInt();
                    if (numPlayers >= 1 && numPlayers <= 4) {
                        game.setCurrentNumPlayers(numPlayers);
                    } else {
                        System.out.println("Invalid number of players. Please choose between 1 and 4.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the game level: ");
                    int level = scanner.nextInt();
                    game.setCurrentGameLevel(level);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

