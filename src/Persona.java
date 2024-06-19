import java.io.Serializable;

public class Persona  implements Serializable {
    String nombre, apellido, barrio, ID, ocupacion;
    int edad;

    public Persona(String nombre, String apellido, int edad, String barrio, String ID, String ocupacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.barrio = barrio;
        this.ID = ID;
        this.ocupacion = ocupacion;
    }
}

