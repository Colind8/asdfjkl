import java.util.ArrayList;

import items.Item;

/**
 * 
 * Inventory
 */
public class Inventory {
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private int max_space;

	/**
	 * Create the inventory
	 */
	public Inventory() {
		max_space = 50;
	}

	public void print_inventory() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println(i + " " + get_item(i).get_item_info_string());
		}
	}

	public Item get_item(int index) {
		return inventory.get(index);
	}

	public void add_item(Item item) {
		if (inventory.size() < max_space) {
			inventory.add(item);
		} else {
			System.out.println("Inventory is full!");
		}
	}
}
