package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

import logica.DatosLocalidad;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Point;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class Interfaz {

	private JFrame frame;
	private Dimension tamanoMapa;
	private JMapViewer mapa;
	private JTable table;
	private JTable table_1;
	private JTextField provincia;
	private JTextField localidad;
	private JTextField habitantes;
	private JTextField latitud;
	private JTextField longitud;
	private ArrayList<DatosLocalidad> conexiones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
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
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		tamanoMapa = new Dimension(1000,1000);
		
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		mapa = new JMapViewer();
		mapa.setZoom(4);
		mapa.setLocation(16, 5);
		mapa.setBorder(new LineBorder(Color.BLUE));
	
		JPanel panel = new JPanel();
		panel.setBounds(10, 53, 428, 697);
	
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(mapa);
		
		mapa.setSize(new Dimension(402, 681));
		mapa.setDisplayPositionByLatLon( -38, -64, 4);		
		table_1 = new JTable();
		table_1.setEnabled(false);
		table_1.setBorder(new LineBorder(Color.BLUE));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Provincia", "Localidad", "Cant. Hab.", "Latitud", "Longitud"
			}
		));
		table_1.setBounds(450, 334, 524, 373);
		frame.getContentPane().add(table_1);
		
		JLabel lblProvincia = new JLabel("Cant. Habitantes");
		lblProvincia.setBounds(648, 191, 98, 14);
		frame.getContentPane().add(lblProvincia);
		
		JLabel label = new JLabel("Provincia");
		label.setBounds(448, 191, 98, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Localidad");
		label_1.setBounds(540, 191, 98, 14);
		frame.getContentPane().add(label_1);
		
		JLabel lblLatitud = new JLabel("Latitud");
		lblLatitud.setBounds(756, 191, 98, 14);
		frame.getContentPane().add(lblLatitud);
		
		JLabel lblLongitud = new JLabel("Longitud");
		lblLongitud.setBounds(857, 191, 98, 14);
		frame.getContentPane().add(lblLongitud);
		
		provincia = new JTextField();
		provincia.setBounds(448, 216, 98, 21);
		frame.getContentPane().add(provincia);
		provincia.setColumns(10);
		
		localidad = new JTextField();
		localidad.setBounds(549, 217, 98, 20);
		frame.getContentPane().add(localidad);
		localidad.setColumns(10);
		
		habitantes = new JTextField();
		habitantes.setBounds(657, 217, 103, 20);
		frame.getContentPane().add(habitantes);
		habitantes.setColumns(10);
		
		latitud = new JTextField();
		latitud.setBounds(765, 217, 98, 21);
		frame.getContentPane().add(latitud);
		latitud.setColumns(10);
		
		longitud = new JTextField();
		longitud.setBounds(866, 216, 108, 21);
		frame.getContentPane().add(longitud);
		longitud.setColumns(10);
		
		JButton btnAgregarLocalidad = new JButton("Agregar Conexi\u00F3n");
		btnAgregarLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatosLocalidad nuevaConexion;
				String prov,loc;
				Integer hab;
				Double lat,lon;
				prov = provincia.getText();
				loc = localidad.getText();
			    hab = Integer.parseInt(habitantes.getText());
				lat = Double.parseDouble(latitud.getText());
				lon = Double.parseDouble(longitud.getText());
		 
				agregarLocalidadMapa(lat,lon,loc);
				nuevaConexion = new DatosLocalidad(prov,loc,hab,lat,lon);
				conexiones = new ArrayList<DatosLocalidad> ();
				conexiones.add(nuevaConexion);
				
				
			}
		});
		btnAgregarLocalidad.setBounds(448, 271, 153, 32);
		frame.getContentPane().add(btnAgregarLocalidad);
		
		
		JLabel lblNewLabel = new JLabel("La planificaci\u00F3n se realizar\u00E1 en base a los siguientes par\u00E1metros:");
		lblNewLabel.setBounds(448, 53, 487, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCostoPorKilmetro = new JLabel("Costo por kil\u00F3metro entre dos ciudades:");
		lblCostoPorKilmetro.setBounds(448, 74, 200, 14);
		frame.getContentPane().add(lblCostoPorKilmetro);
		
		JLabel lblCostoEntreProvincias = new JLabel("Costo agregado entre provincias distintas:");
		lblCostoEntreProvincias.setBounds(448, 90, 210, 14);
		frame.getContentPane().add(lblCostoEntreProvincias);
		
		JLabel lblCostoPorConexin = new JLabel("Costo agregado por conexi\u00F3n de m\u00E1s de 200 km. :");
		lblCostoPorConexin.setBounds(448, 106, 295, 14);
		frame.getContentPane().add(lblCostoPorConexin);
		
		JButton btnObtenerPlanificacin = new JButton("Obtener Planificaci\u00F3n");
		btnObtenerPlanificacin.setBounds(446, 718, 162, 32);
		frame.getContentPane().add(btnObtenerPlanificacin);
		
		JLabel label_2 = new JLabel("1500");
		label_2.setForeground(Color.BLUE);
		label_2.setBounds(743, 74, 46, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("10000");
		label_3.setForeground(Color.BLUE);
		label_3.setBounds(743, 90, 46, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("5000");
		label_4.setForeground(Color.BLUE);
		label_4.setBounds(743, 106, 46, 14);
		frame.getContentPane().add(label_4);
		
		JLabel lblConexionesAgregadas = new JLabel("Conexiones Agregadas");
		lblConexionesAgregadas.setBounds(448, 314, 190, 14);
		frame.getContentPane().add(lblConexionesAgregadas);
		
		JButton btnConfigurar = new JButton("Configurar");
		btnConfigurar.setBounds(843, 78, 117, 32);
		frame.getContentPane().add(btnConfigurar);
		

		
        
		
		//crear coordenada
	//	Coordinate coordenadaPikachu = new Coordinate(-34.5,-58.75);
		// crear DOT
		
		//MapMarker marcador = new MapMarkerDot("JOSÉ CUCHILLO", coordenadaPikachu);
		
		
	//	mapa.addMapMarker(marcador);
		
		
	
	}
	
	public void agregarLocalidadMapa(Double latitud, Double longitud, String localidad){
		Coordinate coordenada = new Coordinate(latitud,longitud);
		MapMarker marcador = new MapMarkerDot(localidad, coordenada);
		mapa.addMapMarker(marcador);

    }
	
	public void dibujarArista(ArrayList<Coordinate> coordenadas){
		MapPolygon polygon = new MapPolygonImpl(coordenadas);
		mapa.addMapPolygon(polygon);
	}
	
}
