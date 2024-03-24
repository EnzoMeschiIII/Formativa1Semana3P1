package Fromativa1Semana3package;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;


@RestController
public class UsuarioController
{
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioController()
    {
        usuarios.add(new Usuario(1, "Admin","Admin123","1-0","Administrador","Casa Matriz",
                    Arrays.asList(new Producto(0,"Null")),
                    detalleCompra(0, 0, 0)));
        usuarios.add(new Usuario(2, "JulioSantos","mamita123","21435782-2","Cliente","La Moneda 100",
                    Arrays.asList(new Producto(1,"Microondas")),
                    detalleCompra(1, 1, 200000)));
        usuarios.add(new Usuario(3, "MacarenaPelolais","divina123","19654876-k","Cliente","Amapolas 432",
                    Arrays.asList(new Producto(2,"PintaUñasRosado")),
                    detalleCompra(2, 3, 25000)));
        usuarios.add(new Usuario(4, "Carlitros","piscola4Ever","19743755-3","Cliente","Vitacumbia 675",
                    Arrays.asList(new Producto(3,"Kuntsman Torobayo")),
                    detalleCompra(3, 26, 2000)));
        usuarios.add(new Usuario(5, "BarbaraRebolledo","gatitosCute","5743256-1","Cliente","Irarrazabal 543",
                    Arrays.asList(new Producto(4,"ComidaGato")),
                    detalleCompra(4, 2, 26000)));
        usuarios.add(new Usuario(6, "Benjamin","Skah","19639357-9","VIP","Macul 555",
                    Arrays.asList(new Producto(5,"FiguraDeGoku")),
                    detalleCompra(5, 3, 32000)));
        usuarios.add(new Usuario(7, "Amanda","Sims3","20164077-6","VIP","Macul 555",
                    Arrays.asList(new Producto(6,"Arenero")),
                    detalleCompra(6, 2, 15000)));
    }

    private Map<Integer, List<Integer>> detalleCompra(int codigo, int cantidad, int precio)
    {
        Map<Integer, List<Integer>> retorno = new HashMap<Integer, List<Integer>>();

        List<Integer> detalleCompra = Arrays.asList(cantidad, precio);
        retorno.put(codigo,detalleCompra);

        return retorno;
    }

    @GetMapping("/usuarios")
    public List <Usuario> getUsuarios()
    {
        return usuarios;
    }

    @GetMapping("/usuarios/clientes")
    public List<Usuario> getClientes() 
    {
        List<Usuario> clientes = new ArrayList<>();
        for (Usuario usuario : usuarios) 
        {
            if ("Cliente".equals(usuario.getRol())) 
            {
                clientes.add(usuario);
            }
        }
        return clientes;
    }

    @GetMapping("/usuarios/porId/{id}")
    public Usuario getUsuarioPorId(@PathVariable int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    @GetMapping("/usuarios/porRol/{rol}")
    public List<Usuario> getUsuariosPorRol(@PathVariable String rol) {
    List<Usuario> usuariosPorRol = new ArrayList<>();
    for (Usuario usuario : usuarios) {
        if (usuario.getRol().equals(rol)) {
            usuariosPorRol.add(usuario);
        }
    }
    return usuariosPorRol;
}

    @GetMapping(path = "/usuarios/{idUsuario}/total/{codigoProducto}")
    public ResponseEntity<Map<String, Integer>> totalCompra(@PathVariable("idUsuario") Integer idUsuario,
                                @PathVariable("codigoProducto") Integer codigoProducto)
    {
        Integer valorTotal = 0;

        for (Usuario usuario : usuarios)
        {
            if (usuario.getId() == idUsuario) 
            {
                Map<Integer, List<Integer>> detalleCompraMap = usuario.getDetalleCompra();
                List<Integer> detalleCompra = detalleCompraMap.get(codigoProducto);
    
                if (detalleCompra != null) 
                {
                    Integer cantidad = detalleCompra.get(0);
                    Integer precio = detalleCompra.get(1);
                    valorTotal = cantidad * precio;
                 }
            }
        }
        Map<String, Integer> retorno = new HashMap<>();
        retorno.put("total", valorTotal);

        return ResponseEntity.ok().body(retorno);
    }
}


