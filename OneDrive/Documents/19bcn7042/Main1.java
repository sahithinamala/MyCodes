//tsp using greedy algorithm
import java.util.*;

public class Main1
{
  public static void main (String[]args)
  {
    Main1 m = new Main1 ();
    Scanner sc = new Scanner (System.in);
      System.out.println ("Enter the size of array");
    int n = sc.nextInt ();
      System.out.println ("Enter the length between the nodes");
    int t[][] = new int[n][n];
    for (int i = 0; i < n; i++)
      {
	for (int j = 0; j < n; j++)
	  {
	    t[i][j] = sc.nextInt ();
	  }
      }
//function call
    m.MinimumRoute (t); //finding the minimum route
  }

//to find the minimum
  static void MinimumRoute (int t[][])
  {
     
    int sum = 0;
    int c = 0;
    int j = 0, i = 0;
    int min = Integer.MAX_VALUE;
    List < Integer > v = new ArrayList <> ();

    v.add (0);
    int[] r = new int[t.length];
 // Traverse the adjacency
  // matrix tsp[][]
    while (i < t.length && j < t[i].length)
      {
	if (c >= t[i].length - 1)
	  {
	    break;
	  }
// If this path is unvisited then and if the cost is less then update the cost
	if (j != i && !(v.contains (j)))
	  {
	    if (t[i][j] < min)
	      {
		min = t[i][j];
		r[c] = j + 1;
	      }
	  }
	j++;
	if (j == t[i].length)
	  {
	    sum += min;
	    min = Integer.MAX_VALUE;
	    
	    v.add (r[c] - 1);
	    j = 0;
	    i = r[c] - 1;
	    
	    c++;
	  }
	  
      }
      System.out.println("Path"); //printing path
	  System.out.println(v );

    i = r[c - 1] - 1; //update

    for (j = 0; j < t.length; j++)
      {

	if ((i != j) && t[i][j] < min)
	  {
	    min = t[i][j];
	    r[c] = j + 1;
	  }
	  
      }
    sum += min;
    System.out.println ("Least Cost is : ");
    System.out.println (sum);
    
    
  }


}