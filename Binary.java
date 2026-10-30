import java.util.Arrays;
import java.util.Scanner;
public class BinarySearch {
public static void main(String[] args) {
System.out.println("Sonam Barde | Batch A | 10 - Binary Search OP");
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
Arrays.sort(arr);
System.out.print("\nSorted list: ");
for (int i = 0; i < n; i++) {
System.out.print(arr[i] + " ");
}
System.out.print("\nEnter element to search: ")
int key = sc.nextInt();
int low = 0;
int high = n - 1;
int position = -1;
while (low <= high) {
int mid = (low + high) / 2;
if (arr[mid] == key) {
position = mid;
break;
}
else if (key > arr[mid]) {
low = mid + 1;
}
else {
high = mid - 1;
}
}
if (position != -1) {
System.out.println("Element " + key +" found at sorted index " + position);
}
else {
System.out.println("Element " + key +" not found.");
}
sc.close();
}
}
