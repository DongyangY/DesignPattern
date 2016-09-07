/*
 * The Adapter Pattern converts the interface of a class into another interface the clients expect.
 * Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
 */

public class EnumerationIterator implements Iterator {
    // Use composition
    Enumeration enumeration;

    public EnumerationIterator(Enumeration enumeration) {
	this.enumeration = enumeration;
    }

    public boolean hasNext() {
	return enumeration.hasMoreElements();
    }

    public Object next() {
	return enumeration.nextElement();
    }

    public void remove() {
	throw new UnsupportedOperationException();
    }
}
