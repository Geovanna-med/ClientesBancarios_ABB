import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import dataStructure.*;

public class Sistema {

    Tree<ClienteBanco> tree = new Tree<>();
    private static Scanner sc = new Scanner(System.in);

    public String newCliente() {

        System.out.println("Ingrese su nombre completo: ");
        String nombre = sc.nextLine();
        System.out.println("\n");

        System.out.println("Ingrese su telefono: ");
        String telefono = sc.nextLine();
        System.out.println("\n");

        String infoUsers = (nombre + "/" + telefono);
        return infoUsers;
    }

    public String obtenerHoraRegistro() { // imprime la hora actual
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

        return timeStamp;
    }

    public void menu() {
        String menu = ("|-----------------Menú---------------------|\n" +
                "| 0. Salir                                |\n" +
                "| 1. Dar de alta a un cliente             |\n" +
                "| 2. Actualizar datos de un cliente       |\n" +
                "| 3. Actualizar saldo de una cuenta       |\n" +
                "| 4. Generar reporte de clientes          |\n" +
                "| 5. Dar de baja a un cliente             |\n" +
                "|-----------------------------------------|");

        while (true) {
            System.out.println(menu);
            int seleccion = sc.nextInt();
            sc.nextLine();
            switch (seleccion) {
                case 1:
                    darAltaCliente();
                    break;
                case 2:
                    actualizarCliente();
                    break;
                case 3:
                    actualizarSaldo();
                    break;
                case 4:

                    break;

                case 5:
                    eliminarCliente();
                    break;
            }

        }
    }

    public void darAltaCliente() {

        String infoCliente = newCliente();
        String[] infoSeparada = infoCliente.split("/");
        System.out.println("\n");
        System.out.println("Nombre del cliente: " + infoSeparada[0]);
        System.out.println("Telefono del cliente: " + infoSeparada[1]);
        System.out.println("Su saldo actual es: $0.00 pesos mexicanos");
        System.out.println("Fecha y hora de registro: " + obtenerHoraRegistro());

        ClienteBanco cliente = new ClienteBanco(infoSeparada[0], infoSeparada[1],
                obtenerHoraRegistro());

        tree.insert(cliente);

        System.out.println(cliente);

    }

    public void actualizarCliente() {

        System.out.println("Escriba el numero de cliente: ");
        int numCliente = sc.nextInt();

        ClienteBanco cliente = new ClienteBanco(numCliente);

        tree.find(cliente);
        String menu = ("|---Actualizar informacion---|\n" +
                "| 0. Salir                   |\n" +
                "| 1. Telefono                |\n" +
                "|----------------------------|");

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

                System.out.println("El telefono " + newTelefono + " se ha guardado exitosamente");

                break;
        }
    }

    public void actualizarSaldo() {
        System.out.println("Escriba el numero de cliente: ");
        int numCliente = sc.nextInt();
        System.out.println("Escriba el numero de cuenta: ");
        int numCuenta = sc.nextInt();

        ClienteBanco cliente = new ClienteBanco(numCliente, numCuenta);

        tree.find(cliente);

        double newSaldo = sc.nextDouble();
        cliente.setSaldo(newSaldo);

        System.out.println("Su saldo es de $" + newSaldo + " pesos mexicanos");

    }

    public void eliminarCliente() {
        System.out.println("Escriba el numero de cliente del usuario que desea eliminar");
        int numCliente = sc.nextInt();

        ClienteBanco cliente = new ClienteBanco(numCliente);

        tree.deleteKey(cliente);
        System.out.println("El usuario con numero de cliente " + numCliente + " ha sido eliminado exitosamente");
    }

    public void all(ArrayList<ClienteBanco> clientesList) throws IOException {

        File file = new File("reporte.csv");
        String row;
        FileWriter fw = new FileWriter(file);
        try {
            for (ClienteBanco cliente : clientesList) {

                // consiste de nombre, domicilio y tel
                row = cliente.toString();
                fw.write(row);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            fw.close();
        }
    }

}
