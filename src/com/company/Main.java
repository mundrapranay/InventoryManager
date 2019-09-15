package com.company;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/*
 toDo: Implement CSV Printer to print log files at tbe end of each session and offer
       to read those log files start of new session.
*/

public class Main {
    private static String logFile = "./logs/inventory.csv";
    private static List<Item> inventory = new LinkedList<>();
    public static void main(String[] args)  throws IOException {
        Inventory session;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(logFile));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
                ){
            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get(0);
                int quantity = Integer.parseInt(csvRecord.get(1));
                double price = Double.parseDouble(csvRecord.get(2));
                String paidBy = csvRecord.get(3);
                inventory.add(new Item(name, quantity, price, paidBy));
            }
            if (!inventory.isEmpty()) {
                session = new Inventory(logFile, inventory);
            } else {
                session = new Inventory(logFile);
            }
        }
        session.main();
    }
}
