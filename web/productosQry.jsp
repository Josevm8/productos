<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="css/table/cebra.css" type="text/css" rel="stylesheet"/>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <script src="jq/jquery-2.0.3.min.js" type="text/javascript" ></script>
        <script src="js/productos.js" type="text/javascript"></script>
    </head>
    <body>
        <h2 style="text-align: center">Mantenimiento de Productos</h2>
        <form action="Productos" method="post">
            <input type="hidden" name="accion" value="BUSCAR"/>

            <div id="cbBuscar">
                <select name="campo">
                    <option value="titulo">Producto</option>
                    <option value="tipo">Tipo</option>
                </select> &nbsp;
                <input type="text" name="laFrase" /> &nbsp;
                <a href="index.jsp" onclick="jsRef();"> 
                    <img src="images/refresh-iconx16.png"/></a>
            </div>
            <div id="bloque"></div>
            
            <table class="cebra" style="margin: auto; width: 550px">

                <caption>
                    Lista de Productos
                </caption>

                <thead>
                    <tr>
                        <td>Producto</td>
                        <td>Tipo</td>
                        <td>Precio</td>
                        <th style="width: 30px">
                            <a href="#" onclick="jsIns();">
                                <img src="css/table/images/ins.png" title="Nuevo"/></a>
                        </th>
                        <th style="width: 30px">
                            <a href="#" onclick="jsDel();">
                                <img src="css/table/images/del.png" title="Retirar"/></a>
                        </th>
                        <th style="width: 30px">
                            <a href="#" onclick="jsUpd();">
                                <img src="css/table/images/upd.png" title="Actualizar"/></a>
                        </th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th colspan="6">josewvm@gmail.com &copy;</th>
                    </tr>
                </tfoot>
                <tbody>
                    <c:forEach items="${list}" var="p" >
                        <tr>
                            <td>${p[1]}</td>
                            <td>${p[2]}</td>
                            <td>${p[3]}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </body>
</html>
