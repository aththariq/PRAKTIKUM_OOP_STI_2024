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
                int temp = sum.shortValue() + num.shortValue();
                if (temp > Short.MAX_VALUE) {
                    sum = Short.MAX_VALUE;
                } else if (temp < Short.MIN_VALUE) {
                    sum = Short.MIN_VALUE;
                } else {
                    sum = (short)temp;
                }
            } else if (num instanceof Integer) {
                long temp = (long)sum.intValue() + num.intValue();
                if (temp > Integer.MAX_VALUE) {
                    sum = Integer.MAX_VALUE;
                } else if (temp < Integer.MIN_VALUE) {
                    sum = Integer.MIN_VALUE;
                } else {
                    sum = (int)temp;
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
                if (sum.floatValue() > 0 && num.floatValue() > 0 && temp < 0) {
                    sum = Float.MAX_VALUE;
                } else if (sum.floatValue() < 0 && num.floatValue() < 0 && temp > 0) {
                    sum = Float.MIN_VALUE;
                } else {
                    sum = temp;
                }
            } else if (num instanceof Double) {
                double temp = sum.doubleValue() + num.doubleValue();
                if (sum.doubleValue() > 0 && num.doubleValue() > 0 && temp < 0) {
                    sum = Double.MAX_VALUE;
                } else if (sum.doubleValue() < 0 && num.doubleValue() < 0 && temp > 0) {
                    sum = Double.MIN_VALUE;
                } else {
                    sum = temp;
                }
            }
        }
        return sum;
    }
}