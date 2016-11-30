/**
 * Created by kreska on 26.11.16.
 */
public class Car {
    MapOrientation orientation;
    Position position;
    IWorldMap map;

    public Car(IWorldMap map) {
        //map.add(this);
        this.map = map;
        this.position = new Position(2, 2);
        this.orientation = MapOrientation.North;
    }

    public Car(IWorldMap map, int x, int y) {
        this.position = new Position(x, y);
        this.map = map;
        this.orientation = MapOrientation.North;
    }

    public Car() {
        this.orientation = MapOrientation.North;
        this.position = new Position(2, 2);
    }

    public String toString2() {
        return "[" + this.position.toString() + ", Orientation: " + this.orientation.toString() + "]";
    }

    @Override
    public String toString() {
        return this.orientation.toString();
    }

    public Position getPosition() {
        return this.position;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case Stay:
                break;
            case Right:
                this.orientation = this.orientation.next();
                break;
            case Left:
                this.orientation = this.orientation.previous();
                break;
            case Forward: {
                Position newPosition = this.position.makeMove(this.orientation);
                if (this.map.canMoveTo(newPosition) && !this.map.isOccupied(newPosition))
                    this.position = newPosition;
                break;
            }
            case Backward: {
                Position newPosition = this.position.makeMove(this.orientation.next().next());
                if (this.map.canMoveTo(newPosition) && !this.map.isOccupied(newPosition))
                    this.position = newPosition;
                break;
            }
        }
    }
}

