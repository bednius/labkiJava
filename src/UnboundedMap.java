import java.util.ArrayList;
import java.util.List;

/**
 * Created by kreska on 27.11.16.
 */
public class UnboundedMap extends AbstractWorldMap {

    public UnboundedMap(List<HayStack> hayStacks) {
        this.hayStacks.addAll(hayStacks);
    }

    @Override
    public String toString() {

        Position origin;

        if (cars.size() > 0) {
            origin = cars.get(0).getPosition();
        } else if (hayStacks.size() > 0) {
            origin = cars.get(0).getPosition();
        } else return "there are no elements on the map";

        int xUpper = origin.x;
        int xLower = xUpper;
        int yUpper = origin.y;
        int yLower = yUpper;

        for (Car car : cars) {
            int tmp = car.getPosition().x;
            if (xLower > tmp) {
                xLower = tmp;
            } else if (xUpper < tmp) {
                xUpper = tmp;
            }
            tmp = car.getPosition().y;
            if (yLower > tmp) {
                yLower = tmp;
            } else if (yUpper < tmp) {
                yUpper = tmp;
            }
        }

        for (HayStack hayStack : hayStacks) {
            int tmp = hayStack.getPosition().x;
            if (xLower > tmp) {
                xLower = tmp;
            } else if (xUpper < tmp) {
                xUpper = tmp;
            }
            tmp = hayStack.getPosition().y;
            if (yLower > tmp) {
                yLower = tmp;
            } else if (yUpper < tmp) {
                yUpper = tmp;
            }
        }

        return new MapVisualizer().dump(this, new Position(xLower - 1, yLower - 1), new Position(xUpper + 1, yUpper + 1));
    }

    @Override
    public boolean canMoveTo(Position position) {
        return true;
    }
}
