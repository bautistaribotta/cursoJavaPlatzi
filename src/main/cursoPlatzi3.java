import java.sql.*;

public class cursoPlatzi3 {
    public static void main(String[] args){
        Connection myConn = null;
        Statement myStant = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet resultSet = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoPlatzi", "root", "root");
            System.out.println("Conexion creada");
            myConn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
