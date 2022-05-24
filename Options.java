package clase3Activity;

import java.util.Scanner;

public class Options extends Crud {

	private String op;

	public void init() {
		System.out.println("===================================================");
		System.out.println("REGISTROS DE LISTAS");
		System.out.println("1. Crear lista");
		System.out.println("2. Ver listas");
		System.out.println("3. Editar Lista ");
		System.out.println("4. Eliminar Lista");
		System.out.println("===================================================");

		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Elija una opci�n: ");
			op = sc.nextLine();

			switch (op) {
				case "1":
					Crud crud1 = new Crud();
					crud1.crear();
					break;
				case "2":
					Crud crud2 = new Crud();
					crud2.mostrar();
					break;
				case "3":
					Crud crud3 = new Crud();
					crud3.editar();
					break;
				case "4":
					Crud crud4 = new Crud();
					crud4.eliminar();
					break;
				default:
					System.out.println("Opci�n Invalida");
					break;
			}

			sc.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
