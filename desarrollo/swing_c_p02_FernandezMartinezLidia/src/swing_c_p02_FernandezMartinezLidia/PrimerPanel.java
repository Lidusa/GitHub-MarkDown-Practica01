/*
 * @author Lidia Fernández Martínez
 * PrimerPanel.java
 * 25 nov. 2021 20:31:46
 */
package swing_c_p02_FernandezMartinezLidia;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Lidia Fernández Martínez
 *
 */
public class PrimerPanel extends JPanel{

	//Creamos el título
	/** The nombre empresa. */
	JLabel nombreEmpresa;
	
	/**
	 * Instantiates a new primer panel.
	 */
	public PrimerPanel() {
		
		//En este panel dejaremos el layout por defecto
		
		//Establecemos un borde
		this.setBorder(BorderFactory.createLineBorder(new Color(255,155,85),3));
		//Y un fondo
		this.setBackground(new Color(165,0,98));
		
		//Creamos el título con el nombre de la empresa
		nombreEmpresa = new JLabel();
		//Le ponemos un texto
		nombreEmpresa.setText("FLOR MORADA");
		//Le cambiamos el formato 
		nombreEmpresa.setFont(new Font("Caladea",Font.ITALIC, 30));
		//Y le damos un color
		nombreEmpresa.setForeground(new Color(255,255,255));
		
		//Lo añadimos al panel
		this.add(nombreEmpresa);
		
	}
}
