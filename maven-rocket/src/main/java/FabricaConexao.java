import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FabricaConexao {

    private static Connection conexao;

    public static Connection getConexao() {
        return conexao;
    }

    public static void abrirConexao() {
        try {
            if (conexao == null) {
                String url = "jdbc:postgresql://localhost:5432/rocket_db";
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password", "123456");
                // props.setProperty("ssl", "true");
                conexao = DriverManager.getConnection(url, props);
                System.out.println("Conexão realizada com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
