package dao.impl;

import dao.DaoPeru;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import parainfo.sql.ConectaDb;


public class DaoPeruImpl implements DaoPeru {

//    private ConectaDb db;
//
//    public DaoPeruImpl() {
//        this.db = new ConectaDb();
//    }
    
    ConectaDb db;

    @Override
    public List<Object[]> peruQry(int numpag, int filsXpag) {
        List<Object[]> list = null;
        String sql = "SELECT departamento, provincia, distrito "
                + "FROM departamentos "
                + "INNER JOIN provincias "
                + "ON departamentos.idDepartamento = provincias.idDepartamento "
                + "INNER JOIN distritos "
                + "ON provincias.idProvincia = distritos.idProvincia "
                + "LIMIT " + (numpag * filsXpag) + "," + filsXpag + "";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                list = new LinkedList<Object[]>();
                while (rs.next()) {
                    Object[] fil = new Object[3];

                    fil[0] = rs.getString(1);
                    fil[1] = rs.getString(2);
                    fil[2] = rs.getString(3);

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
    public List<Object[]> depaQry(int numpag, int filsXpag) {
        List<Object[]> list = null;
        String sql = "SELECT iddepartamento, departamento FROM departamentos "
                + "LIMIT " + (numpag * filsXpag) + "," + filsXpag + "";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                list = new LinkedList<Object[]>();
                while (rs.next()) {
                    Object[] fil = new Object[2];

                    fil[0] = rs.getInt(1);
                    fil[1] = rs.getString(2);

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
    public Integer peruCtasFils() {
        Integer ctas = null;

        String sql = "SELECT COUNT(1) "
                + "FROM departamentos "
                + "INNER JOIN provincias "
                + "ON departamentos.idDepartamento = provincias.idDepartamento "
                + "INNER JOIN distritos "
                + "ON provincias.idProvincia = distritos.idProvincia ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if(rs.next()) {
                    ctas = rs.getInt(1);
                }

            } catch (SQLException e) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return ctas;
    }

    @Override
    public Integer depaCtasFils() {
        Integer ctas = null;

        String sql = "SELECT COUNT(1) FROM productos ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if(rs.next()) {
                    ctas = rs.getInt(1);
                }

            } catch (SQLException e) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return ctas;
    }
}
