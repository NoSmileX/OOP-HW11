package org.example;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File folder = new File("FolderForTXT");
        folder.mkdirs();
        File inputFile = new File(folder, "src.txt");
        File outFirst = new File(folder, "first.txt");
        File outSecond = new File(folder, "second.txt");
        File outThird = new File(folder, "third.txt");
        File outFour = new File(folder, "four.txt");
        System.out.println("Time for copying with Byte Stream is: " +
                FileOperations.copyByteStream(inputFile, outFirst) + " ms");
        System.out.println("Time for copying with Character Stream is: " +
                FileOperations.copyCharacterStream(inputFile, outSecond) + " ms");
        System.out.println("Time for copying with Buffered Stream is: " +
                FileOperations.copyBufferedStream(inputFile, outThird) + " ms");
        System.out.println("Time for copying with Scanner and Print Writer is: " +
                FileOperations.copyWithScanner(inputFile, outFour) + " ms");

        // Сериализовать и десереализовать обьекты из произвольного созданного типа

        Dogs first = new Dogs("Dana", 9, "rabbit", true);
        Dogs second = new Dogs("Kama", 7, "chicken", false);
        Dogs third = new Dogs("Najda", 8, "fish", true);
        Dogs [] dogs = {first, second, third};

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Dogs.ser"));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Dogs.ser"))) {
            out.writeObject(dogs);
            Dogs[] list = (Dogs[]) in.readObject();
            System.out.println(Arrays.toString(list));

        }catch (IOException | ClassNotFoundException e){
            throw e;
        }
    }
}