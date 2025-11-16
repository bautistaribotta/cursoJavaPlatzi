import java.sql.*;
import java.util.*;

public class cursoPlatzi3 {
    public static void main(String[] args) throws SQLException {
        Scanner teclado = new Scanner(System.in);

        final String url = "jdbc:mysql://localhost:3306/cursoPlatzi";
        final String user = "root";
        final String password = "root";

        // No uso un try-finally, uso un try-with resources
        try (Connection myConn = DriverManager.getConnection(url, user, password); Statement myStant = myConn.createStatement()){

//          CREATE - INSERT
            System.out.println("-Empleado agregado con exito-");
            String sqlConsulta = ("INSERT INTO employees (first_name, pa_surname, ma_surname, email, salary) VALUES (?, ?, ?, ?, ?)");
            PreparedStatement myPreparedStant = myConn.prepareStatement(sqlConsulta);
            myPreparedStant.setString(1, "Bautista");
            myPreparedStant.setString(2, "Ribotta");
            myPreparedStant.setString(3, "Merlo");
            myPreparedStant.setString(4, "bautistaribotta@hotmail.com");
            myPreparedStant.setFloat(5, 3000);
            myPreparedStant.executeUpdate();


//          READ - SELECT
            System.out.println("-=LISTADO DE EMPLEADOS=-");
            ResultSet resultSet = myStant.executeQuery("SELECT * FROM employees");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id")
                        + " " +  resultSet.getString("first_name")
                        + " " + resultSet.getString("pa_surname")
                        + " " +  resultSet.getString("ma_surname")
                        + " " +  resultSet.getString("email")
                        + " " +  resultSet.getFloat("salary"));
            }

//          UPDATE
            System.out.print("Ingrese el email nuevo de Bautista: ");
            String nuevo_email = teclado.nextLine();
            myPreparedStant = myConn.prepareStatement("UPDATE employees SET email = ? WHERE id = 6 ");
            myPreparedStant.setString(1, nuevo_email);
            myPreparedStant.executeUpdate();

            // DELETE
            String sqlBorrar = ("DELETE FROM employees WHERE first_name = 'Bautista'");
            myStant.executeUpdate(sqlBorrar);
            System.out.println("-Empleado borrado con exito-");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Fallo la conexion");
        }
    }
}