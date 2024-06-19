import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class SistemaDeSalud {
    List<Persona> personas = new ArrayList<>();
    Map<Integer, KitDePrueba> resultadosDePruebas = new HashMap<>();
    int pruebasDisponibles = 10; // Límite de ejemplo

    public void registrarPersona(Persona persona) throws ExcepcionSinReactivos, ExcepcionIDduplicado, IOException {
        if (pruebasDisponibles <= 0) throw new ExcepcionSinReactivos("No hay más kits de prueba disponibles.");
        for (Persona p : personas) {
            if (p.ID.equals(persona.ID)) throw new ExcepcionIDduplicado("ID duplicado encontrado: " + persona.ID);
        }
        personas.add(persona);
        pruebasDisponibles--;
    }

    public void realizarPruebas() throws IOException {
        Random rand = new Random();
        for (Persona persona : personas) {
            double temperatura = 36 + (39 - 36) * rand.nextDouble();
            KitDePrueba kitDePrueba = new KitDePrueba(persona, temperatura);
            resultadosDePruebas.put(kitDePrueba.numeroDeKit, kitDePrueba);
        }
    }

    public void aislar() throws IOException {
        JSONArray sanos = new JSONArray();
        JSONArray aislar = new JSONArray();

        for (KitDePrueba kit : resultadosDePruebas.values()) {
            JSONObject datosPersona = new JSONObject();
            datosPersona.put("ID", kit.persona.ID);
            datosPersona.put("Temperatura", kit.temperatura);
            datosPersona.put("Barrio", kit.persona.barrio);

            if (kit.temperatura >= 38) {
                aislar.add(datosPersona);
                try {
                    throw new ExcepcionAislamientoRequerido("Aislamiento requerido", kit.numeroDeKit, kit.persona.barrio);
                } catch (ExcepcionAislamientoRequerido e) {
                    System.out.println(e.getMessage());
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("urgente.dat", true))) {
                        oos.writeObject(e);
                    }
                }
            } else {
                sanos.add(datosPersona);
            }
        }
