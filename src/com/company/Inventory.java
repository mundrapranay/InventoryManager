package com.company;
import java.util.*;

// toDo: Make a global scanner instead of multiple scanner objects
// toDo: Use global variables instead of local variables

public class Inventory {

    private List<Item> itemList;

    public void main() {
        itemList = new LinkedList<Item>();
        System.out.println("Welcome to Inventory Manager");
        intro(itemList);
    }

    private void intro(List<Item> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an option:\n 1. New Item(N)\n 2. View Items(V)\n 3. Update Item(U)\n 4. Delete Item(D)\n 5. Quit(Q)");
        String selection = input.nextLine();
        optionSelector(selection, list);
    }

    private void optionSelector(String selection, List<Item> list) {
        Map<Integer, Item> searchMap;
        if (selection.equals("N")) {
            // toDo: Make New Item Object and add it to the inventory
            Scanner input = new Scanner(System.in);
            String name;
            int quantity;
            double price;
            String paidBy;
            System.out.println("Item Name:");
            name = input.nextLine();
            System.out.println("Item Quantity:");
            quantity = input.nextInt();
            System.out.println("Item Price:");
            price = input.nextDouble();
            System.out.println("Item PaidBy:");
            paidBy = input.next();
            list.add(new Item(name, quantity, price, paidBy));
//            System.out.println();
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
            String selection2 = input2.nextLine();
            if (selection2.equals("N")) {
                // toDo: Regex search over names of products
                System.out.println("Enter Name:");
                String keyword = input2.nextLine();
                searchMap = search(keyword,"N",list);
                System.out.println(searchMap);
                System.out.println("Select Item Number:");
                int itemNumber = input2.nextInt();
                updateHelper(searchMap.get(itemNumber), list);
            } else if (selection2.equals("PB")) {
                // toDo: Regex over Paid By
                System.out.println("Enter Name:");
                String keyword = input2.nextLine();
                searchMap = search(keyword, "PB", list);
                System.out.println(searchMap);
                System.out.println("Select Item Number:");
                int itemNumber = input2.nextInt();
                updateHelper(searchMap.get(itemNumber), list);
            } else if (selection2.equals("Q")) {
                // toDo: Less than (inclusive), More than (inclusive), Equal to
                searchMap = numberSearchHelper("Q", list);
                System.out.println(searchMap);
            } else if (selection2.equals("P")) {
                // toDo: Less than (inclusive), More than (inclusive), Equal to
                searchMap = numberSearchHelper("P", list);
                System.out.println(searchMap);
            }else if (selection2.equals("M")) {
                intro(list);
            } else {
                System.out.println("Invalid Option. Choose Again.\n\n");
                optionSelector("U",list);
            }
        } else if (selection.equals("D")){
            Scanner input3 = new Scanner(System.in);
            System.out.println("Enter Name:");
            String keyword = input3.nextLine();
            searchMap = search(keyword,"N",list);
            System.out.println("Select Item Number:");
            int itemNumber = input3.nextInt();
            System.out.println("Are you sure you want to delete item:\n" + searchMap.get(itemNumber).toString()+"\n\n Yes(Y) or No(N)");
            String delete = input3.nextLine();
            if (delete.equals("Y")) {
                try {
                    list.remove(searchMap.get(itemNumber));
                    System.out.println("Item deleted successfully");
                } catch (Error e) {
                    System.out.println(e);
                }
            }
            intro(list);
        } else if (selection.equals("Q")) {
            System.exit(0);
        }else {
            System.out.println("Invalid Option. Choose Again.\n\n");
            intro(list);
        }
    }

    private void updateHelper(Item item, List<Item> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Current Details for " + item.getName() +" are:\n Quantity : " + item.getQuantity() + "\n Price : " + item.getPrice() + "\n Paid By : " + item.getPaidBy());
        list.remove(item);
        System.out.println("Update:\n 1. All Values(A)\n 2. Quantity(Q)");
        String option = input.next();
        if (option.equals("A")) {
            System.out.println("Update values:\n New Quantity : ");
            int newQuantity = input.nextInt();
            System.out.println(" New Price : ");
            double newPrice = input.nextDouble();
            System.out.println(" New Paid By : ");
            String newPaidBy = input.next();
            item.update(item.getName(), newQuantity, newPrice, newPaidBy);
        } else if (option.equals("Q")) {
            System.out.println("Enter New Quantity : ");
            int newQuantity = input.nextInt();
            item.setQuantity(newQuantity);
        } else {
            System.out.println("Invalid Option. Choose Again.\n\n");
            list.add(item);
            updateHelper(item, list);
        }
        list.add(item);
        intro(list);
    }
    private Map<Integer, Item> search(String keyword, String option, List<Item> list) {
        Map<Integer, Item> result = new TreeMap<>();
        int itemCount = 0;
        String checkWord;
        for (Item i : list) {
            if (option.equals("N")) {
                checkWord = i.getName();
            } else {
                checkWord = i.getPaidBy();
            }
            if(keyword.toLowerCase().equals(checkWord.toLowerCase())) {
                itemCount++;
                result.put(itemCount, i);
            }
        }
        return result;
    }
    // quantity is in int and price is in double
    private Map<Integer, Item> numberSearchHelper (String option, List<Item> list) {
        double price;
        int quantity = 0;
        System.out.println("Choose a search option:\n 1. Greater than(G)\n 2. Equal to(E)\n 3. Less than(L)");
        Scanner input4 = new Scanner(System.in);
        String type = input4.nextLine();
        if (option.equals("Q")) {
            System.out.println("Enter Quantity:");
            quantity = input4.nextInt();
            return numberSearch(type, quantity, list);
        } else {
            System.out.println("Enter price:");
            price = input4.nextDouble();
            return numberSearch(type, price, list);
        }
    }
    private Map<Integer, Item> numberSearch (String type, int number, List<Item> list) {
        Map<Integer, Item> result = new TreeMap<>();
        int itemCount = 0;
        for (Item i : list) {
            int checkNumber = i.getQuantity();
            if (type.equals("G")) {
                if (checkNumber >= number) {
                    itemCount++;
                    result.put(itemCount,i);
                }
            } else if (type.equals("E")) {
                if (checkNumber == number) {
                    itemCount++;
                    result.put(itemCount,i);
                }
            } else if (type.equals("L")) {
                if (checkNumber <= number) {
                    itemCount++;
                    result.put(itemCount,i);
                }
            }
        }
        return result;
    }
    private Map<Integer, Item> numberSearch (String type, double number, List<Item> list) {
        Map<Integer, Item> result = new TreeMap<>();
        int itemCount = 0;
        for (Item i : list) {
            double checkNumber = i.getPrice();
            if (type.equals("G")) {
                if (checkNumber >= number) {
                    itemCount++;
                    result.put(itemCount,i);
                }
            } else if (type.equals("E")) {
                if (checkNumber == number) {
                    itemCount++;
                    result.put(itemCount,i);
                }
            } else if (type.equals("L")) {
                if (checkNumber <= number) {
                    itemCount++;
                    result.put(itemCount,i);
                }
            }
        }
        return result;
    }
}
