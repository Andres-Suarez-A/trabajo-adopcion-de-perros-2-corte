import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<ClasePersona> personas = new ArrayList<>();
    private static List<ClasePerro> perrosDisponibles = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú");
            System.out.println("1. Registrar Personas");
            System.out.println("2. Registrar Perros");
            System.out.println("3. Ver personas registradas");
            System.out.println("4. Ver perros disponibles");
            System.out.println("5. Adoptar perro");
            System.out.println("6. Consultar el perro más viejo adoptado por una persona");
            System.out.println("7. Salir del programa");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Documento: ");
                    String documento = scanner.nextLine();
                    personas.add(new ClasePersona(nombre, apellido, edad, documento));
                    break;

                case 2:
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombrePerro = scanner.nextLine();
                    System.out.print("Raza: ");
                    String raza = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edadPerro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tamaño: ");
                    String tamaño = scanner.nextLine();
                    perrosDisponibles.add(new ClasePerro(nombrePerro, placa, edadPerro, raza, tamaño));
                    break;


                case 3:
                    for (ClasePersona persona : personas) {
                        System.out.println(persona);
                    }
                    break;

                case 4:
                    for (ClasePerro perro : perrosDisponibles) {
                        System.out.println(perro);
                    }
                    break;

                case 5:
                    System.out.print("Ingrese documento de la persona: ");
                    String doc = scanner.nextLine();
                    ClasePersona personaAdoptante = personas.stream()
                            .filter(p -> p.documento.equals(doc))
                            .findFirst()
                            .orElse(null);
                    if (personaAdoptante != null) {
                        System.out.print("Ingrese placa del perro: ");
                        String placaPerro = scanner.nextLine();
                        ClasePerro perroAAdoptar = perrosDisponibles.stream()
                                .filter(p -> p.getPlaca().equals(placaPerro))
                                .findFirst()
                                .orElse(null);
                        if (perroAAdoptar != null && personaAdoptante.adoptarPerro(perroAAdoptar)) {
                            perrosDisponibles.remove(perroAAdoptar);
                            System.out.println("Perro adoptado con éxito.");
                        } else {
                            System.out.println("No se pudo adoptar el perro.");
                        }
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese documento de la persona: ");
                    String docConsulta = scanner.nextLine();
                    ClasePersona personaConsulta = personas.stream()
                            .filter(p -> p.documento.equals(docConsulta))
                            .findFirst()
                            .orElse(null);
                    if (personaConsulta != null) {
                        ClasePerro perroViejo = personaConsulta.perroMasGrande();
                        if (perroViejo != null) {
                            System.out.println("Perro más viejo adoptado: " + perroViejo);
                        } else {
                            System.out.println("No ha adoptado perros");
                        }
                    } else {
                        System.out.println("Persona no encontrada");
                    }
                    break;

                case 7:
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 7);

        scanner.close();
    }
}