package logica;

import java.util.ArrayList;

public class Prueba {
ArrayList conexiones;
		
	 public Prueba(){
		 conexiones = new ArrayList<DatosLocalidad>();
		DatosLocalidad dato1 = new DatosLocalidad("Buenos Aires","Los Polvorines",53354,-34.5, -58.68);
		DatosLocalidad dato2 = new DatosLocalidad("Tucuman","Atahona",399,-27.41, -65.28);
		DatosLocalidad dato3 = new DatosLocalidad("Rio Negro","El Bolsón",13000,-41.96, -71.51);
		DatosLocalidad dato4 = new DatosLocalidad("Santa Fé","Venado Tuerto",13000,-33.74, -61.96);
		DatosLocalidad dato5 = new DatosLocalidad("Formosa","El Potrillo",13000,-23.5, -62.68);
		DatosLocalidad dato6 = new DatosLocalidad("Formosa","Buena Vista",887,-25.01, -58.43);
		DatosLocalidad dato7 = new DatosLocalidad("Chubut","Sarmiento",13000,-45.58, -69.06);
		DatosLocalidad dato8 = new DatosLocalidad("Chubut","Rawson",13000,-43.29, -65.09);
		DatosLocalidad dato9 = new DatosLocalidad("Buenos Aires","Villa Bourdeau",982,-38.7, -62.35);
		DatosLocalidad dato10 = new DatosLocalidad("Mendoza","Barrio Primavera",131,-34.63, -68.4);
		DatosLocalidad dato11 = new DatosLocalidad("Mendoza","Punta de Vacas",47,-32.85, -69.75);
		conexiones.add(dato1);
		conexiones.add(dato2);
		conexiones.add(dato3);
		conexiones.add(dato4);
		conexiones.add(dato5);
		conexiones.add(dato6);
		conexiones.add(dato7);
		conexiones.add(dato8);
		conexiones.add(dato9);
		conexiones.add(dato10);
		conexiones.add(dato11);
	
	}
}
