package Fromativa1Semana3package;
import java.util.List;
import java.util.Map;

public class Usuario {
    
    private int id;
    private String nombre;
    private String contraseña;
    private String rut;
    private String rol;
    private String direccion;
    private List<Producto> productos;
    private Map<Integer, List<Integer>> detalleCompra;

    public Usuario(int id, String nombre, String contraseña, String rut, String rol, String direccion, List<Producto> productos,Map<Integer, List<Integer>> detalleCompra)
    {
        this.id=id;
        this.nombre=nombre;
        this.contraseña=contraseña;
        this.rut=rut;
        this.rol=rol;
        this.direccion=direccion;
        this.productos=productos;
        this.detalleCompra=detalleCompra;
    }

    //Getter y Setters
    public int getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getContraseña()
    {
        return contraseña;
    }

    public String getRut()
    {
        return rut;
    }

    public String getRol()
    {
        return rol;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public List<Producto> getProductos()
    {
        return productos;
    }

    public Map<Integer, List<Integer>> getDetalleCompra()
    {
        return detalleCompra;
    }


}
