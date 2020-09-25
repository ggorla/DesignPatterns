import java.util.ArrayList;


import java.util.List;
import org.javatuples.Triplet;

enum RelationShip{
        Parent,child,
        sibling
        }
public class DependencyInversion {
}

/*
    high level Module should not be depended on low level modules
    Both should depend on abstraction

    Abstraction should not depend on details
    Details should depend on abstractions

 */

class Person{
    public String name;
    public Person(String name){
        this.name = name;
    }
}

class RelationShips
{
    private List<Triplet<Person,RelationShip,Person>> relations = new ArrayList<>();
    public List<Triplet<Person,RelationShip,Person>> getRelations(){
        return relations;
    }
    public void addParentAndChild(Person parent, Person child)
    {
        relations.add(new Triplet<>)
    }
}