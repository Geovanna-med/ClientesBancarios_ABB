import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Sistema {

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

    public void obtenerHoraRegistro() { // imprime la hora actual
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

        System.out.println(timeStamp);
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
                    String infoCliente = newCliente();
                    String[] infoSeparada = infoCliente.split("/");
                    System.out.println("\n");
                    System.out.println("Nombre del cliente: " + infoSeparada[0]);
                    System.out.println("Telefono del cliente: " + infoSeparada[1]);
                    System.out.println("Fecha de registro: ");
                    obtenerHoraRegistro();

                    break;
                case 2:
                    System.out.println("Generando .csv");
                    break;
                case 3:
                    System.out.println("Generando .pdf");
                    break;
            }
        }
    }

}
