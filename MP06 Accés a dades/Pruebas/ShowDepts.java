package Pruebas;

import java.io.*;

public class ShowDepts {
    public static void main(String[] args) {
        String fileName = "departaments.bin";

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                int codigoDepartamento = raf.readInt();
                String nombreDepartamento = readFixedLengthString(raf, 10);

                if (codigoDepartamento != 0) {
                    System.out.println("Departament: " + nombreDepartamento);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFixedLengthString(RandomAccessFile raf, int length) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = raf.readChar();
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}








