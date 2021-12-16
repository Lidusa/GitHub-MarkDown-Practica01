/*
 * @author Lidia Fern�ndez Mart�nez
 * TercerPanelNi�os.java
 * 25 nov. 2021 20:38:10
 */
package swing_c_p02_FernandezMartinezLidia;

import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 * @author Lidia Fern�ndez Mart�nez
 *
 */
public class TercerPanelNi�os extends JPanel implements FocusListener {
	
	//Creamos los elementos necesarios
	/** The datos ninnos. */
	JLabel datosNinnos,edadNinnos,cama;
	
	/** The tipo cama. */
	JTextField tipoCama;
	
	/** The edad. */
	JSpinner edad;
	
	public TercerPanelNi�os() {
		//Establecemos un layout
		this.setLayout(new GridLayout(6,1));
		//Establecemos un borde
		this.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),3));
		//Establecemos un fondo
		this.setBackground(new Color(255,155,85));
		
		//TITULO
		//Creamos un JLabel con el t�tulo
		datosNinnos = new JLabel();
		datosNinnos.setText("EXTRA NI�OS");
		
		//Lo colocamos en una caja para centralizarlo en el panel
		Box cajaTitulo = Box.createHorizontalBox();
		cajaTitulo.add(Box.createHorizontalGlue());
		cajaTitulo.add(datosNinnos);
		cajaTitulo.add(Box.createHorizontalGlue());
		//A�adimos la caja al panel
		this.add(cajaTitulo);
		
		//EDAD
		//Creamos un JLabel
		edadNinnos = new JLabel();
		edadNinnos.setText("EDAD");
		//Lo a�adimos
		this.add(edadNinnos);
		//Creamos un JSpinner con las edades
		edad = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		//Lo a�adimos al panel
		this.add(edad);
		
		//CAMA
		//Creamos un JLabel
		cama = new JLabel();
		cama.setText("CAMA");
		//Lo a�adimos
		this.add(cama);
		
		//Creamos un JTextField y le damos funcionalidad
		tipoCama = new JTextField();
		tipoCama.setEditable(false);
		tipoCama.addFocusListener(this);
		//Lo a�adimos
		this.add(tipoCama);
		
		
	}

	/**
	 * Focus gained.
	 *M�todo que coloca el tipo de cama en el JTextField seg�n la edad del ni�o
	 * @param evento the evento
	 */
	@Override
	public void focusGained(FocusEvent evento) {
		
		if(evento.getSource()==tipoCama) {
			int edadSpinner = Integer.parseInt(edad.getValue().toString());
			
			if(edadSpinner >= 0 && edadSpinner <=3) {
				tipoCama.setText("Cuna");
			}else {
				tipoCama.setText("Cama supletoria");
			}
		}
		
	}

	@Override
	public void focusLost(FocusEvent evento) {
		
		
	}
}
