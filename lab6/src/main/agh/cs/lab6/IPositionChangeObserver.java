package agh.cs.lab6;


public interface IPositionChangeObserver {
    void positionChanged(Position oldPosition, Position newPosition);
}
