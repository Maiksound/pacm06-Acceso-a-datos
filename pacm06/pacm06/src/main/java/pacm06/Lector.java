package pacm06;

public class Lector {
	//Definicion de atributos
		private int idLector;
		private String nombre;
		private String apellido;
		private String email;
		private String DNI;
		
		//Constructor vacio
		public Lector() {
			
		}
		//Constructor con los parametros
		public Lector(int idLector, String nombre, String apellido, String email, String DNI) {
			super();
			this.idLector = idLector;
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.DNI = DNI;
		}
		//Getters and setters
	
		public int getIdLector() {
			return idLector;
		}
		public void setIdLector(int idLector) {
			this.idLector = idLector;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDNI() {
			return DNI;
		}
		public void setDNI(String dNI) {
			DNI = dNI;
		}
		
		 //ToString
	    @Override
	    public String toString() {
	        return "Libro{" +
	                "id=" + idLector +
	                ", nombre='" + nombre + '\'' +
	                ",apellido ='" + apellido + '\'' +
	                ", email=" + email+
	                ", DNI='" + DNI + 
	                '}';
	    }
		

	}

