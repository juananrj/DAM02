package setmana2.e13;
import java.util.*;

class MenuExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Play");
            System.out.println("2. Settings");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    game.play();
                    break;
                case 2:
                    ConfigGame.configure(game, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the game. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
