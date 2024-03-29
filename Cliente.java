import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario{
    private float cuenta;
    private ArrayList<Mascota> mascotas;
    Scanner scanner = new Scanner(System.in);
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String mail, String numeroCelular, String direccion, String nickname, String password){
        super(nombre, apellidoPaterno, apellidoMaterno, edad, mail, numeroCelular, direccion, nickname, password);
        this.cuenta = 0.0f;
        this.mascotas = new ArrayList<>();
    }

    public void registrarUnaMascota(){
        boolean mascotaValida = false;
        while(!mascotaValida){
            System.out.println("----REGISTRAR MASCOTA----");
            System.out.println("Ingrese que desea registrar:");
            System.out.println("Perro - Gato");
            String tipoDeMascota = scanner.nextLine();
            if(tipoDeMascota.equalsIgnoreCase("Perro")){
                mascotaValida = true;
                System.out.println("----PERRO----");
                System.out.println("Ingresa el nombre del perro:");
                String nombrePerro = scanner.nextLine();
                System.out.println("Ingresa la edad del perro en años:");
                int edadPerro = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Ingresa el tipo de pelo del perro, a continuación se muestran referencias:");
                System.out.println("- Sin pelo (Ej. Xoloitzcuintle, Terrier americano)");
                System.out.println("- Pelo corto (Ej. Dóberman, Pitbull, Bulldog, Beagle)");
                System.out.println("- Pelo medio (Ej. Maltés, Husky, Pastor alemán, Border collie)");
                System.out.println("- Pelo largo (Ej.Collie de pelo largo (Lassie), Galgo albano, Yorkshire terrier, Komondor).");
                String tipoDePeloPerro = scanner.nextLine();
                System.out.println("Ingresa la altura del perro, a continuación se presentan referencias:");
                System.out.println("- Miniatura (25cm o menos)");
                System.out.println("- Pequeño (25cm a 40cm)");
                System.out.println("- Mediano (40cm a 60cm)");
                System.out.println("- Grande (60cm a 80cm)");
                System.out.println("- Gigante (80cm o más)");
                String alturaPerro = scanner.nextLine();
                Perro nuevoPerro = new Perro(nombrePerro, edadPerro, tipoDePeloPerro, alturaPerro);
                getMascotas().add(nuevoPerro);
                EscritorDeArchivos.escribirPerro(nuevoPerro);

            } else if (tipoDeMascota.equalsIgnoreCase("Gato")) {
                mascotaValida = true;
                System.out.println("----GATO----");
                System.out.println("Ingresa el nombre del gato:");
                String nombreGato = scanner.nextLine();
                System.out.println("Ingresa la edad del gato en años:");
                int edadGato = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Ingresa el tipo de pelo del gato, a continuación se presentan referencias:");
                System.out.println("Sin pelo (Ej.Esfinge, Elfo, Bambino);");
                System.out.println("Pelo medio (Ej. Gato doméstico americano, Siamés, Escocés)");
                System.out.println("Pelo largo(Ej.Persa, Angora, Him).");
                String tipoDePeloGato = scanner.nextLine();
                Gato nuevoGato = new Gato(nombreGato, edadGato, tipoDePeloGato);
                getMascotas().add(nuevoGato);
                EscritorDeArchivos.escribirGato(nuevoGato);
            } else{
                mascotaValida = false;
                System.out.println("Opción de registro no valida, intenta de nuevo.");
            }
        }
    }

    public void reservarServicio(){
       if(mascotas.isEmpty()){
           System.out.println("No hay mascotas registradas, registra al menos una para continuar.");
       } else{
           System.out.println("----SOLICITUD DE SERVICIO PARA MASCOTA----");
           System.out.println("Lista de mascotas registradas de: " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno());
           int indice = 0;
           for(Mascota actual : mascotas){
               System.out.println("Mascota: " + indice);
               if(actual instanceof Perro){
                   Perro perroActual = (Perro)actual;
                   System.out.println("Nombre: " + perroActual.getNombre());
                   System.out.println("Edad: " + perroActual.getEdad() + " años.");
                   System.out.println("Tipo de pelo: " + perroActual.getTipoDePelo());
                   System.out.println("Altura: " + perroActual.getAltura());
               } else if (actual instanceof Gato) {
                   System.out.println("Nombre: " + actual.getNombre());
                   System.out.println("Edad: " + actual.getEdad());
                   System.out.println("Tipo de pelo: " + actual.getTipoDePelo());
               }
               indice++;
           }
           System.out.println("Ingresa el indice correspondiente a la mascota a la cual se le quiere reservar un servicio.");
           int seleccionIndice = scanner.nextInt();
           scanner.nextLine();
           int tamanioLista = mascotas.size();
           if(seleccionIndice > tamanioLista){
               System.out.println("Indice no válido, intente de nuevo.");
           } else {
               Mascota eleccion = mascotas.get(seleccionIndice);
               if(eleccion instanceof Perro){
                   Perro perro = (Perro)eleccion;
                   System.out.println("Nombre: " + perro.getNombre());
                   System.out.println("Edad: " + perro.getEdad() + " años.");
                   System.out.println("Tipo de pelo: " + perro.getTipoDePelo());
                   System.out.println("Altura: " + perro.getAltura());
                   System.out.println("Lista de precios para perro " + perro.getAltura().toLowerCase());
                   if(perro.getAltura().equalsIgnoreCase("Miniatura")){
                       LectorDeArchivos.preciosMiniatura();
                   }
               } else if (eleccion instanceof Gato) {
                   System.out.println("Nombre: " + eleccion.getNombre());
                   System.out.println("Edad: " + eleccion.getEdad());
                   System.out.println("Tipo de pelo: " + eleccion.getTipoDePelo());
               }
           }
       }
    }

    public float getCuenta() {
        return cuenta;
    }

    public void setCuenta(float cuenta) {
        this.cuenta = cuenta;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
