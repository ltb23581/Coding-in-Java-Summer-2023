import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Assert.*;
import org.junit.Test;

public class SimpleLinkedListTest
{

    /**
     * test if the add works in the middle of the list
     */
    @Test
    public void testAdd(){
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(3);
        list.add(1,2);
        assertEquals(2,list.get(1));
    }

    /**
     * Test if the add works in at the beginning of the list
     */
    @Test
    public void testAdd1(){
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(2);
        list.add(3);
        list.add(0,1);
        assertEquals(1,list.get(0));
    }
    /**
     * Test if add works at the end of the list
     */
    @Test
    public void testAdd2(){
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.add(2,3);
        assertEquals(3,list.get(2));
    }
    /**
     * this test for exceptions throw since index is less than 0
     * @throws Exception
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddException() throws IndexOutOfBoundsException {
SimpleLinkedList list = new SimpleLinkedList();
        list.add(5);
        list.add(6);
        list.add(-1, 4);
    }

    /**
     * this test for exceptions throw since index greater than size()
     * @throws Exception
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddException1() throws IndexOutOfBoundsException {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(10);
        list.add(2);
        list.add(3);
        list.add(5,4);
    }
     /**
     * test if the remove works in the middle of the list
     */
    @Test
    public void testRemove(){
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
 list.add(2);
        list.add(3);
        assertEquals(2,list.remove(1));
    }

    /**
     * Test if the add works in at the beginning of the list
     */
    @Test
    public void testRemove1(){
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1,list.remove(0));
    }
    /**
     * Test if add works at the end of the list
     */
    @Test
    public void testRemove2(){
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3,list.remove(2));
    }
    /**
     * Test if add works at the beginning of the list with a size of 1
     */
    @Test
    public void testRemove3(){
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        assertEquals(1,list.remove(0));
    }
    /**
     * this test for exceptions throw since index is less than 0
     * @throws Exception
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() throws IndexOutOfBoundsException {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(-1);
    }
    /**
     * this test for exceptions throw since index is greater that or equal to size()
     * @throws Exception
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException1() throws IndexOutOfBoundsException {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(3);
 }
    /**
     * test for index of an element that does not exist
     *
     */
    @Test
    public void testIndexOf(){
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(-1,list.indexOf(4));
    }

    /**
     * test for index of an element at the end of a list
     *
     */
    @Test
    public void testIndexOf1(){
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2,list.indexOf(3));
  }

    /**
     * test for index of an element at the beginning of a list
     *
     */
    @Test
    public void testIndexOf2(){
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(0,list.indexOf(1));
    }

    /**
     * test for index of an element at in the middle of a list
     *
     */
    @Test
    public void testIndexOf3(){
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
     assertEquals(1,list.indexOf(2));
    }
}
