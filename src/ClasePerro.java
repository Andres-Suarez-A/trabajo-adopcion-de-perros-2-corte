public class ClasePerro {
    private String nombre;
    private String placa;
    private int edad;
    private String raza;
    private String tamaño;

    public ClasePerro(String nombrePerro, String placa, int edadPerro, String raza, String tamaño) {
        this.nombre = nombrePerro;
        this.raza = raza;
        this.edad = edadPerro;
        this.tamaño = tamaño;
        this.placa = placa;


    }

    public void constructor(String nombre, String placa, int edad, String raza, String tamaño){
        this.edad = edad;
        this.nombre = nombre;
        this.placa = placa;
        this.raza = raza;
        this.tamaño = tamaño;
    }

    public String getPlaca(){
        return placa;
    }
    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    public String toString(){
        return "Perro{" +
                "placa='" + placa + '\'' + ", nombre='" + nombre + '\'' + ", raza='" + raza + '\'' + ", edad=" + edad + ", tamaño='" + tamaño + '\'' + '}';
    }

}
