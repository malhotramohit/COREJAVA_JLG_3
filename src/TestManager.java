
class Manager {
	private int id;
	private String name;

	public Manager(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class TestManager {

	public static void main(String[] args) {

		Manager manager1 = new Manager(1, "Mohit");
		Manager manager2 = new Manager(2, "Pierre");
		Manager manager3 = new Manager(3, "Nishu");

		Manager[] managers = new Manager[3];

		managers[0] = manager1;
		managers[1] = manager2;
		managers[2] = manager3;

		try {

			Manager managerObj = findManagerById(managers, 4);

			System.out.println("Manager id is " + managerObj.getId());
			System.out.println("Manager name is " + managerObj.getName());
		} catch (ManagerNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method will return the object of manager if found with the given id else
	 * will throw ManagerNotFoundException
	 * 
	 * @param managers
	 * @param id
	 * @return
	 * @throws ManagerNotFoundException
	 */
	static Manager findManagerById(Manager[] managers, int id) throws ManagerNotFoundException {

		Manager managerObj = null;
		for (int i = 0; i < managers.length; i++) {
			if (managers[i].getId() == id) {
				managerObj = managers[i];
				break;
			}
		}

		if (managerObj == null) {
			throw new ManagerNotFoundException("Manager with the given id is not present");
		}

		return managerObj;
	}

}
