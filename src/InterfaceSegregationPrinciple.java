import javax.print.Doc;

public class InterfaceSegregationPrinciple {
}

class Document{

}
/*
    with this  your forced to implment all the interfaces even its not necessary
 */
interface  Machine
{
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}
/*
    break down of interfaces to multiple
 */

interface Scan{
    void scan(Document d);
}
interface  print{
    void scan(Document d);
}

interface MultiFunctionDevice extends print, Scan{

}
class MultiFunctionPrinter implements  Machine{
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}
class OldFashaionedPrinter implements  Machine{
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}
