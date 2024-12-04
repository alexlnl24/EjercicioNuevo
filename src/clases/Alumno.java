package clases;

import java.util.ArrayList;
import java.util.List;

import utilidades.Utilidades;

public class Alumno implements Comparable<Alumno> {
	
	private String nif;
	private String nombre;
	private String apellido;
	private String ciclo;
	private boolean repetidor;
	private List <Modulo> modulos= new ArrayList<>();
	
		
	public Alumno() {
		modulos= new ArrayList<Modulo>();
	}
	
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
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

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}


	public List<Modulo> getModulos() {
		return modulos;
	}


	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}
	
	

	@Override
	public String toString() {
		return "NIF: " + nif +"\n" +"Nombre: " + nombre +"\n"+"Apellido: " + apellido +"\n"+"Ciclo: " + ciclo+"\n"+ "Repetidor: " + repetidor;
	}

	@Override
	public int compareTo(Alumno otroAlumno) {
		
		return nif.compareTo(otroAlumno.getNif());
	}
	
	public void getDatos() {
		System.out.println("Nombre: "+ nombre);
		System.out.println("Apellido: "+ apellido);
		System.out.println("Ciclo: "+ ciclo);
		if(repetidor) {
			System.out.println("Es repetidor: ");
		}
		System.out.println(repetidor?"Es repetidor":"No es repetidor");
		for(int i=0; i < modulos.size();i++) {
			modulos.get(i).getDatos();
		}
		
	}
	
	public void setDatos(String nif) {
		this.nif= nif;
		
		nombre= Utilidades.introducirCadena("");
		apellido= Utilidades.introducirCadena("");
		ciclo= Utilidades.introducirCadena("");
		repetidor= Utilidades.esBoolean("¿Es repetidor?");
		
		introducirModulos();
	}

	private void introducirModulos() {
		Modulo mod= null;
		String nombreModulo;
		do {
			nombreModulo= Utilidades.introducirCadena("Introduce el nombre del modulo");
			
			mod= buscarModulo(modulos, nombreModulo);
			
			if(mod != null) {
				mod= new Modulo();
				mod.setNombremodulo(nombreModulo);
			}else {
				System.out.println("El modulo ya existe");
			}
			
			
			
		}while(Utilidades.introducirCadena("¿Quieres seguir introduciendo modulos?").equalsIgnoreCase("si"));
		
	}

	private Modulo buscarModulo(List <Modulo> modulos,String nombreModulo) {
		 
		for(Modulo mod: modulos) {
			if(mod.getNombremodulo().equalsIgnoreCase(nombreModulo)) {
				return mod;
			}
		}
		
		return null;
	}
	
	

}
