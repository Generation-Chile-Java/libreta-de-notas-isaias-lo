import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibretaDeNotas libreta = new LibretaDeNotas();
        Scanner sc = new Scanner(System.in);

        libreta.ingresarDatos(sc);

        while (true) {
            System.out.println("\n📋 MENÚ:");
            System.out.println("1. Mostrar Promedio de Notas por Estudiante");
            System.out.println("2. Verificar si una Nota es Aprobatoria/Reprobatoria");
            System.out.println("3. Comparar Nota con el Promedio del Curso");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    libreta.mostrarPromedios();
                    break;
                case "2":
                    System.out.print("Nombre del estudiante: ");
                    String nombre2 = sc.nextLine();
                    System.out.print("Nota a verificar: ");
                    double nota2 = Double.parseDouble(sc.nextLine());
                    libreta.verificarAprobacion(nombre2, nota2);
                    break;
                case "3":
                    System.out.print("Nombre del estudiante: ");
                    String nombre3 = sc.nextLine();
                    System.out.print("Nota a comparar: ");
                    double nota3 = Double.parseDouble(sc.nextLine());
                    libreta.compararConPromedioCurso(nombre3, nota3);
                    break;
                case "0":
                    System.out.println("👋 Saliendo del programa.");
                    return;
                default:
                    System.out.println("❌ Opción inválida.");
            }
        }
    }
}

