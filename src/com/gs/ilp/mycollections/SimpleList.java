package com.gs.ilp.mycollections;


public interface SimpleList {


	/**
	 * Get will return object present at the given index else will return null
	 * 
	 * @param index
	 * @return
	 */
	public Object get(int index);

	void clear();

	/**
	 * Set will be used to replace or update the value at the given index else do
	 * nothing
	 * 
	 * @param index
	 * @param element
	 */
	public void set(int index, Object element);

	/**
	 * Add will be used to add the value at the given index and shift the rest of
	 * the values
	 * 
	 * @param index
	 * @param element
	 */
	public void add(int index, Object element);

	public void add(Object element);

	public Object remove(int index);

	public Object remove(Object element);

	public int contains(Object element);

	public int size();

	public SimpleIterator iterator();


}
