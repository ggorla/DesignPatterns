import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/*
    sapaeration of conserns or functionality
    the implmentation should be concentrating on single
 */
public class SingleResponsibilityPrinciple {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text)
    {
        entries.add(""+(++count)+":"+ text);
    }
    public void  removeEntry(int index)
    {
        entries.remove(index);
    }

    @Override
    public String toString(){
        return String.join(System.lineSeparator(),entries);
    }

}
class Persistance {
    public void save(String filename) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(filename)) {
            out.println(toString());
        }

    }
}
class Demo
{
    public static void main(String[] args){
        SingleResponsibilityPrinciple j =  new SingleResponsibilityPrinciple();
        j.addEntry("I walked today");
        j.addEntry("I ate a bug");
        System.out.println(j);


        Persistance p = new Persistance();
        String filename = "path";

    }
}