package agh.cs.lab6;

/**
 * Created by student26 on 2018-10-15.
 */
public class OptionsParser {
    public MoveDirection[] parse(String[] chain){
        MoveDirection[] moveDirections = new MoveDirection[chain.length];
        int i=0;
        for(String cursor : chain){
            if(cursor.equals("f") || cursor.equals("forward"))moveDirections[i] = MoveDirection.FORWARD;
            else if(cursor.equals("b") || cursor.equals("backward"))moveDirections[i] = MoveDirection.BACKWARD;
            else if(cursor.equals("l") || cursor.equals("left"))moveDirections[i] = MoveDirection.LEFT;
            else if(cursor.equals("r") || cursor.equals("right"))moveDirections[i] = MoveDirection.RIGHT;
            else throw new IllegalArgumentException(cursor + " is not legal move specification");
            i++;
        }
        return moveDirections;
    }
}