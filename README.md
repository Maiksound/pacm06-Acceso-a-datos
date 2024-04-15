# pacm06-Acceso-a-datos
1. Normativa
Requisitos necesarios que debe cumplir el trabajo:
● La PAC de Desarrollo se debe entregar únicamente a través del campus, en la tarea
específica para ello y dentro de los plazos de entrega establecidos en la guía
didáctica. En caso de no cumplir dichos plazos, no se podrán enviar de forma
posterior.
● El día y hora máximo para entregar una PAC de desarrollo es el día especificado en
la guía didáctica.
● Para realizar esta actividad se debe consultar los contenidos del material didáctico
y hacer uso de fuentes bibliográficas y recursos web.
● No se aceptan copias literales de Internet, que se considerarán plagio. Se puede
utilizar Internet para localizar información, pero el redactado de las respuestas
debe ser de elaboración propia, citando la fuente de donde se ha obtenido esta
información.
● Es responsabilidad del alumno/a comprobar que el archivo subido en la plataforma
es el correcto, ya que en ningún caso el profesor revisará el documento antes del
periodo de corrección.
2. Criterios de corrección
A la hora de realizar la corrección y evaluación del trabajo presentado se tendrán en
cuenta los siguientes criterios:
● La calificación numérica oscila del 0 al 10. El profesor podrá disminuir hasta 1
punto la calificación obtenida en caso de que haya errores ortográficos y/o su
presentación no se adecúe a los estándares básicos establecidos.
● En ningún caso se corregirán aquellos trabajos que sean una copia literal de
Internet u otras fuentes.
● Debe ser un trabajo propio donde se traten todos los conceptos mencionados.
● Si no se entrega una PAC de desarrollo, la calificación equivaldrá a un 0.
● Si se detecta la entrega de una PAC copiada, ya sea de una fuente externa o con un
contenido idéntico al de otro alumno/a, serán evaluadas como suspenso, con una
calificación de 0.
3. Actividad
3.1. Objetivo
Desarrollar una aplicación en Java utilizando Hibernate para gestionar una
biblioteca, permitiendo la manipulación de datos relacionados con Libros, Lectores
(usuarios de la biblioteca) y las relaciones entre ellos, como los préstamos de libros.
Consideraciones Adicionales
Se valorará el uso de buenas prácticas en el diseño del código y la estructura del
proyecto.
Es importante manejar correctamente las transacciones y asegurar la integridad de
los datos en la base de datos.
3.2. Descripción
Los alumnos deberán implementar una solución que utilice Hibernate para
interactuar con una base de datos MySQL, diseñada para gestionar los libros de
una biblioteca y su asignación a los lectores. La aplicación debe permitir la
inserción, consulta, actualización y eliminación de datos de libros y lectores, así
como gestionar los préstamos de libros.
Especificaciones Técnicas
Configurar Hibernate para trabajar con una base de datos MySQL. Deben utilizarse
las configuraciones recomendadas para asegurar una conexión eficiente y segura.
3.3. Modelar las Entidades:
Libro: Debe contener atributos como id, titulo, autor, año de publicación y
disponible (un booleano que indica si el libro está disponible para préstamo).
Lector: Debe incluir id, nombre, apellido, email y cualquier otro atributo que
consideres relevante.
Préstamo: Esta entidad gestionará los préstamos de libros a los lectores. Deberá
incluir id, fecha de préstamo, fecha de devolución y las referencias a las entidades
Libro y Lector.
3.4. Implementar Operaciones CRUD (Crear, Leer, Actualizar, Borrar):
Para libros y lectores.
Gestión de préstamos, incluyendo asignar un libro a un lector y registrar la
devolución.
3.5. Consultas:
Libros actualmente prestados a un lector.
Libros disponibles para préstamo.
Historial de préstamos por lector.
3.7. Pruebas Unitarias:
Se deben implementar pruebas para validar las funcionalidades desarrolladas
