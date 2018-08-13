package question;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.Test;

@SuppressWarnings("unused")
public class BinarySearchTreeTest {
	@Test
	public void testSort() throws CustomException, FileNotFoundException,
			IOException, ParseException {
		BinarySearchTree<String> bst = new BinarySearchTree<String>(
				"C:/Users/hp/Downloads/bstinput.json.txt");
		List<Node<String>> result = bst.sortedOrder();
		List <Node<String>> expectedResult = new ArrayList<Node<String>>();
		expectedResult.add(new Node("apple","fruit"));
		expectedResult.add(new Node("cat","animal"));
		expectedResult.add(new Node("cricket","game"));
		expectedResult.add(new Node("hi","hello"));
		expectedResult.add(new Node("mango","fruit"));
		expectedResult.add(new Node("neck","organ"));
		expectedResult.add(new Node("nest","bird home"));
		expectedResult.add(new Node("tarzan","fictional character"));
		expectedResult.add(new Node("zoo","animal house"));

		for (int i = 0; i < result.size(); i++) {
			assertEquals(expectedResult.get(i).getKey(),result.get(i).getKey());
			assertEquals(expectedResult.get(i).getValue(),result.get(i).getValue());
		}
	}

	@Test
	public void testSortBetweenKeys() throws CustomException, FileNotFoundException,
			IOException, ParseException {
		BinarySearchTree<String> bst = new BinarySearchTree<String>(
				"C:/Users/hp/Downloads/bstinput.json.txt");

		List<Node<String>> result = bst.sortBetweenTwoKeyValue("cricket", "neck");
		List <Node<String>> expectedResult = new ArrayList<Node<String>>();
		expectedResult.add(new Node("cricket","game"));
		expectedResult.add(new Node("hi","hello"));
		expectedResult.add(new Node("mango","fruit"));
		expectedResult.add(new Node("neck","organ"));
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expectedResult.get(i).getKey(),result.get(i).getKey());
			assertEquals(expectedResult.get(i).getValue(),result.get(i).getValue());
		}
	}
	@Test
	public void testDelete() throws ParseException, IOException, CustomException
	{
		BinarySearchTree<String> bst = new BinarySearchTree<String>(
				"C:/Users/hp/Downloads/bstinput.json.txt");
		TreeNode<String> result=bst.deleteNode("hi");
		assertEquals("cat",result.getNode().getKey());
	}
	@Test
	public void testGetValue() throws ParseException, IOException, CustomException
	{
		BinarySearchTree<String> bst = new BinarySearchTree<String>(
				"C:/Users/hp/Downloads/bstinput.json.txt");
		String result=bst.getValue("mango");
		assertEquals("fruit",result);
	}
	@Test(expected=CustomException.class)
	public void testGetValueError() throws ParseException, IOException, CustomException
	{
		BinarySearchTree<String> bst = new BinarySearchTree<String>(
				"C:/Users/hp/Downloads/bstinput.json.txt");
		String result=bst.getValue("arjita");
		assertEquals("fruit",result);
	}
	@Test(expected=AssertionError.class)
	public void testNode() throws ParseException, IOException
	{
		BinarySearchTree<String> bst = new BinarySearchTree<String>(
				"C:/Users/hp/Downloads/bstinput.json.txt");
		bst.addNode(null, null);
	}
	@Test(expected=CustomException.class)
	public void testDeleteError() throws ParseException, IOException, CustomException
	{
		BinarySearchTree<String> bst = new BinarySearchTree<String>(
				"C:/Users/hp/Downloads/bstinput.json.txt");
		TreeNode<String> result=bst.deleteNode("arjita");
	}
}
