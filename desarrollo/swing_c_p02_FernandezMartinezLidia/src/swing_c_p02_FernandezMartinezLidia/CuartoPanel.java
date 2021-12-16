/*
 * @author Lidia Fernández Martínez
 * CuartoPanel.java
 * 25 nov. 2021 20:44:14
 */
package swing_c_p02_FernandezMartinezLidia;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Lidia Fernández Martínez
 *
 */
public class CuartoPanel extends JPanel{
	//Creamos los elementos necesarios
	/** The panel arrendador. */
	JPanel panelArrendador,panelInmueble;
	
	/** The pestannas. */
	JTabbedPane pestannas;
	
	/** The datos arrendador. */
	JTextArea datosArrendador,datosInmueble;
	
	/**
	 * Instantiates a new cuarto panel.
	 */
	public CuartoPanel() {
		//Establecemos un layout
		this.setLayout(new BorderLayout());
		//Establecemos un borde
		this.setBorder(BorderFactory.createLineBorder(new Color(212, 97, 166), 3));
		//Y un fondo
		this.setBackground(new Color(255, 255, 255));
		
		//Creamos un JTabbedPane
		pestannas= new JTabbedPane();
		
		//DATOS ARRENDADOR
		//Creamos un panel para los datos del arrendador
		panelArrendador= new JPanel();
		panelArrendador.setBorder(BorderFactory.createLineBorder(new Color(212, 97, 166), 3));
		panelArrendador.setBackground(new Color(255, 255, 255));
		//Creamos un JTextField area donde imprimiremos esos datos y le damos formato
		datosArrendador = new JTextArea();
		datosArrendador.setBackground(new Color(255, 255, 255));
		datosArrendador.setForeground(new Color(255,155,85));
		datosArrendador.setFont(new Font("Roboto", Font.BOLD, 20));
		
		//Añadimos al panel el JTextArea
		panelArrendador.add(datosArrendador);
		
		//DATOS INMUEBLE
		//Haremos lo mismo que en los datos del arrendador
		panelInmueble= new JPanel();
		panelInmueble.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 3));
		panelInmueble.setBackground(new Color(165,0,98));
		
		datosInmueble = new JTextArea();
		datosInmueble.setBackground(new Color(165,0,98));
		datosInmueble.setForeground(new Color(255,155,85));
		datosInmueble.setFont(new Font("Roboto", Font.BOLD, 20));
		
		panelInmueble.add(datosInmueble);
		
		//Añadimos dos pestañas con los paneles
		pestannas.addTab ( "Datos Arrendador", panelArrendador );
		pestannas.addTab ( "Datos Inmueble", panelInmueble   );
		
		//Las añadimos al CuartoPanel
		this.add(pestannas);
		

	}

}
