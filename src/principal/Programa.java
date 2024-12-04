package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import clases.Alumno;
import utilidades.Utilidades;

public class Programa {

	public static void main(String[] args) {
		
		Scanner teclado= new Scanner(System.in);
		List<Alumno> alumnos= new ArrayList<>();
		char opc=' ';
		
		do {
			opc=menuPrincipal(opc);
			
			if(alumnos.isEmpty() && opc>'A' && opc>'S') {
				System.out.println("No hay alumnos introducidos!!!");
			}else {
				switch (opc) {
				case 'A':
					matricularAlumno(alumnos);
					break;
				case 'B':
					listadoAlumnos(alumnos);
					break;
				case 'C':
					listadoAlumnosTodaLaInformacion(alumnos);
					break;
				case 'D':
					introducirNotas(alumnos);
					break;
				case 'E':
					modificarNotas(alumnos);
					break;
				case 'F':
					darDeBaja(alumnos);
					break;
				case 'G':
					darBajaModulo(alumnos);
					break;
				case 'H':
					introducirModuloEnConcreto(alumnos);
					break;
				case 'I':
					
					break;
				case 'J':
					ordenadosPorNif(alumnos);
					break;
				case 'K':
					suspensosPorModulo(alumnos);
					break;
				case 'L':
					mostrarNotaAltaYBaja(alumnos);
					break;
				case 'M':
					listadoSinEvaluar(alumnos);
					break;
				case 'N':
					listadoRepetidores(alumnos);
					break;
				case 'O':
					break;
				case 'P':
					break;
				case 'Q':
					break;
				case 'R':
					break;
				case 'S':
					System.out.println("Hasta luego.");
					break;
			    default:
			    	System.out.println("Opción no válida");
				}
		}
		}while(opc != 'S');

	}

	private static void listadoRepetidores(List<Alumno> alumnos) {
		
		for(Alumno a: alumnos) {
			if(a.getCiclo().equalsIgnoreCase(Utilidades.introducirCadena("Introduzca el Ciclo que busca")) && a.isRepetidor()== true) {
				a.getDatos();
				System.out.println(" ");
			}
		}
		
	}

	private static void listadoSinEvaluar(List<Alumno> alumnos) {
		int moduloAux = 0;
		
		moduloAux= buscarModulo(alumnos, moduloAux);
		
		if(moduloAux >=0) {
			for(Alumno alum: alumnos) {
				if(alum.getModulos().get(moduloAux).getNota() < 1) {
					System.out.println(alum.getNombre()+""+alum.getApellido()+""+alum.getCiclo());
					System.out.println(" ");
				}
			}
		}else {
			System.out.println("Modulo no encontrado");
		}
		
	}

	private static void mostrarNotaAltaYBaja(List<Alumno> alumnos) {
		int moduloAux = 0;
		 moduloAux= buscarModulo(alumnos, moduloAux);
		Alumno aux;
		 if(moduloAux >=0) {
			 for(int i=0;i < alumnos.size();i++){
				 for(int j= i+1; j < alumnos.size(); j++) {
					 if(alumnos.get(i).getModulos().get(i).getNota() < alumnos.get(j).getModulos().get(j).getNota()) {
						 aux= alumnos.get(i);
						 alumnos.set(i, alumnos.get(j));
						 alumnos.set(j, aux);
					 }
				 }
			 }
			 alumnos.get(0).getDatos();
			 alumnos.getLast().getDatos();
		 }else {
			 System.out.println("No se encontro ese modulo");
		 }
	}

	private static void suspensosPorModulo(List<Alumno> alumnos) {
		int moduloAux = 0;
		
		moduloAux= buscarModulo(alumnos, moduloAux);
		
		if(moduloAux >=0) {
			for(Alumno al: alumnos) {
				if(al.getModulos().get(moduloAux).getNota() > 0 && al.getModulos().get(moduloAux).getNota() < 5) {
					al.getDatos();
					System.out.println("");
				}
			}
		}else {
			System.out.println("No se encontro ese modulo");
		}
		
	}

	private static int buscarModulo(List<Alumno> alumnos,int moduloAux) {
		String modulo;
		int encontrado= -1;
		modulo= Utilidades.introducirCadena("Introduzca el modulo que busca");
		
		for(int i=0; i < alumnos.size();i++) {
			if(alumnos.get(i).getModulos().get(i).getNombremodulo().equalsIgnoreCase(modulo)) {
				encontrado= i;
			}
		}
		return encontrado;
	}

	private static void ordenadosPorNif(List<Alumno> alumnos) {
		
		Collections.sort(alumnos);
		listadoAlumnos(alumnos);
		
	}

	private static void introducirModuloEnConcreto(List<Alumno> alumnos) {
		String moduloaux;
		
		moduloaux= Utilidades.introducirCadena("Introduce el nombre del modulo");
		
		for(int i=0; i < alumnos.size(); i++) {
			if(alumnos.get(i).getModulos().equals(moduloaux) && alumnos.get(i).getModulos().get(i).getNota() == 0) {
				System.out.println(alumnos.get(i).getNombre()+ alumnos.get(i).getApellido());
				alumnos.get(i).getModulos().get(i).setNota(Utilidades.leerFloat("Introduzca nueva nota"));
			}
		}
		
	}

	private static void darBajaModulo(List<Alumno> alumnos) {
		String  nif, modulo;
		
		nif= Utilidades.introducirCadena("Introducir el NIF de alumno que desea dar de baja");
		int encontrado= buscarNif(alumnos, nif);
		modulo= Utilidades.introducirCadena("Introduce modulo para dar de baja");
		
		if(encontrado >=0) {
			for(int i=0; i < alumnos.size();i++) {
				if(alumnos.get(i).getModulos().equals(modulo)) {
					alumnos.get(i).getModulos().remove(modulo);
					System.out.println("Modulo borrado correctamente");
				}
			}
		}else {
			System.out.println("No se encuentra alumnno con ese NIF");
		}
		
	}

	private static void darDeBaja(List<Alumno> alumnos) {
		String  nif;
		
		
		nif= Utilidades.introducirCadena("Introducir el NIF de alumno que desea dar de baja");
		int encontrado= buscarNif(alumnos, nif);
		
		if(encontrado >=0) {
			alumnos.remove(encontrado);
		}else {
			System.out.println("No se encuentra alumnno con ese NIF");
		}
		
	}

	private static void modificarNotas(List<Alumno> alumnos) {
		String  nif,modulo;
		
		
		nif= Utilidades.introducirCadena("Introducir el NIF de alumno que desea modificar las notas");
		int encontrado= buscarNif(alumnos, nif);
		
		if(encontrado >=0) {
			modulo= Utilidades.introducirCadena("Introduzca el nombre del modulo");
			for(int i=0; i < alumnos.size();i++) {
				if(alumnos.get(i).getModulos().get(i).getNombremodulo().equalsIgnoreCase(modulo)) {
					alumnos.get(i).getModulos().get(i).setNota(Utilidades.leerFloat("Introduzca nueva nota"));
				}
			}
		}else {
			System.out.println("No se encuentra alumno con ese NIF");
		}
		
	}

	private static void introducirNotas(List<Alumno> alumnos) {
		boolean encontrarAlumno= false;
		String nomaux, apeaux, resp;
		int indAlumno=0;
		
		nomaux= Utilidades.introducirCadena("Introduce el nombre del alumno");
		apeaux= Utilidades.introducirCadena("Introducir el apellido del alumno");
		
		for(int i=0; i < alumnos.size(); i++) {
			if(alumnos.get(i).getNombre().equalsIgnoreCase(nomaux) && alumnos.get(i).getApellido().equalsIgnoreCase(apeaux)) {
				encontrarAlumno= true;
				indAlumno= i;
				System.out.println("Ciclo: "+ alumnos.get(i).getCiclo());
				alumnos.get(i).getModulos();
			}else {
				System.out.println("Alumno no encontrado");
			}
		}
		
		if(Utilidades.introducirCadena("¿Desea introducir notas?").equalsIgnoreCase("si")) {
			
			
		}
		if(!encontrarAlumno) {
			System.out.println("Alumno no encontrado");
		}
	}

	private static void listadoAlumnosTodaLaInformacion(List<Alumno> alumnos) {
		String nif;
		int posicion;
		
		nif= Utilidades.introducirCadena("Introduzca NIF para matricular alumno");
		posicion= buscarNif(alumnos, nif);
		
		if(posicion >= 0) {
			System.out.println("Información del Alumno");
			alumnos.get(posicion).getDatos();
		}else {
			System.out.println("Alumno no econtrado");
		}
	}

	private static void listadoAlumnos(List<Alumno> alumnos) {
		
		for(int i=0; i < alumnos.size(); i++) {
			System.out.println(alumnos.get(i).toString());
		}
		
	}

	private static void matricularAlumno(List<Alumno> alumnos) {
		String nif;
		Alumno alumno;
		int findNif;
		do {
			nif= Utilidades.introducirCadena("Introduzca NIF para matricular alumno");
			findNif= buscarNif(alumnos, nif);
			
			if(findNif >= 0) {
				System.out.println("Alumno ya existe");
			}else {
				
				alumno= new Alumno();
				alumno.setDatos(nif);
				alumnos.add(alumno);
			}
			
		  }while(Utilidades.introducirCadena("¿Desea seguir matriculando alumnos?").equalsIgnoreCase("si"));
		
		
	}

	private static int buscarNif(List<Alumno> alumnos, String nif) {
		
		int encontrado = -1;

		for (int i = 0; i < alumnos.size() && encontrado == -1; i++) {
			if (alumnos.get(i).getNif().equalsIgnoreCase(nif)) {
				encontrado = i;
			}
		}

		return encontrado;
	}

	private static char menuPrincipal(char opc) {
		System.out.println("A. Matricular alumno/s");
		System.out.println("B. Listado de alumnos");
		System.out.println("C. Listado de alumnos con toda la informacion");
		System.out.println("D. Introducir nota/s");
		System.out.println("E. Modificar la nota de un alumno");
		System.out.println("F. Dar de baja un alumno");
		System.out.println("G. Dar de baja un modulo de un alumno");
		System.out.println("H. Introducir las notas de un alumno en concreto");
		System.out.println("I. Nota media de alumnos de un ciclo");
		System.out.println("J. Mostrar alumnos ordenados por NIF");
		System.out.println("K. Mostrar alumnos que hayan suspendido un modulo en concreto");
		System.out.println("L. Mostrar la nota mas alta y la mas baja de un modulo en concreto");
		System.out.println("M. Alumnos sin evaluar de un modulo concreto");
		System.out.println("N. Listado de repetidores");
		System.out.println("O. Listado de suspensos de un ciclo en concreto");
		System.out.println("P. ");
		System.out.println("Q. ");
		System.out.println("R. ");
		System.out.println("S. Salir");
		
		opc= Utilidades.introducirCaracter("Elija la opcion");
		
		return opc;
		
		
	}

}
