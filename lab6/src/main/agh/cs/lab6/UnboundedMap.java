package agh.cs.lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by student26 on 2018-10-29.
 */
public class UnboundedMap extends AbstractWorldMap{
    public UnboundedMap(List<HayStack> hayStackList){
        for(HayStack hayStack : hayStackList){
            //mapElements.add(hayStack);
            elementMap.put(hayStack.getPosition(),hayStack);
        }
    }

    public Object objectAt(Position position){
        /*for(IMapElement mapElement : mapElements){
            if(mapElement.getPosition().equals(position))return mapElement;
        }
        return null;*/
        //return carsMap.get(position);
        return elementMap.get(position);
    }

    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    public String toString(){
        Position low = new Position(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Position high = new Position(Integer.MIN_VALUE,Integer.MIN_VALUE);

        for(Map.Entry<Position,IMapElement> entry : elementMap.entrySet()){
            if(entry!=null) {
                low = low.lowerLeft(entry.getKey());
                high = high.upperRight(entry.getKey());
            }
        }

        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(low,high);
    }
}