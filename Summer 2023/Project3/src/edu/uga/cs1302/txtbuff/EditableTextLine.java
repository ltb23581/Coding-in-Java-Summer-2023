public class EditableTextLine extends TextLine implements Editable {

	// Super uses the TextLines default constructor
	EditableTextLine() {
		super();
	}

	// Super uses the TextLines constructor
	EditableTextLine(String line) {
		super(line);
	}

	/*
	 * Append has to be implemented since it exist in the Editable interface and
	 * adds text to the end of the text array
	 */
	public void append(String fragment) {
		// Finds the new total length of the array
		int total_Length = fragment.length() + length();
		// Increases the capacity if needed
		while (capacity < total_Length) {
			capacity = capacity + DEFAULT_SIZE;
		}
		// Creates a text_Replace array to store the new array
		char[] text_Replace = new char[capacity];
		// Fills the text_Replace array with the things current contained in text
		for (int i = 0; i < length; i++) {
			text_Replace[i] = text[i];
		}
		// Adds the fragment to the end of the text array
		for (int i = 0; i < fragment.length(); i++) {
			text_Replace[i + length()] = fragment.charAt(i);
		}
		// Changes the length to the appropriate length
		length = total_Length;
		text = text_Replace;
	}

	/*
	 * Insert has to be implemented since it exist in the Editable interface and
	 * inserts text anywhere in the text array except at the end of the array since
	 * append already does that
	 */
	public void insert(int index, String fragment) throws TextLineIndexOutOfBoundsException {
		/*
		 * If the index is out of range the program will throw an error and exits the
		 * program
		 */
		TextLineIndexOutOfBoundsException error = new TextLineIndexOutOfBoundsException("Input value is out of range");
		if (index < 0 || index > (length() - 1)) {
			throw error;
		}
		// Finds the new total length of the array
		int total_Length = fragment.length() + length();
		// Increases the capacity if needed
		while (capacity < total_Length) {
			capacity = capacity + DEFAULT_SIZE;
		}
		// Creates a new array to place the new text in
		char[] text_Replace = new char[capacity];
		/*
		 * Creates index to keep track of the old text's array and fragments strings
		 * current index
		 */
		int index_Old_Line = 0;
		int index_Add_Line = 0;
		for (int i = 0; i < total_Length; i++) {
			// Adds the fragment in the index requested
			if (i >= index && i < fragment.length() + index) {
				text_Replace[i] = fragment.charAt(index_Add_Line);
				index_Add_Line++;
			} else {
				text_Replace[i] = text[index_Old_Line];
				index_Old_Line++;
			}
		}
		// Updates the length and text
		length = total_Length;
		text = text_Replace;
	}

	/*
	 * Replace has to be implemented since it exist in the Editable interface and
	 * replaces text anywhere in the text array except at the end of the array
	 */
	public void replace(int start, int end, String fragment) throws TextLineIndexOutOfBoundsException {
		/*
		 * If the index is out of range the program will throw an error and exits the
		 * program
		 */
		TextLineIndexOutOfBoundsException error = new TextLineIndexOutOfBoundsException("Input value is out of range");
		if (start < 0 || end > (length() - 1) || start > end) {
			throw error;
		}
		// Finds the new total length of the array
		int total_Length = length() - ((end + 1) - start);
		// Increases the capacity if needed
		while (capacity < total_Length) {
			capacity = capacity + DEFAULT_SIZE;
		}
		// Creates a new array to place the new text in
		char[] text_Replace = new char[capacity];
		/*
		 * Creates index to keep track of the old text's array current index
		 */
		int index_Old_Line = 0;
		for (int i = 0; i < length(); i++) {
			// Removes the text in between the start and end
			if (i >= start && i <= end) {

			} else {
				text_Replace[index_Old_Line] = text[i];
				index_Old_Line++;
			}
		}
		// Updates the length and text
		length = total_Length;
		text = text_Replace;
		/*
		 * uses the insert method to insert the fragment into the text
		 */
		if (start == length) {
			append(fragment);
		} else {
			insert(start, fragment);
		}
	}
}
