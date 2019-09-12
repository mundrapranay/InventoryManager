package com.company;
import java.util.*;


public class Inventory {

    private List<Item> itemList;

    public void main() {
        itemList = new LinkedList<Item>();
        System.out.println("Welcome to Inventory Manager");
        intro(itemList);
    }

    private void intro(List<Item> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an option:\n 1. New Item(N)\n 2. View Items(V)\n 3. Update Item(U)\n 4. Quit(Q)");
        String selection = input.next();
        optionSelector(selection, list);
    }

    private void optionSelector(String selection, List<Item> list) {
        if (selection.equals("N")) {
            // toDo: Make New Item Object and add it to the inventory
            Scanner input = new Scanner(System.in);
            String name = "";
            int quantity = 0;
            double price = 0.0;
            String paidBy = "";
            System.out.println("Item Name:");
            name = input.next();
            System.out.println("Item Quantity:");
            quantity = input.nextInt();
            System.out.println("Item Price:");
            price = input.nextDouble();
            System.out.println("Item PaidBy:");
            paidBy = input.next();
            list.add(new Item(name, quantity, price, paidBy));
            System.out.println();
            intro(list);
        } else if (selection.equals("V")){
            // toDo: Print the list of items, who paid for them and quantity
            for (Item i : list) {
                System.out.print(i.toString());
            }
            System.out.println();
            intro(list);
        } else if (selection.equals("U")) {
            // toDo: Search inventory list  view that item and give options for all getters and setters
            Scanner input2 = new Scanner(System.in);
            System.out.println("Search item by:\n 1. Name(N)\n 2. Quantity(Q)\n 3. Price(P)\n 4. Paid By(PB)\n 5. Main Menu(M)");
            String selection2 = input2.next();
            if (selection2.equals("N") || selection2.equals("PB")) {
                // toDo: Regex search over names of products
                // toDo: Regex over Paid By
                // make helper function
            } else if (selection2.equals("Q") || selection2.equals("P")) {
                // toDo: Less than (inclusive), More than (exclusive), Equal to
                // helper function
            } else if (selection2.equals("M")) {
                intro(list);
            } else {
                System.out.println("Invalid Option. Choose Again.\n\n");
                optionSelector("U",list);
            }
        } else if (selection.equals("Q")){
            System.exit(0);
        }else {
            System.out.println("Invalid Option. Choose Again.\n\n");
            intro(list);
        }
    }

    private Map<Integer,Item> search(String keyword, List<Item> list) {
        return null;
    }
}
