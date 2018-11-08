/**
 * Clase: Nodo
 * 
 * @author Hector Marion
 * 
 * Version: 16.09.2018.1
 */

package estructura;

public class Nodo{
	
	//Atributos de la Clase
	private int dato;
	private Nodo nodoIzquierdo, nodoDerecho;
	private Nodo nodoPadre;
	
	//Constructores de la clase
	public Nodo(int dato){
		this.dato = dato;
		this.nodoDerecho = null;
		this.nodoIzquierdo = null;
	}
	
	//Constructores de la clase
	public Nodo(int dato, Nodo nodoDerecho, Nodo nodoIzquierdo){
		this.dato = dato;
		this.nodoDerecho = nodoDerecho;
		this.nodoIzquierdo = nodoIzquierdo;
	}
	

	//Getters y Setters
	public int getDato(){
		return dato;
	}

	public void setDato(int dato){
		this.dato = dato;
	}

	public Nodo getNodoIzquierdo() {
		return nodoIzquierdo;
	}

	public void setNodoIzquierdo(Nodo nodoIzquierdo) {
		this.nodoIzquierdo = nodoIzquierdo;
	}

	public Nodo getNodoDerecho() {
		return nodoDerecho;
	}

	public void setNodoDerecho(Nodo nodoDerecho) {
		this.nodoDerecho = nodoDerecho;
	}
	
	public Nodo getNodoPadre() {
		return nodoPadre;
	}

	public void setNodoPadre(Nodo nodoPadre) {
		this.nodoPadre = nodoPadre;
	}


	@Override
	public String toString() {
		return "" + dato + " (" + factorEquilibrio() + ")";
	}
	
	//Metodo para verificar si un Nodo es vacio
	public boolean esVacio(){
		return this == null;
	}
	
	//Metodo para calcular la altura del Nodo
	protected int altura(Nodo nodo){
		if(nodo == null){
			return -1;
		}else{
			return 1 + Math.max(altura(nodo.getNodoDerecho()), altura(nodo.getNodoIzquierdo()));
		}
	}
	
	//Metodo para calcular el Factor de Equilibrio
	protected int factorEquilibrio(){
		return altura(getNodoDerecho()) - altura(getNodoIzquierdo());
	}

}
