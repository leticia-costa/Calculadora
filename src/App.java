import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        String queryResultGenero;
        double queryResultIdade;
        double queryResultPeso;
        double queryResultAltura;

        try{
            DatabaseConnection dbConnection = new DatabaseConnection(); // criação do objeto db conection
            Connection db = dbConnection.GetConnection(); // realização da conexão com o banco de dados

            String inputGenero = "M";
            double inputIdade = 0.02;
            double inputAltura = 57.1;
            double inputPeso = 0.8;

            String queryGenero = "SELECT * FROM dados_calculadora WHERE genero = '"+inputGenero+"' AND idade = "+inputIdade;

            Statement statement = db.createStatement(); // criação de um estado

            ResultSet queryResult = statement.executeQuery(queryGenero);

            while(queryResult.next()){
                queryResultGenero = queryResult.getString("genero");
                queryResultIdade = queryResult.getDouble("idade");
                queryResultPeso = queryResult.getDouble("peso");
                queryResultAltura = queryResult.getDouble("altura");
                System.out.printf("%s, %.2f, %.2f, %.2f \n", queryResultGenero, queryResultIdade,
                    queryResultPeso, queryResultAltura);

                double calcIMC = (inputPeso/((inputAltura*inputAltura)/100)*100);

                Map<String, Boolean> CrescimentoInfantil = ChildGrowthDictionary
                    .getDictionary(calcIMC, queryResultIdade, queryResultGenero);
                
                for (String key : CrescimentoInfantil.keySet()) {
                    if (CrescimentoInfantil.get(key)){
                        System.out.println(key);
                        System.out.printf("Seu IMC é: %.2f\n", calcIMC);
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
