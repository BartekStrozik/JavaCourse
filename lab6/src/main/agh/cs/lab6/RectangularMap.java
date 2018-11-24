package agh.cs.lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student30 on 2018-10-22.
 */
public class RectangularMap extends AbstractWorldMap{
    private int width;
    private int height;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public Object objectAt(Position position){
        /*for(Car car: cars){
            if(car.getPosition().equals(position))return car;
        }
        return null;*/
        return carsMap.get(position);
    }

    public boolean canMoveTo(Position position){
        return (position.smaller(new Position(this.width,this.height)) &&
                position.larger(new Position(0,0)) &&
                !isOccupied(position));
    }

    public String toString(){
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Position(0,0),new Position(width,height));
    }
}