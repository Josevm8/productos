package pruebas;

import dao.DaoProductos;
import dao.impl.DaoProductosImpl;
import dto.Productos;
import java.util.Iterator;
import java.util.List;
import parainfo.sql.ConectaDb;

public class Prueba03insert {

    public static void main(String[] args) {
        DaoProductos daoProductos = new DaoProductosImpl();

//        Productos p = new Productos();
//        p.setTitulo("aaa bbb");
//        p.setTipo("Separata");
//        p.setPrecio(10D);
//
//        String msg = daoProductos.productosIns(p);
//        if (msg == null) {
//            System.out.println("Ok");
//        } else {
//            System.out.println(msg);
//        }
        List<Productos> lista = daoProductos.productosQry2();

        Iterator<Productos> itrPartidos = lista.iterator();
        while (itrPartidos.hasNext()) {
            Productos partido = itrPartidos.next();
            System.out.println(partido.getIdproducto() + " "
                    + partido.getTitulo() + "-"
                    + partido.getPrecio());

        }

    }
}
