import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.Map;

public class Luncher{
    public static void main(String [] args){

        Path path = Paths.get("./Data/dataset.txt");
        AtomicInteger totalNumber = new AtomicInteger(0);
        final List<String> numberLetter = new ArrayList<String>();
        numberLetter.add("one");
        numberLetter.add("two");
        numberLetter.add("three");
        numberLetter.add("four");
        numberLetter.add("five");
        numberLetter.add("six");
        numberLetter.add("seven");
        numberLetter.add("eight");
        numberLetter.add("nine");
        
        try (Stream<String> stream = Files.lines(path)){
            stream.forEach(element ->{
                    String value = "";
                    int indexMot =0;
                    Map<Integer, Integer> dict= new HashMap<>();
                    //index -- Value

                    for(int i=0; i< numberLetter.size(); i++){
                        int index = element.indexOf(numberLetter.get(i));
                        while(index != -1){
                            dict.put(index, i+1);
                            index = element.indexOf(numberLetter.get(i),index+1);
                        }
                    }
                    // On regarde les chiffre
                    for(int i=0; i < element.length(); i++) {
                        if(Character.isDigit(element.charAt(i))){
                            dict.put(i, Integer.parseInt(String.valueOf(element.charAt(i))));
                        }
                        
                    }
                    System.out.println("Le mot : "+element);
                    System.err.println(dict);
                    
                    
                     String resultValue = String.valueOf(dict.get(Collections.min(dict.keySet())));
                     resultValue += String.valueOf(dict.get(Collections.max(dict.keySet())));
                     System.out.println(resultValue);
                    
                     totalNumber.addAndGet(Integer.parseInt(resultValue));
                }
             );

             System.out.println(totalNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}