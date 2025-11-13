import java.sql.*;
import java.util.Scanner;

public class cursoPlatzi1 {
    public static void main(String[] args) {
        try (Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BASES_DE_DATOS_FACULTAD?useSSL=false", "root", "root")) {
            Scanner teclado = new Scanner(System.in);
            String nombre, apellido;
            int telefono;
            String direccion;
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Conexión correctamente establecida.");

            System.out.print("Ingrese el nombre: ");
            nombre = teclado.nextLine();
            System.out.print("Ingrese el apellido: ");
            apellido = teclado.next();
            System.out.print("Ingrese el telefono: ");
            telefono = teclado.nextInt();

            teclado.nextLine(); // Consume el salto de linea

            System.out.print("Ingrese la direccion: ");
            direccion = teclado.nextLine();

            String mySQL = ("INSERT INTO CLIENTE (nombre, apellido, telefono, direccion) VALUES (?, ?, ?, ?)");
            PreparedStatement myStamt = myConn.prepareStatement(mySQL);

            // Carga de datos
            myStamt.setString(1, nombre);
            myStamt.setString(2, apellido);
            myStamt.setInt(3, telefono);
            myStamt.setString(4, direccion);

            // Ejecuto la instruccion, al ser un insert uso executeUpdate
            myStamt.executeUpdate();


            String traerDataset = "SELECT * FROM CLIENTE";

            try(PreparedStatement traerDatos = myConn.prepareStatement(traerDataset);
                ResultSet resultSet = traerDatos.executeQuery();){
                while (resultSet.next()) {
                    System.out.println(
                            "Nombre: " + resultSet.getString("nombre") +
                                    " - Apellido: " + resultSet.getString("apellido")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algo salió mal al conectar con la base de datos.");
        }
    }
}