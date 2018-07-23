package dao.impl;

import dao.DaoProductos;
import dto.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import parainfo.sql.ConectaDb;

public class DaoProductosImpl implements DaoProductos {

    private ConectaDb sql;

    public DaoProductosImpl() {
        this.sql = new ConectaDb();
    }

    @Override
    public List<Object[]> productosQry() {
        // List<Productos> list = null;
        List<Object[]> list = null;
        String s = "SELECT idproducto, titulo, tipo, precio FROM productos";

        Connection cn = sql.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(s);
                ResultSet rs = ps.executeQuery();
                // list = new ArrayList<Productos>();
                list = new LinkedList<>();

                while (rs.next()) {
//                    Productos p = new Productos();
//
//                    p.setIdproducto(rs.getInt(1));
//                    p.setTitulo(rs.getString(2));
//                    p.setTipo(rs.getString(3));
//                    p.setPrecio(rs.getDouble(4));

//                    list.add(p);
                    Object[] fil = new Object[4];

                    fil[0] = rs.getInt(1);
                    fil[1] = rs.getString(2);
                    fil[2] = rs.getString(3);
                    fil[3] = rs.getDouble(4);

                    list.add(fil);
                }
            } catch (SQLException e) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return list;
    }

    @Override
    public String productosIns(Productos productos) {
        String error = null;
        String s = "INSERT productos("
                + "titulo,"
                + "tipo,"
                + "precio"
                + ") VALUES(?,?,?)";

        Connection cn = sql.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(s);
                ps.setString(1, productos.getTitulo());
                ps.setString(2, productos.getTipo());
                ps.setDouble(3, productos.getPrecio());

                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    error = "0 filas afectadas";
                }

            } catch (SQLException e) {
                error = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    error = e.getMessage();
                }
            }
        }

        return error;
    }

    @Override
    public String productosDel(List<Integer> ids) {
        String error = null;
        String s = "DELETE FROM productos WHERE idproducto=?";

        Connection cn = sql.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(s);
                for (Integer x : ids) {
                    ps.setInt(1, x);
                    int ctos = ps.executeUpdate();
                    if (ctos == 0) {
                        throw new SQLException("ID desconocido");
                    }
                }
            } catch (SQLException e) {
                error = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    error = e.getMessage();
                }
            }
        }

        return error;
    }

    @Override
    public Productos productosGet(Integer idproducto) {
        Productos productos = null;
        String s = "SELECT "
                + "idproducto,"
                + "titulo,"
                + "tipo,"
                + "precio "
                + "FROM productos "
                + "WHERE idproducto=?";

        Connection cn = sql.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(s);
                ps.setInt(1, idproducto);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    productos = new Productos();

                    productos.setIdproducto(rs.getInt(1));
                    productos.setTitulo(rs.getString(2));
                    productos.setTipo(rs.getString(3));
                    productos.setPrecio(rs.getDouble(4));
                }
            } catch (SQLException e) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return productos;
    }

    @Override
    public String productosUpd(Productos productos) {
        String error = null;
        String s = "UPDATE productos SET "
                + "titulo=?,"
                + "tipo=?,"
                + "precio=? "
                + "WHERE idproducto=?";

        Connection cn = sql.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(s);
                ps.setString(1, productos.getTitulo());
                ps.setString(2, productos.getTipo());
                ps.setDouble(3, productos.getPrecio());
                ps.setInt(4, productos.getIdproducto());

                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    error = "0 filas afectadas";
                }

            } catch (SQLException e) {
                error = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    error = e.getMessage();
                }
            }
        }

        return error;
    }

    @Override
    public List<Productos> buscar(String laFrase, String campo) {
        List<Productos> list = null;

        String sql1 = "SELECT idproducto, titulo, tipo, precio "
                + "FROM productos WHERE titulo LIKE ?";

        String sql02 = "SELECT idproducto, titulo, tipo, precio "
                + "FROM productos WHERE tipo LIKE ?";

        Connection cn = sql.getConnection();

        if (cn != null && campo.equals("titulo")) {
            try {

                PreparedStatement ps = cn.prepareStatement(sql1);
                ps.setString(1, laFrase);
                // ps.setString(1, laFrase.concat("%"));
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    Productos p = new Productos();

                    p.setIdproducto(rs.getInt(1));
                    p.setTitulo(rs.getString(2));
                    p.setTipo(rs.getString(3));
                    p.setPrecio(rs.getDouble(4));

                    list.add(p);
                }
            } catch (SQLException e) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        } else if (cn != null && campo.equals("tipo")) {
            try {

                PreparedStatement ps = cn.prepareStatement(sql02);
                ps.setString(1, laFrase);
                // ps.setString(1, laFrase.concat("%"));
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<Productos>();
                while (rs.next()) {
                    Productos p = new Productos();

                    p.setIdproducto(rs.getInt(1));
                    p.setTitulo(rs.getString(2));
                    p.setTipo(rs.getString(3));
                    p.setPrecio(rs.getDouble(4));

                    list.add(p);
                }
            } catch (SQLException e) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return list;

    }

    @Override
    public List<Productos> productosQry2() {
        List<Productos> list = null;

        String sql2 = "SELECT idproducto, titulo, tipo, precio "
                + "FROM productos";

        Connection cn = sql.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql2);
                ResultSet rs = ps.executeQuery();
                list = new ArrayList<>();

                while (rs.next()) {
                    Productos p = new Productos();

                    p.setIdproducto(rs.getInt(1));
                    p.setTitulo(rs.getString(2));
                    p.setTipo(rs.getString(3));
                    p.setPrecio(rs.getDouble(4));

                    list.add(p);

                }
            } catch (SQLException e) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return list;
    }

}
