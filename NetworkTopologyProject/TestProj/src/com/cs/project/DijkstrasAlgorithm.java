package com.cs.project;

import java.util.HashSet;
import java.util.Iterator;

import org.omg.CORBA.INTERNAL;

public class DijkstrasAlgorithm {

	private int nodes;
	private int[] distances;
	private HashSet<Integer> settledList;
	private HashSet<Integer> unsettledList;
	private int[][] newAdjacencyMatrix;

	public DijkstrasAlgorithm(int nodes) {
		// TODO Auto-generated constructor stub
		 	this.nodes = nodes;
	        distances = new int[nodes + 1];
	        settledList = new HashSet<Integer>();
	        unsettledList = new HashSet<Integer>();
	        newAdjacencyMatrix = new int[nodes + 1][nodes + 1];
	}
	
	public void dijkstraAlgorithm(int adjacency_matrix[][], int source)
    {
        int evalNode;
        for (int i = 1; i <= nodes; i++)
            for (int j = 1; j <= nodes; j++)
                newAdjacencyMatrix[i][j] = adjacency_matrix[i][j];
 
        for (int i = 1; i <= nodes; i++)
        {
            distances[i] = Integer.MAX_VALUE;
        }
 
        unsettledList.add(source);
        distances[source] = 0;
        while (!unsettledList.isEmpty())
        {
        	evalNode = getNodeWithMinimumDistanceFromUnsettled();
        	unsettledList.remove(evalNode);
            settledList.add(evalNode);
            evaluateNeighbourNodes(evalNode);
        } 
    }
	private int getNodeWithMinimumDistanceFromUnsettled()
    {
        int min ;
        int node = 0;
 
        Iterator<Integer> iterator = unsettledList.iterator();
        node = iterator.next();
        min = distances[node];
        for (int i = 1; i <= distances.length; i++)
        {
            if (unsettledList.contains(i))
            {
                if (distances[i] <= min)
                {
                    min = distances[i];
                    node = i;			
                }
            }
        }
        return node;
    }
	private void evaluateNeighbourNodes(int evalNode)
    {
        int edgeDistance = -1;
        int newDistance  = -1;
 
        for (int destinationNode = 1; destinationNode <= nodes; destinationNode++)
        {
            if (!settledList.contains(destinationNode))
            {
                if (newAdjacencyMatrix[evalNode][destinationNode] != Integer.MAX_VALUE)
                {
                    edgeDistance = newAdjacencyMatrix[evalNode][destinationNode];
                    newDistance = distances[evalNode] + edgeDistance;
                    if (newDistance < distances[destinationNode])
                    {
                    	distances[destinationNode] = newDistance;
                    }
                    unsettledList.add(destinationNode);
                }
            }
        }
    }
	
	public void printShortestPath(int sourceRouter,DijkstrasAlgorithm djsk){
		System.out.println("Shotrest Path to all nodes from source node :: ");
        for (int i = 1; i <= djsk.distances.length - 1; i++)
        {
            System.out.println(sourceRouter + " to " + i + " is "+ djsk.distances[i]);
        }
	}
	
	public void getShortestPathFromSourceToDestination(int sourceRouter,int destnationRouter, DijkstrasAlgorithm djsk){
		System.out.println("Shotrest Path to destination node from source node :: ");
		int val = 0;
        for (int i = 1; i <= djsk.distances.length - 1; i++)
        {
            if (i == destnationRouter){
            	if (djsk.distances[i] == Integer.MAX_VALUE)
            		val=-1;
            	else
            		val=djsk.distances[i];
            	System.out.println(sourceRouter + " to " + i + " is "+ val);
            }
        }
	}
	
	public void printRemovedRouterMatrix(int removedRouterMatrix[][] ){
		int printVal = 0;
		for (int i=1;i<removedRouterMatrix.length;i++){
			for (int j=1;j<removedRouterMatrix.length;j++){
				if (removedRouterMatrix[i][j] == Integer.MAX_VALUE )
					printVal = -1;
				else
					printVal = removedRouterMatrix[i][j];
				System.out.print(printVal + " ");
			}
				System.out.println();
		}
	}
}
