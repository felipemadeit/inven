// Imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.sound.sampled.SourceDataLine;

public class Inventory {

// Attributes of the Inventory class
    private ArrayList<Item> inventory;
    private String inventoryName;
    private String inventoryDescription;

    // Constructors getter and setters and ToString

    public Inventory() {
    }

    public Inventory(ArrayList<Item> inventory, String inventoryDescription, String inventoryName) {
        this.inventory = inventory;
        this.inventoryDescription = inventoryDescription;
        this.inventoryName = inventoryName;
    }

    public Inventory(String inventoryDescription, String inventoryName) {
        this.inventoryDescription = inventoryDescription;
        this.inventoryName = inventoryName;
    }

    

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getInventoryDescription() {
        return inventoryDescription;
    }

    public void setInventoryDescription(String inventoryDescription) {
        this.inventoryDescription = inventoryDescription;
    }

  

    public void saveAsTxt(String nameFile, Inventory inventory) {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile))) {

            // Write inventory name into the txt
            writer.write(inventory.getInventoryName());
            writer.newLine();

            // Write inventory description
            writer.write(inventory.getInventoryDescription());
            writer.newLine();

            // Write each item in the inventory (file)
            for (Item item: inventory.getInventory()) {
                writer.write(item.getName() + ", " + item.getQuantity() + ", " + item.getDescription());
                writer.newLine();
            }

            System.out.println("Inventario almacenado");
       } catch(IOException e) {
            System.err.println("Error al guardar");
       }
    }

    public Inventory loadInventory() {

        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"))) {
            // Read inventory and description
            String inventoryName = reader.readLine();
            String inventoryDescription = reader.readLine();

            // Initialize a list to save the  items
            ArrayList<Item> items = new ArrayList<>();

            // Read each line from the file to get item data
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    // Parse items data
                    String itemName = parts[0].trim();
                    int itemQuantity = Integer.parseInt(parts[1].trim());
                    String itemDescription = parts[2].trim();

                    //Create and add each item to the list
                    Item item = new Item(itemDescription, itemName,itemQuantity);
                    items.add(item);
                } else {
                    // Launch an error if the read fail
                    System.err.println("Errod reading the file");
                }
            }
            // Return the inventory object after reading all data from the txt
            return new Inventory(items, inventoryName, inventoryDescription);

        } catch (IOException e) {
            // Catch the error
            System.err.println("Error reading the file: " + e.getMessage());
            return null;
        }
    }

    // Method to show the inventary in a format
    public void showInventary (Inventory inventory) {

        System.out.println("Inventory: " + inventory.getInventoryName());
        System.out.println("Description: " + inventory.getInventoryDescription());
        System.out.println("Items: ");

        ArrayList<Item> items = inventory.getInventory();
        
        for (Item item: items) {
            System.out.println("Nombre: " + item.getName());
            System.out.println("Cantidad: " + item.getQuantity());
            System.out.println("Description: " + item.getDescription());
            System.out.println("--------------------------------------");

        }
    }
    



    @Override
    public String toString() {
        return "Inventory [inventory=" + inventory + ", inventoryName=" + inventoryName + ", inventoryDescription="
                + inventoryDescription + "]";
    }

    
}