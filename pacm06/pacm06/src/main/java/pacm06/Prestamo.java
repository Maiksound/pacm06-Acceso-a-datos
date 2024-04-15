package pacm06;

import java.util.Date;

public class Prestamo {
	//Definicion de Atributos
	private int idPrestamo;
	private Date fecPrestamo;
	private int fecDevolucion;
	private Libro libro;
	private Lector lector;
	
	//Constructor vacio
	public Prestamo() {
		
	}
	//Constructor con parametros
	
	public Prestamo(int idPrestamo, Date fecPrestamo, int fecDevolucion) {
		super();
		this.idPrestamo = idPrestamo;
		this.fecPrestamo = fecPrestamo;
		this.fecDevolucion = fecDevolucion;
		
	}
	//Getters and Setters

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Date getFecPrestamo() {
		return fecPrestamo;
	}

	public void setFecPrestamo(Date date) {
		this.fecPrestamo = date;
	}

	public int getFecDevolucion() {
		return fecDevolucion;
	}

	public void setFecDevolucion(Date date) {
		this.fecDevolucion = fecDevolucion;
	}
	  public void setLibro(Libro libro) {
	        this.libro = libro;
	    }

	    public void setLector(Lector lector) {
	        this.lector = lector;
	    }
	
	 //ToString
    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + idPrestamo +
                ", fecha Prestamo='" + fecPrestamo + '\'' +
                ",fecha devolucion ='" + fecDevolucion + 
                '}';
    }

	
		
	}


