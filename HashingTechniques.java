import java.util.Scanner;
import java.util.Arrays;

public class HashingTechniques {
    static int moduloDivision(int key, int tableSize) {
        return Math.floorMod(key, tableSize);
    }

    // Digit extraction: choose 1-based positions counted from the right, in the order entered.
    static int digitExtraction(String key, String positions, int tableSize) {
        StringBuilder selected = new StringBuilder();
        for (String part : positions.trim().split("\\s+")) {
            int pos = Integer.parseInt(part);
            int index = key.length() - pos;
            if (index >= 0 && index < key.length()) selected.append(key.charAt(index));
        }
        if (selected.length() == 0) return 0;
        return Integer.parseInt(selected.toString()) % tableSize;
    }

    static int folding(String key, int groupSize, int tableSize, boolean boundary) {
        int sum = 0, groupNo = 0;
        for (int end = key.length(); end > 0; end -= groupSize) {
            int start = Math.max(0, end - groupSize);
            String chunk = key.substring(start, end);
            if (boundary && groupNo % 2 == 1) chunk = new StringBuilder(chunk).reverse().toString();
            sum += Integer.parseInt(chunk);
            groupNo++;
        }
        return sum % tableSize;
    }

    static void linearProbing(Scanner sc) {
        System.out.print("Enter table size: ");
        int size = sc.nextInt();
        if (size <= 0) { System.out.println("Table size must be positive."); return; }
        Integer[] table = new Integer[size];
        System.out.print("How many keys to insert? ");
        int n = sc.nextInt();
        for (int k = 0; k < n; k++) {
            System.out.print("Enter key: ");
            int key = sc.nextInt();
            int home = Math.floorMod(key, size), i = 0;
            while (i < size && table[(home + i) % size] != null) i++;
            if (i == size) System.out.println("Table full; could not insert " + key);
            else {
                int index = (home + i) % size;
                table[index] = key;
                System.out.println("Key " + key + " inserted at index " + index);
            }
        }
        System.out.println("Hash table (empty slot = -):");
        for (int i = 0; i < size; i++) System.out.println(i + " -> " + (table[i] == null ? "-" : table[i]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Modulo Division  2.Digit Extraction  3.Fold Shift  4.Fold Boundary  5.Linear Probing");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();
        if (choice == 5) { linearProbing(sc); sc.close(); return; }
        System.out.print("Enter positive table size: ");
        int size = sc.nextInt();
        if (size <= 0) { System.out.println("Table size must be positive."); sc.close(); return; }
        System.out.print("Enter non-negative key: ");
        String key = sc.next();
        if (!key.matches("\\d+")) { System.out.println("Enter digits only."); sc.close(); return; }
        int address;
        switch (choice) {
            case 1: address = moduloDivision(Integer.parseInt(key), size); break;
            case 2:
                System.out.print("Enter digit positions counted from the right (e.g. 1 3): ");
                sc.nextLine();
                String positions = sc.nextLine();
                address = digitExtraction(key, positions, size); break;
            case 3:
                System.out.print("Enter group size for folding: ");
                int g1 = sc.nextInt();
                if (g1 <= 0) { System.out.println("Group size must be positive."); sc.close(); return; }
                address = folding(key, g1, size, false); break;
            case 4:
                System.out.print("Enter group size for folding: ");
                int g2 = sc.nextInt();
                if (g2 <= 0) { System.out.println("Group size must be positive."); sc.close(); return; }
                address = folding(key, g2, size, true); break;
            default: System.out.println("Invalid option."); sc.close(); return;
        }
        System.out.println("Hash address = " + address);
        sc.close();
    }
}
