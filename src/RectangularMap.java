/**
 * Created by kreska on 27.11.16.
 */
public class RectangularMap extends AbstractWorldMap {
    public Position topRightCorner;
    public Position origin = new Position(0, 0);

    public RectangularMap(int width, int height) {
        this.topRightCorner = new Position(width, height);
    }

    @Override
    public String toString() {
        return new MapVisualizer().dump(this, origin, topRightCorner);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return (position.smaller(topRightCorner) && position.greater(origin));
    }
}
