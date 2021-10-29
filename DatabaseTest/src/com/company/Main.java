package com.company;

import java.sql.*;
import java.util.concurrent.ExecutionException;

public class Main{

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS TESTE; CREATE TABLE TESTE"
            + "("
            + "ID INT PRIMARY KEY,"
            + "NAME VARCHAR(255) NOT NULL"
            + ")";

    private static final String sqlInsertt1 = "INSERT INTO TESTE (ID, NAME) VALUES (1, 'teste1')";
    private static final String sqlInsertt2 = "INSERT INTO TESTE (ID, NAME) VALUES (2, 'teste2')";
    private static final String sqlSelect = "SELECT * FROM TESTE";
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try{
            con = getConnnection();
            Statement statement = con.createStatement();
            statement.execute(sqlCreateTable);
            statement.execute(sqlInsertt1);
            statement.execute(sqlInsertt2);

            showDados(con, sqlSelect);

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
    }
}






//package com.company;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//            Class.forName("org.h2.Driver").newInstance();
//            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
//            Statement stmt = con.createStatement();
//
////            String sql1 = "DROP TABLE IF EXISTS TEST;\n" +
////                    "CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));";
////            stmt.execute(sql1);
//
//            String insertSql = "INSERT INTO TEST VALUES(1, 'Hello');\n" +
//                    "INSERT INTO TEST VALUES(2, 'World');\n";
//            stmt.execute(insertSql);
//
//            String sql = "SELECT * FROM TEST";
//
//            ResultSet rd = stmt.executeQuery(sql);
//            while(rd.next()) {
//                System.out.println(rd.getInt(1) + rd.getString(2));
//            }
//        }
//}
