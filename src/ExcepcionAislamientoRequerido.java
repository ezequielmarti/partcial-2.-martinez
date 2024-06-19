public class ExcepcionAislamientoRequerido extends Exception {
    int numeroDeKit;
    String barrio;

    public ExcepcionAislamientoRequerido(String mensaje, int numeroDeKit, String barrio) {
        super(mensaje);
        this.numeroDeKit = numeroDeKit;
        this.barrio = barrio;
    }
}
