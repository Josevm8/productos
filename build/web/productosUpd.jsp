<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <link href="css/table/manten.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <form action="Productos" method="post">
            <input type="hidden" name="accion" value="UPD"/>
            <input type="hidden" name="idproducto" 
                   value="${producto.idproducto}"/>

            <table class="modelo" style="margin: auto; width: 300px">
                <caption>
                    Actualizar Registroxxx
                </caption>
                <tr><td style="padding: 8px;"></td></tr>
                <tr>
                    <td style="padding-left: 8px;">Producto</td>
                    <td>
                        <input type="text" name="titulo" maxlength="50"
                               style="width: 190px" value="${producto.titulo}"/>
                    </td>
                </tr>
                <tr><td style="padding: 6px;"></td></tr>
                <tr>
                    <td style="padding-left: 8px;">Tipo</td>
                    <td>
                        <select name="tipo" style="width: 100px">
                            <c:choose>
                                <c:when test="${producto.tipo eq 'Online'}">
                                    <option value="Presencial">Presencial</option>
                                    <option value="Online">Online</option>
                                    <option value="Online" selected="selected">Online</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="Presencial" selected="selected">Presencial</option>
                                    <option value="Online">Online</option>
                                 
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </td>
                </tr>
                <tr><td style="padding: 6px;"></td></tr>
                <tr>
                    <td style="padding-left: 8px;">Precio</td>
                    <td>
                        <input type="text" name="precio" maxlength="10"
                               style="width: 75px;text-align: right"
                               value="${producto.precio}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        <input type="submit" value="Enviar"/>
                    </td>
                </tr>
                <tr><td style="padding: 6px;"></td></tr>
            </table>
        </form>
    </body>
</html>
