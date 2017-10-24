package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

import logica.Costos;
import logica.DatosLocalidad;
import logica.Solver;
import logica.Validaciones;

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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;


public class Interfaz {

	private JFrame frame_interfaz;
	private Dimension tamanoMapa;
	private JMapViewer mapa;
	private JTable table;
	private JTable grid_conexiones;
	private JTextField provincia;
	private JTextField localidad;
	private JTextField habitantes;
	private JTextField latitud;
	private JTextField longitud;
	private ArrayList<DatosLocalidad> conexiones;
	
	DefaultTableModel modelo;
	Coordinate coord;
	MapMarker mark;
	
	
	private Costos costo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame_interfaz.setVisible(true);
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
		
		costo = new Costos();
		setCostosDefault(1500.00, 5000.00,1000.00);
		
		tamanoMapa = new Dimension(1000,1000);
		
		frame_interfaz = new JFrame();
		frame_interfaz.setBounds(0, 0, 1000, 718);
		frame_interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_interfaz.getContentPane().setLayout(null);
		
		mapa = new JMapViewer();
		mapa.setZoom(4);
		mapa.setLocation(16, 5);
		mapa.setBorder(new LineBorder(Color.BLUE));
	
		JPanel panel = new JPanel();
		panel.setBounds(10, 53, 423, 627);
	
		frame_interfaz.getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(mapa);
		
		mapa.setSize(new Dimension(402, 611));
		mapa.setDisplayPositionByLatLon( -38, -64, 4);		
		grid_conexiones = new JTable();
		grid_conexiones.setEnabled(false);
		grid_conexiones.setBorder(new LineBorder(Color.BLUE));
		grid_conexiones.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Provincia", "Localidad", "Cant. Hab.", "Latitud", "Longitud"
			}
		));
		grid_conexiones.setBounds(450, 334, 524, 287);
		frame_interfaz.getContentPane().add(grid_conexiones);
		
		JLabel lblProvincia = new JLabel("Cant. Habitantes");
		lblProvincia.setBounds(655, 196, 98, 14);
		frame_interfaz.getContentPane().add(lblProvincia);
		
		JLabel label = new JLabel("Provincia");
		label.setBounds(448, 196, 98, 14);
		frame_interfaz.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Localidad");
		label_1.setBounds(556, 196, 67, 14);
		frame_interfaz.getContentPane().add(label_1);
		
		JLabel lblLatitud = new JLabel("Latitud");
		lblLatitud.setBounds(766, 196, 67, 14);
		frame_interfaz.getContentPane().add(lblLatitud);
		
		JLabel lblLongitud = new JLabel("Longitud");
		lblLongitud.setBounds(870, 196, 75, 14);
		frame_interfaz.getContentPane().add(lblLongitud);
		
		provincia = new JTextField();
		provincia.setBounds(448, 217, 98, 20);
		frame_interfaz.getContentPane().add(provincia);
		provincia.setColumns(10);
		
		localidad = new JTextField();
		localidad.setBounds(551, 217, 98, 20);
		frame_interfaz.getContentPane().add(localidad);
		localidad.setColumns(10);
		
		habitantes = new JTextField();
		habitantes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				Validaciones val = new Validaciones();
				val.validarNumeros(arg0);
			}
		});
		habitantes.setBounds(656, 217, 98, 20);
		frame_interfaz.getContentPane().add(habitantes);
		habitantes.setColumns(10);
		
		latitud = new JTextField();
		latitud.addKeyListener(new KeyAdapter() {		
			@Override
			public void keyTyped(KeyEvent e) {
				Validaciones val = new Validaciones();
				val.validarLongLat(e);
			}
		});
		latitud.setBounds(764, 217, 98, 20);
		frame_interfaz.getContentPane().add(latitud);
		latitud.setColumns(10);
		
		longitud = new JTextField();
		longitud.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validaciones val = new Validaciones();
				val.validarLongLat(e);
			}
		});
		longitud.setBounds(870, 217, 98, 20);
		frame_interfaz.getContentPane().add(longitud);
		longitud.setColumns(10);
		
		
		modelo = (DefaultTableModel) grid_conexiones.getModel();   //modelo para la grilla
		
		
				
		JButton btnAgregarLocalidad = new JButton("Agregar Conexi\u00F3n");
		btnAgregarLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatosLocalidad nuevaConexion;
				String prov,loc;
				Integer hab;
				Double lat,lon;
				
				boolean validados = true; 
				
				validados = validados && validarcampos(provincia) && validarcampos(localidad) && validarcampos(habitantes) && validarcampos(latitud) && validarcampos(longitud);
				
				if(validados == true ){
					prov = provincia.getText();
					loc = localidad.getText();
				    hab = Integer.parseInt(habitantes.getText());
					lat = Double.parseDouble(latitud.getText());
					lon = Double.parseDouble(longitud.getText());
			 
					agregarLocalidadMapa(lat,lon,loc);
					nuevaConexion = new DatosLocalidad(prov,loc,hab,lat,lon);
					conexiones = new ArrayList<DatosLocalidad> ();
					conexiones.add(nuevaConexion);
					
					modelo.addRow(new Object[]{ provincia.getText(), localidad.getText(), 
							habitantes.getText(), latitud.getText(),longitud.getText()
							});
					provincia.setText("");
					localidad.setText("");
					habitantes.setText("");
					latitud.setText("");
					longitud.setText("");
				}else{
					 JOptionPane.showMessageDialog(null,"Complete todos los campos");
				}
								
			}

			private boolean validarcampos(JTextField texto) {
				Validaciones val = new Validaciones();
				return  val.noEsTextoVacio(texto);
			
			}
			
			
		});
		btnAgregarLocalidad.setBounds(448, 271, 153, 32);
		frame_interfaz.getContentPane().add(btnAgregarLocalidad);
		
		
		JLabel lblNewLabel = new JLabel("La planificaci\u00F3n se realizar\u00E1 en base a los siguientes par\u00E1metros:");
		lblNewLabel.setBounds(448, 53, 487, 14);
		frame_interfaz.getContentPane().add(lblNewLabel);
		
		JLabel lblCostoPorKilmetro = new JLabel("Costo por kil\u00F3metro entre dos ciudades:");
		lblCostoPorKilmetro.setBounds(448, 74, 230, 14);
		frame_interfaz.getContentPane().add(lblCostoPorKilmetro);
		
		JLabel lblCostoEntreProvincias = new JLabel("Costo agregado entre provincias distintas:");
		lblCostoEntreProvincias.setBounds(448, 90, 250, 14);
		frame_interfaz.getContentPane().add(lblCostoEntreProvincias);
		
		JLabel lblCostoPorConexin = new JLabel("Costo agregado por conexi\u00F3n de m\u00E1s de 200 km. :");
		lblCostoPorConexin.setBounds(448, 106, 295, 14);
		frame_interfaz.getContentPane().add(lblCostoPorConexin);
		
		JButton btnObtenerPlanificacin = new JButton("Obtener Planificaci\u00F3n");
		btnObtenerPlanificacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Solver s = new Solver(conexiones, costo);
				
				
			}
		});
		btnObtenerPlanificacin.setBounds(448, 640, 162, 32);
		frame_interfaz.getContentPane().add(btnObtenerPlanificacin);
		
//		Muestro los costos en los lables. Y defino al evento del mouseclick
		
		String aux = Double.toString(costo.getCostosDosCiudades());
		JLabel lbl_costokm = new JLabel(aux);
		lbl_costokm.setName("lblCostoPorKilmetro");
		lbl_costokm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(lbl_costokm.getName());
				SetPrecios(lbl_costokm);
			}
		});
		lbl_costokm.setForeground(Color.BLUE);
		lbl_costokm.setBounds(760, 74, 70, 14);
		frame_interfaz.getContentPane().add(lbl_costokm);
		
		aux = Double.toString(costo.getCostoMas200Km());
		JLabel lbl_costoagregado = new JLabel(aux);
		lbl_costoagregado.setName("lbl_costoagregado");
		lbl_costoagregado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SetPrecios(lbl_costoagregado);
			}
		});
		lbl_costoagregado.setForeground(Color.BLUE);
		lbl_costoagregado.setBounds(760, 90, 70, 14);
		frame_interfaz.getContentPane().add(lbl_costoagregado);
		
		aux = Double.toString(costo.getCostoEntreProvincias());
		JLabel lbl_costoprovincias = new JLabel(aux);
		lbl_costoprovincias.setName("lbl_costoprovincias");
		lbl_costoprovincias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SetPrecios(lbl_costoprovincias);
			}
		});
		lbl_costoprovincias.setForeground(Color.BLUE);
		lbl_costoprovincias.setBounds(760, 106, 70, 14);
		frame_interfaz.getContentPane().add(lbl_costoprovincias);
		
		JLabel lblConexionesAgregadas = new JLabel("Conexiones Agregadas");
		lblConexionesAgregadas.setBounds(448, 314, 190, 14);
		frame_interfaz.getContentPane().add(lblConexionesAgregadas);
		
		JButton btn_eliminarfila = new JButton("Deshacer Ultimo");
		btn_eliminarfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(grid_conexiones.getRowCount()>=1){
					conexiones.remove(conexiones.size()-1);
					modelo.removeRow(grid_conexiones.getRowCount()-1);
				}else{
					JOptionPane.showMessageDialog(null,"No se puede eliminar");
				}
			}
		});
		btn_eliminarfila.setBounds(625, 271, 153, 32);
		frame_interfaz.getContentPane().add(btn_eliminarfila);
		
		JButton btn_verMapa = new JButton("Ver en Mapa");
		btn_verMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String loc;
				if(validar_latitudlongitud()){
					mapa.removeAllMapMarkers();
					loc = localidad.getText();
					mark = new MapMarkerDot(loc, coord);
					mapa.addMapMarker(mark);
				}
				
			}

	
		});
		btn_verMapa.setBounds(843, 248, 107, 23);
		frame_interfaz.getContentPane().add(btn_verMapa);
		
		JLabel lbl_configurar = new JLabel("* Para modificar los costos haga click sobre el valor.");
		lbl_configurar.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_configurar.setBounds(458, 131, 487, 14);
		frame_interfaz.getContentPane().add(lbl_configurar);

		
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
	
	private boolean validar_latitudlongitud() {
		Double lat = 0.0;
		Double lon = 0.0; 
		
		try{
			lat = Double.parseDouble(latitud.getText());
			lon = Double.parseDouble(longitud.getText());
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Ingrese un numero valido");
		}
		
		coord = new Coordinate(lat,lon);
		return true;
	}
	
	public void setCostosDefault (Double c, Double m, Double p){
		
		this.costo.setCostoDosCiudades(c);
		this.costo.setCostoMas200Km(m);
		this.costo.setCostoEntreProvincias(p);
				
	}
	
	public Costos getCostos (){
		return this.costo;
	}
	
	private void SetPrecios(JLabel lbl) {
		boolean esOk = false;
		Double auxd = 0.0;
		String TextoIngreso = "";
		String label = lbl.getName();
		System.out.println("NOMBRE " +lbl.getName());
		if(label == "lblCostoPorKilmetro"){
			auxd = costo.getCostosDosCiudades();
			TextoIngreso = "Ingreso Costo entre dos Ciudades";
		}
		if(label == "lbl_costoagregado"){
			auxd = costo.getCostoMas200Km();
			TextoIngreso = "Ingreso Costo por mas de 200 km";
		}
		if(label == "lbl_costoprovincias"){
			auxd = costo.getCostoEntreProvincias();
			TextoIngreso = "Ingreso Costo por conectar 2 provincias";
		}
		
				
		String aux = JOptionPane.showInputDialog("costo por cambio prov", Double.toString(auxd));
		if(aux != null){
		 try{
			 auxd = Double.parseDouble(aux);
			 switch (label) {
			 case "lblCostoPorKilmetro" :
				 costo.setCostoDosCiudades(auxd);
				 break;
			 case "lbl_costoagregado" :
				 costo.setCostoMas200Km(auxd);
				 break;
			 case "lblCostoEntreProvincias" :
				 costo.setCostoEntreProvincias(auxd);
			  break;
			 }
			 lbl.setText(aux);
			 esOk = true;
		 }
		 catch(NumberFormatException arg0){
			  JOptionPane.showMessageDialog(lbl, "Error de formato", "ERROR", JOptionPane.ERROR_MESSAGE);
			  esOk = false;
		 }
		}
	
	}
	
}
