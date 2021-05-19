public class AreaOfTriangle {
    public static Float calcAreaOfTriangle(Float hbVal, Float bVal) {
        try {
            return (hbVal * bVal) / 2;
        } catch (Exception e) {
            return 0.0F;
        }
    }
}
