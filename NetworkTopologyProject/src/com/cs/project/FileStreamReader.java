/**
 * 
 */
package com.cs.project;

import java.io.FileReader;
import java.util.Scanner;

/**
 * @author hossaa01
 *
 */
public class FileStreamReader {

	/**
	 * 
	 */
	
	private FileStreamReader streamReader;
	
	
	public FileStreamReader() {
		// TODO Auto-generated constructor stub
	}
	
	public FileStreamReader(FileStreamReader FileStreamReader) {
		// TODO Auto-generated constructor stub
		
		this.streamReader = streamReader;
	}

	public void readFileAndPrint(String filePath){
		
		FileReader inReader = null;
		String inLine = null;
		Scanner scan = null;
		
		try {
			
			inReader = new FileReader(filePath);
			scan =new Scanner(inReader);
	         
	        while (scan.hasNext()){
	        	inLine = scan.nextLine();
	        	System.out.println(inLine);
	        }
	         
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	        
	}
	
public int[][] readAndStoreFile(String filePath){
		
		FileReader inReader = null;
		String inLine = null;
		Scanner scan = null;
		int adjacency_matrix[][] = null;
		
		try {
			
			inReader = new FileReader(filePath);
			scan =new Scanner(inReader);
	        int number_of_nodes;
	        int i = 0;
	        while (scan.hasNext()){
	        	inLine = scan.nextLine();
	        	
	        	i++;
	        	
	        	int l = 0;
	        	
	        	String numStrings[] = inLine.split(" ");
	        	number_of_nodes = numStrings.length;
	        	
	        	// initialize the matrix using the number of edges +1
	        	if (i == 1)
	        		adjacency_matrix = new int[number_of_nodes + 1][number_of_nodes + 1];
	        	
                for (int j = 1; j <= number_of_nodes; j++)
                 {
                	 adjacency_matrix[i][j] = Integer.parseInt(numStrings[l]);
                	 l++;
                     if (i == j)
                     {
                         adjacency_matrix[i][j] = 0;
                         continue;
                     }
                     if (adjacency_matrix[i][j] <= 0 )
                     {
                         adjacency_matrix[i][j] =  Integer.MAX_VALUE;
                     }
                 } 
	            
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return adjacency_matrix;
		
	        
	}

public int getNumberofNodes(String filePath){
	FileReader inReader = null;
	String inLine = null;
	Scanner scan = null;
	int nodes = 0;
	
	try {
		
		inReader = new FileReader(filePath);
		scan =new Scanner(inReader);
        
        while (scan.hasNext()){
        	inLine = scan.nextLine();
        	String numStrings[] = inLine.split(" ");
        	nodes = numStrings.length;
        }
	}
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
	
	return nodes;
	
}
}
