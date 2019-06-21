package com.gs.ilp.generics;

class MyHashMap<K> implements MyMap<K, String> {

	@Override
	public void put(K key, String val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public K get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public <T> void print(T obj) {
		System.out.println(obj);
	}

	

}

public interface MyMap<K, V> {

	public void put(K key, V val);

	public K get();

}
