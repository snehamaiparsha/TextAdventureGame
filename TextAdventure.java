import java.util.Scanner;

public class TextAdventure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdventureModel model = new AdventureModel();

        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("Type commands like 'go north', 'look', 'take torch', 'inventory', or 'exit'.");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            String response = model.processCommand(command);
            if (response.equals("exit")) {
                System.out.println("Thanks for playing!");
                break;
            }
            System.out.println(response);
        }

        scanner.close();
    }
}
