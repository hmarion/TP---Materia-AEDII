/**
 * Clase: Operaciones
 * 
 * @author Hector Marion
 * 
 * Version: 21.09.2018.1
 */
package vista;

import java.util.Scanner;

import estructura.AVL;
import estructura.Nodo;

public class Operaciones {

	//Metodo para ingresar un valor
	public static String ingresarValor(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese un valor: ");
		String datoIngresado = sc.nextLine();
		return datoIngresado;
	}
	
	//Metodo para verificar si es un entero
	public static boolean isNumeric(String cadena){
		boolean resultado;
		try{
			Integer.parseInt(cadena);
			resultado = true;
		}catch(NumberFormatException excepcion){
			resultado = false;
		}
		return resultado;
	}
	
	//Metodo para insertar un Nodo
	public static void ingresarNodo(AVL arbol){
		int valor;
		String datoIngresado = Operaciones.ingresarValor();
		if(Operaciones.isNumeric(datoIngresado)){
			valor = Integer.parseInt(datoIngresado);
			if(arbol.esVacio() || arbol.buscar(arbol.getRaiz(), valor)==null){
				Nodo nodoAuxiliar = new Nodo(valor);
				arbol.insertarNodo(nodoAuxiliar);
			}else{
				System.out.println("El dato ya se encuentra ingresado");
			}
		}else{
			System.out.println("Debe ingresar un numero");
		}
	}
	
	//Metodo para borrar un Nodo
	public static void borrarNodo(AVL arbol){
		if(!arbol.esVacio()){	
			int valor;
			String datoIngresado = Operaciones.ingresarValor();
			if(Operaciones.isNumeric(datoIngresado)){
				valor = Integer.parseInt(datoIngresado);
				if(arbol.buscar(arbol.getRaiz(), valor)!=null){
					arbol.eliminarNodo(valor);
					System.out.println("Se elimino el dato");
				}else{
					System.out.println("El dato no esta ingresado, no se puede eliminar");
				}
			}
		}else{
			System.out.println("No hay datos para borrar");
		}
	}
	
}
