//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SistemaDeSalud sistema = new SistemaDeSalud();
        try {
            sistema.registrarPersona(new Persona("Juan", "Doe", 30, "Centro", "12345", "Ingeniero"));
            sistema.registrarPersona(new Persona("Ana", "Doe", 28, "Norte", "12346", "Doctora"));
            // Añadir más personas según sea necesario
            sistema.realizarPruebas();
            sistema.aislar();
        } catch (ExcepcionSinReactivos | ExcepcionIDduplicado | IOException e) {
            System.err.println(e.getClass());
        }
    }
}