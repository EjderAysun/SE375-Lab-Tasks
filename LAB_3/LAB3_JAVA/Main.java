package LAB_3.LAB3_JAVA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String data = null;

        try {
            File f = new File("LAB_3/Mission_Documents#3/sample0.txt");
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
            String[] arr = new String[5];
            arr[0] = c;
            arr[4] = "0";
            hashMap.put(i+1, arr);
        }

        Scanner sc = new Scanner(System.in);
        MyRunnable r = new MyRunnable();
        CaseThread caseThread = new CaseThread(r,"case thread");
        ShiftThread shiftThread = new ShiftThread(r,"shift thread");
        ColorThread colorThread =  new ColorThread(r,"color thread");

        caseThread.start();
        caseThread.run(sc, hashMap);

        shiftThread.start();
        shiftThread.run(sc, hashMap);

        colorThread.start();
        colorThread.run(sc, hashMap);

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

        System.out.println();
        System.out.print("Number of Transformations\n[");
        for(String[] arr : hashMap.values()) {
            System.out.print(", " + arr[4]);
        }
        System.out.println("]");
    }

    public static synchronized void increment(String[] arr) {
        arr[4] = Integer.toString(Integer.valueOf(arr[4]) + 1);
    }
}