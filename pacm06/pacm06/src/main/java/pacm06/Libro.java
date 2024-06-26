package pacm06;

public class Libro {
	//Definicion de atributos
	private int idLibro;
	private String nombre;
	private String autor;
	private int aņoPublicacion;
	private boolean disponible;
	
	//Constructor vacio
	public Libro() {
		
	}
	//Constructor con los parametros
	public Libro(int idLibro, String nombre, String autor, int aņoPublicacion, boolean disponible) {
		super();
		this.idLibro = idLibro;
		this.nombre = nombre;
		this.autor = autor;
		this.aņoPublicacion = aņoPublicacion;
		this.disponible = disponible;
	}
	//Getters and setters
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAņoPublicacion() {
		return aņoPublicacion;
	}
	public void setAņoPublicacion(int aņoPublicacion) {
		this.aņoPublicacion = aņoPublicacion;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	 //ToString
    @Override
    public String toString() {
        return "Libro{" +
                "id=" + idLibro +
                ", nombre='" + nombre + '\'' +
                ",autor ='" + autor + '\'' +
                ", aņoPublicacion=" + aņoPublicacion+
                ", disponible='" + disponible + 
                '}';
    }
	

}
