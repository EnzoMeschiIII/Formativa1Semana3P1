package Fromativa1Semana3package;

public class Producto {
    private int codigo;
    private String nombre;

    public Producto(int codigo, String nombre)
    {
        this.codigo=codigo;
        this.nombre=nombre;
    }

     //Getter y Setters
     public int getCodigo()
     {
         return codigo;
     }
 
     public String getNombre()
     {
         return nombre;
     }
}
