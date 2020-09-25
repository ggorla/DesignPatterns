import java.util.List;
import java.util.stream.Stream;

enum Color
{
    red,green,blue
}
enum Size
{
    small, medium, large, yuge
}
/*
    Open Closed Principle
    closed for modifcications
    open for new implmentaions
 */
public class OpenClosedPrinciple {

    public String name;
    public Color color;
    public Size size;

    public OpenClosedPrinciple(String name, Color color, Size size)
    {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter
{
    public Stream<OpenClosedPrinciple> filterByColor(List<OpenClosedPrinciple> products, Color color)
    {
        return products.stream().filter(p->p.color==color);
    }
    public Stream<OpenClosedPrinciple> filterByColor(List<OpenClosedPrinciple> products, Size size)
    {
        return products.stream().filter(p->p.size==size);
    }
    public Stream<OpenClosedPrinciple> filterBySizeAndColor(
            List<OpenClosedPrinciple> products, Size size, Color color) {
        return products.stream().filter(p -> p.size == size && p.color == color);
    }
}
interface  Spec<T>{
    boolean isSatified(T item);
}
interface  Filter<T>{
    Stream<T> filter (List<T> items, Spec<T> spec);

}
class BetterFilter implements  Filter<OpenClosedPrinciple>{
    @Override
    public Stream<OpenClosedPrinciple> filter(List<OpenClosedPrinciple> items, Spec<OpenClosedPrinciple> spec) {
        return items.stream().filter(p -> spec.isSatified(p));
    }
}
class ColorSpecfiction implements Spec<OpenClosedPrinciple>{
    private  Color color;
    public ColorSpecfiction(Color color){
        this.color = color;
    }

    @Override
    public boolean isSatified(OpenClosedPrinciple item) {
        return item.color == color;
    }

}
class SizeSpecfiction implements Spec<OpenClosedPrinciple>{
    private  Size size;
    public SizeSpecfiction(Size size){
        this.size = size;
    }

    @Override
    public boolean isSatified(OpenClosedPrinciple item) {
        return item.size == size;
    }

}
class Demo1{
    public static void main(String[] args){
        OpenClosedPrinciple apple = new OpenClosedPrinciple("Apple", Color.green, Size.small);
        OpenClosedPrinciple tree = new OpenClosedPrinciple("Tree", Color.green, Size.small);
        OpenClosedPrinciple house = new OpenClosedPrinciple("House", Color.blue, Size.small);
        List<OpenClosedPrinciple> products = List.of(apple,tree,house);
        ProductFilter pf = new ProductFilter();
        System.out.println("Green Products(old):");
        pf.filterByColor(products, Color.green).forEach((p -> System.out.println(" " + p.name + "is green")));

        BetterFilter bf = new BetterFilter();
        System.out.println("Green Products (new):");
        bf.filter(products, new ColorSpecfiction(Color.green)).forEach(p-> System.out.println(" "+ p.name+ " is gree"));
    }

}
