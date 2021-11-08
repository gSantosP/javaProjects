package dao.impl;

import configuration.ConfigurationJDBC;
import dao.IDao;
import model.Endereco;
import model.Paciente;
import org.apache.log4j.Logger;
import util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PacienteDaoH2 implements IDao <Paciente> {

    private ConfigurationJDBC configurationJDBC;
    private EnderecoDaoH2 enderecoDaoH2;
    final static Logger log = Logger.getLogger(PacienteDaoH2.class);

    public PacienteDaoH2(EnderecoDaoH2 enderecoDaoH2) {
        this.configurationJDBC = new ConfigurationJDBC();
        this.enderecoDaoH2 = enderecoDaoH2;
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        log.debug("Registrando novo paciente: " + paciente.toString());
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement statement = null;
        paciente.setEndereco(enderecoDaoH2.salvar(paciente.getEndereco()));
        String query = String.format("INSERT INTO PACIENTE (NOME, SOBRENOME, RG, DATA_CADASTRO, ENDERECO_ID ) VALUES ('%s', '%s', '%s', '%s', '%s')",paciente.getNome(), paciente.getSobrenome(), paciente.getRg(),
                Util.dateToTimestamp(paciente.getDataCadastro()), paciente.getEndereco().getId());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next())
                paciente.setId(rs.getInt(1));
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Optional<Paciente> buscar(Integer id) {
        Paciente paciente = null;
        log.debug("Bucando paciente com id: " + id);
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement statement = null;

        String query = String.format("SELECT ID, NOME, SOBRENOME, RG, DATA_CADASTRO, ENDERECO_ID FROM PACIENTE WHERE ID = '%s'", id);

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()){
                paciente = criarObjetoPaciente(rs);
            }
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return paciente != null ? Optional.of(paciente) : Optional.empty();
    }


    @Override
    public void excluir(Integer id) {
        log.debug("Excluindo paciente com id: " + id);
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format("DELETE FROM PACIENTE WHERE ID = '%s'", id);
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
    public List<Paciente> buscarTodos() {
        log.debug("Bucando todos os pacientes");
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = "SELECT * FROM PACIENTE";
        List<Paciente> pacientes = new ArrayList<>();

        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                pacientes.add(criarObjetoPaciente(rs));
            }
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pacientes;
    }


    private Paciente criarObjetoPaciente(ResultSet rs) throws SQLException {

        Integer idPaciente = rs.getInt("ID");
        String nome = rs.getString("NOME");
        String sobrenome = rs.getString("SOBRENOME");
        String rg = rs.getString("RG");
        Date dataCadastro = rs.getDate("DATA_CADASTRO");
        Endereco endereco = enderecoDaoH2.buscar(rs.getInt("ENDERECO_ID")).orElse(null);

        return new Paciente(idPaciente, nome, sobrenome, rg, dataCadastro,endereco);
    }
}
