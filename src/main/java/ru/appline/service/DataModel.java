package ru.appline.service;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import static ru.appline.service.Direction.*;

public class DataModel implements Serializable {

    private static final DataModel instance = new DataModel();

    private static final int PERIOD = 44;

    private final Map<Direction, AngleValue> model;

    public DataModel() {
        this.model = new LinkedHashMap<>();
        model.put(NORTH, null);
        model.put(NORTH_EAST, null);
        model.put(EAST, null);
        model.put(SOUTH_EAST, null);
        model.put(SOUTH, null);
        model.put(SOUTH_WEST, null);
        model.put(WEST, null);
        model.put(NORTH_WEST, null);
        setupCompassByLeftNorthValue(341);
    }

    private void setupCompassByLeftNorthValue(int leftNorthValue) {
        int nextleftValue = leftNorthValue;
        for (Map.Entry<Direction, AngleValue> entry : model.entrySet()) {
            int rightValue = calcRightValue(nextleftValue);
            model.put(entry.getKey(), new AngleValue(nextleftValue, rightValue));
            nextleftValue = rightValue + 1;
        }
    }

    private int calcRightValue(int leftValue) {
        int rightValue = leftValue + PERIOD;
        if (rightValue > 359) {
            rightValue = rightValue - 360;
        }
        return rightValue;
    }


    public static DataModel getInstance() {
        return instance;
    }

    public void resetCompassDirections(Map<String, String> compassParam) {

        String northDirectionRange = compassParam.get(NORTH.getDirectionValue());

        String[] splitNorthRange = northDirectionRange.split("-");
        int leftAngleValue = Integer.parseInt(splitNorthRange[0]);
        setupCompassByLeftNorthValue(leftAngleValue);
    }

    public Map<String, String> measure(Integer degree) {
        if (degree > 359) {
            return Map.of("Side", "Unknown");
        }

        for (Map.Entry<Direction, AngleValue> modelEntry : model.entrySet()) {
            Direction direction = modelEntry.getKey();

            Integer leftVal = modelEntry.getValue().getLeftVal();
            Integer rightVal = modelEntry.getValue().getRightVal();

            if (leftVal > rightVal) {
                if ((leftVal <= degree && degree <= 359) || (0 <= degree && degree <= rightVal)) {
                    return Map.of("Side", direction.getDirectionValue());
                }
            } else {
                if (leftVal <= degree && degree <= rightVal) {
                    return Map.of("Side", direction.getDirectionValue());
                }
            }
        }
        return Map.of("Side", "Unknown");
    }
}
