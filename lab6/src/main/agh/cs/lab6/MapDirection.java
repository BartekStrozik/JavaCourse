package agh.cs.lab6;

/**
 * Created by student26 on 2018-10-08.
 */
public enum MapDirection {
    East,
    South,
    West,
    North;

    public String toString(){
        switch(this){
            case North:
                return "Północ";
            case South:
                return "Południe";
            case West:
                return "Zachód";
            case East:
                return "Wschód";
            default: return "";
        }
    }

    public MapDirection next() {
        return MapDirection.values()[(this.ordinal() + 1) % MapDirection.values().length];
    }

    public MapDirection previous(){
        if(this.ordinal() == 0){
            return MapDirection.values()[MapDirection.values().length - 1];
        }
        return MapDirection.values()[this.ordinal() - 1];
    }
}