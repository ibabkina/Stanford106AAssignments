package week6;

import acm.program.ConsoleProgram;

public class ExpandableArray extends ConsoleProgram {
	
	private Object[] array;
	
	/**
	* Creates a new expandable array with no elements. */
	public ExpandableArray() {
	//	You fill in the implementation . . .
		array = new Object[0]; 
	}
	
	/**
	* Sets the element at the given index position to the specified.
	* value. If the internal array is not large enough to contain that
	* element, the implementation expands the array to make room. */
	public void set(int index, Object value) {
	//	You fill in the implementation . . .
		if(index < array.length) { array[index] = value; }
		else {
			Object[] temp = new Object[index + 1]; 
			for(int i = 0; i < array.length; i++)
				temp[i] = array[i];
			array = temp;	
			array[index] = value;	
		}
	}
	/**
	* Returns the element at the specified index position, or null if
	* no such element exists. Note that this method never throws an
	* out-of-bounds exception; if the index is outside the bounds of * the array, the return value is simply null.
	*/
	public Object get(int index) {
	//	You fill in the implementation . . .
		if(array.length <= index) { return null; }
		else { return array[index]; }
	}
	
	public void run() {
		ExpandableArray myList = new ExpandableArray(); 
		
		myList.set(14, "Bob");
		myList.set(21, "Sally");
		
		String value = (String) myList.get(14); // Note the cast if (value != null) {
        println("Got value: " + value);
        
        value = (String) myList.get(21);
        println("Got value: " + value);
        
        value = (String) myList.get(13);
        println("Got value: " + value);
     }
}
