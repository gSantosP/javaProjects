package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationJDBC {

    private String jdbcDriver;
    private String dbUrl;
    private  String nomeUsuario;
    private String senhaUsuario;

    public ConfigurationJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/clinica;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'CREATE.SQL'";
        this.nomeUsuario = "sa";
        this.senhaUsuario = "sa";
    }

    public Connection conectarComBancoDeDados() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senhaUsuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
