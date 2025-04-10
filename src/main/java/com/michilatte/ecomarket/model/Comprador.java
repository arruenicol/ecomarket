package com.michilatte.ecomarket.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comprador")
public class Comprador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComprador;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombreComprador;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellidoComprador;

    @Enumerated(EnumType.STRING)
    //ENUM @Column(name = "tipo_doc", nullable = false)

    @Column(name = "num_identificador", unique = true, nullable = false, length = 20)
    private String numIdentificador;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimientoComprador;

    @Column(name = "telefono", unique = true, length = 15)
    private String telefonoComprador;

    @Column(name = "correo", unique = true, length = 50, nullable = false)
    private String correo;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @Column(name = "direccion", length = 50, nullable = false)
    private String direccionCliente;

    public Comprador() {
    }

    public Comprador(long idComprador, String nombreComprador, String apellidoComprador,
                     String numIdentificador,Date fechaNacimientoCliente, String telefonoCliente,
                     String correoComprador, String contraComprador, String direccionComprador) {
        this.idComprador = idComprador;
        this.nombreComprador = nombreComprador;
        this.apellidoComprador = apellidoComprador;
        this.numIdentificador = numIdentificador;

        this.telefonoComprador = telefonoComprador;
        this.correo = correo;
        this.contrasenia= contrasenia;
        //this.direccionComprador = direccionComprador;
    }

    public long getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(long idComprador) {
        this.idComprador = idComprador;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getApellidoCliente() {
        return apellidoComprador;
    }

    public void setApellidoComprador(String apellidoComprador) {
        this.apellidoComprador = apellidoComprador;
    }

    public String getNumIdentificador() {
        return numIdentificador;
    }

    public void setNumIdentificador(String numIdentificador) {
        this.numIdentificador = numIdentificador;
    }

    public String getTelefonoComprador() {
        return telefonoComprador;
    }
}
