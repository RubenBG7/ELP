# ELP
Proyecto Mónica Morán y Rubén Barrado para el control de participación

El proyecto se compone de una interfaz gráfica formada por dos ventanas, una "VentanaTablero" en la que aparecen todos los alumnos/personas
de las que se quiera contabilizar la asistencia al aula, está formado por un array de botones dividido en dos paneles, de forma que se
asemeje más a la distribución de las aulas de la universidad, además de ellos especificamos en qué lugar se sitúa el profesor y la pantalla del proyector con el fin de hacerlo más intuitivo para la persona que va a usarlo. Por ultimo podemos encontrar en esta ventana también un botón de deshacer el cual guarda los clics que hemos realizado en la suma de participaciones y en caso de error del usuario deshará el anterior movimiento.
También compone el proyecto otra ventana emergente del lado derecho de la pantalla que cargará una tabla dinámica con todo el listado de
alumnos seguido de dos columnas contiguas con las participaciones del día actual y a continuación otra columna con sus participaciones
totales del curso. La tabla está programada de forma que las columnas son redistribuibles haciendo "drag and drop" de forma que pueda ser
más cómoda a la hora de verificar algún dato de ésta.

Por último tenemos un fichero de testo en el que se situarán todos los alumnos del aula en formato:
"Nombre Apellido1 Apellido2,nºParticipaciones"
lo que conseguimos con este formato es dar la posibilidad al usuario de convertir fácilmente este fichero de texto a una tabla de excel
en un .csv.

Una última especificación en cuanto a la situación de los archivos, está diseñado de forma que el fichero de texto y todas las imágenes
que acompañen al programa estén situadas en la carpeta raíz del proyecto, al igual que si queremos crear un fichero .jar o .exe para usarlo
simplemente tendremos que acompañar ese fichero de las imágenes y el fichero/ficheros de texto que deseemos que el programa utilice.
