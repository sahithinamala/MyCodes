import java.util.*;
public class q1 {
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int a = sc.nextInt();
		int arr[] = new int[a];
        System.out.println("Enter elements of an array");
        for(int i = 0;i<a;i++)
        arr[i] = sc.nextInt();
		int n = arr.length;

		arranging(arr, n);
		printing(arr, n);
		
	}
	
	static void arranging(int arr[], int n)
	{
		int count = 0; 
	
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				count++;
		}
		for (int i = 0; i < count; i++)
			arr[i] = 0;
		for (int i = count; i < n; i++)
			arr[i] = 1;
	}
	
	static void printing(int arr[], int n)
	{
		System.out.print("Array after arranging is :");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
	

}

