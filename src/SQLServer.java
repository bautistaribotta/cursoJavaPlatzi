import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLServer {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost"
                + ";databaseName=BASE_DE_DATOS_FACULTAD"
                + ";user=bautistaribotta"
                + ";password=Bauti013!"
                + ";encrypt=true"
                + ";trustServerCertificate=true";

        Connection myConn = null;
        Statement myStat = null;
        ResultSet myRes = null;
    }
}