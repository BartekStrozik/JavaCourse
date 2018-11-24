package agh.cs.lab6;

/**
 * Created by student26 on 2018-10-08.
 */
public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "("+Integer.toString(x)+","+Integer.toString(y)+")";
    }

    public boolean smaller(Position p){
        return (this.x <= p.x && this.y <= p.y);
    }

    public boolean larger(Position p){
        return (this.x >= p.x && this.y >= p.y);
    }

    public Position upperRight(Position p){
        return new Position(Math.max(this.x,p.x),Math.max(this.y,p.y));
    }

    public Position lowerLeft(Position p){
        return new Position(Math.min(this.x,p.x),Math.min(this.y,p.y));
    }

    public Position add(Position p){
        return new Position(this.x+p.x,this.y+p.y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;
        if(this.x == that.x && this.y == that.y)return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }
}