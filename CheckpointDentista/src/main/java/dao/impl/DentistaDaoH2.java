package dao.impl;

import configuration.ConfigurationJDBC;
import dao.IDao;
import model.Dentista;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
// Script de criação de tabela esta junto aos demais em "create.sql"
public class DentistaDaoH2 implements IDao<Dentista> {

        private ConfigurationJDBC configurationJDBC;
        final static Logger log = Logger.getLogger(dao.impl.DentistaDaoH2.class);

        public DentistaDaoH2() {
            this.configurationJDBC = new ConfigurationJDBC();

        }

        @Override
        // Metodo que salva um novo dentista no banco
        public Dentista salvar(Dentista dentista) {
            log.debug("Registrando novo dentista: " + dentista.toString());
            Connection connection = configurationJDBC.conectarComBancoDeDados();
            Statement statement = null;

            String query = String.format("INSERT INTO DENTISTA (NUMERODEMATRICULA, NOME, SOBRENOME) VALUES ('%s', '%s', '%s')",dentista.getNumeroDeMatricula() ,dentista.getNome(), dentista.getSobreNome());

            try {
                statement = connection.createStatement();
                statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next())
                    dentista.setId(rs.getInt(1));
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return dentista;
        }



    @Override
        public Optional<Dentista> buscar(Integer id) {
            Dentista dentista = null;
            log.debug("Bucando dentista com id: " + id);
            Connection connection = configurationJDBC.conectarComBancoDeDados();
            Statement statement = null;

            String query = String.format("SELECT ID, NUMERODEMATRICULA, NOME, SOBRENOME FROM DENTISTA WHERE ID = '%s'", id);

            try {
                statement = connection.createStatement();
                ResultSet rs = statement.getGeneratedKeys();
                while (rs.next()){
                    dentista = criarObjetoDentista(rs);
                }
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return dentista != null ? Optional.of(dentista) : Optional.empty();
        }


        @Override
        public void excluir(Integer id) {
            log.debug("Excluindo dentista com id: " + id);
            Connection connection = configurationJDBC.conectarComBancoDeDados();
            Statement statement = null;
            String query = String.format("DELETE FROM DENTISTA WHERE ID = '%s'", id);
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
        // Este seria o "listar todos os dentistas, mas reaproveitei a interface e
        // reescrevi os metodos"
        public List<Dentista> buscarTodos() {
            log.debug("Buscando todos os dentistas");
            Connection connection = configurationJDBC.conectarComBancoDeDados();
            Statement statement = null;
            String query = "SELECT * FROM DENTISTA";
            List<Dentista> dentistas = new ArrayList<>();

            try{
                statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()){
                    dentistas.add(criarObjetoDentista(rs));
                }
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return dentistas;
        }


        private Dentista criarObjetoDentista(ResultSet rs) throws SQLException {

            Integer idDentista = rs.getInt("ID");
            String numeroDeMatricula = rs.getString("NUMERODEMATRICULA");
            String nome = rs.getString("NOME");
            String sobrenome = rs.getString("SOBRENOME");

            return new Dentista(idDentista, numeroDeMatricula, nome, sobrenome);
        }
    }


