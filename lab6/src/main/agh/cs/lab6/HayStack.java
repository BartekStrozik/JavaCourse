package agh.cs.lab6;

/**
 * Created by student26 on 2018-10-29.
 */
public class HayStack extends AbstractWorldMapElement{
    private Position position;

    public HayStack(Position position){
        this.position = position;
    }

    public Position getPosition(){
        return this.position;
    }

    public String toString(){
        return "s";
    }
}