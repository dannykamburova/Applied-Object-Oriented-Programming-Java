package problem1;

import java.util.*;

public class ArrayListTest {
    public static <E extends Comparable<E>> E max(E[][] list){
        E max = list[0][0];
        for(int i = 0; i < list.length; i++){
            List<E> row = Arrays.asList(list[i]);
            if(max.compareTo(Collections.max(row)) > 0){
                max = Collections.max(row);
            }
        }
        return max;
    }

    public static <E> void shuffle(ArrayList<E> list){
        Collections.shuffle(list);
    }

    public static <E extends Comparable<E>> E
            max(ArrayList<E> list){
        return Collections.max(list);
    }

    public static <E> ArrayList<E>
        removeDuplicates(ArrayList<E> list) {
        ArrayList<E> noDuplicates = new ArrayList<>();
        for(E e : list){
            //1vo reshenie
            if(Collections.frequency(noDuplicates, e) == 0){
            //if(!noDuplicates.contains(e)){ // 2ro reshenie
                noDuplicates.add(e);
            }
        }
        //3to reshenie
        LinkedHashSet<E> set = new LinkedHashSet<>(list);
        noDuplicates.addAll(set);
        return noDuplicates;
    }

    public static void main(String[] args) {
        Integer[][] arr = new Integer[][]{
                {1,2,3},
                {4,15,6},
                {7,8,9}
        };
        System.out.println("Max: " + max(arr));

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,14,5,6,7,8,9,3,4,5,3));
        System.out.println("Max: " + max(list));
        shuffle(list);
        System.out.println("Elements: " + list);

        ArrayList<Integer> noDuplicates = removeDuplicates(list);
        System.out.println("No duplicates: " + noDuplicates);
    }
}
