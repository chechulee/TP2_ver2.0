package logica;

public class Costos {

	public double costodosciudades, costo_entre_prov, costo_mas_200km;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Costos(){
		
		costodosciudades = 0;
		costo_entre_prov = 0;
		costo_mas_200km = 0;
	}
	public Costos(Double c, Double p, Double m){
		costodosciudades = c;
		costo_entre_prov = p;
		costo_mas_200km = m;
	}
	public void setCostoDosCiudades(double p){   // P precio
		this.costodosciudades = p;
	}
	public void setCostoEntreProvincias(double p){
		this.costo_entre_prov = p;
	}
	public void setCostoMas200Km (double p){
		this.costo_mas_200km = p;
	}
	
	public double getCostosDosCiudades (){
		return this.costodosciudades;
	}
	public double getCostoEntreProvincias(){
		return this.costo_entre_prov;
	}
	public double getCostoMas200Km (){
		return this.costo_mas_200km;
	}
	@Override
	public String toString() {
		return "Costos [costo entre dos ciudades=" + costodosciudades + ", costo entre provincias=" + costo_entre_prov
				+ ", costo mas 200km=" + costo_mas_200km + "]";
	}


}
