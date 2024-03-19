package LAB_3.LAB3_JAVA;

import java.util.Scanner;
import java.util.HashMap;

public class CaseThread extends Thread {

    public CaseThread(Runnable r, String name) {super(r, name);}

    String l_or_u = null;

    public void run(Scanner sc, HashMap<Integer, String[]> hash) {

        while(true) {
            try {
                System.out.println("Upper case (U) or Lower case (L)");
                l_or_u = sc.nextLine();
                if(!l_or_u.equals("U") && !l_or_u.equals("L")) throw new Exception("Please write 'U' or 'L'");
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (String[] arr : hash.values()) {
            String c = arr[0];
            if(l_or_u.equals("U")) arr[1] = c.toUpperCase();
            else arr[1] = c.toLowerCase();
            synchronized (arr[4]) {
                arr[4] = Integer.toString(Integer.valueOf(arr[4]) + 1);
            }
            // or
            // Main.increment(arr);
        }
    }
}