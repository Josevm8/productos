package pruebas;

import dao.DaoProductos;
import dao.impl.DaoProductosImpl;
import java.util.LinkedList;
import java.util.List;

public class Prueba04delete {

    public static void main(String[] args) {
        DaoProductos daoProductos = new DaoProductosImpl();

        List<Integer> list = new LinkedList<Integer>();
        list.add(6);

        String msg = daoProductos.productosDel(list);
        if (msg == null) {
            System.out.println("Ok");
        } else {
            System.out.println(msg);
        }
    }
}
