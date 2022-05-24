package clase3Activity;

public class Crud {

	Archivo archivo = new Archivo();

	public void crear() {
		archivo.crearLista();
	}
	
	public void mostrar() {
		archivo.mostrarListas();
	}
	
	public void editar() {
		archivo.modificarLista();
	}
	
	public void eliminar() {
		archivo.eliminarLista();
	}

}
