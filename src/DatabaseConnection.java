import java.sql.Connection; //importando a conexão com o banco
import java.sql.DriverManager; //importando a ponte entre o bancoe o código

public class DatabaseConnection {
    Connection con = null; // variavel de conexão
    public Connection GetConnection(){
        //função responsável pela conexão
        try{
            if(con == null){
                con = DriverManager.getConnection("jdbc:mysql://localhost/pediamed","root","");
                //se não existir conexão, ele se conecta utilizando url, login e senha
            } else if (con.isClosed()) {
                con = null;
                return GetConnection();
                // caso a conexão esteja fechada ele tenta se reconectar
            }
        }
        catch(Exception e){
            System.out.println(e);
            // caso ocorra algum erro, ele imprime o erro
        }
        return con;
        // retorna a conexão
    }
}
