package clase3Activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Archivo extends Lista {

	private String rout = "D:\\Synopsis\\Java\\";
	private String nameFile;
	private String path;

	public void crearLista() {
		System.out.println("===================================================");
		System.out.print("Ingrese Nombre para Lista: ");
		Scanner sc = new Scanner(System.in);
		nameFile = sc.nextLine() + ".txt";
		path = rout + nameFile;
		File file = new File(path);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);

			HashMap<Integer, String> lista = new HashMap<Integer, String>();
			String linea;
			do {
				System.out.print("Ingrese contenido: ");
				linea = sc.nextLine();
				if (!linea.equals("")) {
					lista.put(lista.size() + 1, linea);
				}
			} while (!linea.equals(""));
			System.out.println("---------------------------------------------------");
			for (Integer key : lista.keySet()) {
				pw.println(key + ": " + lista.get(key));
			}
			pw.close();
			sc.close();
			System.out.println("===================================================");
			System.out.println("Lista Creada Exitosamente");
		} catch (Exception e) {
			System.out.println("Error al crear archivo");
		}
	}

	public void mostrarListas() {
		File folder = new File(rout);
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles.length != 0) {
			System.out.println("---------------------------------------------------");
			int i = 1;
			for (File file : folder.listFiles()) {
				if (!file.isDirectory()) {
					String name = file.getName();
					System.out.println(i + ". " + name.substring(0, name.length() - 4));
				}
				i++;
			}
			System.out.println("---------------------------------------------------");
			System.out.println("Total de listas: " + listOfFiles.length);
			System.out.println("===================================================");
			System.out.print("Ingrese el numero de la lista que desea visualizar: ");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			System.out.println("---------------------------------------------------");
			modificarLista(num);
			sc.close();
		} else {
			System.out.println("===================================================");
			System.out.println("No hay archivos");
			System.out.println("Desea crear una lista? (y/n)");
			Scanner sc = new Scanner(System.in);
			String resp = sc.nextLine();
			if (resp.equals("y")) {
				crearLista();
			}
			sc.close();
		}
	}

	public void modificarLista() {
		File folder = new File(rout);
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles.length != 0) {
			int i = 1;
			for (File file : folder.listFiles()) {
				if (!file.isDirectory()) {
					String name = file.getName();
					System.out.println(i + ". " + name.substring(0, name.length() - 4));
					i++;
				}
			}
			System.out.println("===================================================");
			System.out.print("Ingrese el numero de la lista que desea modificar: ");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			modificarLista(num);
			sc.close();
		} else {
			System.out.println("===================================================");
			System.out.println("No hay archivos");
			System.out.println("Desea crear una lista? (y/n)");
			Scanner sc = new Scanner(System.in);
			String resp = sc.nextLine();
			if (resp.equals("y")) {
				crearLista();
			}
			sc.close();
		}
	}

	public void modificarLista(int num) {
		File folder = new File(rout);
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles.length != 0) {

			if (num > 0 && num <= listOfFiles.length) {
				File file = listOfFiles[num - 1];
				try {
					Scanner contenido = new Scanner(file);
					while (contenido.hasNextLine()) {
						System.out.println(contenido.nextLine());
					}
					contenido.close();
					System.out.println("===================================================");
					System.out.println("¿Qué desea realizar? ");
					System.out.print("(1. Agregar Nuevos Datos, 2. Modificar Datos, 3. Eliminar Datos): ");
					Scanner sc2 = new Scanner(System.in);
					String opc = sc2.nextLine();

					Lista listop = new Lista();
					switch (opc) {
						case "1":
							listop.agregarDato(file);
							break;
						case "2":
							listop.modificarDato(file);
							break;
						case "3":
							listop.eliminarDato(file);
							break;
						default:
							System.out.println("Opcion no valida");
							break;
					}
					sc2.close();
				} catch (FileNotFoundException ex) {
					System.out.println("Error: " + ex);
				} catch (Exception e) {
					System.out.println("Error: " + e);
				}
			} else {
				System.out.println("Error: Numero de lista no valido");
			}
		} else {
			System.out.println("===================================================");
			System.out.println("No hay archivos");
			System.out.println("Desea crear una lista? (y/n)");
			Scanner sc = new Scanner(System.in);
			String resp = sc.nextLine();
			if (resp.equals("y")) {
				crearLista();
			}
			sc.close();
		}
	}

	public void eliminarLista() {

		File folder = new File(rout);
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles.length != 0) {
			int i = 1;
			for (File file : folder.listFiles()) {
				if (!file.isDirectory()) {
					String name = file.getName();
					System.out.println(i + ". " + name.substring(0, name.length() - 4));
					i++;
				}
			}
			System.out.println("===================================================");
			System.out.print("Ingrese el numero de la lista que desea eliminar: ");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			if (num > 0 && num <= listOfFiles.length) {
				File file = listOfFiles[num - 1];
				file.delete();
				sc.close();
			} else {
				System.out.println("Error: Numero de lista no valido");
			}
			System.out.println("Lista eliminada con exito");
			System.out.println("===================================================");
		} else {
			System.out.println("===================================================");
			System.out.println("No hay listas para eliminar");
		}
	}

}
