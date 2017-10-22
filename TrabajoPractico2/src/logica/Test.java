package logica;
import java.awt.EventQueue;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

public class Test {
	private JMapViewer miMapa;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		miMapa = new JMapViewer();
		miMapa.setZoomContolsVisible(false);
		
		miMapa.setDisplayPositionByLatLon( -38, -64, 4);
		frame.setContentPane(miMapa);
		Prueba prueba = new Prueba();
		DatosLocalidad d ;
		
		

		for (int i = 0 ; i < prueba.conexiones.size(); i++){
			d = (DatosLocalidad) prueba.conexiones.get(i);
			agregarLocalidadMapa(d.getLat(),d.getLon(), d.getLocalidad());
		}
		
		Solver solver = new Solver(prueba.conexiones);

AGM arbol  = solver.arbolGM.kruskal();
System.out.println(solver.arbolGM.cantAristas);
Coordinate coordV1,coordV2;
double peso;

           for(Integer j = 0 ; j < arbol.aristasConPesos.size() ; j ++){
		        	 int v1 = arbol.aristasConPesos.get(j).getArista().getx();
			        int v2 = arbol.aristasConPesos.get(j).getArista().gety();
		          coordV1 = solver.obtenerCoordenada(v1);
		          coordV2 = solver.obtenerCoordenada(v2);
		          peso = Math.round(arbol.aristasConPesos.get(j).getPeso());
		          dibujarArista(coordV1, coordV2);
		          System.out.println(solver.obtenerLocalidad(v1) + " con "+ solver.obtenerLocalidad(v2) + v1 + "---" + v2 + "  Peso:   " + peso);
			 
           }
      
       System.out.println("Costo Total =  $ " + solver.costoTotal());
}

	//}
	
	public void dibujarArista(Coordinate v1, Coordinate v2){
		ArrayList<Coordinate> coordenadas = new ArrayList<Coordinate>();
		coordenadas.add(v1);
		coordenadas.add(v2);
		coordenadas.add(v1);
		dibujar(coordenadas);
	}
	 private void dibujar(ArrayList<Coordinate> c){
		MapPolygon pol = new MapPolygonImpl(c);
		miMapa.addMapPolygon(pol);

	}
	
	public void agregarLocalidadMapa(Double latitud, Double longitud, String localidad){
		Coordinate coordenada = new Coordinate(latitud,longitud);
		MapMarker marcador = new MapMarkerDot(localidad, coordenada);
		miMapa.addMapMarker(marcador);
		}
	

}

