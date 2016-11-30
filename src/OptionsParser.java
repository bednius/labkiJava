import java.util.ArrayList;

/**
 * Created by kreska on 26.11.16.
 */
public class OptionsParser {
    private ArrayList<MoveDirection> result = new ArrayList<>();

    public MoveDirection[] parse(String args[]) {
        for (String arg : args) {
            switch (arg) {
                case "f":
                    result.add(MoveDirection.Forward);
                    break;
                case "r":
                    result.add(MoveDirection.Right);
                    break;
                case "b":
                    result.add(MoveDirection.Backward);
                    break;
                case "l":
                    result.add(MoveDirection.Left);
                    break;
                case "s":
                    result.add(MoveDirection.Stay);
                    break;
                default:
                    throw new IllegalArgumentException(arg + " argument is invalid");
            }
        }
        MoveDirection[] res = new MoveDirection[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
