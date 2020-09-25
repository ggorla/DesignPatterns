import java.awt.*;
import java.security.PublicKey;

public class LiskovSubsitution {
}
class Retangle{
    protected  int width, height;

    public Retangle(){
    }

    public  Retangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public int getArea(){ return  width*height;}

    @Override
    public  String toString(){
        return "Rectangle{" +"width="+width+
                ",Height="+ height+'}';
    }
}

class Square extends Retangle
{
    public  Square(){}

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(height);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(width);
    }

    public Square(int size)
    {
        width = height = size;
    }
}
class Demo2
{
    static void userIt(Retangle r){
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected are of"+(width*10)+", got"+r.getArea());
}

    public static void main(String[] args) {
        Retangle rc = new Retangle(2,3);
    }
}