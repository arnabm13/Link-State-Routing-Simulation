package com.cs.project;

import java.util.Scanner;


public class ExecuteAlgorithm {

	public ExecuteAlgorithm() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int source = 0;
		int destination = 0;
		int removedRouter = 0;
		int removedRouterMatrix[][] = null;
		int numberOfNodes = 0;
		
		// This will read the input file and print on the console
		FileStreamReader f = new FileStreamReader();
		String path = "C:\\Project\\Input.txt";

		// This method will be used for option 1 of the user input to print the original matrix and return to the main menu.
		f.readFileAndPrint(path);
		int adjacency_matrix[][] = f.readAndStoreFile(path);
		
		System.out.println("Enter the source router ");
        source = scan.nextInt();
        
        //declaring and initialise the constructor
        numberOfNodes = f.getNumberofNodes(path);
        DijkstrasAlgorithm dijkstrasAlgorithm = new DijkstrasAlgorithm(numberOfNodes);
        
        //This method will determine the shortest path of each of the nodes from the source router
        dijkstrasAlgorithm.dijkstraAlgorithm(adjacency_matrix, source);
        
        // this method will print the shortest path of each of the nodes from the source router
        dijkstrasAlgorithm.printShortestPath(source, dijkstrasAlgorithm);
        
        //This will print the cost between source and destination router.
        System.out.println("Enter the destination router ");
        destination = scan.nextInt();
        dijkstrasAlgorithm.getShortestPathFromSourceToDestination(source, destination, dijkstrasAlgorithm);
        
        //This will print the new connetion table when a router is down.
        System.out.println("Select a router to be removed ");
        removedRouter = scan.nextInt();
        
        removedRouterMatrix = new int[f.getNumberofNodes(path)+1][f.getNumberofNodes(path)+1];
        
        for (int i=0; i<=f.getNumberofNodes(path);i++){
        	if (i==0)
        		continue;
        	
        	for (int j=0; j <= f.getNumberofNodes(path); j++)
            {	
        		if (j==0)
        			continue;
        		if(removedRouter == i && j!= removedRouter)
        			removedRouterMatrix[i][j] = Integer.MAX_VALUE;
        		else if (removedRouter != i && j == removedRouter)
                	removedRouterMatrix[i][j] = Integer.MAX_VALUE;
                else
                removedRouterMatrix[i][j] = adjacency_matrix[i][j];
                
            } 
        	
        }
       DijkstrasAlgorithm dijkstras = new DijkstrasAlgorithm(numberOfNodes);
        
       dijkstras.printRemovedRouterMatrix(removedRouterMatrix);
             
       if (destination == 0){
    	   System.out.println("Enter the destination router ");
           destination = scan.nextInt();
           dijkstras.dijkstraAlgorithm(removedRouterMatrix, source);
           dijkstras.getShortestPathFromSourceToDestination(source, destination, dijkstras);
       }
    	   
       else
       {
    	   dijkstras.dijkstraAlgorithm(removedRouterMatrix, source);
    	   dijkstras.getShortestPathFromSourceToDestination(source, destination, dijkstras);
       }
    	   
	}
	
}
