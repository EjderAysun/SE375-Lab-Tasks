package LAB_3.LAB3_JAVA;

import java.util.HashMap;
import java.util.Scanner;

public class ColorThread extends Thread{

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_YELLOW = "\u001B[33m";
    String colour = null;

    public ColorThread(Runnable r, String name) {super(r, name);}

    public void run(Scanner sc, HashMap<Integer, String[]> hash) {

        while(true) {
            try {
                System.out.println("What is the colour (R or Y): ");
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
            synchronized (arr[4]) {
                arr[4] = Integer.toString(Integer.valueOf(arr[4]) + 1);
            }
            // or
            // Main.increment(arr);
        }
    }
}