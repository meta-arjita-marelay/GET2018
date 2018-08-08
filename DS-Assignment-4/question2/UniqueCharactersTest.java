package question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharactersTest {
	UniqueCharacters uniqueCharacters = new UniqueCharacters();

	@Test
	public void testUniqueCharacter() throws InvalidInput {
		int result = uniqueCharacters.computeUniqueCharacters("abcdef");
		assertEquals(6, result);
	}

	@Test
	public void testUniqueCharacterNegative() throws InvalidInput {
		int result = uniqueCharacters.computeUniqueCharacters("abcdef");
		assertNotEquals(7, result);
	}

	@Test
	public void testSameCharacter() throws InvalidInput {
		int result = uniqueCharacters.computeUniqueCharacters("abcdddef");
		assertEquals(6, result);
	}

	@Test
	public void testSameButDifferentCaseCharacter() throws InvalidInput {
		int result = uniqueCharacters.computeUniqueCharacters("abcddDDef");
		assertEquals(6, result);
	}

	@Test
	public void testWithSpace() throws InvalidInput {
		int result = uniqueCharacters.computeUniqueCharacters("abcddDD     ef");
		assertEquals(6, result);
	}

	@Test
	public void testWithSpecialCharacters() throws InvalidInput {
		int result = uniqueCharacters
				.computeUniqueCharacters("abcddDD  ^^   ef");
		assertEquals(7, result);
	}

	@Test
	public void testCachePresenceTest() throws InvalidInput {
		uniqueCharacters.computeUniqueCharacters("abcdef");
		assertTrue(uniqueCharacters.getCache().ifStringPresent("abcdef"));
	}

	@Test(expected = InvalidInput.class)
	public void testInvalidInput() throws InvalidInput {
		int result = uniqueCharacters.computeUniqueCharacters(null);
		assertEquals(7, result);
	}

	@Test
	public void testWithZeroCharacters() throws InvalidInput {
		int result = uniqueCharacters.computeUniqueCharacters("");
		assertEquals(0, result);
	}

	@Test
	public void testWithOnlyWhiteSpaceCharacters() throws InvalidInput {
		int result = uniqueCharacters.computeUniqueCharacters("     ");
		assertEquals(0, result);
	}
}
