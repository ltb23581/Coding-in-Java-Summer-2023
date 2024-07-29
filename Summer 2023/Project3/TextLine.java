
public class TextLine {

	// Variables required for the textline class
	public static final int DEFAULT_SIZE = 80;
	public int length;
	public char[] text;
	public int capacity;

	// Empty constructor creating an empty array
	public TextLine() {
		length = 0;
		capacity = DEFAULT_SIZE;
		text = new char[capacity];
	}

	// Constructor creating an array with the string contained in it
	public TextLine(String line) {
		length = line.length();
		capacity = DEFAULT_SIZE;
		// The while loop is used to create a larger capacity if needed
		while (length > capacity) {
			capacity = capacity + DEFAULT_SIZE;
		}
		text = new char[capacity];
		// Fills the array with the string
		for (int i = 0; i < length; i++) {
			text[i] = line.charAt(i);
		}
	}

	// Gets the length of the string
	public int length() {
		return length;
	}

	// Gets the capacity of the array
	public int capacity() {
		return capacity;
	}

	/*
	 * Checks if the fragment of text exist in the text and if it does return the
	 * starting index if not return -1
	 */
	public int indexOf(String fragment) {
		// Creates an array of the fragment string to use and check if the fragment is
		// contained in the text
		char[] fragment_Search = fragment.toCharArray();
		// Searches the entire array
		for (int i = 0; i < length() - 1; i++) {
			/*
			 * If a letter in the text is found that resembles the first letter of the
			 * fragment the index it will proceed to check if the reset of the text matches
			 * with the fragment text.
			 */
			if (fragment_Search[0] == text[i]) {
				int index_Position = i;
				// it uses fragment_Length to keep track of how many characters match up with
				// the text
				int fragment_Length = 1;
				i++;
				for (int j = 1; j < fragment.length() && i < length() && fragment_Search[j] == text[i]; j++) {
					i++;
					fragment_Length++;
				}
				/*
				 * if the fragment_Length equals the fragment's length then the fragment is
				 * found and it returns the starting index. If the fragment is not found the
				 * program continues to search until it either finds a match or doesn't
				 */
				if (fragment_Length == fragment_Search.length) {
					return index_Position;
				}
			}
		}
		// if a match is never found the program returns -1
		return -1;
	}

	/*
	 * Checks if the fragment of text exist in the text and if it does return the
	 * starting index if not return -1 starting from the fromIndex
	 */
	public int indexOf(String fragment, int fromIndex) throws TextLineIndexOutOfBoundsException {
		/*
		 * Checks if the fromIndex is in bounds of the text, if it is not it will throw
		 * an error and exit the program
		 */
		TextLineIndexOutOfBoundsException error = new TextLineIndexOutOfBoundsException("Input value is out of range");
		if (fromIndex < 0 || fromIndex > (length() - 1)) {
			throw error;
		}
		// Creates an array of the fragment string to use and check if the fragment is
		// contained in the text
		char[] fragment_Search = fragment.toCharArray();
		// The for loop will start at the fromIndex to start the search there
		for (int i = fromIndex; i < length() - 1; i++) {
			/*
			 * If a letter in the text is found that resembles the first letter of the
			 * fragment the index it will proceed to check if the reset of the text matches
			 * with the fragment text.
			 */
			if (fragment_Search[0] == text[i]) {
				int index_Position = i;
				// it uses fragment_Length to keep track of how many characters match up with
				// the text
				int fragment_Length = 1;
				i++;
				for (int j = 1; j < fragment.length() && i < length() && fragment_Search[j] == text[i]; j++) {
					i++;
					fragment_Length++;
				}
				/*
				 * if the fragment_Length equals the fragment's length then the fragment is
				 * found and it returns the starting index. If the fragment is not found the
				 * program continues to search until it either finds a match or doesn't
				 */
				if (fragment_Length == fragment_Search.length) {
					return index_Position;
				}
			}
		}
		// if a match is never found the program returns -1
		return -1;
	}

	// Checks if the object's text equals the text
	public boolean equals(Object obj) {
		String textLine = "";
		for (int i = 0; i < text.length - 1; i++) {
			textLine = textLine + text[i];
		}
		if (obj.toString().equals(textLine)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String textLine = "";
		for (int i = 0; i < text.length; i++) {
			textLine = textLine + text[i];
		}
		return textLine;
	}
}
