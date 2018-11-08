/**
 * Clase: AVL
 * 
 * @author Hector Marion
 * 
 * Version: 16.09.2018.1
 */

package estructura;

public class AVL extends ABB{
	
	//Metodo para ingresar un Nodo
	public Nodo insertarNodo(Nodo nodo, Nodo raiz){
		Nodo nuevoPadre = raiz;
		if(raiz == null){
			nuevoPadre = nodo;
		}else{
			if(nodo.getDato() < raiz.getDato()){
				if(raiz.getNodoIzquierdo() == null){
					raiz.setNodoIzquierdo(nodo);
				}else{
					raiz.setNodoIzquierdo(insertarNodo(nodo, raiz.getNodoIzquierdo()));
					if(raiz.factorEquilibrio() == -2){
						if(nodo.getDato() < raiz.getNodoIzquierdo().getDato()){
							nuevoPadre = rotacionHijoIzquierdo(raiz);						
						}else{
							nuevoPadre = rotacionDobleHijoIzquierdo(raiz);
						}
					}
				}
			}else{
				if(raiz.getNodoDerecho() == null){
					raiz.setNodoDerecho(nodo);
				}else{
					raiz.setNodoDerecho(insertarNodo(nodo, raiz.getNodoDerecho())) ;
					if(raiz.factorEquilibrio() == 2){
						if(nodo.getDato() > raiz.getNodoDerecho().getDato()){
							nuevoPadre = rotacionHijoDerecho(raiz);
						}else{
							nuevoPadre = rotacionDobleHijoDerecho(raiz);
						}
					}
				}
			}
		}
		return nuevoPadre;
	}
	
	public void insertarNodo(Nodo nodo){
		setRaiz(insertarNodo(nodo, getRaiz()));
	}
	
	//Metodo para balancear el arbol
	public void balancearArbol(Nodo nodo, Nodo padre){
		Nodo nuevoPadre = nodo;
		if(nodo!=null){
			if(nodo.factorEquilibrio()==-2){
				if(nodo.altura(nodo.getNodoIzquierdo().getNodoIzquierdo()) >= nodo.altura(nodo.getNodoIzquierdo().getNodoDerecho())){
					nuevoPadre = rotacionHijoIzquierdo(nodo);
					if(nodo == getRaiz()){
						setRaiz(nuevoPadre);
					}else{						
						padre.setNodoIzquierdo(nuevoPadre);
					}
				}else{
					nuevoPadre = rotacionDobleHijoIzquierdo(nodo);
					if(nodo == getRaiz()){
						setRaiz(nuevoPadre);
					}else{						
						padre.setNodoIzquierdo(nuevoPadre);
					}
				}
			}else if(nodo.factorEquilibrio()==2){
				if(nodo.altura(nodo.getNodoDerecho().getNodoDerecho()) >= nodo.altura(nodo.getNodoDerecho().getNodoIzquierdo())){					
					nuevoPadre = rotacionHijoDerecho(nodo);
					if(nodo == getRaiz()){
						setRaiz(nuevoPadre);
					}else{
						padre.setNodoDerecho(nuevoPadre);
					}
					System.out.println(nuevoPadre.toString());
				}else{
					nuevoPadre = rotacionDobleHijoDerecho(nodo);
					if(nodo == getRaiz()){
						setRaiz(nuevoPadre);
					}else{
						padre.setNodoDerecho(nuevoPadre);
					}
				}
			}
		}
	}
	
	public void balancearArbolAVL(Nodo nodo, Nodo padre){
		balancearArbol(nodo, padre);
	}
	
	public void recorrerYOrdenar(Nodo nodo, Nodo padre){
		if(nodo!=null){
			if(nodo.factorEquilibrio()>1 || nodo.factorEquilibrio() <1){
				balancearArbolAVL(nodo, padre);
			}
			if(nodo.getNodoIzquierdo() != null){
				padre = nodo;
				recorrerYOrdenar(nodo.getNodoIzquierdo(), padre);
			}
			if(nodo.getNodoDerecho() != null){
				padre = nodo;
				recorrerYOrdenar(nodo.getNodoDerecho(), padre);
			}
		}
	}
	
	//Metodo para eliminar un Nodo
	public void eliminarNodo(int a){
		this.setRaiz(eliminarNodo(getRaiz(), a));
		recorrerYOrdenar(getRaiz(), getRaiz());
	}
	
	public Nodo eliminarNodo(Nodo nodo, int a){
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
	
	//Metodos para rotaciones simples
	public Nodo rotacionHijoIzquierdo(Nodo nodo){
		Nodo auxiliar = nodo.getNodoIzquierdo();
		nodo.setNodoIzquierdo(auxiliar.getNodoDerecho());
		auxiliar.setNodoDerecho(nodo);
		return auxiliar;
	}
	
	public Nodo rotacionHijoDerecho(Nodo nodo){
		Nodo auxiliar = nodo.getNodoDerecho();
		nodo.setNodoDerecho(auxiliar.getNodoIzquierdo());
		auxiliar.setNodoIzquierdo(nodo);
		return auxiliar;
	}
	
	//Metodos para rotaciones dobles
	public Nodo rotacionDobleHijoIzquierdo(Nodo nodo){
		Nodo auxiliar;
		nodo.setNodoIzquierdo(rotacionHijoDerecho(nodo.getNodoIzquierdo()));
		auxiliar = rotacionHijoIzquierdo(nodo);
		return auxiliar;
	}
	
	public Nodo rotacionDobleHijoDerecho(Nodo nodo){
		Nodo auxiliar;
		nodo.setNodoDerecho(rotacionHijoIzquierdo(nodo.getNodoDerecho()));
		auxiliar = rotacionHijoDerecho(nodo);
		return auxiliar;
	}

}
