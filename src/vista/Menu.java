/**
 * Clase: Menu
 * 
 * Clase que contiene la impresion de pantalla de los distintos menus del sitema.
 * 
 * @author Hector Marion
 * 
 * Version: 13.09.2018.1
 */

package vista;

public class Menu {

	//Metodo para imprimir el menu principal
	public static void menuPrincipal(){ 
		
		System.out.println("\nArbol AVL");
		System.out.println("1 - Insertar un dato"); 
		System.out.println("2 - Borrar un dato");
		System.out.println("3 - Mostrar todos los datos ordenados con su FE");
		System.out.println("0 - Salir.");
		System.out.print  ("Ingrese la opcion seleccionada: ");
	}
	
	
}
