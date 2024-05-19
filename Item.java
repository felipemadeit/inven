// Imports
import java.util.*;

public class Item {
    
    // Scanner
    Scanner scanner = new Scanner(System.in);

    // Attributes of the class item
    private String name;
    private int quantity;
    private String description;

    // Constructors and getters and setters
    public Item() {
    }

    public Item(String description, String name, int quantity) {
        this.description = description;
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Class methods

 

    // ToString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item{");
        sb.append("name=").append(name);
        sb.append(", quantity=").append(quantity);
        sb.append(", description=").append(description);
        sb.append('}');
        return sb.toString();
    }





}