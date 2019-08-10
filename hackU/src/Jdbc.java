import java.sql.*; 

public class Jdbc {
    public static void main(String... args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:../develop.sqlite3");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            execute_sql(statement);
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        } 
    }

    private static void execute_sql(Statement statement) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS users");
        statement.executeUpdate("CREATE TABLE users (id INTEGER, name STRING)");
        statement.executeUpdate("INSERT INTO users (id ,name) VALUES (1, 'matsukawa')");
    }  
} 