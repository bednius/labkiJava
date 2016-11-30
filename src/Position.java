/**
 * Created by kreska on 26.11.16.
 */
public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean smaller(Position other) {
        return (this.x <= other.x && this.y <= other.y);
    }

    public boolean greater(Position other) {
        return (this.x >= other.x && this.y >= other.y);
    }

    public Position add(Position other) {
        return new Position(this.x + other.x, this.y + other.y);
    }

    public boolean equals(Position other) {
        if (this == other)
            return true;
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;
        return (this.x == that.x && this.y == that.y);
    }

    public Position makeMove(MapOrientation orientation) {
        switch (orientation) {
            case North:
                return new Position(this.x, this.y + 1);
            case East:
                return new Position(this.x + 1, this.y);
            case South:
                return new Position(this.x, this.y - 1);
            case West:
                return new Position(this.x - 1, this.y);
            default:
                return null;
        }
    }
}
