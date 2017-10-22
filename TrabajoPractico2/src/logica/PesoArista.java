package logica;

public class PesoArista implements Comparable<PesoArista>{

		public Tupla<Integer, Integer> aristas;
		public Double peso;

		public PesoArista (int x, int y, Double p){
		aristas = new Tupla<Integer, Integer>(x, y);
		peso = p;
	}
	 public Double getPeso (){
		 return this.peso;
	 }
	 public Tupla<Integer, Integer> getArista (){
		 return this.aristas;
	 }
		public String toString() {
			return "PesoArista [aristas=" + aristas + ", peso=" + peso + "]";
		}
		@Override
    	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PesoArista other = (PesoArista) obj;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		return true;
	}
	
	

	 @Override
		public int compareTo(PesoArista o) {
			return (int) (peso - o.peso);
		}

	}

	
	
	

