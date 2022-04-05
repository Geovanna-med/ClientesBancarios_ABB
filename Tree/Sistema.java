import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import dataStructure.*;

public class Sistema {

    Tree<ClienteBanco> tree = new Tree<>();

    public String newCliente() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese su nombre completo: ");
        String nombre = scan.nextLine();
        System.out.println("\n");

        System.out.println("Ingrese su telefono: ");
        String telefono = scan.nextLine();
        System.out.println("\n");

        String infoUsers = (nombre + "/" + telefono);

        scan.close();

        return infoUsers;
    }

    public String obtenerHoraRegistro() { // imprime la hora actual
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

        return timeStamp;
    }

    public void menu() {
        String menu = ("|----------------------------Menú------------------------------|\n" +
                "| 0. Salir                                                      |\n" +
                "| 1. Dar de alta a un cliente                                   |\n" +
                "| 2. Actualizar datos de un cliente                             |\n" +
                "| 3. Generar reporte de clientes                                |\n" +
                "| 4. Generar reporte de clientes con antiguedad mayor a 5 anios |\n" +
                "| 5. Dar de baja a un cliente                                   |\n" +
                "|---------------------------------------------------------------|");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(menu);
            int seleccion = sc.nextInt();
            sc.nextLine();
            switch (seleccion) {
                case 0:
                    return;
                case 1:
                    darAltaCliente();
                    break;
                case 2:
                    actualizarCliente();
                    break;
                case 3:
                    System.out.println("Generando .pdf");
                    break;
            }
            sc.close();
        }
    }

    public void darAltaCliente() {

        String infoCliente = newCliente();
        String[] infoSeparada = infoCliente.split("/");
        System.out.println("\n");
        System.out.println("Nombre del cliente: " + infoSeparada[0]);
        System.out.println("Telefono del cliente: " + infoSeparada[1]);
        System.out.println("Fecha y hora de registro: " + obtenerHoraRegistro());

        ClienteBanco cliente = new ClienteBanco(infoSeparada[0], infoSeparada[1],
                obtenerHoraRegistro());

        tree.insert(cliente);
        System.out.println(cliente.toString());

    }

    public void actualizarCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba el numero de cliente: ");
        int numCliente = sc.nextInt();

        ClienteBanco cliente = new ClienteBanco(numCliente);

        tree.find(cliente);
        String menu = ("|---Actualizar informacion---|\n" +
                "| 0. Salir                   |\n" +
                "| 1. Telefono                |\n" +
                "|----------------------------|");

        while (true) {
            System.out.println("Elija la informacion que desea actualizar");
            System.out.println(menu);
            int seleccion = sc.nextInt();
            sc.nextLine();
            switch (seleccion) {
                case 0:
                    return;
                case 1:
                    System.out.println("Ingrese el nuevo telefono");
                    String newTelefono = sc.nextLine();
                    cliente.setTelefono(newTelefono);
                    break;
            }
        }

    }

    public void eliminarCliente() {
        // tree.deleteRec(null, null)

    }

}
