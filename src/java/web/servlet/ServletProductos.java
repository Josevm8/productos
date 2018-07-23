package web.servlet;

import dao.DaoProductos;
import dao.impl.DaoProductosImpl;
import dto.Productos;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletProductos", urlPatterns = {"/Productos"})
public class ServletProductos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        String target = "index.jsp";
        String error = null;
        //
        DaoProductos daoProductos = new DaoProductosImpl();

        if (accion == null) {
            error = "solicitud no recibida";

        } else if (accion.equals("BUSCAR")) {

            String campo = request.getParameter("campo");
            String frase = request.getParameter("laFrase");
            String listo = "%" + frase + "%";

            List<Productos> list = daoProductos.buscar(listo,campo);

            if (list != null) {
                request.setAttribute("list", list);
                target = "productosQry.jsp";
            } else {
                error = "no hay acceso a Productos";
            }

        } else if (accion.equals("QRY")) {
          //  List<Productos> list = daoProductos.productosQry();
            List<Object[]> list = daoProductos.productosQry();

            if (list != null) {
                request.setAttribute("list", list);
                target = "productosQry.jsp";
            } else {
                error = "no hay acceso a Productos";
            }

        } else if (accion.equals("INS")) {
            Productos p = new Productos();
            error = valida(request, p);

            if (error == null) {
                error = daoProductos.productosIns(p);
            }

        } else if (accion.equals("DEL")) {
            String ids = request.getParameter("ids");
            String[] id = ids.split(",");

            List<Integer> list = new LinkedList<Integer>();
            for (String x : id) {
                list.add(Integer.valueOf(x));
            }

            error = daoProductos.productosDel(list);

        } else if (accion.equals("GET")) {
            String id = request.getParameter("id");

            Productos p = daoProductos.productosGet(Integer.valueOf(id));
            if (p != null) {
                request.setAttribute("producto", p);
                target = "productosUpd.jsp";
            } else {
                error = "sin acceso a Producto de ID: " + id;
            }

        } else if (accion.equals("UPD")) {
            Productos p = new Productos();
            error = valida(request, p);

            if (error == null) {
                error = daoProductos.productosUpd(p);
            }

        } else {
            error = "solicitud no reconocida";
        }

        //
        if (error != null) {
            request.setAttribute("msg", error);
            target = "mensaje.jsp";
        }

       // RequestDispatcher dispatcher = request.getRequestDispatcher(target);
       // dispatcher.forward(request, response);
        request.getRequestDispatcher(target).forward(request, response);
    }

    // apoyo
    private String valida(HttpServletRequest request, Productos productos) {
        String error = null;
        String idproducto = request.getParameter("idproducto");
        String titulo = request.getParameter("titulo");
        String tipo = request.getParameter("tipo");
        String precio = request.getParameter("precio");

        Integer idproductox = null;
        if (idproducto != null) {
            try {
                idproductox = Integer.valueOf(idproducto);
            } catch (NumberFormatException e) {
                error = "ID de producto incorrecto";
            }
        }

        if (error == null) {
            if ((titulo == null) || (titulo.trim().length() == 0)) {
                error = "ingrese Titulo de Producto";
            }
        }

        if (error == null) {
            if ((tipo == null) || (tipo.trim().length() == 0)) {
                error = "ingrese Tipo de Producto";
            }
        }

        Double preciox = null;
        if (error == null) {
            try {
                preciox = Double.valueOf(precio);
            } catch (NumberFormatException e) {
                error = "precio de Producto errado";
            }
        }

        if (error == null) {
            productos.setIdproducto(idproductox);
            productos.setTitulo(titulo);
            productos.setTipo(tipo);
            productos.setPrecio(preciox);
        }

        return error;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
