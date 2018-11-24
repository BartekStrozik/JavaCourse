package agh.cs.lab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student26 on 2018-10-15.
 */
public class Car extends AbstractWorldMapElement{
    private MapDirection direction = MapDirection.North;
    private Position position = new Position(2,2);
    private IWorldMap map;

    List<IPositionChangeObserver> observers = new ArrayList<>();

    public Car(){}

    public Car(IWorldMap map){
        this.map = map;
    }

    public Car(IWorldMap map, Position initialPosition){
        this.map = map;
        if(this.map.canMoveTo(initialPosition)){
            this.position = new Position(initialPosition.x,initialPosition.y);
        }
    }

    public Position getPosition(){ return this.position;}

    public String toString(){
        switch(this.direction){
            case North: return "^";
            case South: return "v";
            case East: return ">";
            case West: return "<";
            default : return "";
        }
    }

    public void move(MoveDirection direction){
        if(direction == MoveDirection.RIGHT) {
            this.direction = this.direction.next();
            return;
        }
        if(direction == MoveDirection.LEFT) {
            this.direction = this.direction.previous();
            return;
        }
        Position newPosition = this.position;
        int x = 0, y = 0;
        switch(this.direction) {
            case North:
                x = 0; y = 1;
                break;
            case West:
                x = -1; y = 0;
                break;
            case South:
                x = 0; y = -1;
                break;
            case East:
                x = 1; y = 0;
                break;
        }
        if(direction == MoveDirection.BACKWARD) {
            x = -x;
            y = -y;
        }
        newPosition = newPosition.add(new Position(x, y));
        if(this.map.canMoveTo(newPosition))this.position = newPosition;

    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChanged(Position oldPosition, Position newPosition){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public static void main(String[] args){
        RectangularMap map = new RectangularMap(10,10);
        //System.out.println(map.toString());

        Car mercedes = new Car(map,new Position(5,5));
        map.place(mercedes);
        System.out.println(map.toString());

        RectangularMap map1 = new RectangularMap(10,10);
        RectangularMap map2= new RectangularMap(10,10);
        //mercedes.addObserver(map);
        mercedes.addObserver(map1);
        mercedes.addObserver(map2);

        String[] directions = {"f","r","f","r","l","l","b","b","f","r","f","r"};
        OptionsParser optionsParser = new OptionsParser();
        MoveDirection[] moveDirection = optionsParser.parse(directions);

        map.run(moveDirection);
        System.out.println(map);

        System.out.println("map1");
        System.out.println(map1);
        System.out.println("map2");
        System.out.println(map2);
    }

//cwiczenie try..catch

    /*public static void main(String[] args){
        try{
            List<HayStack> hayStacks = new ArrayList<>();
            HayStack h1 = new HayStack(new Position(1,1));
            HayStack h2 = new HayStack(new Position(1,0));
            HayStack h3 = new HayStack(new Position(1,-1));
            HayStack h4 = new HayStack(new Position(-3,1));
            hayStacks.add(h1);
            hayStacks.add(h2);
            hayStacks.add(h3);
            hayStacks.add(h4);
            UnboundedMap map = new UnboundedMap(hayStacks);
            System.out.println(map.toString());

            Car mercedes = new Car(map,new Position(-12,1));
            Car mercedes2 = new Car(map,new Position(1,4));
            Car mercedes3 = new Car(map,new Position(1,10));
            map.place(mercedes);
            map.place(mercedes2);
            map.place(mercedes3);
            System.out.println(map.toString());

            OptionsParser optionsParser = new OptionsParser();
            String chain[]={"f","f"};
            optionsParser.parse(chain);
        }
        catch(IllegalArgumentException ex){
            System.out.println("Coś poszło nie tak...");
        }
    }*/

    /*public static void main(String[] args){
        List<HayStack> hayStacks = new ArrayList<>();
        HayStack h1 = new HayStack(new Position(1,1));
        HayStack h2 = new HayStack(new Position(1,0));
        HayStack h3 = new HayStack(new Position(1,-1));
        HayStack h4 = new HayStack(new Position(-3,1));
        hayStacks.add(h1);
        hayStacks.add(h2);
        hayStacks.add(h3);
        hayStacks.add(h4);

        UnboundedMap map = new UnboundedMap(hayStacks);
        System.out.println(map.toString());

        Car mercedes = new Car(map,new Position(10,12));
        Car mercedes2 = new Car(map,new Position(-1,7));
        Car mercedes3 = new Car(map,new Position(1,5));
        map.place(mercedes);
        map.place(mercedes2);
        map.place(mercedes3);
        System.out.println(map.toString());

        String chain[]={"f","f","f","f"};
        OptionsParser optionsParser = new OptionsParser();
        MoveDirection moveDirection[] = optionsParser.parse(chain);

        UnboundedMap map1 = new UnboundedMap(hayStacks);
        UnboundedMap map2 = new UnboundedMap(hayStacks);

        mercedes.addObserver(map);
        mercedes.addObserver(map1);
        mercedes.addObserver(map2);

        map.run(moveDirection);

        System.out.println(map.toString());
        System.out.println("1111111111");
        System.out.println(map1.toString());
        System.out.println("2222222222");
        System.out.println(map2.toString());
    }*/

//ćwiczenie struktury danych tablicy haszującej

    /*public static void main(String[] args){
        HashMap<Integer,String> table = new HashMap<>();
        table.put(0,"wiatrak");
        table.put(2,"papieros");
        table.put(4,"góra");
        table.put(10,"wirnik");
        table.put(7,"clubcard");

        for(Map.Entry<Integer,String> entry : table.entrySet()){
            System.out.println(entry.getValue());
        }

        System.out.println(table.size());

    }*/
}