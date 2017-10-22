package logica;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

public class AGM {
	
	

	ArrayList<PesoArista>  aristasConPesos;
	Grafo arbolGM;
	int cantAristas;
	
	
	ArrayList<Integer>  visitados;

	
	public AGM( ArrayList<PesoArista> pAristas, int cantVertices){
		aristasConPesos = pAristas;
		
		cantAristas = 0;
		visitados = new  ArrayList<Integer>();
		arbolGM = new Grafo(cantVertices);
	
	}
	
	
	
	 @Override
		public String toString() {
			return "AGM [arbolGM=" + arbolGM + "]";}
			
			
			
			
	public AGM kruskal(){
		Double menorPeso;
		ArrayList<PesoArista> auxPesoarista= new ArrayList<PesoArista>(); 
		ArrayList<PesoArista> kruskalPesoArista= new ArrayList<PesoArista>();
		auxPesoarista=this.aristasConPesos;
		auxPesoarista.sort(null);
		int kruskalCantidadVertices=this.arbolGM.vertices();
		AGM kruskalito = new AGM(auxPesoarista, kruskalCantidadVertices);
		int vertice1, vertice2;
	while (auxPesoarista.size()!=0){
		    menorPeso = auxPesoarista.get(0).getPeso();
			vertice1 = auxPesoarista.get(0).aristas.a;
			vertice2 = auxPesoarista.get(0).aristas.b;
			
			if(!kruskalito.arbolGM.existeArista(vertice1, vertice2)){
				kruskalito.arbolGM.agregarArista(vertice1,vertice2);
				PesoArista aux3= new PesoArista(vertice1,vertice2,menorPeso);
				kruskalPesoArista.add(aux3);
				 cantAristas ++;
		
			if (kruskalito.arbolGM.grafoTieneCiclo()){
					kruskalito.arbolGM.eliminarArista(vertice1,vertice2);
					cantAristas--;
					auxPesoarista.remove(0);
					kruskalPesoArista.remove(kruskalPesoArista.size()-1);
					kruskalito.arbolGM.ciclos--;
			}
			else
					auxPesoarista.remove(0);
	
	}}
	kruskalito.aristasConPesos.addAll(kruskalPesoArista);
	return kruskalito;

	
}
	
public boolean ifChulo(){
	boolean verdadero = true;
	return verdadero  ?  true: false;
}
	public static void main(String[] args) {
		ArrayList<PesoArista> PARISTA= new ArrayList<PesoArista> ();
	
		
		 PesoArista peso1= new PesoArista(0,1,4.0);
		 PesoArista peso2= new PesoArista(1,2,8.0);
		 PesoArista peso3= new PesoArista(2,3,6.0);
		 PesoArista peso4= new PesoArista(3,4,9.0);
		 PesoArista peso5= new PesoArista(4,5,10.0);
		 PesoArista peso6= new PesoArista(5,6,3.0);
		 PesoArista peso7= new PesoArista(6,7,1.0);
		 PesoArista peso8= new PesoArista(7,0,8.0);
		 PesoArista peso9= new PesoArista(7,8,6.0);
		 PesoArista peso10= new PesoArista(1,7,12.0);
		 PesoArista peso11= new PesoArista(2,8,3.0);
		 PesoArista peso12= new PesoArista(8,6,5.0);
		 PesoArista peso13= new PesoArista(2,5,4.0);
		 PesoArista peso14= new PesoArista(3,5,13.0);
	 
		 
		 PARISTA.add(peso1);
		 PARISTA.add(peso2);
		 PARISTA.add(peso3);
		 PARISTA.add(peso4);
		 PARISTA.add(peso5);
		 PARISTA.add(peso6);
		 PARISTA.add(peso7);
		 PARISTA.add(peso8);
		 PARISTA.add(peso9);
		 PARISTA.add(peso10);
		 PARISTA.add(peso11);
		 PARISTA.add(peso12);
		 PARISTA.add(peso13);
		 PARISTA.add(peso14);
		
	 		 
		 AGM arbol= new AGM(PARISTA, 9);
		 
		 
		arbol.arbolGM.agregarArista(0, 1);
		arbol.arbolGM.agregarArista(1, 2);
		arbol.arbolGM.agregarArista(2, 3);
		arbol.arbolGM.agregarArista(3, 4);
		arbol.arbolGM.agregarArista(4, 5);
		arbol.arbolGM.agregarArista(5, 6);
		arbol.arbolGM.agregarArista(6, 7);
		arbol.arbolGM.agregarArista(7, 0);
		arbol.arbolGM.agregarArista(7, 8);
		arbol.arbolGM.agregarArista(1, 7);
		arbol.arbolGM.agregarArista(2, 8);
		arbol.arbolGM.agregarArista(8, 6);
		arbol.arbolGM.agregarArista(2, 5);
		arbol.arbolGM.agregarArista(3, 5);
	
		
		
//		System.out.println(arbol.arbolGM);
//		System.out.println(arbol.aristasConPesos);
//		System.out.println(arbol.arbolGM.ciclos);
//		System.out.println(arbol.kruskal());
//		System.out.println(arbol.aristasConPesos);
//		
	}

	public void agregarArista(int i, int j) {
		this.arbolGM.agregarArista(i, j);
		
	}
	
	
	
	
	
	
	
}