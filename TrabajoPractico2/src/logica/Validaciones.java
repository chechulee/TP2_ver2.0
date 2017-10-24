package logica;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class Validaciones {

	int a;
	
	public void validarLongLat(KeyEvent e){
		a = e.getKeyChar();
		if(!Character.isDigit(a) && a != '.' && a !='+' && a !='-'){
			e.consume();
		}
	}
	public void validarNumeros(KeyEvent e){
		a = e.getKeyChar();
		if(!Character.isDigit(a)){
			e.consume();
		}
	}
	
	public void validaDoublePos(KeyEvent e){
		a = e.getKeyChar();
		if(!Character.isDigit(a) && a != '.'){
			e.consume();
		}
	}
	public boolean noEsTextoVacio(JTextField txt){
		return txt.getText().length()!= 0;
	}

}
