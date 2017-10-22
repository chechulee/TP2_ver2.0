package logica;

import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Solver {
	public ArrayList<DatosLocalidad> conexiones;
	public ArrayList<PesoArista>  aristasConPesos;
	
	public AGM arbolGM;
	int cantAristas;
	

	
	public Solver(ArrayList c){
		this.conexiones = c;
		int cantVertices = c.size();
		
		aristasConPesos = new ArrayList();
		
	  aristasConPesos.sort(null);
		arbolGM = new AGM(aristasConPesos, cantVertices);
		arbolGM.kruskal();
		generarTodasLasAristasYpesosDelGrafo();
	}
	

	private void generarTodasLasAristasYpesosDelGrafo(){
		PesoArista pesoArista;
	    Double peso;	
		for (int i = 0; i < conexiones.size(); i++){
			for(int j = i+1; j < conexiones.size(); j++){
				if(j!=i) {
					arbolGM.agregarArista(i,j);
					//pesoArista = new PesoArista(i,j,(calcularDistancia(i,j)));
					peso = calcularPeso(i,j);
					//System.out.println(obtenerLocalidad(i)+"  " + obtenerLocalidad(j) + "  " + "$ " + peso);
					pesoArista = new PesoArista(i,j,peso);
					aristasConPesos.add(pesoArista);
					cantAristas++;
				}
			}
	   }
	}

	public Double calcularPeso(Integer vertice1, Integer vertice2){
		Double peso, costoXKM,costoDistintaProv,costoMasLimiteKM, limiteKM, KM;
		costoXKM = 2.0;
		costoMasLimiteKM = 3.0;
		costoDistintaProv = 5.0;
		limiteKM = 200.0;
		KM = calcularDistancia(vertice1,vertice2);
		peso =  KM * costoXKM; 
		
		if(obtenerLocalidad(vertice1) != obtenerLocalidad(vertice2)) peso = peso + costoDistintaProv;
		if(KM > limiteKM) peso = peso + costoMasLimiteKM;
				return peso;
		
	}
	public double calcularDistancia(Integer vertice1 ,Integer vertice2){
		Coordinate coordenada_i, coordenada_j;
		double distanciaKM;
		Coordinate coordVertice1 = obtenerCoordenada(vertice1);
		Coordinate coordVertice2=obtenerCoordenada(vertice2);
	   distanciaKM = distanciaCoord(coordVertice1.getLat(), coordVertice1.getLon(), coordVertice2.getLat(), coordVertice2.getLon());	
	   return distanciaKM;
	}
	public  Coordinate obtenerCoordenada(Integer vertice){
		Coordinate coordenada = new Coordinate(conexiones.get(vertice).latitud, conexiones.get(vertice).longitud);
		return coordenada;
	}
	
	public String obtenerLocalidad(int pos){
		String localidad = conexiones.get(pos).Localidad;
		return localidad;
	}
	
	
	private double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
	//double radioTierra = 3958.75;//en millas  
	double radioTierra = 6371;//en kilómetros  
	double dLat = Math.toRadians(lat2 - lat1);
	double dLng = Math.toRadians(lng2 - lng1); 
	double sindLat = Math.sin(dLat / 2);
	double sindLng = Math.sin(dLng / 2); 
	double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)* Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)); 
	double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
	double distancia = radioTierra * va2;
	return distancia;
	}
	
	public double costoTotal(){
		double costoT;
		costoT = 0;
		for(int i = 0 ; i < aristasConPesos.size(); i ++)
			costoT = costoT + aristasConPesos.get(i).getPeso();
		return costoT;
	}
	
	
}