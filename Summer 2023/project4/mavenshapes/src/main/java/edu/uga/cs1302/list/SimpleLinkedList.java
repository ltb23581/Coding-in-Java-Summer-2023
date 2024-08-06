import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.Iterator;
import java.io.Serializable;

/**
 * This class provides a simple generic list implmented as a doubly linked list.
 * It is similar to the LinkedList class included in the java.util package.
 *
 * The elements on the list are ordered, and the first element of the list is at
 * position 0 and the last element is at position list.size() - 1.
 */
public class SimpleLinkedList<E> implements SimpleList<E>, Iterable<E>, Serializable {
	private Node<E> first; // first node of the list
	private Node<E> last; // last node of the list
	private int count; // number of list elements
	private int modCount; // the total number of modifications
							// (add and remove calls)

	/**
	 * Creates an empty SimpleLinkedList.
	 */
	public SimpleLinkedList() {
		first = null;
		last = null;
		count = 0;
		modCount = 0;
	}

	/**
	 * Checks if this SimpleLinkedList is empty.
	 * 
	 * @return true if and only if the list is empty
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * Returns the number of elements in this SimpleLinkedList.
	 * 
	 * @return the number of elements in this list
	 */
	public int size() {
		return count;
	}

	/**
	 * Adds an element at the end of this list.
	 * 
	 * @param e the element to be added to the end of this list
	 * @return true
	 */
	public boolean add(E e) {
		Node<E> node = new Node<E>(e, last, null);

		if (last == null) // list is empty
			first = node;
		else
			last.next = node;
		last = node;
		count++;
		modCount++; // increase modification count; element added
		return true;
	}

	/**
	 * Adds an element at a specific index in the list
	 * 
	 * @param index the specific index to add the element to in the list
	 * @param e     the element to be added to the list
	 * @return true
	 */
	public boolean add(int index, E e) throws IndexOutOfBoundsException {
		// your code goes here...
		// checks if the index is out of bounds
		IndexOutOfBoundsException error = new IndexOutOfBoundsException("Input value is out of range");
		if (index < 0 || index > size())
			throw error;
		// creates a node which stores the element to be added into the list
		Node<E> node = new Node<E>(e, last, null);
		// creates a current that is equal to first and is used to traverse the list
		Node<E> current = first;
		// checks if the index is equal to the size or size is equal to 0
		if (index == size() || size() == 0) {
			/*
			 * if the index is equal to the size that means the element is added at the end
			 * of the list
			 */
			add(e);
			return true;
		}
		if (index == 0) {
			node.next = current;
			current = node;
			first = node;
			count++;
			modCount++;
			return true;
		}
		/*
		 * if not the for loop will traverse through the list to the specified location
		 */
		for (int i = 0; i < index - 1; i++)
			current = current.next;
		// once there the loop will make the next index equal to the current
		node.next = current.next;
		// the current is then equal to the node
		current.next = node;
		count++;
		modCount++;
		return true;
	}

	/**
	 * Returns the element of the list at the indicated position.
	 * 
	 * @param index the position of the list element to return
	 * @return the element at position index
	 * @throws IndexOutOfBoundsException if the index is &#60; 0 or &#62; the size
	 *                                   of the list.
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		validateIndex(index, count - 1); // must be an index of an existing element
		Node<E> node = getNodeAt(index);
		return node.elem;
	}

	/**
	 * removes the node from the list at a specific index
	 * 
	 * @param index the position of the node in the list to remove
	 * @return found which is a node that stores the removed node
	 */
	public E remove(int index) throws IndexOutOfBoundsException {
		// your code goes here...
		// if index out of bound throw an exception
		IndexOutOfBoundsException error = new IndexOutOfBoundsException("Input value is out of range");
		if (index < 0 || index >= size())
			throw error;
		// creates found to save the element that will be removed from the list
		Node<E> found;
		// creates current to use it to traverse through the list
		Node<E> current = first;
		// if the index is 0 remove the element at that index
		if (index == 0) {
			found = first;
			/*
			 * if size is equal to 1 the list will be empty so both first and last will be
			 * null
			 */
			if (size() == 1) {
				first = null;
				last = null;
				return found.elem;
			}
			// if size is not one remove the element by making first equal to its next
			first = current.next;
			return found.elem;
		}
		// traverse the list until it reaches the element just before the element to
		// remove
		for (int i = 0; i < index - 1; i++)
			current = current.next;
		// save the element to be removed
		found = current.next;
		// if the last element is the one that will be removed the last has to be
		// updated
		if (index == size() - 1) {
			current.next = null;
			last = current;
			count--;
			modCount++;
			return found.elem;
		}
		current.next = current.next.next;
		count--;
		modCount++;
		return found.elem; // you need to modify this return statement
	}

	/**
	 * Searches for the first instance of e and returns the index
	 * 
	 * @param e the element to search for
	 * @return index of the element
	 * @return -1 if the element does not exist in the list
	 */
	public int indexOf(E e) {
		// your code goes here...
		// current is used to traverse the list
		Node<E> current = first;
		int index = 0;
		// while loop will scan the whole list for the element
		while (current.next != null) {
			// if it finds an instance of e then returns the index of that location
			if (current.elem == e) {
				return index;
			}
			index++;
			current = current.next;
		}
		// checks the last index
		if (current.elem == e) {
			return index;
		}
		// returns -1 if the element does not exist in the list
		return -1;
	}

	/**
	 * Returns an Iterator of the list elements, starting at the beginning of this
	 * list.
	 * 
	 * @return the created Iterator
	 */
	public Iterator<E> iterator() {
		return new SimpleLinkedListIterator(0);
	}

	/**
	 * Returns a ListIterator of the list elements, starting at the given position
	 * in this list.
	 * 
	 * @param index the position of the first element on the list to be returned
	 *              from the iterator
	 * @return the created ListIterator
	 * @throws IndexOutOfBoundsException if the index is &#60; 0 or &#62; the size
	 *                                   of the list.
	 */
	public ListIterator<E> listIterator(int index) throws IndexOutOfBoundsException {
		validateIndex(index, count); // must be possible to insert after the last element
		return new SimpleLinkedListIterator(index);
	}

	// The methods and inner classes below are private, and are intended for
	// internal use only.

	// Return the node at a given index.
	// The argument, index, must be verified to be a legal index into this list.
	private Node<E> getNodeAt(int index) {
		Node<E> curr = first;
		for (int i = 0; i < index; i++)
			curr = curr.next;
		return curr;
	}

	// Verify that a given index is within bounds 0 through end.
	// The second argument, end, should be either count-1, if the given index must
	// be a valid index of an existing element, or count, if an insert is to be at
	// the end of a list, or an iterator starting at the right end of the list.
	private void validateIndex(int index, int end) {
		if (index < 0 || index > end)
			throw new IndexOutOfBoundsException("Illegal list index: " + index);
	}

	// This is a private nested class implementing a doubly-linked list node.
	// It makes sense for this class to be private, as it is only useful internally
	// to
	// the SimpleLinkedList class.
	// Because this class is private, so it is accessible only to the host class
	// SimpleLinkedList,
	// therefore, there is no need to define the variables as private.
	private static class Node<E> {
		E elem;
		Node<E> next;
		Node<E> prev;

		Node(E elem, Node<E> prev, Node<E> next) {
			this.elem = elem;
			this.next = next;
			this.prev = prev;
		}
	}

	/**
	 * This class provides an iterator for the SimpleLinkedList. Some methods have
	 * not been implemented intentaionlly; you are not expected to implement them.
	 */
	private class SimpleLinkedListIterator implements ListIterator<E> {
		private Node<E> currNode;
		private Node<E> previouslyReturned;
		private int currPos; // index of the element to be returned next
		private int expectedModCount; // the count of modifications at the time of this iteractor creation

		// Creates a new iterator starting at position index.
		// javadoc comment needed
		public SimpleLinkedListIterator(int index) {
			validateIndex(index, count); // verify the staring index; may be equal to count
			expectedModCount = modCount;
			previouslyReturned = null;
			if (count == 0)
				currNode = null;
			else
				currNode = getNodeAt(index);
			currPos = index;
		}

		// Returns true if this list iterator has more elements when traversing the list
		// forward.
		// javadoc comment needed
		public boolean hasNext() {
			return currPos < count;
		}

		// Returns true if this list iterator has more elements when traversing the list
		// in the reverse direction.
		// javadoc comment needed
		public boolean hasPrevious() {
			return currPos > 0;
		}

		// Returns the next element on the list.
		// May throw NoSuchElementException if the next element does not exist.
		public E next() {
			checkForComodification();
			if (currPos >= count || currNode == null)
				throw new NoSuchElementException();
			previouslyReturned = currNode;
			currPos++;
			currNode = currNode.next;
			return previouslyReturned.elem;
		}

		// Returns the index of the element that would be returned by a call to next.
		// javadoc comment needed
		public int nextIndex() {
			return currPos;
		}

		// Returns the previous element in the list.
		// javadoc comment needed
		public E previous() {
			checkForComodification();
			if (currPos <= 0)
				throw new NoSuchElementException();
			currPos--;
			if (currNode == null) {
				currNode = last;
				previouslyReturned = last;
				return previouslyReturned.elem;
			} else {
				currNode = currNode.prev;
				previouslyReturned = currNode;
				return previouslyReturned.elem;
			}
		}

		// Returns the index of the element that would be returned by a call to
		// previous.
		// javadoc comment needed
		public int previousIndex() {
			return currPos - 1;
		}

		// The following are optional operations which are not supported in the
		// SimpleLinkedList implementation.

		// Adds a new element
		// not implemented here
		public void add(Object e) {
			throw new UnsupportedOperationException("add called while iterating is not available");
		}

		// Removes from the list the last element that was returned by next or previous
		// (optional operation).
		// not implemented here
		public void remove() {
			throw new UnsupportedOperationException("remove called while iterating is not available");
		}

		// Replaces the last element returned by next or previous with the specified
		// element (optional operation).
		// not implemented here
		public void set(Object e) {
			throw new UnsupportedOperationException("set called while iterating is not available");
		}

		// check if there was a concurrent modification of the list contents.
		// if yes, throw a ConcurrentModificationException exception
		private final void checkForComodification() {
			if (expectedModCount != SimpleLinkedList.this.modCount)
				throw new ConcurrentModificationException("list modified while iterator is in progress");
		}
	}
}
