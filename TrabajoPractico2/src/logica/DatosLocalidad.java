package logica;

public class DatosLocalidad {
	@Override
	public String toString() {
		return "DatosLocalidad [nombreProvincia=" + nombreProvincia + ", Localidad=" + Localidad + ", cantHabitantes="
				+ cantHabitantes + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}


	String nombreProvincia;
	String Localidad;
	int cantHabitantes;
	Double latitud,longitud;
	
	
	public DatosLocalidad(String prov, String loc, int hab, double lat, double lon){
		nombreProvincia = prov;
		Localidad = loc;
		cantHabitantes = hab;
		latitud = lat;
		longitud = lon;
		
	}

	public String getProv(){
		return this.nombreProvincia;
	}
	
	public String getLocalidad(){
		return this.Localidad;
	}
	
	public Double getLat(){
		return this.latitud;
	}
	
	public Double getLon(){
		return this.longitud;
	}
	
	
}
