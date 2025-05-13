import java.util.*;

public class Adventurer {
    private Room currentRoom;
    private List<String> inventory;

    public Adventurer(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void takeItem(String item) {
        inventory.add(item);
    }

    public boolean dropItem(String item) {
        return inventory.remove(item);
    }

    public boolean hasItem(String item) {
        return inventory.contains(item);
    }
}
