import java.util.ArrayList;

public class MinOp {
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private int numOp = 0;

    public int minimumOperationsNeeded(Number[] arrNum) {
        for (Number n : arrNum) {
            list.add(n.intValue());
        }
        
        while (!allZero()) {
            while (searchOdd() != list.size()) {
                list.set(searchOdd(), list.get(searchOdd()) - 1);
                numOp++;
            }
            if (!allZero()) {
                for (int i = 0; i < list.size(); i++) {
                    list.set(i, list.get(i) / 2);
                }
                numOp++;
            }
        }

        return numOp;
    }

    private int searchOdd() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 1) return i;
        }
        return list.size();
    }

    private boolean allZero() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) return false;
        } return true;
    }
}