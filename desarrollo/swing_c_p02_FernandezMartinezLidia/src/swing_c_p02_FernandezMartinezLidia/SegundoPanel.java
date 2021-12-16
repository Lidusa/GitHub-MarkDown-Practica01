/*
 * @author Lidia Fernández Martínez
 * SegundoPanel.java
 * 25 nov. 2021 20:34:03
 */
package swing_c_p02_FernandezMartinezLidia;

import java.awt.*;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class SegundoPanel.
 *
 * @author Lidia Fernández Martínez
 */
public class SegundoPanel extends JPanel {
	
	//Creamos los elementos necesarios
	/** The dni. */
	JLabel datos,nombre,apellidos,telefono, dni;
	
	/** The txt apellidos. */
	JTextField txtNombre, txtApellidos;
	
	/** The txt dni. */
	JFormattedTextField txtTelefono, txtDni;
	
	/** The mascara dni. */
	MaskFormatter mascaraTelefono, mascaraDni;

	/**
	 * Instantiates a new segundo panel.
	 */
	public SegundoPanel() {
		
		//Establecemos un layout
		this.setLayout(new GridLayout(10,1));
		
		//Establecemos un borde
		this.setBorder(BorderFactory.createLineBorder(new Color(214,41,0),3));
		//Y un fondo
		this.setBackground(new Color(255,155,85));
		
		
		//A continuación iremos colocando todos los elementos que se encuentran en el panel
		
		//TITULO
		//Creamos un JLabel con el título del panel y le damos formato
		datos = new JLabel();
		datos.setText("DATOS DEL ARRENDADOR");
		datos.setFont(new Font("Roboto",Font.BOLD, 20));
		datos.setForeground(new Color(212,97,166));
		
		//NOMBRE
		//Creamos un JLabel para indicar que hay que colocar en el campo y un JTextField con el campo
		nombre = new JLabel();
		nombre.setText("NOMBRE *");
		nombre.setFont(new Font("Roboto",Font.PLAIN, 18));
		nombre.setForeground(new Color(212,97,166));
		txtNombre = new JTextField();
		
		//APELLIDOS
		//Creamos un JLabel para indicar que hay que colocar en el campo y un JTextField con el campo
		apellidos = new JLabel();
		apellidos.setText("APELLIDOS *");
		apellidos.setFont(new Font("Roboto",Font.PLAIN, 18));
		apellidos.setForeground(new Color(212,97,166));
		txtApellidos = new JTextField();
		
		//TELEFONO
		//Creamos un JLabel para indicar que hay que colocar en el campo y un JFormattedTextField con el campo
		telefono = new JLabel();
		telefono.setText("TELEFONO * (9 DÍGITOS)");
		telefono.setFont(new Font("Roboto",Font.PLAIN, 18));
		telefono.setForeground(new Color(212,97,166));
		
		//Añadimos una máscara para establecer un formato determinado al campo
		try {
			mascaraTelefono = new MaskFormatter("#########");
			txtTelefono = new JFormattedTextField(mascaraTelefono);
			txtTelefono.setFocusLostBehavior(txtTelefono.COMMIT);
			//campoTelefono.setBounds(140,140,150,23);
			} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}

		//DNI
		//Creamos un JLabel para indicar que hay que colocar en el campo y un JFormattedTextField con el campo
		dni = new JLabel();
		dni.setText("DNI *");
		dni.setFont(new Font("Roboto",Font.PLAIN, 18));
		dni.setForeground(new Color(212,97,166));
		
		//Añadimos una máscara para establecer un formato determinado al campo
		try {
			mascaraDni = new MaskFormatter("########U");
			txtDni = new JFormattedTextField(mascaraDni);
			txtDni.setFocusLostBehavior(txtDni.COMMIT);
			//campoTelefono.setBounds(140,140,150,23);
			} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		
		//Creamos una caja para poder colocar el título centralizado en el panel
		Box cajaDatos = Box.createHorizontalBox();
		cajaDatos.add(Box.createHorizontalGlue());
		cajaDatos.add(datos);
		cajaDatos.add(Box.createHorizontalGlue());
		this.add(cajaDatos);
		
		//Creamos cajas para poder colocar los elementos del formulario centralizados en el panel

		//CAJAS DEL NOMBRE
		Box cajaNombre = Box.createHorizontalBox();
		cajaNombre.add(Box.createHorizontalGlue());
		cajaNombre.add(nombre);
		cajaNombre.add(Box.createHorizontalGlue());
		this.add(cajaNombre);

		Box cajaTxtNombre = Box.createHorizontalBox();
		cajaTxtNombre.add(Box.createHorizontalStrut(60));
		cajaTxtNombre.add(txtNombre);
		cajaTxtNombre.add(Box.createHorizontalStrut(60));
		this.add(cajaTxtNombre);

		//CAJAS DE LOS APELLIDOS
		Box cajaApellidos = Box.createHorizontalBox();
		cajaApellidos.add(Box.createHorizontalGlue());
		cajaApellidos.add(apellidos);
		cajaApellidos.add(Box.createHorizontalGlue());
		this.add(cajaApellidos);

		Box cajaTxtApellidos = Box.createHorizontalBox();
		cajaTxtApellidos.add(Box.createHorizontalStrut(60));
		cajaTxtApellidos.add(txtApellidos);
		cajaTxtApellidos.add(Box.createHorizontalStrut(60));
		this.add(cajaTxtApellidos);
		
		//CAJAS DEL TELEFONO
		Box cajaTelefono = Box.createHorizontalBox();
		cajaTelefono.add(Box.createHorizontalGlue());
		cajaTelefono.add(telefono);
		cajaTelefono.add(Box.createHorizontalGlue());
		this.add(cajaTelefono);

		Box cajaTxtTelefono = Box.createHorizontalBox();
		cajaTxtTelefono.add(Box.createHorizontalStrut(60));
		cajaTxtTelefono.add(txtTelefono);
		cajaTxtTelefono.add(Box.createHorizontalStrut(60));
		this.add(cajaTxtTelefono);

		//CAJAS DEL DNI
		Box cajaDNI = Box.createHorizontalBox();
		cajaDNI.add(Box.createHorizontalGlue());
		cajaDNI.add(dni);
		cajaDNI.add(Box.createHorizontalGlue());
		this.add(cajaDNI);

		Box cajaTxtDNI = Box.createHorizontalBox();
		cajaTxtDNI.add(Box.createHorizontalStrut(60));
		cajaTxtDNI.add(txtDni);
		cajaTxtDNI.add(Box.createHorizontalStrut(60));
		this.add(cajaTxtDNI);
		
		




		

	}
}
