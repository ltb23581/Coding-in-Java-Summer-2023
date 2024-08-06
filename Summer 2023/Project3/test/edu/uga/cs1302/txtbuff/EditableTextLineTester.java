import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Assert.*;

import org.junit.Test;

public class EditableTextLineTester {

	@Test
	public void testAppend() {
		// Test appending nothing
		EditableTextLine line = new EditableTextLine("Hello");
		line.append("");
		assertEquals("Hello", line.toString());
	}

	@Test
	public void testAppend1() {
		// Test appending something
		EditableTextLine line = new EditableTextLine("Hello");
		line.append(" World");
		assertEquals("Hello World", line.toString());
	}

	@Test
	public void testAppend2() {
		// Test appending something that will increase capacity
		EditableTextLine line = new EditableTextLine(
				"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		line.append("i");
		assertEquals("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooi",
				line.toString());
	}

	@Test
	public void testInsert() throws TextLineIndexOutOfBoundsException {
		// Test inserting nothing
		EditableTextLine line = new EditableTextLine("Hello");
		line.insert(1, "");
		assertEquals("Hello", line.toString());
	}

	@Test
	public void testInsert1() throws TextLineIndexOutOfBoundsException {
		// Test inserting something at the beginning
		EditableTextLine line = new EditableTextLine("Hello");
		line.insert(0, "World");
		assertEquals("WorldHello", line.toString());
	}

	@Test
	public void testInsert2() throws TextLineIndexOutOfBoundsException {
		// Test inserting something in the middle
		EditableTextLine line = new EditableTextLine("Hello");
		line.insert(2, "World");
		assertEquals("HeWorldllo", line.toString());
	}

	@Test
	public void testInsert3() throws TextLineIndexOutOfBoundsException {
		// Test inserting something in the close to the end
		EditableTextLine line = new EditableTextLine("Hello");
		line.insert(4, "World");
		assertEquals("HellWorldo", line.toString());
	}

	@Test
	public void testInsert4() throws TextLineIndexOutOfBoundsException {
		// Test inserting something that will increase capacity
		EditableTextLine line = new EditableTextLine(
				"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		line.insert(4, "i");
		assertEquals("ooooioooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo",
				line.toString());
	}

	@Test(expected = TextLineIndexOutOfBoundsException.class)
	public void testInsert5() throws TextLineIndexOutOfBoundsException {
		// Test inserting something out of range to throw an error
		EditableTextLine line = new EditableTextLine("hello");
		line.insert(5, "i");
	}

	@Test(expected = TextLineIndexOutOfBoundsException.class)
	public void testInsert6() throws TextLineIndexOutOfBoundsException {
		// Test inserting something out of range to throw an error
		EditableTextLine line = new EditableTextLine("hello");
		line.insert(-1, "i");
	}

	@Test
	public void testReplace() throws TextLineIndexOutOfBoundsException {
		// Test replacing nothing
		EditableTextLine line = new EditableTextLine("hello");
		line.replace(0, 0, "");
		assertEquals("ello", line.toString());
	}

	@Test
	public void testReplace1() throws TextLineIndexOutOfBoundsException {
		// Test replacing with something equal in size
		EditableTextLine line = new EditableTextLine("hello");
		line.replace(0, 0, "p");
		assertEquals("pello", line.toString());
	}

	@Test
	public void testReplace2() throws TextLineIndexOutOfBoundsException {
		// Test replacing with something larger
		EditableTextLine line = new EditableTextLine("hello");
		line.replace(0, 0, "pillow");
		assertEquals("pillowello", line.toString());
	}

	@Test
	public void testReplace3() throws TextLineIndexOutOfBoundsException {
		// Test replacing something in the middle
		EditableTextLine line = new EditableTextLine("hello");
		line.replace(3, 3, "p");
		assertEquals("helpo", line.toString());
	}

	@Test
	public void testReplace4() throws TextLineIndexOutOfBoundsException {
		// Test replacing something at the end
		EditableTextLine line = new EditableTextLine("hello");
		line.replace(4, 4, "p");
		assertEquals("hellp", line.toString());
	}

	@Test
	public void testReplace5() throws TextLineIndexOutOfBoundsException {
		// Test replacing everything
		EditableTextLine line = new EditableTextLine("hello");
		line.replace(0, 4, "pillows");
		assertEquals("pillows", line.toString());
	}

	@Test
	public void testReplace6() throws TextLineIndexOutOfBoundsException {
		// Test replacing a portion
		EditableTextLine line = new EditableTextLine("hello");
		line.replace(2, 3, "ww");
		assertEquals("hewwo", line.toString());
	}

	@Test
	public void testReplace7() throws TextLineIndexOutOfBoundsException {
		// Test replacing something that will increase the capacity
		EditableTextLine line = new EditableTextLine(
				"oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		line.replace(1, 1, "ii");
		assertEquals("oiioooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo",
				line.toString());
	}

	@Test
	public void testReplace8() throws TextLineIndexOutOfBoundsException {
		// Test replacing something that will keep the increased capacity the same
		EditableTextLine line = new EditableTextLine(
				"ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooi");
		line.replace(80, 80, "");
		assertEquals("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo",
				line.toString());
	}

	@Test(expected = TextLineIndexOutOfBoundsException.class)
	public void testReplace9() throws TextLineIndexOutOfBoundsException {
		// Test replacing throwing error if start below out of bounds
		EditableTextLine line = new EditableTextLine("Hello");
		line.replace(-1, 3, "");

	}

	@Test(expected = TextLineIndexOutOfBoundsException.class)
	public void testReplace10() throws TextLineIndexOutOfBoundsException {
		// Test replacing throwing error if start is above out of bounds
		EditableTextLine line = new EditableTextLine("Hello");
		line.replace(5, 3, "");

	}

	@Test(expected = TextLineIndexOutOfBoundsException.class)
	public void testReplace11() throws TextLineIndexOutOfBoundsException {
		// Test replacing throwing error if end is below out of bounds
		EditableTextLine line = new EditableTextLine("Hello");
		line.replace(0, -1, "");

	}

	@Test(expected = TextLineIndexOutOfBoundsException.class)
	public void testReplace12() throws TextLineIndexOutOfBoundsException {
		// Test replacing throwing error if both below out of bounds
		EditableTextLine line = new EditableTextLine("Hello");
		line.replace(-1, -1, "");

	}

	@Test(expected = TextLineIndexOutOfBoundsException.class)
	public void testReplace13() throws TextLineIndexOutOfBoundsException {
		// Test replacing throwing error if both above out of bounds
		EditableTextLine line = new EditableTextLine("Hello");
		line.replace(5, 5, "");

	}

	@Test(expected = TextLineIndexOutOfBoundsException.class)
	public void testReplace14() throws TextLineIndexOutOfBoundsException {
		// Test replacing throwing error if start is above and end is below
		EditableTextLine line = new EditableTextLine("Hello");
		line.replace(5, -1, "");

	}

	@Test
	public void testLength() {
		// test if length is 0 when created without text
		EditableTextLine line = new EditableTextLine();
		assertEquals(0, line.length());
	}

	@Test
	public void testLength1() {
		// test if length is 5 when created with text
		EditableTextLine line = new EditableTextLine("Hello");
		assertEquals(5, line.length());
	}

	@Test
	public void testLength2() {
		// test if length is 80 when created with text size 80
		EditableTextLine line = new EditableTextLine(
				"12345678901234567890123456789012345678901234567890123456789012345678901234567890");
		assertEquals(80, line.length());
	}

	@Test
	public void testLength3() {
		// test if length is 81 when created with text size 81
		EditableTextLine line = new EditableTextLine(
				"123456789012345678901234567890123456789012345678901234567890123456789012345678901");
		assertEquals(81, line.length());
	}

	@Test
	public void testCapacity() {
		// test if capacity is 80 when created without text
		EditableTextLine line = new EditableTextLine();
		assertEquals(80, line.capacity());
	}

	@Test
	public void testCapacity1() {
		// test if capacity is 80 when created with text
		EditableTextLine line = new EditableTextLine("Hello");
		assertEquals(80, line.capacity());
	}

	@Test
	public void testCapacity2() {
		// test if capacity is 80 when created with text size 80
		EditableTextLine line = new EditableTextLine(
				"12345678901234567890123456789012345678901234567890123456789012345678901234567890");
		assertEquals(80, line.capacity());
	}

	@Test
	public void testCapacity3() {
		// test if capacity is 160 when created with text size 81
		EditableTextLine line = new EditableTextLine(
				"123456789012345678901234567890123456789012345678901234567890123456789012345678901");
		assertEquals(160, line.capacity());
	}

	@Test
	public void testIndexOfString() {
		// Test if this can find the whole text
		EditableTextLine line = new EditableTextLine("Hello");
		assertEquals(0, line.indexOf("Hello"));
	}

	@Test
	public void testIndexOfString1() {
		// Test if this returns -1 since hellos does not exist but hello does
		EditableTextLine line = new EditableTextLine("Hello");
		assertEquals(-1, line.indexOf("Hellos"));
	}

	@Test
	public void testIndexOfString2() {
		// Test if it can find the first case of l
		EditableTextLine line = new EditableTextLine("Hello");
		assertEquals(2, line.indexOf("l"));
	}

	@Test
	public void testIndexOfStringInt() throws TextLineIndexOutOfBoundsException {
		// Test if this can find the whole text
		EditableTextLine line = new EditableTextLine("Hello");
		assertEquals(0, line.indexOf("Hello", 0));

	}

	@Test
	public void testIndexOfStringInt1() throws TextLineIndexOutOfBoundsException {
		// Test if it can not find the text
		EditableTextLine line = new EditableTextLine("Hello");
		assertEquals(-1, line.indexOf("Hello", 1));
	}

	@Test
	public void testIndexOfStringInt2() throws TextLineIndexOutOfBoundsException {
		// Test if it can find the first case of l
		EditableTextLine line = new EditableTextLine("Hello");
		assertEquals(2, line.indexOf("l", 1));
	}

	@Test
	public void testIndexOfStringInt3() throws TextLineIndexOutOfBoundsException {
		// Test if it can find the second case of l
		EditableTextLine line = new EditableTextLine("Hello");
		assertEquals(3, line.indexOf("l", 3));
	}

	@Test(expected = TextLineIndexOutOfBoundsException.class)
	public void testIndexOfStringInt4() throws TextLineIndexOutOfBoundsException {
		// Test if indexofstring can throw an exception
		EditableTextLine line = new EditableTextLine("Hello");
		line.indexOf("l", 7);

	}

	@Test(expected = TextLineIndexOutOfBoundsException.class)
	public void testIndexOfStringInt5() throws TextLineIndexOutOfBoundsException {
		// Test if indexofstring can throw an exception
		EditableTextLine line = new EditableTextLine("Hello");
		line.indexOf("l", -1);

	}

	@Test
	public void testEqualsObject() {
		// Test if equals can detect if equals is
		EditableTextLine line = new EditableTextLine("Hello");
		EditableTextLine line1 = new EditableTextLine("Hello");
		assertTrue(line.equals(line1));
	}

	@Test
	public void testToString() {
		// Test if toString will print the correct text
		EditableTextLine line = new EditableTextLine("Hello");
		assertEquals("Hello", line.toString());
	}

}
