package clase3Activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Lista {
    protected void agregarDato(File file) throws IOException {
        try {
            HashMap<Integer, String> lista = new HashMap<>();
            FileReader fr = new FileReader(file);
            try (BufferedReader bf = new BufferedReader(fr)) {
                String linea;
                while ((linea = bf.readLine()) != null) {
                    String[] dato = linea.split(": ");
                    lista.put(Integer.parseInt(dato[0]), dato[1]);
                }

                FileWriter fw = new FileWriter(file);
                PrintWriter pw = new PrintWriter(fw);
                Scanner sc = new Scanner(System.in);
                String linea2;
                do {
                    System.out.print("Ingrese contenido: ");
                    linea2 = sc.nextLine();
                    if (!linea2.equals("")) {
                        lista.put(lista.size() + 1, linea2);
                    }
                } while (!linea2.equals(""));
                System.out.println("---------------------------------------------------");
                for (Integer key : lista.keySet()) {
                    pw.println(key + ": " + lista.get(key));
                }
                pw.close();
                sc.close();
            }
            System.out.println("===================================================");
            System.out.println("Datos agregados exitosamente");
        } catch (Exception e) {
            System.out.println("Error al agregar datos");
        }
    }

    protected void modificarDato(File file) {
        try {
            HashMap<Integer, String> lista = new HashMap<>();
            FileReader fr = new FileReader(file);
            try (BufferedReader bf = new BufferedReader(fr)) {
                String linea;
                while ((linea = bf.readLine()) != null) {
                    String[] dato = linea.split(": ");
                    lista.put(Integer.parseInt(dato[0]), dato[1]);
                }

                Scanner sc = new Scanner(System.in);
                System.out.print("Ingrese numero de dato a modificar: ");
                Integer numero = sc.nextInt();
                sc.nextLine();
                System.out.print("Ingrese nuevo contenido: ");
                String nuevo = sc.nextLine();
                if (!nuevo.equals("")) {
                    lista.put(numero, nuevo);
                }
                sc.close();
                FileWriter fw = new FileWriter(file);
                PrintWriter pw = new PrintWriter(fw);
                for (Integer key : lista.keySet()) {
                    pw.println(key + ": " + lista.get(key));
                }
                pw.close();
            }
            System.out.println("===================================================");
            System.out.println("Dato modificado exitosamente");

        } catch (Exception e) {
            System.out.println("Error al mostrar archivo: " + e);
        }

    }

    protected void eliminarDato(File file) {
        try {
            HashMap<Integer, String> lista = new HashMap<>();
            FileReader fr = new FileReader(file);
            try (BufferedReader bf = new BufferedReader(fr)) {
                String linea;
                while ((linea = bf.readLine()) != null) {
                    String[] dato = linea.split(": ");
                    lista.put(Integer.parseInt(dato[0]), dato[1]);
                }

                Scanner sc = new Scanner(System.in);
                System.out.print("Ingrese numero de dato a modificar: ");
                Integer numero = sc.nextInt();
                lista.remove(numero);
                FileWriter fw = new FileWriter(file);
                PrintWriter pw = new PrintWriter(fw);
                for (Integer key : lista.keySet()) {
                    pw.println(key + ": " + lista.get(key));
                }
                pw.close();
                sc.close();
            }
            System.out.println("===================================================");
            System.out.println("Dato eliminado exitosamente");

        } catch (Exception e) {
            System.out.println("Error al eliminar el dato: " + e);
        }
    }
}
