package com.gs.ilp.equalsAndHashCode;

class MyHashMap {

	private int size;
	private Node[] table;

	public MyHashMap(int size) {
		this.size = size;
		table = new Node[size];
	}

	class Node {
		private Object ele;
		private Object key;
		private int hash;
		private Node next;

		public Node(Object ele, Object key, int hash) {
			this.ele = ele;
			this.key = key;
			this.hash = hash;
		}

	}

	public void put(Object key, Object value) {
		int hash;
		int index;
		if (key != null) {
			hash = hash(key);
			index = hash & size - 1;
			if (null != table[index]) {
				// traverse linked list
				Node ptr = table[index];
				boolean isKeyAlreadyPresent = false;
				for (Node pptr = ptr; pptr != null; pptr = pptr.next) {
					ptr = pptr;
					if (hash == ptr.hash && ptr.key.equals(key)) {
						// replace old value
						ptr.ele = value;
						isKeyAlreadyPresent = true;
						break;
					}
				}
				if (!isKeyAlreadyPresent) {
					Node node = new Node(value, key, hash);
					ptr.next = node;
				}

			} else {
				table[index] = new Node(value, key, hash);
			}
		}

	}

	public Object get(Object key) {
		int hash;
		int index;
		Object value = null;
		if (key != null) {
			hash = hash(key);
			index = hash & size - 1;
			if (table[index] != null) {
				for (Node pptr = table[index]; pptr != null; pptr = pptr.next) {
					if (hash == pptr.hash && pptr.key.equals(key)) {
						value = pptr.ele;
						break;
					}
				}
			}
		}
		return value;
	}

	private int hash(Object val) {
		return val.hashCode();
	}
}

class Car {
	private int carId;
	private String carName;
	private String color;
	private double price;

	public Car(int carId, String carName, String color, double price) {
		this.carId = carId;
		this.carName = carName;
		this.color = color;
		this.price = price;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + ", color=" + color + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {

		return 256546;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carId != other.carId)
			return false;
		if (carName == null) {
			if (other.carName != null)
				return false;
		} else if (!carName.equals(other.carName))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

}

public class TestMyHashMap {
	public static void main(String[] args) {

		MyHashMap myHashMap = new MyHashMap(5);

		Car car1 = new Car(1, "Dzire", "black", 5654546.45656);
		Car car2 = new Car(2, "Santro", "blue", 898546.45656);
		Car car3 = new Car(3, "Ritz", "red", 8895654546.45656);
		Car car4 = new Car(4, "BAlleno", "green", 32323.45656);
		Car car5 = new Car(5, "I20", "white", 334344556.45656);

		// key as id , value as object
		myHashMap.put(car1, car1);
		myHashMap.put(car2, car2);
		myHashMap.put(car3, car3);
		myHashMap.put(car4, car4);
		myHashMap.put(car5, car5);

		Car car55 = new Car(5, "I20", "white", 334344556.45656); // DB :

		myHashMap.put(car55, car3);

		// myHashMap.put(car3.getCarId(), car5);
		System.out.println("car55:->" + car55.hashCode());
		System.out.println("car5:->" + car5.hashCode());

		System.out.println("car1 is " + myHashMap.get(car1));
		System.out.println("car2 is " + myHashMap.get(car2));
		System.out.println("car3 is " + myHashMap.get(car3));
		System.out.println("car4 is " + myHashMap.get(car4));
		System.out.println("car5 is " + myHashMap.get(car55));

	}

}