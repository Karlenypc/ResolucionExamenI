
import java.util.Scanner;

/**
 *
 * @author Karlenypc
 */
public class ControlPacientCOVID19 {

    //Propiedades
    static String nombre;
    static String apellido1;
    static String apellido2;
    static int edad;
    static String sexo;
    static boolean histFumado;
    static boolean enfGraves;
    static String tipoSangre;
    static boolean portadorCOVID19;

    //Metodo ingresar datos basicos
    public static void infoPersonal() {
        Scanner lector = new Scanner(System.in);
        
        System.out.print("Nombre: ");
        nombre = lector.next();
        System.out.print("Apellido 1: ");
        apellido1 = lector.next();
        System.out.print("Apellido 2: ");
        apellido2 = lector.next();
        System.out.print("Edad: ");
        edad = lector.nextInt();
        System.out.println("Sexo:  femenino / masculino");
        sexo = lector.next();
    }

    //Metodo ingresar datos de tipo médico
    public static void infoMedica() {
        Scanner lector = new Scanner(System.in);
        
        String opcion;
        System.out.println("Historial de fumado? Si/No");
        opcion = lector.next();
        if (opcion.equals("Si")) {
            histFumado = true; 
        }
        
        System.out.println("Enfermedades graves? Si/No");
        opcion = lector.next();
        if (opcion.equals("Si")) {
            enfGraves = true;
        }
        
        System.out.print("Tipo de sangre: ");
        tipoSangre = lector.next();
        
        System.out.println("Portador de COVID19? Si/No");
        opcion = lector.next();
        if (opcion.equals("Si")) {
           portadorCOVID19 = true;
        }

    }

    //Metodo para calcular la probabilidad de no enfermar de forma grave
    public static double probEnfermarGrave() {
        double resultado = 0;
        resultado = (0.1 * edad);
        return resultado;
    }

    //Metodo para mostrar la información del paciente
    public static void mostrarInfoCompleta() {
        
        System.out.println("**********************************");
        System.out.println("Informacion del Paciente.");
        System.out.println("Tipo Básica:");
        System.out.println("Nombre Completo: " + nombre + " " + apellido1 + " " + apellido2);
        System.out.println("Edad: " + edad);
        System.out.println("Sexo: " + sexo); 
        System.out.println("\n" + "Tipo Médica:");
        System.out.println("Tipo de sangre: " + tipoSangre);
        System.out.println("Historial de fumado = " + histFumado);
        System.out.println("Historial de enfermedades graves = " + enfGraves);
        System.out.println("Portador de COVID19 = " + portadorCOVID19);
        System.out.println("**********************************");
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        char seleccion;

        do {
            System.out.println("\n" + "Por favor seleccione la opción que desea realizar:");
            System.out.println("a) Ingresar datos de tipo básico.");
            System.out.println("b) Ingresar datos de tipo médico.");
            System.out.println("c) Mostrar datos del paciente.");
            System.out.println("d) Calcular probabilidad de que el paciente no enferme gravemente.");
            System.out.println("e) Borrar todos los datos registrados.");
            System.out.println("f) Salir.");

            seleccion = lector.next().charAt(0);

            switch (seleccion) {

                case 'a': {
                    infoPersonal();
                    break;
                }

                case 'b': {

                    if (nombre == null || apellido1 == null || edad == 0) {
                        System.out.println("Primero debe ingresar datos de tipo básico.");
                    } else {
                        infoMedica();
                    }
                    break;
                }

                case 'c': {

                    mostrarInfoCompleta();
                    if (edad > 50 || histFumado == true || enfGraves == true) {

                        System.out.println("\n" + "***ALERTA***");
                    }

                    if (tipoSangre.equals("O-")) {
                        System.out.println("Este es un mensaje de prevención.");
                    }
                    break;
                }

                case 'd': {

                    double probabilidad;
                    probabilidad = probEnfermarGrave();
                    System.out.println("La probabilidad de que el paciente no enferme de forma grave es: " + probabilidad);
                    break;
                }

                case 'e': {

                    nombre = null;
                    apellido1 = null;
                    apellido2 = null;
                    edad = 0;
                    sexo = null;
                    tipoSangre = null;
                    histFumado = false;
                    enfGraves = false;
                    portadorCOVID19 = false;
                    System.out.println("Los datos se han eliminado correctamente.");
                    break;
                }
                
                default : {
                    System.out.println("El ciclo ha finalizado");
                }   
            }
        } while (seleccion < 'f');
    }
}
