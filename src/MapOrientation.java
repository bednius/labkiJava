/**
 * Created by kreska on 26.11.16.
 */
public enum MapOrientation {
    North,
    East,
    South,
    West;

    public String toString() {
        switch(this) {
            case North: return "^";
            case South: return "v";
            case West: return "<";
            case East: return ">";
            default: return "unknown orientation";
        }
    }

    public MapOrientation next() {
        return MapOrientation.values()[(this.ordinal()+1)%4];
    }

    public MapOrientation previous() {
        return MapOrientation.values()[(this.ordinal()+3)%4];
    }
}
