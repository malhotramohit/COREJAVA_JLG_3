package com.gs.ilp.mycollections;

public interface SimpleIterator {
	public boolean hasNext();

	public Object next();

	public Object currentElement();

	public Object remove();

	public void reset();
}