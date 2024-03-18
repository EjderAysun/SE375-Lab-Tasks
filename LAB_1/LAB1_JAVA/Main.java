package LAB_1.LAB1_JAVA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String data = null;

        try {
            File f = new File("LAB_2/Mission_Documents#2/sample0.txt");
            Scanner fileSc = new Scanner(f);
            while (fileSc.hasNextLine()) {
                data = fileSc.nextLine();
                System.out.println(data);
            }
            fileSc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }

        HashMap<Integer, String[]> hashMap = new HashMap<Integer, String[]>();

        for (int i = 0; i < data.length(); i++) {
            String c = String.valueOf(data.charAt(i));
            String[] arr = new String[4];
            arr[0] = c;
            hashMap.put(i+1, arr);
        }

        Scanner sc = new Scanner(System.in);
        Case caseThread = new Case();
        Shift shiftThread = new Shift();
        Color colorThread =  new Color();

        caseThread.changeCase(sc, hashMap);
        shiftThread.shiftLetter(sc, hashMap);
        colorThread.changeColor(sc, hashMap);

        sc.close();

        System.out.println("Original");
        for(String[] arr : hashMap.values()) {
            System.out.print(arr[0]);
        }

        System.out.println();
        System.out.println("After Case Change");
        for(String[] arr : hashMap.values()) {
            System.out.print(arr[1]);

        }

        System.out.println();
        System.out.println("After Shift");
        for(String[] arr : hashMap.values()) {
            System.out.print(arr[2]);
        }

        System.out.println();
        System.out.println("After Color Change");
        for(String[] arr : hashMap.values()) {
            System.out.print(arr[3]);
        }
    }
}