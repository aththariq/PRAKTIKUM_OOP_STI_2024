import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Set<String> set = new HashSet<>();
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            String s = input[i];
            char[] c = s.toCharArray();
            Arrays.sort(c);
            set.add(new String(c));
        }
        System.out.println(set.size());
    }
}