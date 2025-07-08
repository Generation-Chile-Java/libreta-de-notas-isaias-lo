import java.util.*;

public class LibretaDeNotas {
    private Map<String, ArrayList<Double>> calificaciones = new HashMap<>();
    private final double NOTA_MIN = 1.0;
    private final double NOTA_MAX = 7.0;
    private final double NOTA_APROBACION = 4.0;

    public void ingresarDatos(Scanner sc) {
        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = Integer.parseInt(sc.nextLine());

        if (cantidadAlumnos <= 0) {
            System.out.println("❌ Cantidad inválida.");
            return;
        }

        System.out.print("Ingrese la cantidad de notas por alumno: ");
        int cantidadNotas = Integer.parseInt(sc.nextLine());

        if (cantidadNotas <= 0) {
            System.out.println("❌ Cantidad inválida.");
            return;
        }

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.print("\nNombre del alumno #" + (i + 1) + ": ");
            String nombre = sc.nextLine();

            ArrayList<Double> notas = new ArrayList<>();

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.print("  Nota #" + (j + 1) + ": ");
                double nota = Double.parseDouble(sc.nextLine());

                if (nota < NOTA_MIN || nota > NOTA_MAX) {
                    System.out.println("⚠️ Nota fuera de rango (1.0 - 7.0). Intente nuevamente.");
                    j--;
                } else {
                    notas.add(nota);
                }
            }

            calificaciones.put(nombre, notas);
        }
    }

    public void mostrarPromedios() {
        for (String alumno : calificaciones.keySet()) {
            ArrayList<Double> notas = calificaciones.get(alumno);
            double promedio = calcularPromedio(notas);
            System.out.printf("📊 %s → Promedio: %.2f | Máx: %.2f | Mín: %.2f%n",
                    alumno, promedio, Collections.max(notas), Collections.min(notas));
        }
    }

    public void verificarAprobacion(String alumno, double nota) {
        if (!calificaciones.containsKey(alumno)) {
            System.out.println("❌ Estudiante no encontrado.");
            return;
        }

        if (nota < NOTA_MIN || nota > NOTA_MAX) {
            System.out.println("❌ Nota inválida.");
            return;
        }

        if (nota >= NOTA_APROBACION) {
            System.out.println("✅ Nota aprobatoria.");
        } else {
            System.out.println("❌ Nota reprobatoria.");
        }
    }

    public void compararConPromedioCurso(String alumno, double nota) {
        if (!calificaciones.containsKey(alumno)) {
            System.out.println("❌ Estudiante no encontrado.");
            return;
        }

        double promedioCurso = calcularPromedioCurso();
        System.out.printf("📚 Promedio del curso: %.2f%n", promedioCurso);

        if (nota > promedioCurso) {
            System.out.println("🔼 La nota está por sobre el promedio del curso.");
        } else if (nota < promedioCurso) {
            System.out.println("🔽 La nota está por debajo del promedio del curso.");
        } else {
            System.out.println("⏺ La nota es igual al promedio del curso.");
        }
    }

    private double calcularPromedio(ArrayList<Double> notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    private double calcularPromedioCurso() {
        double suma = 0;
        int cantidadTotal = 0;

        for (ArrayList<Double> notas : calificaciones.values()) {
            for (double nota : notas) {
                suma += nota;
                cantidadTotal++;
            }
        }

        return cantidadTotal > 0 ? suma / cantidadTotal : 0;
    }
}
