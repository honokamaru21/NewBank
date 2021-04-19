package utilities;

import org.junit.Assert;
import java.sql.*;
import java.util.*;

public class DataBase {
    private static Connection connection;
    private static Statement statement;
    private static final String JDBC_URL = "jdbc:mysql://3.131.35.165:3306/digitalbank?user=dbank&password=MyCOMPleaxPasSW0rd!12X";
    public void open() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(JDBC_URL);
                statement = connection.createStatement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Can`t establish connection to DB");
        }
    }
    public void close() {
        try {
            if (connection != null) connection.close();
            if (statement!=null) statement.close();
            connection = null;
            statement = null;
        } catch (SQLException e){
            e.printStackTrace();
            Assert.fail("Can`t close connection to DB");
        }
    }
    public List<String> getColumnNames(ResultSet rs){
        List<String> columnNames = new ArrayList<>();
        try{
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i<columnCount; i++){
                columnNames.add(metaData.getColumnName(i));
            }
        }catch (SQLException e){
            e.printStackTrace();
            Assert.fail(e.getLocalizedMessage());
        }
        return columnNames;
    }

    public ResultSet query(String query){
        if (connection == null) open();
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Not able to execute query");
        }
        return null;
    }
    public List<Map<String, Object>> convertResultSet(ResultSet rs){
        List<Map<String, Object>> table = new ArrayList<>();
        List<String> columnNames = getColumnNames(rs);
        // Populate table From result set
        // Iterate through each Row
        Map<String, Object> row = new HashMap<>();
        while (true) {
            try{
                if (!rs.next()) break;
                for (String columnName : columnNames) {
                    row.put(columnName, rs.getObject(columnName));
                }
                table.add(row);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        try {
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return table;
    }
//    public void main(String[] args) {
//        open();
//        ResultSet rs = query("SELECT *\n" +
//                "FROM digitalbank.account\n" +
//                "WHERE account_number = 486130062;");
//        List<Map<String, Object>> table = convertResultSet(rs);
//        table.forEach(System.out::println);
//    }
}
