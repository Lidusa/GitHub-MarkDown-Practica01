/*
 * @author Lidia Fern�ndez Mart�nez
 * VentanaPrincipal.java
 * 25 nov. 2021 20:32:38
 */
package swing_c_p02_FernandezMartinezLidia;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.*;

/**
 * @author Lidia Fern�ndez Mart�nez
 *
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
	
	//Creamos todos los elementos necesarios
	/** The contenedor. */
	private Container contenedor;
	
	/** The menu. */
	private JMenuBar menu;
	
	/** The archivo. */
	private JMenu archivo, registro, ayuda;
	
	/** The salir. */
	private JMenuItem salir, altaPisos, bajaPisos, acercaDe;
	
	/** The ventana principal. */
	private VentanaPrincipal ventanaPrincipal;
	
	/** The informacion empresa. */
	String informacionEmpresa;
	
	/** The btn alta. */
	JButton btnAlta, btnBaja;
	
	/** The panel botones. */
	JPanel panelBotones;

	/**
	 * Instantiates a new ventana principal.
	 */
	public VentanaPrincipal() {

		// Llamamos al constructor para poner un t�tulo a nuestra ventana
		super("Gesti�n Apartamentos Tur�sticos �FLOR MORADA�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// A�adimos un toolkit para a�adir un icono y centrar la ventana
		Toolkit miPantalla = Toolkit.getDefaultToolkit();

		//A�adimos un icono personalizado a la ventana
		Image iconoPersonalizado = miPantalla.getImage(getClass().getResource("/recursos/iconoEmpresa.png"));
		this.setIconImage(iconoPersonalizado);

		// 0btenemos la resolucion
		Dimension tamagnoPantalla = miPantalla.getScreenSize();

		// obtenemos el ancho y el alto de la pantalla y los guardamos

		int altoPantalla = tamagnoPantalla.height;
		int anchoPantalla = tamagnoPantalla.width;

		// Hacemos que la ventana se posicione en el centro de la pantalla
		this.setSize(anchoPantalla / 2, altoPantalla / 2);
		this.setLocation(anchoPantalla / 4, altoPantalla / 4);

		
		// Instanciamos el contenedor para poder colocar la ventana modal
		contenedor = getContentPane();

		// A�adimos un m�todo donde estructuramos un men�
		this.ComponentesMenu();
		
		//Establecemos el panel de los botones
		panelBotones = new JPanel();
		//Y le damos un layout
		panelBotones.setLayout(new BorderLayout());
		
		//Creamos los botones 
		
		//BTNALTA
		btnAlta = new JButton();
		//Permitimos que sea nemot�cnico
		btnAlta.setMnemonic(KeyEvent.VK_A);
		//Le ponemos un icono
		ImageIcon guardar = new ImageIcon(getClass().getResource("/recursos/guardar.png"));
		btnAlta.setIcon(guardar);
		//Le ponemos un texto
		btnAlta.setText("Alta Pisos");
		//Le damos funcionalidad
		btnAlta.addActionListener(this);
		
		//BTNBAJA
		//Haremos lo mismo que con el bot�n anterior
		btnBaja = new JButton();
		btnBaja.setMnemonic(KeyEvent.VK_B);
		ImageIcon eliminar = new ImageIcon(getClass().getResource("/recursos/eliminar.png"));
		btnBaja.setIcon(eliminar);
		btnBaja.setText("Baja Pisos");
		btnBaja.addActionListener(this);
		
		//Los metemos en una caja 
		Box cajaBotones= Box.createHorizontalBox();
		cajaBotones.add(Box.createHorizontalGlue());
		cajaBotones.add(btnAlta);
		cajaBotones.add(Box.createHorizontalGlue());
		cajaBotones.add(btnBaja);
		cajaBotones.add(Box.createHorizontalGlue());
		//A�adimos la caja al panelBotones
		panelBotones.add(cajaBotones,BorderLayout.CENTER);
		
		//A�adimos el panel a la ventanaPrincipal
		this.add(panelBotones);
	}

	
	/**
	 * Sets the ventana principal.
	 *
	 * @param miVentana the new ventana principal
	 */
	public void setVentanaPrincipal(VentanaPrincipal miVentana) {
		ventanaPrincipal = miVentana;
	}


	/**
	 * Componentes menu.
	 * M�todo en el que creamos un men� para la ventana y establecemos sus caracter�sticas y estructura
	 */
	private void ComponentesMenu() {

		// creamos la barra de menu
		menu = new JMenuBar();

		// Creamos las opciones de la barra
		archivo = new JMenu("Archivo");
		registro = new JMenu("Registro");
		registro.setMnemonic(KeyEvent.VK_R);
		ayuda = new JMenu("Ayuda");

		// Creamos el contenido de las opciones de la barra y sus acciones
		salir = new JMenuItem("Salir");
		salir.addActionListener(this);

		altaPisos = new JMenuItem("Alta Pisos");
		altaPisos.addActionListener(this);

		bajaPisos = new JMenuItem("Baja Pisos");
		bajaPisos.addActionListener(this);

		acercaDe = new JMenuItem(" Acerca de...");
		acercaDe.addActionListener(this);

		// agregamos el contenido con su respectiva opci�n 
		archivo.add(salir);
		registro.add(altaPisos);
		registro.add(bajaPisos);
		ayuda.add(acercaDe);

		//A�adimos a la barra las opciones
		menu.add(archivo);
		menu.add(registro);
		menu.add(ayuda);

		//A�adimos el men� completo a la ventana
		this.setJMenuBar(menu);

	}

	/**
	 * Action performed.
	 *M�todo en el que damos funcionalidad a los dos botones que contiene esta ventana y los
	 *contenidos del men�
	 *
	 * La opci�n Salir nos sacar� de la aplicaci�n
	 * La opci�n AltaPisos del men� nos abrir� la ventana modal
	 * La opci�n BajaPisos del men� nos mostrar� un JOptionPanel diciendo que no est� desarrollada la opci�n
	 * La opci�n Acerca de nos mostrar� un JOptionPanel con informaci�n de la empresa y del uso de la aplicaci�n
	 * Los botones Alta Pisos y Baja Pisos haran lo mismo que sus respectivas partes en el men�
	 * @param evento the evento
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == salir) {
			System.exit(0);
		}

		if (evento.getSource() == altaPisos) {
			VentanaDialogo miVentanaJDialog = new VentanaDialogo(ventanaPrincipal, true);
			miVentanaJDialog.setVisible(true);
		}

		if (evento.getSource() == bajaPisos) {
			JOptionPane.showMessageDialog(null, "ESTA OPCI�N NO EST� DESARROLLADA", "BAJA PISOS",
					JOptionPane.ERROR_MESSAGE);
		}

		if (evento.getSource() == acercaDe) {
			informacionEmpresa="La empresa Gesti�n Apartamentos Tur�sticos �FLOR MORADA�, ofrece la mayor cantidad";
			informacionEmpresa+="\ny los mejores apartamentos para alquilar de toda Espa�a, poniendo a su disposici�n";
			informacionEmpresa+="\n una aplicaci�n para realizar su reserva de manera r�pida y c�moda.";
			informacionEmpresa+="\n\nUSO DE LA APLICACION";
			informacionEmpresa+="\n\nPulse en el bot�n Alta Pisos para realizar su reserva";
			informacionEmpresa+="\nRellene todos los campos para poder guardar su reserva con exito";
			informacionEmpresa+="\nRecuerde rellenar todos los campos obligatorios, los cuales, estar�n marcados con el s�mbolo *";
			JOptionPane.showMessageDialog(null, informacionEmpresa, "ACERCA DE", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (evento.getSource() == btnAlta) {
			VentanaDialogo miVentanaJDialog = new VentanaDialogo(ventanaPrincipal, true);
			miVentanaJDialog.setVisible(true);
		}
		
		if (evento.getSource() == btnBaja) {
			JOptionPane.showMessageDialog(null, "ESTA OPCI�N NO EST� DESARROLLADA", "BAJA PISOS",
					JOptionPane.ERROR_MESSAGE);
		}
		
		
		

	}
}
