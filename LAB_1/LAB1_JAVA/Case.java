package LAB_1.LAB1_JAVA;

import java.util.Scanner;
import java.util.HashMap;

public class Case {

    String l_or_u = null;

    public void changeCase(Scanner sc, HashMap<Integer, String[]> hash) {

        while(true) {
            try {
                System.out.println("Please state your choice...");
                System.out.println("UPPER case or lower case (U or L): ");
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
        }

    }
}