package Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 * @version 1.0
 * @author NachoDiaz
 */
public class padron {

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String dni;
        int selectmenu = 5;
        boolean checked = true; //para controlar la salida del bucle del numero del menu
        String linea;
        String ruta = "src/Ficheros/padron.txt";
        //Flujo de lectura
        FileWriter escritor = null;
        BufferedWriter miBufferedWriter = null;
        //Flujo de escritura
        BufferedReader miBufferedReader = null;
        FileReader lector = null;

        try {
            //flujo de esccritura
            lector = new FileReader(ruta);
            miBufferedReader = new BufferedReader(lector);
            //flujo de lectura
            escritor = new FileWriter(ruta);
            miBufferedWriter = new BufferedWriter(escritor);
            do {
                //menu
                System.out.println("Padron de Habitantes de Villanueva del Trabuco");
                System.out.println("==============================================");
                System.out.println("Elija una opcion : \n1.-Registrar habitante \n2.-Mostrar patron\n3.-Salir\n¿Opcion?");
                //----------------------VALIDACION DE OPCION--------------------
                do {
                    if (!checked) {
                        System.out.println("Opcion no valida (1-3)");
                    }
                    try {
                        checked = true;
                        selectmenu = t.nextInt();
                        if (selectmenu != 1 && selectmenu != 2 && selectmenu != 3) {
                            checked = false;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Debe de ser un numero");
                        checked = false;
                        t.nextLine();
                    }
                } while (!checked);
                checked = true;//flag on por si nos vuelve a hacer falta
                //==================================EMPIEZA EL MENU=====================================
                switch (selectmenu) {
                    //=====================CASE1=============================
                    case 1:
                        //------------------------------Validacion del Dni-----------------------
                        do {
                            System.out.println("Dni del registro");
                            dni = t.next();
                            if (dni.length() != 9) {
                                System.out.println("El dni debe tener el formato 99999999Z");
                            }
                        } while (dni.length() != 9);
                        //----------------------------flujo de lectura y escritura----------------
                        do {
                            linea = miBufferedReader.readLine();
                            lector.read();
                            if (linea != null) {
                                escritor.write(linea);
                                miBufferedWriter.newLine();
                            }
                        } while (linea != null);
                        miBufferedWriter.write(dni);
                        break;
                    //======================CASE 2======================
                    case 2:
                         linea = miBufferedReader.readLine();
                        System.out.println(linea);
                        do {
                           
                            if (linea != null) {
                                System.out.println(linea);
                            }
                        } while (linea != null);
                        break;
                    default:
                        System.out.println("Saliendo............");
                        break;
                }
            } while (selectmenu != 3);
        } catch (FileNotFoundException e) {
            System.out.println("Error archivo no encoontrado " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error no esperado " + e.getMessage());
        }
    }

}
