package agh.cs.lab6;

import javafx.geometry.Pos;

import java.util.*;

/**
 * Created by student26 on 2018-10-29.
 */
public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    //protected List<IMapElement> mapElements = new ArrayList<>();
    //protected List<Car> cars = new ArrayList<>();

    protected Map<Position,IMapElement> elementMap = new HashMap<>();
    protected Map<Position,Car> carsMap = new HashMap<>();

    public abstract Object objectAt(Position position);

    public boolean isOccupied(Position position){
        return (objectAt(position)!=null);
    }

    public abstract boolean canMoveTo(Position position);

    public void place(Car car){
        if(this.canMoveTo(car.getPosition())){
            //cars.add(car);
            //mapElements.add(car);

            carsMap.put(car.getPosition(),car);
            elementMap.put(car.getPosition(),car);
        }
        else throw new IllegalArgumentException("Position: "
                + car.getPosition() + " is already occupied.");
    }

    public abstract String toString();

    public void run(MoveDirection[] directions){
        Collection<Car> collection = carsMap.values();
        List<Car> carList = new ArrayList<>();
        carList.addAll(collection);

        int i=0;
        for(MoveDirection moveDirection : directions){
            Position position = carList.get(i).getPosition();
            carList.get(i).move(moveDirection);
            if(!position.equals(carList.get(i).getPosition())){
                elementMap.remove(position);
                elementMap.put(carList.get(i).getPosition(),carList.get(i));

                carsMap.remove(position);
                carsMap.put(carList.get(i).getPosition(),carList.get(i));

                carsMap.get(carList.get(i).getPosition()).positionChanged(
                        position,carList.get(i).getPosition()
                );
            }
            i=(i+1)%carsMap.size();
        }
    }

    public void positionChanged(Position oldPosition, Position newPosition){
        //carsMap.put(newPosition,carsMap.remove(oldPosition));
        carsMap.remove(oldPosition);
        carsMap.put(newPosition,new Car());
    }
}