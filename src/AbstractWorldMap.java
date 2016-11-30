import java.util.ArrayList;
import java.util.List;

/**
 * Created by kreska on 28.11.16.
 */
public abstract class AbstractWorldMap implements IWorldMap {
    protected List<HayStack> hayStacks = new ArrayList<>();
    protected List<Car> cars = new ArrayList<>();

    @Override
    public boolean add(Car car) {
        if(!isOccupied(car.getPosition())) {
            cars.add(car);
            return true;
        }
        else throw new IllegalArgumentException("Position "  + car.getPosition().toString() + " is occupied");
    }

    @Override
    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            cars.get(i % cars.size()).move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        for(Car car : cars) {
            if(car.getPosition().equals(position)) {
                return true;
            }
        }

        for(HayStack hayStack : hayStacks) {
            if(hayStack.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        for(Car car : cars) {
            if(car.getPosition().equals(position)) {
                return car;
            }
        }

        for(HayStack hayStack : hayStacks) {
            if(hayStack.getPosition().equals(position)) {
                return hayStack;
            }
        }
        return "";
    }
}
