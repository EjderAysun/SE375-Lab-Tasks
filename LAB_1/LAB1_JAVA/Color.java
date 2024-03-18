package LAB_1.LAB1_JAVA;

import java.util.HashMap;
import java.util.Scanner;

public class Color {

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_YELLOW = "\u001B[33m";
    String colour = null;

    public void changeColor(Scanner sc, HashMap<Integer, String[]> hash) {

        while(true) {
            try {
                System.out.println("Please state your choice...");
                System.out.println("Color of characters (R or Y): ");
                String k = sc.nextLine();
                if(!k.equals("R") && !k.equals("Y")) throw new Exception("Please write R or Y !");
                else if (k.equals("R")) colour = ANSI_RED;
                else colour = ANSI_YELLOW;
                break;
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        for (String[] arr : hash.values()) {
            String c = arr[1];
            arr[3] = colour+c+ANSI_RESET;
        }
    }
}