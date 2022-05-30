import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App {
    public static void main(String[] args) {
        String queryResultGenero;
        double queryResultIdade;
        double queryResultPeso;
        double queryResultAltura;

        try{
            DatabaseConnection dbConnection = new DatabaseConnection(); // criação do objeto db conection
            Connection db = dbConnection.GetConnection(); // realização da conexão com o banco de dados

            String inputGenero = "F";
            double inputIdade = 0.08;
            double inputAltura = 72.4;
            double inputPeso = 10.9;

            String queryGenero = "SELECT * FROM dados_calculadora WHERE genero = '"+inputGenero+"' AND idade = "+inputIdade;

            Statement statement = db.createStatement(); // criação e um estado

            ResultSet queryResult = statement.executeQuery(queryGenero);

            while(queryResult.next()){
                queryResultGenero = queryResult.getString("genero");
                queryResultIdade = queryResult.getDouble("idade");
                queryResultPeso = queryResult.getDouble("peso");
                queryResultAltura = queryResult.getDouble("altura");
                System.out.printf("%s, %.2f, %.2f, %.2f \n", queryResultGenero, queryResultIdade,
                    queryResultPeso, queryResultAltura);

                double calcIMC = (inputPeso/((inputAltura*inputAltura)/100)*100);

                if(inputIdade < 1){
                    if(calcIMC <= 12.6){
                        System.out.printf("O percentil 3 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    } 
                    else if(calcIMC <= 14.8){
                        System.out.printf("percentil 15 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 17.4){
                        System.out.printf("percentil 50 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 19.4){
                        System.out.printf("percentil 85 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 21.8){
                        System.out.printf("percentil 97 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                }
                                
                else if(inputIdade < 2){
                    if(calcIMC <= 14.2){
                        System.out.printf("O percentil 3 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 15.6){
                        System.out.printf("percentil 15 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 17.1){
                        System.out.printf("percentil 50 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 18.9){
                        System.out.printf("percentil 85 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 20.4){
                        System.out.printf("percentil 97 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                }
                                
                else if(inputIdade < 3){
                    if(calcIMC <= 14.5){
                        System.out.printf("O percentil 3 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 15.5){
                        System.out.printf("percentil 15 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 16.7){
                        System.out.printf("percentil 50 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 18.2){
                        System.out.printf("percentil 85 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 19.9){
                        System.out.printf("percentil 97 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                }
                                
                else if(inputIdade < 4){
                    if(calcIMC <= 13.6){
                        System.out.printf("O percentil 3 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 15.0){
                        System.out.printf("percentil 15 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 16.2){
                        System.out.printf("percentil 50 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 17.6){
                        System.out.printf("percentil 85 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 19.2){
                        System.out.printf("percentil 97 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                }

                else if(inputIdade < 5){
                    if(calcIMC <= 13.5){
                        System.out.printf("O percentil 3 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 14.6){
                        System.out.printf("percentil 15 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 15.8){
                        System.out.printf("percentil 50 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 17.2){
                        System.out.printf("percentil 85 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                    else if(calcIMC <= 18.7){
                        System.out.printf("percentil 97 \n");
                        System.out.printf("O IMC é %.2f \n", calcIMC);
                    }
                }
            }

        } catch (SQLException e){
            System.out.println(e);
        }

    }
}
