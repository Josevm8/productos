<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <link href="css/table/manten.css" type="text/css" rel="stylesheet"/>

    </head>

    <body>
        <form action="Productos" method="post">
            <input type="hidden" name="accion" value="INS"/>

            <table class="modelo" style="margin: auto; width: 280px">
                <caption>
                    Agregar Registro
                </caption>
                <tr><td style="padding: 8px;"></td>
                    <td></td>
                </tr>
                <tr>
                    <td style="padding-left: 8px;">Producto</td>
                    <td>
                        <input type="text" name="titulo" maxlength="50"
                               style="width: 150px"/>
                    </td>
                </tr>
                <tr><td style="padding: 6px;"></td>
                    <td></td>
                </tr>
                <tr>
                    <td style="padding-left: 8px;">Tipo</td>
                    <td>
                        <select name="tipo" style="width: 100px">
                            <option value="Presencial">Presencial</option>
                            <option value="Online">Online</option>
                            
                        </select>
                    </td>
                </tr>
                <tr><td style="padding: 6px;"></td>
                    <td></td>
                </tr>
                <tr>
                    <td style="padding-left: 8px;">Precio</td>
                    <td>
                        <input type="text" name="precio" maxlength="10"
                               style="width: 75px;text-align: right"/>
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
                <tr><td style="padding: 6px;"></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
