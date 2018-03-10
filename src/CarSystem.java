import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kreska on 26.11.16.
 */
public class CarSystem {
    public static void main(String[] args) {
        try {
            System.out.println("start");

            MoveDirection[] directions = new OptionsParser().parse(args);
            ArrayList<HayStack> hayStacks = new ArrayList<>();
            hayStacks.add(new HayStack(new Position(-4, -4)));
            hayStacks.add(new HayStack(new Position(7, 7)));
            hayStacks.add(new HayStack(new Position(3, 6)));
            hayStacks.add(new HayStack(new Position(2, 0)));
            IWorldMap map = new UnboundedMap(hayStacks);
            map.add(new Car(map));
            map.add(new Car(map, 3, 4));
            map.add(new Car(map));
            map.run(directions);
            //MapVisualizer mapVis = new MapVisualizer();
            System.out.println(map.toString());
            //System.out.println(map.isOccupied(new Position(3, 4)));
            //System.out.println(map.isOccupied(new Position(1, 1)));
            //System.out.println(map.toString());
            //run(new OptionsParser().parse(args));
            IWorldMap map2 = new RectangularMap(10, 5);
            Car bmw = new Car(map2, 3, 4);
            map2.add(bmw);
            bmw.move(MoveDirection.Backward);
            System.out.println(bmw.toString2());
            bmw.move(MoveDirection.Left);
            System.out.println(bmw.toString2());
            bmw.move(MoveDirection.Forward);
            System.out.println(bmw.toString2());
            bmw.move(MoveDirection.Right);
            System.out.println(bmw.toString2());
            bmw.move(MoveDirection.Forward);
            System.out.println(bmw.toString2());
            bmw.move(MoveDirection.Forward);
            System.out.println(bmw.toString2());
            bmw.move(MoveDirection.Forward);
            System.out.println(bmw.toString2());
            bmw.move(MoveDirection.Forward);
            System.out.println(bmw.toString2());
            System.out.println(map2.toString());

            IWorldMap bawaria = new UnboundedMap(Collections.emptyList());
            System.out.println(bawaria.toString());
            System.out.println("stop");
        } catch (IllegalArgumentException err) {
            System.err.println(err);
        }


    }

    private static MoveDirection[] convertArguments(String[] args) {
        MoveDirection[] result = new MoveDirection[args.length];
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f":
                    result[i] = MoveDirection.Forward;
                    break;
                case "b":
                    result[i] = MoveDirection.Backward;
                    break;
                case "r":
                    result[i] = MoveDirection.Right;
                    break;
                case "l":
                    result[i] = MoveDirection.Left;
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    private static void run(MoveDirection[] args) {
        for (MoveDirection arg : args) {
            if (arg != null) {
                switch (arg) {
                    case Forward:
                        System.out.println("f");
                        break;
                    case Backward:
                        System.out.println("b");
                        break;
                    case Right:
                        System.out.println("r");
                        break;
                    case Left:
                        System.out.println("l");
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
