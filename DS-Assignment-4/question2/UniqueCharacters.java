package question2;

import java.util.HashSet;
import java.util.Set;

/**
 * UniqueCharacters contains cache and will compute the unique characters in
 * string
 * 
 * @author Arjita
 *
 */
public class UniqueCharacters {
	private Cache cache = new Cache();// cache object

	/**
	 * computeUniqueCharacters will compute number of unique characters in input
	 * string
	 * 
	 * @param inputString
	 *            whose number of unique characters is to be computed
	 * @return number of unique characters in string
	 * @throws InvalidInput
	 *             if string given is null
	 */
	public int computeUniqueCharacters(String inputString) throws InvalidInput {
		// check if input string is null
		if (inputString == null) {
			throw new InvalidInput("invalid input");
		}
		// temporary string with all characters in same cases and without white
		// space
		String string = inputString;
		string = string.replaceAll("\\s", "");
		string = string.toUpperCase();
		// check if inputString already present in cache then return the unique
		// number of characters after fetching from cache
		if (cache.ifStringPresent(inputString)) {
			return cache.resultOfString(inputString);
		}
		// temporary uniqueResult will store unique characters of input string
		// only
		Set<Character> uniqueResult = new HashSet<Character>();
		for (char character : string.toCharArray()) {
			uniqueResult.add(character);
		}
		// string and number of unique characters will be stored in cache
		cache.saveStringResult(inputString, uniqueResult.size());
		return uniqueResult.size();
	}

	public Cache getCache() {
		return cache;
	}

}
