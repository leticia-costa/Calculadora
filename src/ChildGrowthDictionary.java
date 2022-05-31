import java.util.HashMap;
import java.util.Map;

public class ChildGrowthDictionary {
    static Map<String, Boolean> dictionaryToBeReturned = new HashMap<String, Boolean>();


    private static void populateDictionary(Map<String, Boolean> dictionary, double percentil3, 
        double percentil15, double percentil50, double percentil85, double percentil97, double IMC){

            dictionary.put("percentil 3", IMC <= percentil3);
            dictionary.put("percentil 15", IMC <= percentil15);
            dictionary.put("percentil 50", IMC <= percentil50);
            dictionary.put("percentil 85", IMC <= percentil85);
            dictionary.put("percentil 97", IMC <= percentil97);
    }

    public static Map<String, Boolean> getDictionary(double IMC, double idade){
        if(idade > 0 && idade < 1){
            populateDictionary(dictionaryToBeReturned, 12.6, 14.8, 
                17.4, 19.4, 21.8, IMC);
        }
        else if(idade < 2){
            populateDictionary(dictionaryToBeReturned, 14.2, 15.6, 
                17.1, 18.9, 20.4, IMC);
        }
        else if(idade < 3){
            populateDictionary(dictionaryToBeReturned, 14.5, 15.5, 
                16.7, 18.2, 19.9, IMC);
        }
        else if(idade < 4){
            populateDictionary(dictionaryToBeReturned, 13.6, 15.0, 
                16.2, 17.6, 19.2, IMC);
        }
        else if(idade < 5){
            populateDictionary(dictionaryToBeReturned, 13.5, 14.6, 
                15.8, 17.2, 18.7, IMC);
        }
        else {
            return null;
        }
        return dictionaryToBeReturned;
    }
}