import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String archivoCSV = "Proveedores.csv";
        String linea;
        ArrayList<Proveedor> listaProveedores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            // Leer el encabezado
            br.readLine();
            // Leer las líneas del archivo
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\t");
                if (datos.length == 4) {
                    Proveedor proveedor = new Proveedor(datos[0], datos[1], datos[2], datos[3]);
                    listaProveedores.add(proveedor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar los proveedores migrados
        for (Proveedor proveedor : listaProveedores) {
            System.out.println(proveedor);
        }
    }
}