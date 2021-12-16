/*
 * @author Lidia Fern�ndez Mart�nez
 * TercerPanel.java
 * 25 nov. 2021 19:49:41
 */
package swing_c_p02_FernandezMartinezLidia;

import java.awt.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

import java.awt.event.*;
import javax.swing.event.*;

// TODO: Auto-generated Javadoc
/**
 * The Class TercerPanel.
 *
 * @author Lidia Fern�ndez Mart�nez
 */
public class TercerPanel extends JPanel implements ItemListener, ChangeListener, FocusListener {

	//Creamos todos los componentes necesarios para el panel
	/** The cama 4. */
	JLabel datosReserva,direccion, provincia, fechaAlta, fechaFinal, numHuespedes, numDormitorios, numBannos, numCamas, tipoCamas,
			minimo,cama1,cama2,cama3,cama4;
	
	/** The txt fecha F. */
	JFormattedTextField txtFechaA, txtFechaF;
	
	/** The txt direccion. */
	JTextField txtDireccion;
	
	/** The tipos camas 4. */
	JComboBox<String> provincias, tiposCamas,tiposCamas2,tiposCamas3,tiposCamas4;
	
	/** The n camas. */
	JSpinner nHuespedes, nDormitorios, nBannos, nCamas;
	
	/** The check ninnos. */
	JCheckBox checkNinnos;
	
	/** The precio minimo. */
	JTextArea precioMinimo;
	
	/** The panel ninnos. */
	TercerPanelNi�os panelNinnos;
	
	/** The panel imagenes. */
	TercerPanelImagenes panelImagenes;
	
	/** The caja cama 4. */
	Box cajaCama1, cajaCama2,cajaCama3,cajaCama4;
	
	/** The panel camas. */
	JPanel panelCentral,panelComponentes,panelCamas;

	/**
	 * Instantiates a new tercer panel.
	 */
	public TercerPanel() {
		//Establecemos un layout
		this.setLayout(new BorderLayout());
		//Establecemos un borde
		this.setBorder(BorderFactory.createLineBorder(new Color(165, 0, 98), 3));
		//Y un fondo
		this.setBackground(new Color(212, 97, 166));
		
		//Primero colocaremos el t�tulo del panel 
		
		//Creamos el JLabel y lo metemos en una caja para poder centralizarlo en el panel
		datosReserva = new JLabel();
		datosReserva.setText("DATOS DE LA RESERVA");
		datosReserva.setFont(new Font("Roboto", Font.BOLD, 20));
		datosReserva.setForeground(new Color(255, 255, 255));
		
		Box cajaDatos = Box.createHorizontalBox();
		cajaDatos.add(Box.createHorizontalGlue());
		cajaDatos.add(datosReserva);
		cajaDatos.add(Box.createHorizontalGlue());
		
		//A�adimos la caja con el t�tulo en el norte del panel
		this.add(cajaDatos,BorderLayout.NORTH);
		
		//M�todo que se explica al final y que se ha creado para organizar mejor el c�digo
		DatosReserva();

	
		//Creamos un panel auxiliar para colocar varios paneles en el centro del tercerPanel
		panelCentral = new JPanel();
		//Establecemos un layout
		panelCentral.setLayout(new GridLayout(4,1));
		//Y un fondo
		panelCentral.setBackground(new Color(212, 97, 166));
		
		//Creamos un panel donde colocaremos los elementos del m�todo DatosReserva()
		panelComponentes = new JPanel();
		//Establecemos un fondo
		panelComponentes.setBackground(new Color(212, 97, 166));
		//Y un layout
		panelComponentes.setLayout(new GridLayout(11,2));
		
		//A�adimos al panel los elementos del m�todo DatosReserva()
		panelComponentes.add(direccion);
		panelComponentes.add(txtDireccion);
		panelComponentes.add(provincia);
		panelComponentes.add(provincias);
		panelComponentes.add(fechaAlta);
		panelComponentes.add(fechaFinal);
		panelComponentes.add(txtFechaA);
		panelComponentes.add(txtFechaF);
		panelComponentes.add(numHuespedes);
		panelComponentes.add(numDormitorios);
		panelComponentes.add(nHuespedes);
		panelComponentes.add(nDormitorios);
		panelComponentes.add(numBannos);
		panelComponentes.add(numCamas);
		panelComponentes.add(nBannos);
		panelComponentes.add(nCamas);
	
		//A�adimos este panel al panel auxiliar
		panelCentral.add(panelComponentes);
		
		//M�todo que se explica al final y que se ha creado para organizar mejor el c�digo
		TiposCamas();

		//Creamos un JCheckBox para saber si habr� ni�os y le damos formato y funcionalidad
		checkNinnos = new JCheckBox();
		checkNinnos.setText("�NI�OS?");
		checkNinnos.setFont(new Font("Roboto", Font.PLAIN, 15));
		checkNinnos.setForeground(new Color(255, 255, 255));
		checkNinnos.setBackground(new Color(212, 97, 166));
		checkNinnos.addItemListener(this);
		
		//Declaramos el panel con los datos de los ni�os
		
		panelNinnos = new TercerPanelNi�os();
		//Hacemos que sus elementos no se puedan editar desde el inicio
		for (Component c : panelNinnos.getComponents()) {

			   c.setEnabled(false); 

			}
		//Creamos una caja para colocar el JCheckBox y el panelNinnos
		Box cajaCheck = Box.createHorizontalBox();
		cajaCheck.add(checkNinnos);
		cajaCheck.add(Box.createHorizontalStrut(10));
		cajaCheck.add(panelNinnos);
		cajaCheck.add(Box.createHorizontalStrut(10));
		
		//A�adimos la caja al panel auxiliar
		panelCentral.add(cajaCheck);
		
		//Declaramos el panel de las im�genes
		panelImagenes = new TercerPanelImagenes();
		
		//Creamos una caja para colocar mejor el panelImagenes
		Box cajaImagenes = Box.createHorizontalBox();
		cajaImagenes.add(panelImagenes);
		
		//A�adimos la caja al panel auxiliar
		panelCentral.add(cajaImagenes);
		
		
		//A�adimos el panel auxiliar al tercerPanel en el centro
		this.add(panelCentral,BorderLayout.CENTER);
		
		

		//Creamos un JLabel para indicar lo que se mostrar� en el JTextArea que tambi�n crearemos
		minimo = new JLabel();
		minimo.setText("PRECIO M�NIMO: ");
		minimo.setFont(new Font("Roboto", Font.PLAIN, 18));
		minimo.setForeground(new Color(255, 255, 255));
		
		precioMinimo = new JTextArea();
		//Acemos que no se pueda editar
		precioMinimo.setEditable(false);
		//Le damos funcionalidad
		precioMinimo.addFocusListener(this);
		
		//Creamos una caja para colocar centralizar los elementos
		Box cajaPrecio = Box.createHorizontalBox();
		cajaPrecio.add(Box.createHorizontalGlue());
		cajaPrecio.add(minimo);
		cajaPrecio.add(Box.createHorizontalGlue());
		cajaPrecio.add(precioMinimo);
		
		//A�adimos la caja al tercerPanel al sur
		this.add(cajaPrecio,BorderLayout.SOUTH);
	
		
		

	}

	
	/**
	 * Datos reserva.
	 * M�todo en el que se establecen la mayor�a de los datos que debe rellenar el usuario
	 * Se han colocado en este m�todo para limpiar el c�digo y hacerlo m�s claro
	 */
	private void DatosReserva() {
		
		//A continuaci�n iremos colocando los elementos principales del panel
		
		//DIRECCION
		//Creamos un JLabel para indicar que hay que colocar en el campo y un JTextField con el campo
		direccion = new JLabel();
		direccion.setText("DIRECCION *");
		direccion.setFont(new Font("Roboto", Font.PLAIN, 18));
		direccion.setForeground(new Color(255, 255, 255));

		txtDireccion = new JTextField();

		//PROVINCIA
		//Creamos un JLabel para indicar que hay que seleccionar en el ComboBox 
		provincia = new JLabel();
		provincia.setText("PROVINCIA");
		provincia.setFont(new Font("Roboto", Font.PLAIN, 18));
		provincia.setForeground(new Color(255, 255, 255));

		//Se crea un array con las provincias de Espa�a
		String provinciasLista[] = { "�lava", "Albacete", "Alicante", "Almer�a", "Asturias", "�vila", "Badajoz",
				"Barcelona", "Burgos", "C�ceres", "C�diz", "Cantabria", "Castell�n", "Ciudad Real", "C�rdoba", "Cuenca",
				"Gerona", "Granada", "Guadalajara", "Guip�zcoa", "Huelva", "Huesca", "Islas Baleares", "Ja�n",
				"La Coru�a", "La Rioja", "Las Palmas", "Le�n", "L�rida", "Lugo", "Madrid", "M�laga", "Murcia",
				"Navarra", "Orense", "Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia",
				"Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora",
				"Zaragoza" };
		//Se a�ade esta lista a un JComboBox
		provincias = new JComboBox<String>(provinciasLista);

		//FECHA DE ALTA
		//Creamos un JLabel para indicar que hay que colocar en el campo y un JFormattedTextField con el campo
		fechaAlta = new JLabel();
		fechaAlta.setText("FECHA DE ALTA* (DD/MM/AAAA)");
		fechaAlta.setFont(new Font("Roboto", Font.PLAIN, 18));
		fechaAlta.setForeground(new Color(255, 255, 255));
		
		//Le colocamos un formato y le pasamos la fecha de hoy
		
		txtFechaA = new JFormattedTextField();
		Date fechaHoy= new Date();
		SimpleDateFormat fechaConFormato= new SimpleDateFormat("dd/MM/yyyy");
		fechaConFormato.format(fechaHoy);
		
		txtFechaA.setValue(fechaConFormato.format(fechaHoy));
		
		
		//FECHA FINAL
		//Creamos un JLabel para indicar que hay que colocar en el campo y un JFormattedTextField con el campo
		fechaFinal = new JLabel();
		fechaFinal.setText("FECHA DE SALIDA* (DD/MM/AAAA)");
		fechaFinal.setFont(new Font("Roboto", Font.PLAIN, 18));
		fechaFinal.setForeground(new Color(255, 255, 255));
		
		//Le a�adimos a la fecha anterior un a�o
		txtFechaF = new JFormattedTextField();
		Date fechaMasAnno = new Date();
		fechaMasAnno.setYear(fechaHoy.getYear()+1);
		fechaConFormato.format(fechaMasAnno);
		
		txtFechaF.setValue(fechaConFormato.format(fechaMasAnno));

		//NUMHUESPEDES
		//Creamos un JLabel y un JSpinner para seleccionar el n�mero de hu�spedes
		numHuespedes = new JLabel();
		numHuespedes.setText("N�MERO DE HUESPEDES");
		numHuespedes.setFont(new Font("Roboto", Font.PLAIN, 18));
		numHuespedes.setForeground(new Color(255, 255, 255));
		
		nHuespedes = new JSpinner(new SpinnerNumberModel(1, 0, 8, 1));

		//NUMDORMITORIOS
		//Creamos un JLabel y un JSpinner para seleccionar el n�mero de dormitorios
		numDormitorios = new JLabel();
		numDormitorios.setText("N�MERO DE DORMITORIOS");
		numDormitorios.setFont(new Font("Roboto", Font.PLAIN, 18));
		numDormitorios.setForeground(new Color(255, 255, 255));
		
		nDormitorios = new JSpinner(new SpinnerNumberModel(1, 0, 4, 1));

		//NUMBANNOS
		//Creamos un JLabel y un JSpinner para seleccionar el n�mero de ba�os
		numBannos = new JLabel();
		numBannos.setText("N�MERO DE BA�OS");
		numBannos.setFont(new Font("Roboto", Font.PLAIN, 18));
		numBannos.setForeground(new Color(255, 255, 255));
		
		nBannos = new JSpinner(new SpinnerNumberModel(1, 0, 2, 1));

		//NUMCAMAS
		//Creamos un JLabel y un JSpinner para seleccionar el n�mero de camas
		numCamas = new JLabel();
		numCamas.setText("N�MERO DE CAMAS");
		numCamas.setFont(new Font("Roboto", Font.PLAIN, 18));
		numCamas.setForeground(new Color(255, 255, 255));
		
		nCamas = new JSpinner(new SpinnerNumberModel(1, 0, 4, 1));
		nCamas.addChangeListener(this);
		
	}
	
	/**
	 * Tipos camas.
	 * M�todo en el que se encuentra todo lo relacionado con los tipos de camas seg�n el usuario haya elegido un
	 * n�mero de camas
	 * 
	 * Se ha colocado en un m�todo para limpiar y organizar mejor el c�digo, ya que es algo muy largo
	 */
	private void TiposCamas() {
		
		//Creamos un JLabel 
		tipoCamas = new JLabel();
		tipoCamas.setText("TIPO DE CAMAS");
		tipoCamas.setFont(new Font("Roboto", Font.PLAIN, 18));
		tipoCamas.setForeground(new Color(255, 255, 255));
		
		//Creamos un array con el tipo de camas
		String camasLista[] = { "Simple", "Doble", "Sof� cama"};
		
		//Creamos JComboBox para cada n�mero de camas
		tiposCamas = new JComboBox<String>(camasLista);
		tiposCamas2 = new JComboBox<String>(camasLista);
		tiposCamas3 = new JComboBox<String>(camasLista);
		tiposCamas4 = new JComboBox<String>(camasLista);
		
		
		//Creamos un panel para colocar las camas de manera organizada
		panelCamas= new JPanel();
		//Establecemos un layout
		panelCamas.setLayout(new GridLayout(5,2));
		//Y un fondo
		panelCamas.setBackground(new Color(212, 97, 166));
		
		//Creamos un JLabel y una caja para cada n�mero de cama
		
		//CAMA 1
		cama1 = new JLabel();
		cama1.setText("CAMA 1");
		cama1.setFont(new Font("Roboto", Font.PLAIN, 15));
		cama1.setForeground(new Color(255, 255, 255));
		
		cajaCama1 = Box.createHorizontalBox();
		cajaCama1.add(cama1);
		cajaCama1.add(Box.createHorizontalStrut(10));
		cajaCama1.add(tiposCamas);
		cajaCama1.add(Box.createHorizontalStrut(10));
		//Hacemos que desde el principio sea visible ya que la opci�n por defecto es una cama
		cajaCama1.setVisible(true);
		
		//CAMA 2
		cama2 = new JLabel();
		cama2.setText("CAMA 2");
		cama2.setFont(new Font("Roboto", Font.PLAIN, 15));
		cama2.setForeground(new Color(255, 255, 255));
		
		cajaCama2 = Box.createHorizontalBox();
		cajaCama2.add(cama2);
		cajaCama2.add(Box.createHorizontalStrut(10));
		cajaCama2.add(tiposCamas2);
		cajaCama2.add(Box.createHorizontalStrut(10));
		//Hacemos que no aparezca por defecto
		cajaCama2.setVisible(false);
		
		//CAMA 3
		cama3 = new JLabel();
		cama3.setText("CAMA 3");
		cama3.setFont(new Font("Roboto", Font.PLAIN, 15));
		cama3.setForeground(new Color(255, 255, 255));
		
		cajaCama3 = Box.createHorizontalBox();
		cajaCama3.add(cama3);
		cajaCama3.add(Box.createHorizontalStrut(10));
		cajaCama3.add(tiposCamas3);
		cajaCama3.add(Box.createHorizontalStrut(10));
		//Hacemos que no aparezca por defecto
		cajaCama3.setVisible(false);
		
		//CAMA 4
		cama4 = new JLabel();
		cama4.setText("CAMA 4");
		cama4.setFont(new Font("Roboto", Font.PLAIN, 15));
		cama4.setForeground(new Color(255, 255, 255));
		
		cajaCama4 = Box.createHorizontalBox();
		cajaCama4.add(cama4);
		cajaCama4.add(Box.createHorizontalStrut(10));
		cajaCama4.add(tiposCamas4);
		cajaCama4.add(Box.createHorizontalStrut(10));
		//Hacemos que no aparezca por defecto
		cajaCama4.setVisible(false);
		
		//A�adimos al panel las cajas
		panelCamas.add(Box.createVerticalStrut(10));
		panelCamas.add(Box.createVerticalStrut(10));
		panelCamas.add(cajaCama1);
		panelCamas.add(cajaCama2);
		panelCamas.add(Box.createVerticalStrut(10));
		panelCamas.add(Box.createVerticalStrut(10));
		panelCamas.add(cajaCama3);
		panelCamas.add(cajaCama4);
		
		//Creamos una caja para colocar el JLabel y el panel de las camas
		Box cajaCamas = Box.createHorizontalBox();
		cajaCamas.add(tipoCamas);
		cajaCamas.add(Box.createHorizontalGlue());
		cajaCamas.add(panelCamas);
		
		//A�adimos la caja al panel auxiliar
		panelCentral.add(cajaCamas);
		
	}


	/**
	 * Item state changed.
	 *M�todo que activar� o desactivar� el panelNinnos,seg�n se pulse o no el JCheckBox
	 * @param evento the evento
	 */
	@Override
	public void itemStateChanged(ItemEvent evento) {
		if(evento.getSource()== checkNinnos) {
			if(checkNinnos.isSelected()) {
				for (Component c : panelNinnos.getComponents()) {

					   c.setEnabled(true); 

					}
			}else {
				for (Component c : panelNinnos.getComponents()) {

					   c.setEnabled(false); 

					}
			}
		}
		
	}


	/**
	 * State changed.
	 *M�todo que seg�n el n�mero de camas que haya elegido el usuario, se iran mostrando o
	 *ocultando el n�mero de camas para elegir su tipo
	 * @param evento the evento
	 */
	@Override
	public void stateChanged(ChangeEvent evento) {
		if(evento.getSource()==nCamas) {
			//Cogemos el valor del JSpinner
			int nCamasSpinner = Integer.parseInt(nCamas.getValue().toString());
			
			if(nCamasSpinner==0) {
				cajaCama1.setVisible(false);
				cajaCama2.setVisible(false);
				cajaCama3.setVisible(false);
				cajaCama4.setVisible(false);
			}
			
			if(nCamasSpinner==1) {
				cajaCama1.setVisible(true);
				cajaCama2.setVisible(false);
				cajaCama3.setVisible(false);
				cajaCama4.setVisible(false);
			}
			
			if(nCamasSpinner==2) {
				cajaCama1.setVisible(true);
				cajaCama2.setVisible(true);
				cajaCama3.setVisible(false);
				cajaCama4.setVisible(false);
			}
			
			if(nCamasSpinner==3) {
				cajaCama1.setVisible(true);
				cajaCama2.setVisible(true);
				cajaCama3.setVisible(true);
				cajaCama4.setVisible(false);
			}
			
			if(nCamasSpinner==4) {
				cajaCama1.setVisible(true);
				cajaCama2.setVisible(true);
				cajaCama3.setVisible(true);
				cajaCama4.setVisible(true);
			}
		}
		
	}


	/**
	 * Focus gained.
	 *M�todo que realizar� los c�lculos del precio m�nimo cuando tenga el foco
	 * @param evento the evento
	 */
	@Override
	public void focusGained(FocusEvent evento) {
		
		if(evento.getSource()==precioMinimo) {
			int precio = 0;
			
			int numeroDeCamas = Integer.parseInt(nCamas.getValue().toString());
			
			if(numeroDeCamas==1) {
				if(tiposCamas.getSelectedItem().toString().equalsIgnoreCase("Doble")) {
					precio+=20;
				}else {
					precio+=15;
				}
			}
			
			if(numeroDeCamas==2) {
				if(tiposCamas.getSelectedItem().toString().equalsIgnoreCase("Doble")) {
					precio+=20;
				}else {
					precio+=15;
				}
				
				if(tiposCamas2.getSelectedItem().toString().equalsIgnoreCase("Doble")) {
					precio+=20;
				}else {
					precio+=15;
				}
			}
			
			if(numeroDeCamas==3) {
				if(tiposCamas.getSelectedItem().toString().equalsIgnoreCase("Doble")) {
					precio+=20;
				}else {
					precio+=15;
				}
				
				if(tiposCamas2.getSelectedItem().toString().equalsIgnoreCase("Doble")) {
					precio+=20;
				}else {
					precio+=15;
				}
				
				if(tiposCamas3.getSelectedItem().toString().equalsIgnoreCase("Doble")) {
					precio+=20;
				}else {
					precio+=15;
				}
			}
			
			if(numeroDeCamas==4) {
				if(tiposCamas.getSelectedItem().toString().equalsIgnoreCase("Doble")) {
					precio+=20;
				}else {
					precio+=15;
				}
				
				if(tiposCamas2.getSelectedItem().toString().equalsIgnoreCase("Doble")) {
					precio+=20;
				}else {
					precio+=15;
				}
				
				if(tiposCamas3.getSelectedItem().toString().equalsIgnoreCase("Doble")) {
					precio+=20;
				}else {
					precio+=15;
				}
				
				if(tiposCamas4.getSelectedItem().toString().equalsIgnoreCase("Doble")) {
					precio+=20;
				}else {
					precio+=15;
				}
			}
			
			int numeroDeBannos = Integer.parseInt(nBannos.getValue().toString());
			
			int totalBannos= numeroDeBannos*25;
			
			precio+=totalBannos;
			
			if(checkNinnos.isSelected()) {
				precio+=12;
			}
			
			precioMinimo.setText(precio + "�");
			
		}
		
		
	}


	/**
	 * Focus lost.
	 *
	 * @param evento the evento
	 */
	@Override
	public void focusLost(FocusEvent evento) {
		
		
	}

}
