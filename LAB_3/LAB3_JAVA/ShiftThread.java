package LAB_3.LAB3_JAVA;

import java.util.HashMap;
import java.util.Scanner;

public class ShiftThread extends Thread{

    public ShiftThread(Runnable r, String name) {super(r, name);}

    int shift_amount = 0;
    final String lower_alphabet = "abcdefghijklmnopqrstuvwxyz";
    final String upper_alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int size_of_alp = lower_alphabet.length();

    public void run(Scanner sc, HashMap<Integer, String[]> hash) {

        while(true) {
            try {
                System.out.println("What is the shift amount?");
                String k = sc.nextLine();
                if(!k.equals("1") && !k.equals("2") && !k.equals("3")) throw new Exception("Please write 1 or 2 or 3 !");
                else shift_amount = Integer.parseInt(k);
                break;
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        for (String[] arr : hash.values()) {
            String c = arr[0];
            if(c.toUpperCase().equals(c)) {
                int index = upper_alphabet.indexOf(c);
                arr[2] = upper_alphabet.substring((index + shift_amount) % size_of_alp, (index + shift_amount) % size_of_alp + 1);
            } else {
                int index = lower_alphabet.indexOf(c);
                arr[2] = lower_alphabet.substring((index + shift_amount) % size_of_alp, (index + shift_amount) % size_of_alp + 1);
            }
            synchronized (arr[4]) {
                arr[4] = Integer.toString(Integer.valueOf(arr[4]) + 1);
            }
            // or
            // Main.increment(arr);
        }
    }
}