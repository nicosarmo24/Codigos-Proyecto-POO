import java.io.*;
import java.util.StringTokenizer;


public class LectorDeArchivos {
    public static boolean buscaNickPassClientes(String nickname, String password){
        boolean encontradoClientes = false;
        try{
            File archivoClientes = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\RegistroClientes.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                String[] datos = new String[10];
                int i = 0;
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                while(particion.hasMoreTokens()){
                    datos[i] = particion.nextToken();
                    i++;
                }
                if(datos[8].equalsIgnoreCase(nickname) && datos[9].equalsIgnoreCase(password)){
                    encontradoClientes = true;
                }
                lineaLeida = bufferEntrada.readLine();
            }
            bufferEntrada.close();
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return encontradoClientes;
    }

    public static boolean buscaNickPassAdmins(String nickname, String password){
        boolean encontradoAdmins = false;
        try{
            File archivoClientes = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\RegistroAdministradores.txt");
            FileReader lector = new FileReader(archivoClientes);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            while(lineaLeida != null){
                String[] datos = new String[10];
                int i = 0;
                StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                while(particion.hasMoreTokens()){
                    datos[i] = particion.nextToken();
                    i++;
                }
                if(datos[8].equalsIgnoreCase(nickname) && datos[9].equalsIgnoreCase(password)){
                    encontradoAdmins = true;
                }
                lineaLeida = bufferEntrada.readLine();
            }
            bufferEntrada.close();
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return encontradoAdmins;
    }
    public static void preciosMiniatura(){
        try{
            File preciosMiniatura = new File("C:\\Users\\nicol\\OneDrive\\Imágenes\\Escritorio\\ArchivosAuxiliaresPruebasProyecto\\PreciosMiniatura.txt");
            FileReader lector = new FileReader(preciosMiniatura);
            BufferedReader bufferEntrada = new BufferedReader(lector);
            String lineaLeida = bufferEntrada.readLine();
            int numeroDeLinea = 1;
            while(lineaLeida != null){
                if(numeroDeLinea == 1){
                    float[] preciosBanio = new float[5];
                    int i = 0;
                    StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                    while(particion.hasMoreTokens()){
                        String dato = particion.nextToken();
                        preciosBanio[i] = Float.parseFloat(dato);
                    }
                    System.out.println("Precios de baño para perro miniatura:");
                    System.out.println("Precio base: $" + preciosBanio[0]);
                    System.out.println("Sin pelo: $" + preciosBanio[1]);
                    System.out.println("Pelo corto: $" + preciosBanio[2]);
                    System.out.println("Pelo medio: $" + preciosBanio[3]);
                    System.out.println("Pelo largo: $" + preciosBanio[4]);
                } else if (numeroDeLinea == 2) {
                    float[] preciosPelo = new float[4];
                    int i = 0;
                    StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                    while(particion.hasMoreTokens()){
                        String dato = particion.nextToken();
                        preciosPelo[i] = Float.parseFloat(dato);
                    }
                    System.out.println("Precios de corte de pelo para perro miniatura:");
                    System.out.println("Sin pelo: $" + preciosPelo[0]);
                    System.out.println("Pelo corto: $" + preciosPelo[1]);
                    System.out.println("Pelo medio: $" + preciosPelo[2]);
                    System.out.println("Pelo largo: $" + preciosPelo[3]);
                } else if (numeroDeLinea == 3) {
                    float[] precioUnia = new float[1];
                    int i = 0;
                    StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                    while(particion.hasMoreTokens()){
                        String dato = particion.nextToken();
                        precioUnia[i] = Float.parseFloat(dato);
                    }
                    System.out.println("Precio de corte de uñas para perro miniatura: $" + precioUnia[0]);
                } else if(numeroDeLinea == 4) {
                    float[] precioDientes = new float[1];
                    int i = 0;
                    StringTokenizer particion = new StringTokenizer(lineaLeida, ":");
                    while(particion.hasMoreTokens()){
                        String dato = particion.nextToken();
                        precioDientes[i] = Float.parseFloat(dato);
                    }
                    System.out.println("Precio de cepillado de dientes para perro miniatura: $" + precioDientes[0]);
                }
                numeroDeLinea++;
                lineaLeida = bufferEntrada.readLine();
            }
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
