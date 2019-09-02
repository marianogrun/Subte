package subte;

import java.awt.event.*;
import java.sql.*;

public class Modelo {

    private String driver;
    private String prefijoConexion;
    private String ip;
    private String usr;
    private String psw;
    private String bd;
    private String tabla;
    private String resultadoEstacionConsulta;
    private String resultadoComentarioConsulta;
    private Connection connection;
    private ActionListener listener;

    public Modelo() {
        driver = "com.mysql.jdbc.Driver";
        prefijoConexion = "jdbc:mysql://";
        ip = "127.0.0.1";             // Direccion IP donde esta corriendo el SGBD
        usr = "";                     // Usuario
        psw = "";                     // Password
        bd = "subte_b";               // Base de datos
        tabla = "estaciones";         // Tabla de las estaciones
        resultadoEstacionConsulta = "";
        resultadoComentarioConsulta = "";
    }

    public String getResultadoEstacionConsulta() {
        return resultadoEstacionConsulta;
    }

    public String getResultadoComentarioConsulta() {
        return resultadoComentarioConsulta;
    }

    public void consultar(String nombre, String sentido) {
        if (!nombre.isEmpty()) {
            connection = obtenerConexion();
            String q = "SELECT " + sentido
                    + " FROM " + tabla
                    + " WHERE Actual='" + nombre + "'";
            try {
                resultadoEstacionConsulta = nombre;

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(q);
                while (resultSet.next()) {
                    resultadoEstacionConsulta = resultSet.getString(1);
                }
                resultSet.close();
                statement.close();

                String q2 = "SELECT comentario FROM " + tabla
                        + " WHERE Actual='" + resultadoEstacionConsulta + "'";
                resultadoComentarioConsulta = "";

                statement = connection.createStatement();
                resultSet = statement.executeQuery(q2);
                while (resultSet.next()) {
                    resultadoComentarioConsulta = resultSet.getString(1);
                }
                resultSet.close();
                statement.close();

            } catch (SQLException ex) {
                reportException(ex.getMessage());
            }
        }
    }

    public void addExceptionListener(ActionListener listener) {
        this.listener = listener;
    }

    private void reportException(String exception) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, exception);
            listener.actionPerformed(evt);
        }
    }

    private Connection obtenerConexion() {
        if (connection == null) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                reportException(ex.getMessage());
            }
            try {
                connection = DriverManager.getConnection(prefijoConexion + ip + "/" + bd, usr, psw);
            } catch (SQLException ex) {
                reportException(ex.getMessage());
            }
            Runtime.getRuntime().addShutdownHook(new ShutDownHook());
        }
        return connection;
    }

    private class ShutDownHook extends Thread {

        @Override
        public void run() {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                reportException(ex.getMessage());
            }
        }
    }
}
