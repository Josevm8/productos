package web.servlet;

import dao.DaoPeru;
import dao.impl.DaoPeruImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletPeru", urlPatterns = {"/Peru"})
public class ServletPeru extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        StringBuilder sb = new StringBuilder();
        //
        DaoPeru daoPeru = new DaoPeruImpl();
        final int FILS_PERU = 10;
        final int FILS_DEPA = 4;

        if (accion.equals("PERU_CBO")) {
            Integer ctas = daoPeru.peruCtasFils();//1830 distritos
            if (ctas != null) {
                int ctasPag = (ctas % FILS_PERU) == 0 ? (ctas / FILS_PERU) : (ctas / FILS_PERU + 1);

                sb.append("<select id =\"numpag_peru\" onchange=\"cbperu();\">");
                for (int i = 0; i < ctasPag; i++) {
                    sb.append("<option value=\"").append(i).append("\">");
                    sb.append(1 + i);
                    sb.append("</option>");
                }
                sb.append("</select>");
            }

        } else if (accion.equals("PERU_QRY")) {
            String numpag = request.getParameter("numpag");
            List<Object[]> list = daoPeru.peruQry(Integer.valueOf(numpag), FILS_PERU);

            if (list != null) {
                for (Object[] f : list) {
                    sb.append("<tr>");
                    sb.append("<td>").append(f[0]).append("</td>");
                    sb.append("<td>").append(f[1]).append("</td>");
                    sb.append("<td>").append(f[2]).append("</td>");
                    sb.append("</tr>");
                }
            }


        } else if (accion.equals("DEPA_CBO")) {
            Integer ctas = daoPeru.depaCtasFils(); //10
            if (ctas != null) {
                int ctasPag = (ctas % FILS_DEPA) == 0 ? (ctas / FILS_DEPA) : (ctas / FILS_DEPA + 1);

                sb.append("<select id =\"numpag_depa\" onchange=\"cbdepa();\">");
                for (int i = 0; i < ctasPag; i++) {
                    sb.append("<option value=\"").append(i).append("\">");
                    sb.append(1 + i);
                    sb.append("</option>");
                }
                sb.append("</select>");
            }

        } else if (accion.equals("DEPA_QRY")) {
            String numpag = request.getParameter("numpag");
            List<Object[]> list = daoPeru.depaQry(Integer.valueOf(numpag), FILS_DEPA);

            if (list != null) {
                for (Object[] f : list) {
                    sb.append("<tr>");
                    sb.append("<td>").append(f[0]).append("</td>");
                    sb.append("<td>").append(f[1]).append("</td>");
                    sb.append("</tr>");
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print(sb);
        out.close();
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
