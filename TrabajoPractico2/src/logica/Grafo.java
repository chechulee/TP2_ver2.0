package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Grafo
{
	// Representamos el grafo por listas de vecinos
	private ArrayList< HashSet<Integer> > _vecinos;
	int cantAristas;
	int ciclos;
	// auxiliares
	private ArrayList<Integer> L;
	private boolean [] marcados;
	private boolean [] marcados2;
	
	// El número de vértices queda fijado en el constructor
	public Grafo(int cantidadDeVertices)
	{
		_vecinos = new ArrayList< HashSet<Integer> >(cantidadDeVertices);
		ciclos = 0;
		for(int i=0; i<cantidadDeVertices; ++i)
			_vecinos.add(new HashSet<Integer>());
		cantAristas = 0;
		marcados2 = new boolean [vertices()];
	}
	
	// Se agrega una arista en O(1)
	public void agregarArista(int i, int j)
	{
		ArrayList <Integer> alcanzablesDei = new ArrayList <Integer>();
		ArrayList <Integer> alcanzablesDej = new ArrayList <Integer>();
		
		alcanzablesDei.addAll(alcanzables(i));
		alcanzablesDei.addAll(alcanzables(j));
		
		_vecinos.get(i).add(j);
		_vecinos.get(j).add(i);
		
		cantAristas++;
		
		for(int k=0; k < marcados2.length ; k++){
			for(int w=0; w < marcados2.length ; w++){
				if(marcados[k] ==  true &&  k ==i  && marcados2[w] == true &&  w == j && alcanzablesDei.containsAll(alcanzablesDej))
						ciclos++;
			}
		}
		
		marcados2[i] = true;
		marcados2[j] = true;

		
		
		
	}

	// Informa si existe una arista, en O(1)
	public boolean existeArista(int i, int j)
	{
		verificarVertice(i, "consultar una arista");
		verificarVertice(j, "consultar una arista");

		return _vecinos.get(i).contains(j);
	}

	// Eliminación de una arista, en O(1)
	public void eliminarArista(int i, int j)
	{
		verificarVertice(i, "eliminar una arista");
		verificarVertice(j, "eliminar una arista");

		_vecinos.get(i).remove(j);
		_vecinos.get(j).remove(i);
	}
	
	// Grado de un vértice (cantidad de vecinos), en O(1)
	public int grado(int i)
	{
		return vecinos(i).size();
	}
	
	
	// Conjunto de vecinos de un vértice, en O(1)
//	@SuppressWarnings("unchecked")
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i, "consultar los vecinos");
		return (Set<Integer>) _vecinos.get(i).clone();
	}
		
	// Lanza una excepción si el índice v está fuera de rango para los vértices
	private void verificarVertice(int v, String accion)
	{
		if( v<0 || v>=vertices() )
			throw new IllegalArgumentException("Se intentó " + accion + " con un índice inexistente! vertice = " + v);
	}

	// Lanza una excepción si los índices son iguales
	private void verificarDistintos(int i, int j, String accion)
	{
		if( i == j )
			throw new IllegalArgumentException("Se intentó " + accion + " con los dos vértices iguales! vertice = " + i);
	}
	
	// Cantidad de vértices
	public int vertices()
	{
		return _vecinos.size();
	}
	
	// nuevo
	// Vertices alcanzables desde el vertice inicial
	public Set<Integer> alcanzables(int inicial)
	{
		inicializar(inicial);
		while( L.size() > 0 )
		{
			int i = L.get(0);
			marcados[i] = true;
	
			agregarVecinosPendientes(i);
			L.remove(0);
		}

		return setMarcados();
	}

	public boolean grafoTieneCiclo() {
		   if(this.ciclos > 0)
			   return true;
		   else
			   return false;
		}
	
	
	// Inicializa las variables auxiliares del algoritmo
	private void inicializar(int inicial)
	{
		// Pendientes de visitar
		L = new ArrayList<Integer>();
		L.add(inicial);
		
		// Visitados
		marcados = new boolean[vertices()];
	}

	// Agregar a L los vecinos no marcados de i
	private void agregarVecinosPendientes(int i)
	{
		for(Integer v: vecinos(i))
		{
			if( !marcados[v] && !L.contains(v) )
				L.add(v);
		}
	}
	
	// Pone los elementos en true en un set
	private Set<Integer> setMarcados()
	{
		Set<Integer> ret = new HashSet<Integer>();
		for(int i=0; i<marcados.length; ++i)
		{
			if( marcados[i] == true )
				ret.add(i);
		}

		return ret;
	}

	public String toString() {
		String ret="Grafo  vertices= "+ this.alcanzables(0)+'\n';
		
		for (int i=0;i<vertices();i++){
			
			ret=ret+   "_vecinos de "+ i +"=" + this.vecinos(i) + '\n';
			}
		ret=ret + " CantArista()=" + cantAristas;
		return ret;}
	
	
}










