package greycat.idea;

public enum GCMPrimitiveTypes {

    String, Long, Integer, Bool, Double, Task, Int, Boolean, DoubleArray, LongArray, IntArray, StringArray, LongToLongMap, LongToLongArrayMap, StringToIntMap, DMatrix, LMatrix, IntToIntMap, IntToStringMap, NDTree, KDTree;

    public static boolean isPrimitive(String originalName) {
        for (GCMPrimitiveTypes p : GCMPrimitiveTypes.values()) {
            if (p.name().equals(originalName)) {
                return true;
            }
        }
        return false;
    }

}
