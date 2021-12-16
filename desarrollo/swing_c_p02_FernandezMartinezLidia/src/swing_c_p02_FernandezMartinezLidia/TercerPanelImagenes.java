/*
 * @author Lidia Fern�ndez Mart�nez
 * TercerPanelImagenes.java
 * 25 nov. 2021 20:41:42
 */
package swing_c_p02_FernandezMartinezLidia;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Lidia Fern�ndez Mart�nez
 *
 */
public class TercerPanelImagenes extends JPanel implements MouseListener {
	
	//Creamos todos los componentes necesarios para el panel
	/** The imagen. */
	ImageIcon imagen ;
	
	/** The info. */
	JLabel info, imagenes;
	
	/** The contador. */
	int contador=1;
	
	/** The ruta. */
	//Colocamos un contador seg�n el nombre de las im�genes
	String ruta= "/recursos/imagen"+contador+".jpg";
	
	public TercerPanelImagenes() {
		//Establecemos un layout
		this.setLayout(new BorderLayout());
		//Y un fondo
		this.setBackground(new Color(212, 97, 166));
		
		//Creamos un JLabel para indicar como se deben pasar las im�genes
		info = new JLabel();
		info.setText("Click en la imagen para pasar a la siguiente");
		info.setFont(new Font("Roboto", Font.PLAIN, 14));
		info.setForeground(new Color(255, 255, 255));
		this.add(info,BorderLayout.NORTH);
		
		//CReamos la imagen con la ruta establecida anteriormente y le ponemos funcionalidad
		imagen = new ImageIcon(getClass().getResource(ruta));
		imagenes = new JLabel(imagen);
		imagenes.addMouseListener(this);
		
		//A�adimos el JLabel con las im�genes al panel en el centro
		this.add(imagenes,BorderLayout.CENTER);
		
	}
	
	/**
	 * Mouse clicked.
	 *M�todo que cambia de imagen cada vez que se clica sobre una de ellas. Si no quedan m�s, avisa al usuario
	 * @param evento the evento
	 */
	@Override
	public void mouseClicked(MouseEvent evento) {
		if(evento.getSource()==imagenes) {
			if(contador>=3) {
				
				info.setText("No quedan m�s im�genes");
				
			}else {
				
				contador+=1;
				ruta="/recursos/imagen"+contador+".jpg";
				imagen = new ImageIcon(getClass().getResource(ruta));
				imagenes.setIcon(imagen);
				
					
			}
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


