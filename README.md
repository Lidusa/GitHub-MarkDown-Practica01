#  swing_c_p02_FernandezMartinezLidia
## Descripción
Interfaz gráfica en la que se puede realizar la reserva de un apartamento turístico, introduciendo los datos personales y eligiendo las características de la reserva. También se mostrarán los datos elegidos.

## Contenido de la publicación
En esta publicación encontramos:
* El directorio ***"desarrollo"***: contiene los archivos con nuestro proyecto.
* El directorio ***"ejecutable"***: contiene el ejecutable del proyecto.
* El directorio ***"documentación técnica"***: contiene el javadoc generado del proyecto.
* El directorio ***"documentos"***: contiene un pdf sobre en el que se explica y muestra como se han implementado las 10 reglas de Usabilidad.

## Desarrollo del proyecto
1. Se crean las clases ***"Main.java"*** y ***"VentanaPrincipal.java"***.
2. En la clase ***"Main.java"***, creamos un objeto de la clase ***"VentanaPrincipal.java"***. Hacemos la ventana vsible.
3. A la ventana que hemos creado, le daremos un título, le añadiremos un icono personalizado y la centraremos en la mitad de la pantalla.Le añadiremos un menú desde el que poderemos: salir de la aplicación, abrir la ventana modal (que se creará a continuación) donde se realizará la reserva y un apartado con información de la empresa.Por último, le añadiremos en el centro dos botones: uno para abrir la ventana de la reserva y otro indicando que la opción seleccionada no esta disponible.
4. Crearemos una clase ***"VentanaDialogo.java"***.Le daremos la estructura de una ventana modal instanciando un contenedor e indicando de que ventana padre queremos que salga. Volvemos a ***"VentanaPrincipal.java"*** y añadimos el listener al botón para que abra esta ventana.
5. A nuestra ventana diálogo, le daremos un título, un icono personalizado y haremos que ocupe toda la resolución de la pantalla. En esta iremos añadiendo los paneles que se desarrollarán y tres botones con distintas acciones: limpiar todos los campos y colocarlos con sus valores por defecto, imprimir los datos introducidos en un panel y indicar que se ha guardado la reserva si todos los campos se han rellenado correctamente, si no, se mostrará un error.
6. Creamos la clase ***"PrimerPanel.java"***. A este panel le añadiremos un color de fondo y un borde. Aquí simplemente añadiremos el título de la empresa.
7. Creamos la clase ***"SegundoPanel.java"***. A este panel le añadiremos un color de fondo y un borde. En este panel añadiremos etiquetas y campos de texto en los que se pedirá al usuario que introduzca: su nombre, apellidos, dni y teléfono. Cada campo tendrá su formato adecuado.
8. Creamos la clase ***"TercerPanel.java"***. A este panel le añadiremos un color de fondo y un borde. Estableceremos los datos característicos de una reserva: dirección, provincia, fecha de entrada y salida, número de huéspedes, dormitorios, camas, baños. Según el número de camas, también se permitirá elegir que tipo son: simple o doble. También añadiremos un check para indicar si se llevan niños. Si es así, se activará un panel con los datos de los niños. Para ello, creamos una nueva clase         ***"TercerPanelNiños.java"***, donde indicaremos la edad del niño, y dependiendo de su edad se colocará de forma automática el tipo de cama que se le otorgará.También añadiremos   un panel con imágenes. Crearemos otra clase llamada ***"TercerPanelImagenes.java"***, en el que añadiremos las imagenes y haremos que cada vez que se pulse en una imagen se     pase a la siguiente.Estos dos últimos paneles debemos añadirlos al  ***"TercerPanel.java"***. Por último, añadiremos un campo que hará un cálculo del importe a pagar dependiendo de las opciones que se hayan seleccionado.
9. El último panel que crearemos será la clase  ***"CuartoPanel.java"***. A este panel le añadiremos un color de fondo y un borde. Añadiremos dos pestañas, y cuando pulsemos el botón de **"Imprimir"**, se mostrarán los datos del arrendador y los datos de la reserva.


 
## Despliegue (como ejecutar la aplicación desde el ejecutable)
### Windows
1. Accede a la ruta donde se encuentre el ejecutable.
2. Simplemente haz doble click en el archivo jar para que este se ejecute.
### Línea de comandos
1. Abre la consola de comandos o cmd.
2. Para que se ejecute el ejecutable, debes escribir la siguiente línea de código:


    `-java -jar nombredelarchivo.jar`
## Construido con
IDE (entorno de desarrollo integrado) Eclipse.
## Versionado
1.0
## Autores
Lidia Fernández Martínez
## Licencia
Sin licencia, software de uso libre.
## Recursos adicionales:
* GitHub: https://github.com/
* Moddle Centros: https://educacionadistancia.juntadeandalucia.es/centros/almeria/




