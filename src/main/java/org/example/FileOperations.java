package org.example;

import java.io.*;
import java.util.Scanner;

public class FileOperations {

    public static long copyByteStream(File in, File out) throws IOException {
        long start = System.currentTimeMillis();

        byte[] buffer = new byte[1024 * 1024];
        int readByte = 0;
        try (FileInputStream fis = new FileInputStream(in);
             FileOutputStream fos = new FileOutputStream(out)) {
            while ((readByte = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, readByte);
            }
        } catch (IOException e) {
            throw e;
        }
        return System.currentTimeMillis() - start;
    }

    public static long copyCharacterStream(File in, File out) throws IOException {
        long start = System.currentTimeMillis();

        char[] buffer = new char[1024 * 1024];
        int readChar = 0;
        try (FileReader fr = new FileReader(in);
             FileWriter fw = new FileWriter(out)) {
            while ((readChar = fr.read(buffer)) > 0) {
                fw.write(buffer, 0, readChar);
            }
        } catch (IOException e) {
            throw e;
        }
        return System.currentTimeMillis() - start;
    }

    public static long copyBufferedStream(File in, File out) throws IOException {
        long start = System.currentTimeMillis();

        String readString;
        try (BufferedReader br = new BufferedReader(new FileReader(in), 1024 * 1024);
             BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
            while ((readString = br.readLine()) != null) {
                bw.write(readString);
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            throw e;
        }
        return System.currentTimeMillis() - start;
    }

    public static long copyWithScanner(File in, File out) throws IOException {
        long start = System.currentTimeMillis();

        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(in), 1024 * 1024));
             PrintWriter pw = new PrintWriter(out)) {
            while (sc.hasNextLine()) {
                pw.print(sc.nextLine());
                pw.println();
            }
        } catch (IOException e) {
            throw e;
        }
        return System.currentTimeMillis() - start;
    }
}
