import java.util.ArrayList;
import java.util.List;

public class ClasePersona {
   private String nombre;
   private String apellido;
   private int edad;
   String documento;
   private List<ClasePerro> perrosAdoptados;

   public ClasePersona(String nombre, String apellido, int edad, String documento) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.edad = edad;
      this.documento = documento;
      this.perrosAdoptados = new ArrayList<>();
   }
   public void persona(String nombre, String apellido, String documento, int edad){
      this.edad = edad;
      this.nombre = nombre;
      this.documento = documento;
      this.apellido = apellido;
      this.perrosAdoptados = new ArrayList<>();
   }
   public boolean adoptarPerro(ClasePerro ClasePerro) {
      if (perrosAdoptados.size() < 3) {
         perrosAdoptados.add(ClasePerro);
         return true;
      }
      return false;
}
   public ClasePerro perroMasGrande() {
      return perrosAdoptados.stream().max((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad())).orElse(null);
   }

   @Override
   public String toString() {
      return "Persona{" +
              "nombre='" + nombre + '\'' +
              ", apellido='" + apellido + '\'' +
              ", edad=" + edad +
              ", documento='" + documento + '\'' +
              ", perrosAdoptados=" + perrosAdoptados +
              '}';
   }
}
