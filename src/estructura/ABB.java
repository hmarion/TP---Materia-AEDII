/**
 * Clase: ABB 
 * 
 * @author Hector Marion
 * 
 * Version: 16.09.2018.1
 */

package estructura;

public class ABB {

	//Atributos de la Clase
	private Nodo raiz;
	
	
	//Constructor de la Clase
	public ABB(int valor){
		this.raiz = new Nodo(valor);
	}
	
	public ABB(Nodo raiz){
		this.raiz = raiz;
	}
	
	public ABB(){
		this.raiz = null;
	}

	
	//Getters y Setters
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	
	//Metodo para ingresar un Nodo
	public Nodo insertarNodo(Nodo nodo, Nodo raiz){
		if(raiz == null){
			this.setRaiz(nodo);
		}else{
			if(nodo.getDato() < raiz.getDato()){
				if(raiz.getNodoIzquierdo() == null){
					raiz.setNodoIzquierdo(nodo);
				}else{
					insertarNodo(nodo, raiz.getNodoIzquierdo());
				}
			}else{
				if(raiz.getNodoDerecho() == null){
					raiz.setNodoDerecho(nodo);
				}else{
					insertarNodo(nodo, raiz.getNodoDerecho());
				}
			}
		}
		return raiz;
	}
	
	//Metodo para verificar si un Nodo es Hoja
	public boolean esHoja(){
		boolean hoja= false;
		if(raiz.getNodoIzquierdo().esVacio() && raiz.getNodoDerecho().esVacio()){
			hoja = true;
		}
		return hoja;
	}
	
	//Metodo para buscar el Maximo
	protected Nodo buscarMaximo(Nodo nodo){
		if(nodo.getNodoDerecho()==null){
			return nodo;
		}else{
			return nodo;
		}
	}
	
	//Metodo para buscar el Minimo
	protected Nodo buscarMinimo(Nodo nodo){
		if(nodo == null){
			return null;
		}else if(nodo.getNodoIzquierdo() == null){
			return nodo;
		}
		return buscarMinimo(nodo.getNodoIzquierdo());
	}
	
	//Metodo para eliminar un Nodo
	public void eliminarNodo(int a){
		raiz = eliminarNodo(raiz, a);
	}
	
	private Nodo eliminarNodo(Nodo nodo, int a){
		if(nodo.getDato()==a){
			if(nodo.getNodoDerecho()==null && nodo.getNodoIzquierdo()==null){
				nodo = null;
			}else if(nodo.getNodoDerecho()==null){
				nodo = nodo.getNodoIzquierdo();
			}else if(nodo.getNodoIzquierdo()==null){
				nodo = nodo.getNodoDerecho();
			}else{
				nodo.setDato(buscarMinimo(nodo.getNodoDerecho()).getDato());
				nodo.setNodoDerecho(eliminarNodo(nodo.getNodoDerecho(), nodo.getDato()));
			}
		}else if(nodo.getDato()>a && nodo.getNodoIzquierdo()!=null){
			nodo.setNodoIzquierdo(eliminarNodo(nodo.getNodoIzquierdo(), a));
		}else if(nodo.getDato()<a && nodo.getNodoDerecho()!=null){
			nodo.setNodoDerecho(eliminarNodo(nodo.getNodoDerecho(), a));
		}
		return nodo;
	}
	
	//Metodo para verificar si el arbol es vacio
	public boolean esVacio(){
		return raiz == null;
	}
	
	//Metodo para buscar un Nodo
	public Nodo buscar(Nodo nodo, int a){
		if(a < nodo.getDato() && nodo.getNodoIzquierdo()!=null){
			return buscar(nodo.getNodoIzquierdo(), a);
		}else if(a > nodo.getDato() && nodo.getNodoDerecho()!=null){
			return buscar(nodo.getNodoDerecho(), a);
		}else if(a == nodo.getDato()){
			return nodo;
		}else{
			return null;
		}
	}
	
	//Metodo para imprimir el Arbol in-orden
	public void recorrerInOrden(Nodo nodo){
		if(nodo.getNodoIzquierdo() != null){
			recorrerInOrden(nodo.getNodoIzquierdo());
		}
		if(nodo == buscarMinimo(raiz)){
			System.out.print(nodo.toString());
		}else{
			System.out.print(", " + nodo.toString());
		}
		if(nodo.getNodoDerecho() != null){
			recorrerInOrden(nodo.getNodoDerecho());
		}
	}
	
}
