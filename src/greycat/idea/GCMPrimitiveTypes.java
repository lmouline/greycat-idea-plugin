package greycat.idea;

public enum GCMPrimitiveTypes {

    String, Long, Integer, Bool, Double, Continuous;

    public static boolean isPrimitive(String originalName) {
        for (GCMPrimitiveTypes p : GCMPrimitiveTypes.values()) {
            if (p.name().equals(originalName)) {
                return true;
            }
        }
        return false;
    }

}
