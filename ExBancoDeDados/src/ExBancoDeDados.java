import org.apache.log4j.Logger;

import java.sql.*;
import java.util.concurrent.ExecutionException;

public class ExBancoDeDados {

    private static final Logger logger = Logger.getLogger(ExBancoDeDados.class);

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS TESTE; CREATE TABLE TESTE"
                    + "("
                    + "ID INT PRIMARY KEY, "
                    + "NOME VARCHAR(255) NOT NULL, "
                    + "IDADE INT, "
                    + "SEXO CHAR, "
                    + "EMAIL VARCHAR(255)"
                    + ")";

            private static final String sqlInsertt1 = "INSERT INTO TESTE (ID, NOME, IDADE, SEXO, EMAIL) VALUES (1, 'maria', 20, 'F', 'maria@email.com')";
            private static final String sqlInsertt2 = "INSERT INTO TESTE (ID, NOME, IDADE, SEXO, EMAIL) VALUES (1, 'joao', 30, 'M', 'joao@email.com')";
            private static final String sqlInsertt3 = "INSERT INTO TESTE (ID, NOME, IDADE, SEXO, EMAIL) VALUES (3, 'jose', 40, 'M', 'jose@email.com')";

            private static final String sqlUpdate = "UPDATE TESTE" +
                    "SET IDADE = 18," +
                    "WHERE IDADE = 20;";

            private static final String sqlDelete = "DELETE FROM TESTE WHERE ID = 3;";

            public static void main(String[] args) throws SQLException {
                Connection con = null;
                try{
                    con = getConnnection();
                    Statement statement = con.createStatement();
                    statement.execute(sqlCreateTable);
                    statement.execute(sqlInsertt1);
                    statement.execute(sqlInsertt2);
                    statement.execute(sqlInsertt3);

                    try{
                        statement.execute(sqlInsertt2);
                        logger.info("id repetido");



                    }catch(Exception ex){
                        ex.printStackTrace();

                    }
                    statement.execute(sqlDelete);
                    statement.execute(sqlUpdate);


                    // showDados(con, sqlSelect);

                }
                catch(Exception e){
                    e.printStackTrace();

                }finally {
                    if(con == null)
                        return;
                    con.close();
                }





            }    public static Connection getConnnection() throws Exception{
                Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();

                return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

            }
            private static void showDados(Connection connection, String sqlQuery) throws Exception{
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sqlQuery);
                while(rs.next()){
                    System.out.println(rs.getInt(1) + " - " + rs.getString(2));
                }
            }}



