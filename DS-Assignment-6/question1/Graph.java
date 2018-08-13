package question1;

import java.util.List;

import question2.InvalidInput;

public interface Graph {
public boolean isConnected() throws InvalidInput;
public List<Integer> reachable(int node);
public int[] mst();
public int shortestPath(int source, int destination);
}
