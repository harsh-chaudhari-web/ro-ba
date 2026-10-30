import java.util.Scanner;
public class LinearSearch1 {
public static void main(String[] args) {
System.out.println("Sonam Barde | Batch A | 10 - Linear Search OP");
Scanner sc = new Scanner(System.in);
System.out.print("Enter number of elements: ");
int n = sc.nextInt();
int[] arr = new int[n];
System.out.println("Enter " + n + " elements:");
for (int i = 0; i < n; i++) {
arr[i] = sc.nextInt();
}
System.out.print("List of elements: ");
for (int i = 0; i < n; i++) {
System.out.print(arr[i] + " ");
}
System.out.print("\nEnter element to search: ");
int key = sc.nextInt();
int position = -1;
for (int i = 0; i < n; i++) {
if (arr[i] == key) {
position = i;
break;
}
}
if (position != -1) {
System.out.println("Element " + key+" found at index " + position);
}
else {
System.out.println("Element " + key + " not found.");
}
sc.close();
}
}
