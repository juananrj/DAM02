package Pruebas;


import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomWriteProfesores {
    public static void main(String[] args) {

        int DNI[]= {123124141,4123123,7565443};
        String profesoress[] = {"david","gamero","raul"};
        int codidep[] ={1,2,3};

        try {

            RandomAccessFile f = new RandomAccessFile("Salidas/profesores.bin", "rw");


            for (int i = 0; i <profesoress.length; i++) {

                int dniprofesor = DNI[i];
                String nom = profesoress[i];
                int codi =  codidep[i];

                StringBuffer stb = new StringBuffer(nom);
                stb.setLength(20);

                f.writeInt(dniprofesor);
                f.writeChars(stb.toString());
                f.writeInt(codi);
            }

            f.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}

