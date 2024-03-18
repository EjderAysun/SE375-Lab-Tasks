package LAB_1.LAB1_JAVA;

import java.util.HashMap;
import java.util.Scanner;

public class Shift{

    int shift_amount = 0;
    final String lower_alphabet = "abcdefghijklmnopqrstuvwxyz";
    final String upper_alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int size_of_alp = lower_alphabet.length();

    public void shiftLetter(Scanner sc, HashMap<Integer, String[]> hash) {

        while(true) {
            try {
                System.out.println("Please state your choice...");
                System.out.println("How many characters to shift (number between 1-3): ");
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
        }
    }
}