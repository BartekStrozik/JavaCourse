package agh.cs.lab6;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student26 on 2018-10-29.
 */
public class RectangularMapTest {
    @Test
    public void testObjectAt(){
        RectangularMap rectangularMap1 = new RectangularMap(10,10);

        Car mercedes = new Car(rectangularMap1,new Position(7,7));
        Car audi = new Car(rectangularMap1,new Position(4,1));
        Car volkswagen = new Car(rectangularMap1,new Position(5,2));
        Car opel = new Car(rectangularMap1,new Position(6,6));

        rectangularMap1.carsMap.put(mercedes.getPosition(),mercedes);
        rectangularMap1.carsMap.put(audi.getPosition(),audi);
        rectangularMap1.carsMap.put(volkswagen.getPosition(),volkswagen);
        rectangularMap1.carsMap.put(opel.getPosition(),opel);

        assertEquals(rectangularMap1.objectAt(mercedes.getPosition()),mercedes);
        assertEquals(rectangularMap1.objectAt(audi.getPosition()),audi);
        assertEquals(rectangularMap1.objectAt(volkswagen.getPosition()),volkswagen);
        assertEquals(rectangularMap1.objectAt(opel.getPosition()),opel);
        assertEquals(rectangularMap1.objectAt(new Position(1,1)),null);
    }

    @Test
    public void testIsOccupied(){
        RectangularMap rectangularMap1 = new RectangularMap(10,10);

        Car mercedes = new Car(rectangularMap1,new Position(7,7));
        Car audi = new Car(rectangularMap1,new Position(4,1));
        Car volkswagen = new Car(rectangularMap1,new Position(5,2));
        Car opel = new Car(rectangularMap1,new Position(6,6));

        rectangularMap1.carsMap.put(mercedes.getPosition(),mercedes);
        rectangularMap1.carsMap.put(audi.getPosition(),audi);
        rectangularMap1.carsMap.put(volkswagen.getPosition(),volkswagen);
        rectangularMap1.carsMap.put(opel.getPosition(),opel);

        assertEquals(rectangularMap1.isOccupied(mercedes.getPosition()),true);
        assertEquals(rectangularMap1.isOccupied(audi.getPosition()),true);
        assertEquals(rectangularMap1.isOccupied(volkswagen.getPosition()),true);
        assertEquals(rectangularMap1.isOccupied(opel.getPosition()),true);
        assertEquals(rectangularMap1.isOccupied(new Position(1,1)),false);
    }

    @Test
    public void testCanMoveTo(){
        RectangularMap rectangularMap1 = new RectangularMap(12,8);
        assertEquals(rectangularMap1.canMoveTo(new Position(14,10)),false);

        RectangularMap rectangularMap2 = new RectangularMap(7,1);
        assertEquals(rectangularMap2.canMoveTo(new Position(4,3)),false);

        RectangularMap rectangularMap3 = new RectangularMap(4,4);
        assertEquals(rectangularMap3.canMoveTo(new Position(3,4)),true);

        RectangularMap rectangularMap4 = new RectangularMap(12,8);
        assertEquals(rectangularMap4.canMoveTo(new Position(12,8)),true);

        RectangularMap rectangularMap5 = new RectangularMap(0,0);
        assertEquals(rectangularMap5.canMoveTo(new Position(0,0)),true);

        Car car1 = new Car(rectangularMap1, new Position(0,0));
        rectangularMap1.place(car1);
        assertEquals(rectangularMap1.canMoveTo(new Position(0,0)),false);

        Car car2 = new Car(rectangularMap1, new Position(1,4));
        rectangularMap1.place(car2);
        Car car3 = new Car(rectangularMap1, new Position(1,4));
        rectangularMap1.place(car3);
        assertEquals(rectangularMap1.canMoveTo(new Position(1,4)),false);
    }

    @Test
    public void testPlace(){
        boolean flag = false;
        try {
            RectangularMap rectangularMap1 = new RectangularMap(10, 10);
            rectangularMap1.place(new Car());

            RectangularMap rectangularMap2 = new RectangularMap(7, 4);
            rectangularMap2.place(new Car(rectangularMap2, new Position(4, 4)));

            RectangularMap rectangularMap3 = new RectangularMap(8, 5);
            Car car = new Car(rectangularMap3, new Position(9, 9));
            rectangularMap3.place(car);

            Car car1 = new Car(rectangularMap3, new Position(9, 9));
            rectangularMap3.place(car1);
        }catch(IllegalArgumentException ex){
            flag = true;

        }
        assertEquals(flag,true);
    }

    @Test
    public void testRun(){
        RectangularMap rectangularMap1 = new RectangularMap(10,10);

        Car mercedes = new Car(rectangularMap1,new Position(7,7));
        rectangularMap1.carsMap.put(mercedes.getPosition(),mercedes);

        String args[]={"r","l","f","f","f","b"};
        OptionsParser optionsParser = new OptionsParser();
        rectangularMap1.run(optionsParser.parse(args));

        assertEquals(mercedes.getPosition(),new Position(7,9));
    }
}