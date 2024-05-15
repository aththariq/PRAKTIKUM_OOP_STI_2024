import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deq = new ArrayDeque<>();

        int n = sc.nextInt();
        sc.nextLine();

        boolean isReverse = false;

        if (n >= 1 && n <= 100000) {
            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split(" ");
                if (input[0].equals("addFirst")) {
                    if (isReverse) {
                        deq.addLast(Integer.parseInt(input[1]));
                    } else {
                        deq.addFirst(Integer.parseInt(input[1]));
                    }
                } else if (input[0].equals("addLast")) {
                    if (isReverse) {
                        deq.addFirst(Integer.parseInt(input[1]));
                    } else {
                        deq.addLast(Integer.parseInt(input[1]));
                    }
                } else if (input[0].equals("reverse")) {
                    isReverse = !isReverse;
                } else if (input[0].equals("pollFirst")) {
                    if (deq.isEmpty()) {
                        System.out.println("Empty");
                    } else {
                        System.out.println(deq.pollFirst());
                    }
                } else if (input[0].equals("pollLast")) {
                    if (deq.isEmpty()) {
                        System.out.println("Empty");
                    } else {
                        System.out.println(deq.pollLast());
                    }
                }
            }
        }
    }
}
