import java.sql.Date;

public class ClienteBanco {

    private int numCliente;
    private String nombre;
    private int numCuenta;
    private String telefono;
    private double saldo;
    private Date fechaRegistro;

    public ClienteBanco(int numCliente, int numCuenta, String telefono, double saldo, Date fechaRegistro) {
        this.numCliente = numCliente;
        this.numCuenta = numCuenta;
        this.telefono = telefono;
        this.saldo = saldo;
        this.fechaRegistro = fechaRegistro;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
