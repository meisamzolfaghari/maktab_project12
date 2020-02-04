package ir.maktab.project12.instagram.services;

import java.util.Scanner;
import java.util.Set;

public class Functions {

    public static void displayMenu(Set<String> commands){
        System.out.println("\t+------------------------+");
        System.out.println("\t|          Menu          |");
        System.out.println("\t+------------------------+");
        StringBuilder row;
        for (String command : commands) {
            row = new StringBuilder("\t|   " + command);
            for (; row.length()<26; )
                row.append(" ");
            row.append("|");
            System.out.println(row);
        }
        System.out.println("\t+------------------------+");
    }

    public static String getCommand(Set<String> commands) {
        Scanner scanner = new Scanner(System.in);
        String command;

        displayMenu(commands);
        while (true) {
            System.out.print("\t\u29bf Enter command: ");
            command = scanner.next();

            if (!commands.contains(command))
                System.out.println("\t\u274c Command not found!");
            else
                return command;
        }
    }


}
