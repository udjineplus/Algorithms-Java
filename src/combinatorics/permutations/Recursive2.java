package combinatorics.permutations;

import java.util.*;

public class Recursive2 implements Iterable<List<Integer>> {

    private final int MAX_ITEMS;
    private final int MAX_PERMUTE;
    private static final List<Integer> P = new ArrayList<>();

    private int permuteId;
    private List<Deque<Integer>> result;

    Recursive2(int maxItems) {
        this.MAX_ITEMS = maxItems;
        this.MAX_PERMUTE = factorial(maxItems);
        state = new Integer[] {0,0,0,0};
        init();
    }

    private void init() {
        permuteId = 0;
        for (int i = 0; i < MAX_ITEMS; i++) {
            P.add(i + 1);
        }
        result = permute(P);
    }

    public static void main(String[] args) {
        Recursive2 recursive = new Recursive2(4);
        int i = 0;
        for (List<Integer> item : recursive) {
            System.out.println(Arrays.toString(item.toArray()));
            i++;
        }
        System.out.println(i);
    }

    /**
     * типа хранить тут состояние итераций массивов
     */
    // private Stack<Integer> stack = new Stack<>();
    private Integer[] state;
    private int recursiveCall = -1;

    private List<Deque<Integer>> permute(List<Integer> array) {
            recursiveCall++;
            List<Deque<Integer>> res = new ArrayList<Deque<Integer>>();
            for (int i = state[recursiveCall]; i < array.size(); i++) {
                Integer item = array.get(i);
                state[recursiveCall] = i;
                if(array.size() == 1) {
                    Deque<Integer> list = new ArrayDeque<>();
                    list.add(item);
                    res.add(list);
                    return res;
                }
                List<Integer> arrayWithOutItem = new ArrayList<Integer>(array);
                arrayWithOutItem.remove(item);
                List<Deque<Integer>> permuted = permute(arrayWithOutItem);

                for(int j = 0; j < permuted.size(); j++) {
                    Deque<Integer> permute = permuted.get(j);
                    permute.push(item);
                    res.add(permute);
                }
                recursiveCall--;
            }
            return res;

    }

    @Override
    public Iterator<List<Integer>> iterator() {
        return new Iterator<List<Integer>>() {
            @Override
            public boolean hasNext() {
                return permuteId != MAX_PERMUTE;
            }

            @Override
            public List<Integer> next() {
                List<Integer> res = new ArrayList<>();
                for (Integer item : result.get(permuteId)) {
                    res.add(item);
                }
                permuteId++;
                return res;
            }
        };
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

}
