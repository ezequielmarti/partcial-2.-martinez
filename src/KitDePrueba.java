import java.io.Serializable;

public class KitDePrueba implements Serializable {
    static int siguienteNumeroDeKit = 1;
    int numeroDeKit;
    Persona persona;
    double temperatura;

    public KitDePrueba(Persona persona, double temperatura) {
        this.numeroDeKit = siguienteNumeroDeKit++;
        this.persona = persona;
        this.temperatura = temperatura;
    }
}
