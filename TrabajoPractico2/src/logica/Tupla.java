package logica;
import java.util.ArrayList;

public class Tupla <T1, T2> {
	T1 a;
	T2 b;
	public Tupla (T1 x, T2 y){
		a = x;  		b = y;
	}
	public T1 getx(){
		return this.a;
	}
	public T2 gety(){
		return this.b;
	}
	public void setx(T1 x){
		this.a = x;
	}
	public void sety(T2 y){
		this.b = y;
	}
	@Override 
	public String toString(){
		return "Tupla : "+this.getx() + " : "+this.gety();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
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
		Tupla<Integer, Integer> other = (Tupla<Integer, Integer>) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}
	
	
	
	
}
