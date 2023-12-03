import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import java.util.concurrent.atomic.AtomicInteger;

public class Luncher{
    public static void main(String [] args){

        Path path = Paths.get("./Data/dataset.txt");
        AtomicInteger totalNumber = new AtomicInteger(0);
        final List<String> numberLetter = new ArrayList<String>();
        numberLetter.add("one");
        numberLetter.add("tow");
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

                    // on regarde s'il y a les nombre en lettre

                   numberLetter.contains(element)

                    // On regarde les chiffre
                    for(int i=0; i < element.length(); i++) {
                        
                        

                        if(Character.isDigit(element.charAt(i))){
                            value += element.charAt(i);
                        }
                        
                    }
                    
                    String resultValue = String.valueOf(value.charAt(0));
                    resultValue += String.valueOf(value.charAt(value.length()-1));
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