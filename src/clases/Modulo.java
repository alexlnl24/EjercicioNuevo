package clases;

import utilidades.Utilidades;

public class Modulo {
	
	private String nombreModulo;
	private float nota;
	
	public Modulo() {
		nota=0;
	}

	public String getNombremodulo() {
		return nombreModulo;
	}

	public void setNombremodulo(String nombremodulo) {
		this.nombreModulo = nombremodulo;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public void setDatos() {
		nombreModulo= Utilidades.introducirCadena("Introducir nombre de modulo");
		nota= Utilidades.leerFloat("Introduce nota");
	}

	public void getDatos() {
		if(nota== 0) {
			System.out.println("Modulo: "+nombreModulo+"SIN NOTA");
		}else{
			System.out.println("Modulo: "+nombreModulo+"Nota: "+nota);
		}
		
	}

	
	
	
	

}
