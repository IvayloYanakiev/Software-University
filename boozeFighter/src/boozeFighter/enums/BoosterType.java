package boozeFighter.enums;

import java.util.HashMap;
import java.util.Map;

public enum BoosterType {
    Chicken (0),
    Ham (1),
    Sandwich (2),
    Steak (3);

    private final int index;
    private static Map<Integer, BoosterType> indexToValue = new HashMap();

    static {
        for (BoosterType type : BoosterType.values()) {
            indexToValue.put(type.index, type);
        }
    }

    BoosterType(int index) {
        this.index = index;
    }

    public static BoosterType getTypeByIndex(int index) {
        return indexToValue.get(index);
    }
}