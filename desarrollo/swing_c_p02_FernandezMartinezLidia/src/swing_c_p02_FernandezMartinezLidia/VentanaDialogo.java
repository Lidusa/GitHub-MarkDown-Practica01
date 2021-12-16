/*
 * @author Lidia Fernández Martínez
 * VentanaDialogo.java
 * 25 nov. 2021 20:33:23
 */
package swing_c_p02_FernandezMartinezLidia;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Lidia Fernández Martínez
 *
 */
public class VentanaDialogo extends JDialog implements ActionListener {

	//Creamos los elementos necesarios
	/** The contenedor. */
	private Container contenedor;
	
	/** The primer panel. */
	PrimerPanel primerPanel;
	
	/** The segundo panel. */
	SegundoPanel segundoPanel;
	
	/** The tercer panel. */
	TercerPanel tercerPanel;
	
	/** The cuarto panel. */
	CuartoPanel cuartoPanel;
	
	/** The panel extra. */
	JPanel panelExtra,panelBotones;
	
	/** The btn imprimir. */
	JButton btnImprimir,btnNuevo,btnGuardar;
	
	/**
	 * Instantiates a new ventana dialogo.
	 *
	 * @param ventanaPrincipal the ventana principal
	 * @param modal the modal
	 */
	public VentanaDialogo(VentanaPrincipal ventanaPrincipal, boolean modal) {
		
		// Establecemos el JFrame padre
		super(ventanaPrincipal, modal);
		
		// Instanciamos el contenedor
		contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());
		
		// Ponemos el título a la ventana
		this.setTitle("ALTA PISOS");

		// Añadimos un toolkit para añadir un icono y centrar la ventana
		Toolkit miPantalla = Toolkit.getDefaultToolkit();

		// Añadimos un icono personalizado a la ventana
		Image iconoPersonalizado = miPantalla.getImage(getClass().getResource("/recursos/iconoEmpresa.png"));
		this.setIconImage(iconoPersonalizado);
		
		// 0btenemos la resolucion
		Dimension tamagnoPantalla = miPantalla.getScreenSize();

		// obtenemos el ancho y el alto de la pantalla y los guardamos
		int altoPantalla = tamagnoPantalla.height;
		int anchoPantalla = tamagnoPantalla.width;

		// Establecemos el tamaño
		this.setSize(anchoPantalla, altoPantalla);
		this.setLocation(0, 0);
		
		//Añadimos un panelExtra para poder colocar mejor los paneles centrales de la ventana
		panelExtra = new JPanel();
		//Le damos un layout 
		panelExtra.setLayout(new GridLayout(1,3));
		
		//Creamos el primer panel
		primerPanel = new PrimerPanel();
		//Lo colocamos en el norte del contenedor
		contenedor.add(primerPanel,BorderLayout.NORTH);
		
		//Creamos los paneles tres paneles centrales
		segundoPanel = new SegundoPanel();
		tercerPanel = new TercerPanel();
		cuartoPanel = new CuartoPanel();
		
		//Los añadimos al panel extra
		panelExtra.add(segundoPanel);
		panelExtra.add(tercerPanel);
		panelExtra.add(cuartoPanel);
		
		//Añadimos este panelExtra en el centro del contenedor
		contenedor.add(panelExtra,BorderLayout.CENTER);
		
	
		//Creamos los 3 botones inferiores
		
		//BTNIMPRIMIR
		//Lo creamos 
		btnImprimir = new JButton();
		//Le damos un texto
		btnImprimir.setText("Imprimir a documento");
		//Le ponemos un icono
		ImageIcon imprimir = new ImageIcon(getClass().getResource("/recursos/imprimir.png"));
		btnImprimir.setIcon(imprimir);
		//Le damos funcionalidad
		btnImprimir.addActionListener(this);
		
		//de la misma forma se hará con los dos siguientes
		
		//BTNNUEVO
		btnNuevo = new JButton();
		btnNuevo.setText("Nuevo");
		ImageIcon nuevo = new ImageIcon(getClass().getResource("/recursos/limpiar.png"));
		btnNuevo.setIcon(nuevo);
		btnNuevo.addActionListener(this);
		
		//BTNGUARDAR
		btnGuardar = new JButton();
		btnGuardar.setText("Guardar");
		ImageIcon guardar = new ImageIcon(getClass().getResource("/recursos/guardar.png"));
		btnGuardar.setIcon(guardar);
		btnGuardar.addActionListener(this);
		
		//Creamos el un panel para estos botones con el objetivo de poder personalizar más esta zona
		panelBotones = new JPanel();
		//Le damos un layout
		panelBotones.setLayout(new BorderLayout());
		//Le ponemos un borde
		panelBotones.setBorder(BorderFactory.createLineBorder(new Color(255,155,85), 3));
		//Y un fondo
		panelBotones.setBackground(new Color(165,0,98));
		
		//Creamos una caja para los botones para poder colocarlos mejor estructurados
		Box cajaBotones = Box.createHorizontalBox();
		cajaBotones.add(Box.createHorizontalGlue());
		cajaBotones.add(btnImprimir);
		cajaBotones.add(Box.createHorizontalGlue());
		cajaBotones.add(btnNuevo);
		cajaBotones.add(Box.createHorizontalGlue());
		cajaBotones.add(btnGuardar);
		cajaBotones.add(Box.createHorizontalGlue());

		//Añadimos la caja al panelBotones
		panelBotones.add(cajaBotones);
		
		//Añadimos al contenedor el panelBotones al sur
		contenedor.add(panelBotones, BorderLayout.SOUTH);
	

	}

	/**
	 * Action performed.
	 *Método que se encarga de dar funcionalidad a los botones de la VentanaDialogo
	 *
	 *El botón Imprimir a documento se encarga de mostrar los datos introducidos del arrendador y del inmueble
	 *en el cuarto panel. Lo hará si ninguno de los campos obligatorios está vacio, sino, mostrará un mensaje avisando
	 *de que se deben rellenar.
	 *
	 *El botón Nuevo limpiará toos los campos y les pondrá sus valores por defecto
	 *
	 *El botón Guardar mostrará un mensaje indicando que se ha guardado la reserva. Si no están rellenos
	 *todos los campos obligatorios mostrará un mensaje indicando que deben rellenarse.
	 * @param evento the evento
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource()==btnImprimir) {
			
			if(segundoPanel.txtNombre.getText().toString().isEmpty() || segundoPanel.txtApellidos.getText().toString().isEmpty() || 
					segundoPanel.txtTelefono.getText().toString().equals("         ") || segundoPanel.txtDni.getText().toString().equals("         ")){
				
				JOptionPane.showMessageDialog(null, "DEBE RELLENAR LOS CAMPOS OBLIGATORIOS(*) DEL ARRENDADOR", "DATOS NO MOSTRADOS",
						JOptionPane.WARNING_MESSAGE);
			}else {
				cuartoPanel.datosArrendador.setText("NOMBRE: "+ segundoPanel.txtNombre.getText()+"\nAPELLIDOS: "+ segundoPanel.txtApellidos.getText()+"\nTELEFONO:"+ segundoPanel.txtTelefono.getText()
				+"\nDNI: "+ segundoPanel.txtDni.getText());
			}
			
			if(tercerPanel.txtDireccion.getText().toString().isEmpty() || tercerPanel.txtFechaA.getText().toString().equals("00/00/0000") || 
					tercerPanel.txtFechaF.getText().toString().equals("00/00/0000")){
				
				JOptionPane.showMessageDialog(null, "DEBE RELLENAR LOS CAMPOS OBLIGATORIOS(*) DEL INMUEBLE", "DATOS NO MOSTRADOS",
						JOptionPane.WARNING_MESSAGE);
			}else {
				String cadena= "DIRECCION: "+tercerPanel.txtDireccion.getText()+"\nPROVINCIA: "+tercerPanel.provincias.getSelectedItem()+"\nFECHA DE ALTA: "+
			tercerPanel.txtFechaA.getText()+"\nFECHA DE SALIDA: "+tercerPanel.txtFechaF.getText()+"\nNÚMERO DE HUESPEDES: "+tercerPanel.nHuespedes.getValue()+
			"\nNÚMERO DE DORMITORIOS: "+tercerPanel.nDormitorios.getValue()+"\nNÚMERO DE BAÑOS: "+tercerPanel.nBannos.getValue()+"\nNÚMERO DE CAMAS: "+tercerPanel.nCamas.getValue();
				
				int numCamas = Integer.parseInt(tercerPanel.nCamas.getValue().toString());
				boolean checkNinnos = tercerPanel.checkNinnos.isSelected();
				if(checkNinnos == false) {
					if(numCamas==0) {
						cuartoPanel.datosInmueble.setText(cadena+"\nPRECIO MÍNIMO: "+tercerPanel.precioMinimo.getText());
					}
					
					if(numCamas==1) {
						cuartoPanel.datosInmueble.setText(cadena+"\n\tCAMA1: "+tercerPanel.tiposCamas.getSelectedItem()
						+"\nPRECIO MÍNIMO: "+tercerPanel.precioMinimo.getText());
					}
					
					if(numCamas==2) {
						cuartoPanel.datosInmueble.setText(cadena+"\n\tCAMA1: "+tercerPanel.tiposCamas.getSelectedItem()+"\n\tCAMA2: "+tercerPanel.tiposCamas2.getSelectedItem()
						+"\nPRECIO MÍNIMO: "+tercerPanel.precioMinimo.getText());
					}
					
					if(numCamas==3) {
						cuartoPanel.datosInmueble.setText(cadena+"\n\tCAMA1: "+tercerPanel.tiposCamas.getSelectedItem()+"\n\tCAMA2: "+tercerPanel.tiposCamas2.getSelectedItem()
						+"\n\tCAMA3: "+tercerPanel.tiposCamas3.getSelectedItem()+"\nPRECIO MÍNIMO: "+tercerPanel.precioMinimo.getText());
					}
					if(numCamas==4) {
						cuartoPanel.datosInmueble.setText(cadena+"\n\tCAMA1: "+tercerPanel.tiposCamas.getSelectedItem()+"\n\tCAMA2: "+tercerPanel.tiposCamas2.getSelectedItem()
						+"\n\tCAMA3: "+tercerPanel.tiposCamas3.getSelectedItem()+"\n\tCAMA4: "+tercerPanel.tiposCamas4.getSelectedItem()+"\nPRECIO MÍNIMO: "+tercerPanel.precioMinimo.getText());
					}
				}else {
					
					if(numCamas==0) {
						cuartoPanel.datosInmueble.setText(cadena+"\nEDAD: "+tercerPanel.panelNinnos.edad.getValue()+"\nTIPO DE CAMA: "+tercerPanel.panelNinnos.tipoCama.getText()+"\nPRECIO MÍNIMO: "+tercerPanel.precioMinimo.getText());
					}
					
					if(numCamas==1) {
						cuartoPanel.datosInmueble.setText(cadena+"\n\tCAMA1: "+tercerPanel.tiposCamas.getSelectedItem()+"\nEDAD: "+tercerPanel.panelNinnos.edad.getValue()+"\nTIPO DE CAMA: "+tercerPanel.panelNinnos.tipoCama.getText()
						+"\nPRECIO MÍNIMO: "+tercerPanel.precioMinimo.getText());
					}
					
					if(numCamas==2) {
						cuartoPanel.datosInmueble.setText(cadena+"\n\tCAMA1: "+tercerPanel.tiposCamas.getSelectedItem()+"\n\tCAMA2: "+tercerPanel.tiposCamas2.getSelectedItem()
						+"\nEDAD: "+tercerPanel.panelNinnos.edad.getValue()+"\nTIPO DE CAMA: "+tercerPanel.panelNinnos.tipoCama.getText()+"\nPRECIO MÍNIMO: "+tercerPanel.precioMinimo.getText());
					}
					
					if(numCamas==3) {
						cuartoPanel.datosInmueble.setText(cadena+"\n\tCAMA1: "+tercerPanel.tiposCamas.getSelectedItem()+"\n\tCAMA2: "+tercerPanel.tiposCamas2.getSelectedItem()
						+"\n\tCAMA3: "+tercerPanel.tiposCamas3.getSelectedItem()+"\nEDAD: "+tercerPanel.panelNinnos.edad.getValue()+"\nTIPO DE CAMA: "+tercerPanel.panelNinnos.tipoCama.getText()
						+"\nPRECIO MÍNIMO: "+tercerPanel.precioMinimo.getText());
					}
					if(numCamas==4) {
						cuartoPanel.datosInmueble.setText(cadena+"\n\tCAMA1: "+tercerPanel.tiposCamas.getSelectedItem()+"\n\tCAMA2: "+tercerPanel.tiposCamas2.getSelectedItem()
						+"\n\tCAMA3: "+tercerPanel.tiposCamas3.getSelectedItem()+"\n\tCAMA4: "+tercerPanel.tiposCamas4.getSelectedItem()
						+"\nEDAD: "+tercerPanel.panelNinnos.edad.getValue()+"\nTIPO DE CAMA: "+tercerPanel.panelNinnos.tipoCama.getText()+"\nPRECIO MÍNIMO: "+tercerPanel.precioMinimo.getText());
					}
					
					
				}
			}	
		}
		
		
		
		if(evento.getSource()==btnNuevo) {
			segundoPanel.txtNombre.setText("");
			segundoPanel.txtApellidos.setText("");
			segundoPanel.txtTelefono.setText("");
			segundoPanel.txtDni.setText("");
			
			tercerPanel.txtDireccion.setText("");
			tercerPanel.provincias.setSelectedIndex(0);
			tercerPanel.txtFechaA.setText("00/00/0000");
			tercerPanel.txtFechaF.setText("00/00/0000");
			tercerPanel.nHuespedes.setValue(1);
			tercerPanel.nDormitorios.setValue(1);
			tercerPanel.nBannos.setValue(1);
			tercerPanel.nCamas.setValue(1);
			tercerPanel.tiposCamas.setSelectedIndex(0);
			tercerPanel.tiposCamas2.setSelectedIndex(0);
			tercerPanel.tiposCamas3.setSelectedIndex(0);
			tercerPanel.tiposCamas4.setSelectedIndex(0);
			tercerPanel.checkNinnos.setSelected(false);
			tercerPanel.panelNinnos.edad.setValue(0);
			tercerPanel.panelNinnos.tipoCama.setText("");
			tercerPanel.panelImagenes.info.setText("Click en la imagen para pasar a la siguiente");
			tercerPanel.panelImagenes.contador=1;
			tercerPanel.panelImagenes.ruta = "/recursos/imagen"+tercerPanel.panelImagenes.contador+".jpg";
			tercerPanel.panelImagenes.imagen = new ImageIcon(getClass().getResource(tercerPanel.panelImagenes.ruta));
			tercerPanel.panelImagenes.imagenes.setIcon(tercerPanel.panelImagenes.imagen);
			tercerPanel.precioMinimo.setText("");
			
			Date fechaHoy= new Date();
			SimpleDateFormat fechaConFormato= new SimpleDateFormat("dd/MM/yyyy");
			fechaConFormato.format(fechaHoy);
			tercerPanel.txtFechaA.setValue(fechaConFormato.format(fechaHoy));
			
			
			Date fechaMasAnno = new Date();
			fechaMasAnno.setYear(fechaHoy.getYear()+1);
			fechaConFormato.format(fechaMasAnno);
			
			tercerPanel.txtFechaF.setValue(fechaConFormato.format(fechaMasAnno));
			
			cuartoPanel.datosArrendador.setText("");
			cuartoPanel.datosInmueble.setText("");
		}
		
		if(evento.getSource()==btnGuardar) {
			
			if(segundoPanel.txtNombre.getText().toString().isEmpty() || segundoPanel.txtApellidos.getText().toString().isEmpty() || 
					segundoPanel.txtTelefono.getText().toString().equals("         ") || segundoPanel.txtDni.getText().toString().equals("         ") || 
					tercerPanel.txtDireccion.getText().toString().isEmpty() || tercerPanel.txtFechaA.getText().toString().equals("00/00/0000") || 
					tercerPanel.txtFechaF.getText().toString().equals("00/00/0000")) {
				
				JOptionPane.showMessageDialog(null, "DEBE RELLENAR LOS CAMPOS OBLIGATORIOS(*)", "DATOS NO GUARDADOS",
						JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "LA RESERVA SE HA GUARDADO CON EXITO", "RESERVA GUARDADA",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}

}
