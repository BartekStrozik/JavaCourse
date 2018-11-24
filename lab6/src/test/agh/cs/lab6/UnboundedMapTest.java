package agh.cs.lab6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by student26 on 2018-10-29.
 */
public class UnboundedMapTest {
    @Test
    public void testObjectAt(){
        List<HayStack> hayStacks = new ArrayList<>();
        HayStack hayStackArray[] = new HayStack[4];
        hayStackArray[0] = new HayStack(new Position(1,1));
        hayStackArray[1] = new HayStack(new Position(0,12));
        hayStackArray[2] = new HayStack(new Position(7,-2));
        hayStackArray[3] = new HayStack(new Position(-1,-3));
        for(HayStack h : hayStackArray)hayStacks.add(h);

        UnboundedMap unboundedMap1 = new UnboundedMap(hayStacks);

        Car mercedes = new Car(unboundedMap1,new Position(14,7));
        Car audi = new Car(unboundedMap1,new Position(24,18));
        Car volkswagen = new Car(unboundedMap1,new Position(-18,0));
        Car opel = new Car(unboundedMap1,new Position(0,0));

        unboundedMap1.elementMap.put(mercedes.getPosition(),mercedes);
        unboundedMap1.elementMap.put(audi.getPosition(),audi);
        unboundedMap1.elementMap.put(volkswagen.getPosition(),volkswagen);
        unboundedMap1.elementMap.put(opel.getPosition(),opel);

        assertEquals(unboundedMap1.objectAt(mercedes.getPosition()),mercedes);
        assertEquals(unboundedMap1.objectAt(audi.getPosition()),audi);
        assertEquals(unboundedMap1.objectAt(volkswagen.getPosition()),volkswagen);
        assertEquals(unboundedMap1.objectAt(opel.getPosition()),opel);

        assertEquals(unboundedMap1.objectAt(hayStackArray[0].getPosition()),hayStackArray[0]);
        assertEquals(unboundedMap1.objectAt(hayStackArray[1].getPosition()),hayStackArray[1]);
        assertEquals(unboundedMap1.objectAt(hayStackArray[2].getPosition()),hayStackArray[2]);
        assertEquals(unboundedMap1.objectAt(hayStackArray[3].getPosition()),hayStackArray[3]);
        assertEquals(unboundedMap1.objectAt(new Position(1,1)),hayStackArray[0]);
    }

    @Test
    public void testIsOccupied(){
        List<HayStack> hayStacks = new ArrayList<>();
        HayStack hayStackArray[] = new HayStack[4];
        hayStackArray[0] = new HayStack(new Position(1,1));
        hayStackArray[1] = new HayStack(new Position(8,1));
        hayStackArray[2] = new HayStack(new Position(-9,-1));
        hayStackArray[3] = new HayStack(new Position(4,-13));
        for(HayStack h : hayStackArray)hayStacks.add(h);

        UnboundedMap unboundedMap1 = new UnboundedMap(hayStacks);

        Car mercedes = new Car(unboundedMap1,new Position(7,7));
        Car audi = new Car(unboundedMap1,new Position(4,1));
        Car volkswagen = new Car(unboundedMap1,new Position(5,2));
        Car opel = new Car(unboundedMap1,new Position(6,6));

        unboundedMap1.elementMap.put(mercedes.getPosition(),mercedes);
        unboundedMap1.elementMap.put(audi.getPosition(),audi);
        unboundedMap1.elementMap.put(volkswagen.getPosition(),volkswagen);
        unboundedMap1.elementMap.put(opel.getPosition(),opel);

        assertEquals(unboundedMap1.isOccupied(mercedes.getPosition()),true);
        assertEquals(unboundedMap1.isOccupied(audi.getPosition()),true);
        assertEquals(unboundedMap1.isOccupied(volkswagen.getPosition()),true);
        assertEquals(unboundedMap1.isOccupied(opel.getPosition()),true);
        assertEquals(unboundedMap1.isOccupied(hayStackArray[0].getPosition()),true);
        assertEquals(unboundedMap1.isOccupied(hayStackArray[1].getPosition()),true);
        assertEquals(unboundedMap1.isOccupied(hayStackArray[2].getPosition()),true);
        assertEquals(unboundedMap1.isOccupied(hayStackArray[3].getPosition()),true);
        assertEquals(unboundedMap1.isOccupied(new Position(1,1)),true);
    }

    @Test
    public void testCanMoveTo(){
        List<HayStack> hayStacks = new ArrayList<>();
        HayStack hayStackArray[] = new HayStack[4];
        hayStackArray[0] = new HayStack(new Position(1,1));
        hayStackArray[1] = new HayStack(new Position(0,12));
        hayStackArray[2] = new HayStack(new Position(7,-2));
        hayStackArray[3] = new HayStack(new Position(-1,-3));
        for(HayStack h : hayStackArray)hayStacks.add(h);
        UnboundedMap unboundedMap1 = new UnboundedMap(hayStacks);

        Car mercedes = new Car(unboundedMap1,new Position(7,7));
        Car audi = new Car(unboundedMap1,new Position(4,1));
        Car volkswagen = new Car(unboundedMap1,new Position(5,2));
        Car opel = new Car(unboundedMap1,new Position(6,6));

        unboundedMap1.elementMap.put(mercedes.getPosition(),mercedes);
        unboundedMap1.elementMap.put(audi.getPosition(),audi);
        unboundedMap1.elementMap.put(volkswagen.getPosition(),volkswagen);
        unboundedMap1.elementMap.put(opel.getPosition(),opel);

        assertEquals(unboundedMap1.canMoveTo(mercedes.getPosition()),false);
        assertEquals(unboundedMap1.canMoveTo(audi.getPosition()),false);
        assertEquals(unboundedMap1.canMoveTo(volkswagen.getPosition()),false);
        assertEquals(unboundedMap1.canMoveTo(opel.getPosition()),false);
        assertEquals(unboundedMap1.canMoveTo(hayStackArray[0].getPosition()),false);
        assertEquals(unboundedMap1.canMoveTo(hayStackArray[1].getPosition()),false);
        assertEquals(unboundedMap1.canMoveTo(hayStackArray[2].getPosition()),false);
        assertEquals(unboundedMap1.canMoveTo(hayStackArray[3].getPosition()),false);
        assertEquals(unboundedMap1.canMoveTo(new Position(1,1)), false);
    }

    @Test
    public void testPlace(){
        boolean flag = false;
        try {
            List<HayStack> hayStacks = new ArrayList<>();
            HayStack hayStackArray[] = new HayStack[4];
            hayStackArray[0] = new HayStack(new Position(0, 13));
            hayStackArray[1] = new HayStack(new Position(-7, 4));
            hayStackArray[2] = new HayStack(new Position(2, -2));
            hayStackArray[3] = new HayStack(new Position(1, 5));
            for (HayStack h : hayStackArray) hayStacks.add(h);

            UnboundedMap unboundedMap1 = new UnboundedMap(hayStacks);

            Car mercedes = new Car(unboundedMap1, new Position(7, 7));
            Car audi = new Car(unboundedMap1, new Position(0, 13));
            Car volkswagen = new Car(unboundedMap1, new Position(5, 2));
            Car opel = new Car(unboundedMap1, new Position(5, 2));

            unboundedMap1.place(mercedes);
            unboundedMap1.place(audi);
            unboundedMap1.place(volkswagen);
            //unboundedMap1.place(opel);
        }catch(IllegalArgumentException ex) {
            flag = true;
        }
        assertEquals(flag,false);
        //assertEquals(flag,true);
    }

    @Test
    public void testRun(){
        List<HayStack> hayStacks = new ArrayList<>();
        HayStack h = new HayStack(new Position(0,0));
        hayStacks.add(h);
        UnboundedMap unboundedMap1 = new UnboundedMap(hayStacks);

        Car mercedes = new Car(unboundedMap1,new Position(-7,0));
        unboundedMap1.place(mercedes);

        String args[]={"l","l","f","b","f","f"};
        OptionsParser optionsParser = new OptionsParser();
        unboundedMap1.run(optionsParser.parse(args));

        assertEquals(mercedes.getPosition(),new Position(-7,-2));

    }
}