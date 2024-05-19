
import java.util.*;


public class Main {
    
    //Scanner creation
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Menu of the sofware
        int option = 0;

        // The exit option is the number 6
        while (option != 6) {
            System.out.println("Welcome to the best software inventory" );
            System.out.println("What do you want to do today?");
            System.out.println("1. Create new inventory");
            System.out.println("2. View inventory");
            System.out.println("3. Modify Inventory");
            option = scanner.nextInt();

            switch (option) {

                case 1:
                    // Request inventory data from the user
                    System.out.println("Please enter the name of the inventory");
                    String nameInv = scanner.nextLine();

                    scanner.nextLine();
                    System.out.println("Please enter a short description to this inventory");
                    String descripInv = scanner.nextLine();

                    System.out.println("Please enter the quantity of the products");
                    int quantityPro = scanner.nextInt();

                    ArrayList<Item> invent = new ArrayList<>();


                    // Loop to create the number of items said by the user
                    for (int i =0; i < quantityPro; i++) {

                        // Request Item data from the user 
                        System.out.println("Please enter the name of the item");
                        String itemname = scanner.nextLine();

                        scanner.nextLine();
                        System.out.println("Please enter the quantity of the " + itemname + " product");
                        int quantityItem = scanner.nextInt();

                        System.out.println("Please enter a short description oft the item");
                        String itemDescrip = scanner.nextLine();
                        scanner.nextLine();

                        //Each item will be created and stored
                        Item item = new Item(itemDescrip, itemname, quantityItem);
                        invent.add(item);
                    }
                    // Creation of a new objet Inventory
                    Inventory inventory = new Inventory(invent, nameInv, descripInv);
                    inventory.saveAsTxt("inventory.txt", inventory);

                    //inventory.loadInventory();
                    inventory.showInventary(inventory);
                    
                    System.out.println(nameInv + " was created succesfully");
                    break;
                
                case 2:

                    // Create a inventory
                    Inventory txtInv = new Inventory();
                    //Asign to the created inventory the saved inventory in the txt
                    txtInv = txtInv.loadInventory();
        
                    // Check if inventory was loaded successfully
                    if (txtInv != null) {
                        // If the inventory was succesfully charged show inventary
                        txtInv.showInventary(txtInv);
                    } else {
                        System.err.println("No se pudo cargar el inventario desde el archivo.");
                    }
                    
                    
                    



            }
        }

    }
}