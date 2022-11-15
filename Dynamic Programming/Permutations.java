package tiresome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Permutations permutations = new Permutations();
        int size;

        System.out.print("ENTER SIZE : ");
        size = scanner.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) array[i] = scanner.nextInt();

        List<Integer> permutation = new ArrayList<>();
        Boolean[] positions = new Boolean[size];
        Arrays.fill(positions, Boolean.FALSE);

        permutations.generate(array, permutation, positions);

    }

    private void generate(int[] array, List<Integer> perm, Boolean[] positions) {

        if (perm.size() == array.length) System.out.println(perm);
        else {
            for (int i = 0; i < array.length; i++) {
                if (positions[i] == Boolean.TRUE)
                    continue;
                perm.add(array[i]);
                positions[i] = Boolean.TRUE;
                generate(array, perm, positions);
                perm.remove(perm.size() - 1);
                positions[i] = Boolean.FALSE;
            }
        }
    }
}
