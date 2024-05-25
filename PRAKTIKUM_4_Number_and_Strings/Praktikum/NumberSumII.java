public class NumberSumII {
    public Number sumNumberII(Number[] numArr) {
        Number sum = 0;
        for (Number num : numArr) {
            if (num instanceof Byte) {
                byte temp = (byte)(sum.byteValue() + num.byteValue());
                if (temp < sum.byteValue() && temp < num.byteValue()) {
                    sum = Byte.MAX_VALUE;
                } else if (temp > sum.byteValue() && temp > num.byteValue()) {
                    sum = Byte.MIN_VALUE;
                } else {
                    sum = temp;
                }
            } else if (num instanceof Short) {
                short temp = (short)(sum.shortValue() + num.shortValue());
                if (temp < sum.shortValue() && temp < num.shortValue()) {
                    sum = Short.MAX_VALUE;
                } else if (temp > sum.shortValue() && temp > num.shortValue()) {
                    sum = Short.MIN_VALUE;
                } else {
                    sum = temp;
                }
            } else if (num instanceof Integer) {
                int temp = sum.intValue() + num.intValue();
                if (temp < sum.intValue() && temp < num.intValue()) {
                    sum = Integer.MAX_VALUE;
                } else if (temp > sum.intValue() && temp > num.intValue()) {
                    sum = Integer.MIN_VALUE;
                } else {
                    sum = temp;
                }
            } else if (num instanceof Long) {
                long temp = sum.longValue() + num.longValue();
                if (temp < sum.longValue() && temp < num.longValue()) {
                    sum = Long.MAX_VALUE;
                } else if (temp > sum.longValue() && temp > num.longValue()) {
                    sum = Long.MIN_VALUE;
                } else {
                    sum = temp;
                }
            } else if (num instanceof Float) {
                float temp = sum.floatValue() + num.floatValue();
                if (Float.isInfinite(temp)) {
                    sum = temp < 0 ? Float.MIN_VALUE : Float.MAX_VALUE;
                } else {
                    sum = temp;
                }
            } else if (num instanceof Double) {
                double temp = sum.doubleValue() + num.doubleValue();
                if (Double.isInfinite(temp)) {
                    sum = temp < 0 ? Double.MIN_VALUE : Double.MAX_VALUE;
                } else {
                    sum = temp;
                }
            }
        }
        return sum;
    }
}