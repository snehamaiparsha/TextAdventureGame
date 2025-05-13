import java.util.*;

public class AdventureModel {
    private Adventurer adventurer;

    public AdventureModel() {
        Room room1 = new Room("Forest", "You are in a dark forest. Birds are chirping.");
        Room room2 = new Room("Cave", "You are in a damp cave.");
        Room room3 = new Room("Castle", "You stand before a grand castle.");

        room1.setExit("north", room2);
        room2.setExit("south", room1);
        room2.setExit("east", room3);
        room3.setExit("west", room2);

        room1.addItem("map");
        room2.addItem("torch");
        room3.addItem("key");

        adventurer = new Adventurer(room1);
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public String processCommand(String command) {
        String[] words = command.toLowerCase().trim().split(" ");
        if (words.length == 0) return "Enter a command.";

        switch (words[0]) {
            case "go":
                if (words.length < 2) return "Go where?";
                return goRoom(words[1]);
            case "look":
                return look();
            case "take":
                if (words.length < 2) return "Take what?";
                return take(words[1]);
            case "drop":
                if (words.length < 2) return "Drop what?";
                return drop(words[1]);
            case "use":
                if (words.length < 2) return "Use what?";
                return use(words[1]);
            case "inventory":
                return showInventory();
            case "exit":
                return "exit";
            default:
                return "Unknown command.";
        }
    }

    private String goRoom(String direction) {
        Room nextRoom = adventurer.getCurrentRoom().getExit(direction);
        if (nextRoom == null) {
            return "You can't go that way.";
        } else {
            adventurer.setCurrentRoom(nextRoom);
            return "You moved to " + nextRoom.getName() + ".\n" + nextRoom.getDescription();
        }
    }

    private String look() {
        Room room = adventurer.getCurrentRoom();
        String items = room.getItems().isEmpty() ? "No items here." : "You see: " + room.getItems();
        return room.getDescription() + "\n" + room.getExitString() + "\n" + items;
    }

    private String take(String item) {
        Room room = adventurer.getCurrentRoom();
        if (room.getItems().contains(item)) {
            room.removeItem(item);
            adventurer.takeItem(item);
            return "You took the " + item + ".";
        } else {
            return "There is no " + item + " here.";
        }
    }

    private String drop(String item) {
        if (adventurer.dropItem(item)) {
            adventurer.getCurrentRoom().addItem(item);
            return "You dropped the " + item + ".";
        } else {
            return "You don't have that item.";
        }
    }

    private String use(String item) {
        if (adventurer.hasItem(item)) {
            return "You used the " + item + ". Nothing happens... yet.";
        } else {
            return "You don't have that item.";
        }
    }

    private String showInventory() {
        List<String> inv = adventurer.getInventory();
        return inv.isEmpty() ? "You're carrying nothing." : "Inventory: " + inv;
    }
}
