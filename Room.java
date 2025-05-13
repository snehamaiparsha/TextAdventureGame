import java.util.*;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits;
    private List<String> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
    }

    public void setExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    public String getDescription() {
        return description;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public boolean removeItem(String item) {
        return items.remove(item);
    }

    public List<String> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public String getExitString() {
        return "Exits: " + String.join(", ", exits.keySet());
    }
}
