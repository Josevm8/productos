package dao;

import dto.Productos;
import java.util.List;
import java.util.Map;

public interface DaoProductos {

    public List<Object[]> productosQry();
    
    public List<Productos> productosQry2();

    public String productosIns(Productos productos);

    public String productosDel(List<Integer> ids);

    public Productos productosGet(Integer idproducto);

    public String productosUpd(Productos productos);
    
    public List<Productos> buscar(String laFrase, String campo);
}
