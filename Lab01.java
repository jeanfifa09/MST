/* 
* Lab 01 - Prim's algorithm
* Submitted by:
* Jordan Germinal
*/

//package hw02;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException; 

public class Lab01 
{ 
  public void Lab01(double graph[][],int Vertices)
    { 
        MSTPRIM(graph,Vertices);
    }
    //Function to to find the minimum Key value
    int EXTRACTMIN(double key[], int  Set[],int Vertices) 
    { 
        // set minimum value to infinity 
        double minimum = Double.MAX_VALUE;
            int minimum_index=-1; 
            int i=0;
        while (i<Vertices)
        {  
            if (Set[i] == 0 && key[i] < minimum) 
            { 
                minimum = key[i]; 
                minimum_index = i;   
            } 
        i++;
        } 
     return minimum_index; 
    }
 
    // Function to build and print MST for a graph represented 
    void MSTPRIM(double W[][],int Vertices) 
    { 
        int i;
        // Key values used to pick minimum weight edge in cut 
        double key[] = new double [Vertices]; 
        // To represent set of vertices not yet included in MST 
       int Set[] = new int[Vertices]; 
        // Set all keys to infinity 
        for ( i = 0; i < Vertices; i++) 
        { 
            key[i] = Double.MAX_VALUE; 
            Set[i] = 0; 
          
        } 
        // array to hold parent value of MSt
        double pi[] = new double[Vertices]; 
        // Always include first 1st vertex in MST. 
        key[0] = 0;     // set first vertex to 0
          // Set the first node to -1     
        pi[0] = -1; 
     
       i=0;
       while (i<Vertices-1) 
       { 
            //Choose the minimum key vertex from the set
          
            int u = EXTRACTMIN(key, Set,Vertices); 
          
            // Add the picked vertex to the MST Set 
            Set[u] = 1; 
            // Change the  key value and pi index of the adjacent 
            for (int v = 0; v < Vertices; v++) 
            
                // Update value of key if less  graph[u][v] than Key[v] 
                if (W[u][v]!=0 && Set[v] == 0 && W[u][v] < key[v]) 
                { 
                    pi[v] = u; 
                    key[v] = W[u][v]; 
                } 
            i++;
        } 
        double total=0;
        for ( i = 1; i < Vertices; i++) 
        {  
            System.out.printf("%d-%d  %.5f \n",(int)pi[i],i,W[i][(int)pi[i]]);
            total+=W[i][(int)pi[i]];
        } 
         System.out.printf("%.5f\n",total);  
    } 
  
    public static void main (String[] args) throws FileNotFoundException, IOException 
    { 
        
        Lab01 mst = new Lab01(); 
        String arraystrings,arraystrings2,firstpart,secondpart,thirdpart;
        String filename= args[0];
       
        FileReader fr2 = new FileReader(filename);
        //The two required buffered Readers
        BufferedReader br2 = new BufferedReader(fr2);
        //First reader for file 
        FileReader fr = new FileReader(filename);
        //The required buffered Readers
        BufferedReader br = new BufferedReader(fr);
    
        int i,j,y=0,w=0;
        while((arraystrings2 = br2.readLine()) != null)
        {      
            if(y==0)
            { 
                String[] parts = arraystrings2.split("\\s");
                firstpart = parts[0]; 
                w=Integer.parseInt(firstpart);
            } 
        y++;
        }
        int Vertices=w;y=0;
        double graph[][] = new double[Vertices][Vertices];
        while((arraystrings = br.readLine()) != null)
        {
            String[] parts = arraystrings.split("\\s");
            if(y>=2)
            {
                // the three parts separated 1,2 and 3
                firstpart = parts[0]; 
                secondpart = parts[1];
                thirdpart =parts[2];
                int number1 = Integer.parseInt(firstpart);
                int number2 = Integer.parseInt(secondpart);
                double number3 = Double.parseDouble(thirdpart);
                graph[number1][number2]=number3;
                graph[number2][number1]=number3;      
            } 
            else if(y<2)
            {
            }
            y++;
        }
        for(i=0;i<5;i++)
        {
            for(j=0;j<5;j++)
            {          
            }   
        }
      // Print the solution 
        mst.Lab01(graph,Vertices); 
    }
}
