package dao.impl;

import configuration.ConfigurationJDBC;
import dao.IDao;
import model.Endereco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnderecoDaoH2 implements IDao<Endereco> {

    private ConfigurationJDBC configurationJDBC;

    public EnderecoDaoH2() {
        this.configurationJDBC = new ConfigurationJDBC();
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format("INSERT INTO ENDERECO (RUA, NUMERO, CIDADE, ESTADO) VALUES ('%s', '%s', '%s', '%s')",
                endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next())
                endereco.setId(rs.getInt(1));
            statement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return endereco;
    }

    @Override
    public Optional<Endereco> buscar(Integer id) {
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format("SELECT ID, RUA, NUMERO, CIDADE, ESTADO FROM ENDERECO WHERE ID = '%s'", id);
        Endereco endereco = null;

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                endereco = criarObjetoEndeco(rs);
            }
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return endereco != null ? Optional.of(endereco) : Optional.empty();
    }


    @Override
    public void excluir(Integer id) {
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format("DELETE FROM ENDERECO WHERE ID = %s", id);
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Endereco> buscarTodos() {
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = "SELECT * FROM ENDERECO";
        List<Endereco> enderecos = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                enderecos.add(criarObjetoEndeco(rs));
            }
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return enderecos;
    }


    private Endereco criarObjetoEndeco(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("ID");
        String rua = rs.getString("RUA");
        String numero = rs.getString("NUMERO");
        String cidade = rs.getString("CIDADE");
        String estado = rs.getString("ESTADO");
        return new Endereco(id, rua, numero, cidade, estado);
    }
}
