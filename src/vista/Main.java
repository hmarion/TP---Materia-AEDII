/**
 * Clase: Main
 * 
 * @author Hector Marion
 * 
 * Version: 16.09.2018.1
 */

package vista;

import java.util.Scanner;

import estructura.AVL;

public class Main {

public static void main(String[] args) {
		
		int opcion1 = 1; //Opcion para utilizar en el menu principal
		AVL arbol = new AVL();
		
		while(opcion1 != 0){ 		
			try{				
				Scanner sc = new Scanner(System.in);
				Menu.menuPrincipal(); //Impresion del Menu Principal
				opcion1 = sc.nextInt(); 
				
				switch(opcion1){				
					
					case 1: //Insertar un Nodo
						Operaciones.ingresarNodo(arbol);
						break;
					case 2: //Borrar un nodo
						Operaciones.borrarNodo(arbol);
						break;
					case 3: //Mostrar el Arbol InOrden
						if(arbol.esVacio()){
							System.out.println("No hay datos ingresados");
						}else{
							arbol.recorrerInOrden(arbol.getRaiz());	
							System.out.println("");
						}
						break;
						
					case 0: //Salir del Programa
						System.out.println("Gracias por utilizar nuestro programa!");
						break;
						
					default:
						System.out.println("La opcion ingresada es incorrecta");
				}
			}catch(Exception e){
				System.out.println("Ingreso un caracter no valido");
			}
		}
	}
}
