import java.lang.Comparable;
import java.util.UUID;
import java.math.BigInteger;
import java.util.Random;

public class ClienteBanco implements Comparable<ClienteBanco> {

    Random random = new Random();

    private int numCliente;

    public ClienteBanco(int numCliente) {
        this.numCliente = numCliente;
    }

    private String nombre;
    private int numCuenta;
    private String telefono;
    private double saldo;
    private String fechaRegistro;

    public ClienteBanco(String nombre, String telefono,
            String string) {
        this.nombre = nombre;
        this.numCliente = random.nextInt();
        this.numCuenta = random.nextInt();
        this.telefono = telefono;
        this.saldo = 0;
        this.fechaRegistro = string;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int compareTo(ClienteBanco cliente) {
        if (this.getClass() == ClienteBanco.class) {
            if (cliente instanceof ClienteBanco) {
                if (this.numCliente == cliente.numCliente) {
                    return 0;
                } else if (this.numCliente > cliente.numCliente) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return -1;
            }
        }
        return numCliente;

    }
}
