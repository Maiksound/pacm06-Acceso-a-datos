# pacm06-Acceso-a-datos


1. Actividad
1.1. Objetivo
Desarrollar una aplicación en Java utilizando Hibernate para gestionar una
biblioteca, permitiendo la manipulación de datos relacionados con Libros, Lectores
(usuarios de la biblioteca) y las relaciones entre ellos, como los préstamos de libros.
Consideraciones Adicionales
Se valorará el uso de buenas prácticas en el diseño del código y la estructura del
proyecto.
Es importante manejar correctamente las transacciones y asegurar la integridad de
los datos en la base de datos.
1.2. Descripción
Los alumnos deberán implementar una solución que utilice Hibernate para
interactuar con una base de datos MySQL, diseñada para gestionar los libros de
una biblioteca y su asignación a los lectores. La aplicación debe permitir la
inserción, consulta, actualización y eliminación de datos de libros y lectores, así
como gestionar los préstamos de libros.
Especificaciones Técnicas
Configurar Hibernate para trabajar con una base de datos MySQL. Deben utilizarse
las configuraciones recomendadas para asegurar una conexión eficiente y segura.
1.3. Modelar las Entidades:
Libro: Debe contener atributos como id, titulo, autor, año de publicación y
disponible (un booleano que indica si el libro está disponible para préstamo).
Tambien se crea la clase LibroDAO(Data Access Object) en la cual proporciono metodos para interactuar con la base de datos para la entidad Libro.
Varios metodos de los empleados son estaticos para poder ser invocados sin necesidad de crear una instancia.
Lector: Debe incluir id, nombre, apellido, email y cualquier otro atributo que
consideres relevante.
LectorDAO:El funcionamiento es igual que la clase LibroDAO
Préstamo: Esta entidad gestionará los préstamos de libros a los lectores. Deberá
incluir id, fecha de préstamo, fecha de devolución y las referencias a las entidades
Libro y Lector.
PrestamoDAO: Proporciona los metodos que representan la informacion sobre los prestamos de los libros
PrestamoService: actúa como una capa intermedia entre la capa de presentación (en este caso, representada por la clase Main) y la capa de acceso a datos (representada por los DAOs). Su objetivo es encapsular la lógica relacionada con los préstamos de libros. Con ella proporciono métodos para manipular los préstamos de libros, encapsulando la lógica relacionada con las operaciones de préstamo y devolución, mientras delega las operaciones de acceso a datos a los DAOs correspondientes.
1.4. Implementar Operaciones CRUD (Crear, Leer, Actualizar, Borrar):
Para libros y lectores.
Gestión de préstamos, incluyendo asignar un libro a un lector y registrar la
devolución.
1.5. Consultas:
Libros actualmente prestados a un lector.
Libros disponibles para préstamo.
Historial de préstamos por lector.
6. Pruebas Unitarias:
Se deben implementar pruebas para validar las funcionalidades desarrolladas

La forma de funcionamiento del programa es a traves del Main el cual es el punto de entrada del programa, es donde encontramos la logica principal que interactua con el usuario y utiliza los DAOs para realizar operaciones en la BBDD utilizando hibernate.
