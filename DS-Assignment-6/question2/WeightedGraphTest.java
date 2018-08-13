package question2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WeightedGraphTest {

	@Test
	public void testIsConnected() throws InvalidInput {
		WeightedGraph weightedGraph = new WeightedGraph(4);
		weightedGraph.addEdge(0, 1,1);
		weightedGraph.addEdge(0, 2,1);
		weightedGraph.addEdge(0, 3,1);
		weightedGraph.addEdge(3, 1,1);
		assertEquals(true, weightedGraph.isConnected());
	}
	@Test
	public void testReachable() throws InvalidInput {
		WeightedGraph weightedGraph = new WeightedGraph(4);
		weightedGraph.addEdge(0, 1,1);
		weightedGraph.addEdge(0, 2,1);
		weightedGraph.addEdge(0, 3,1);
		weightedGraph.addEdge(3, 1,1);
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(1);
		result.add(2);
		result.add(3);
		assertEquals(result, weightedGraph.reachable(0));
	}
	@Test
	public void testMst() throws InvalidInput {
		WeightedGraph weightedGraph = new WeightedGraph(4);
		weightedGraph.addEdge(0, 1,1);
		weightedGraph.addEdge(0, 2,1);
		weightedGraph.addEdge(0, 3,1);
		weightedGraph.addEdge(3, 1,1);
		int[] result= new int[4];
		result=weightedGraph.mst();
		for(int i=0;i<result.length;i++)
		{
			System.out.println(result[i]);
		}
		assertArrayEquals(result, weightedGraph.mst());
	}
}
