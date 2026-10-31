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

	/**
	 * Print every item in the inventory
	 */
	public void print_inventory() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println(i + ". " + get_item(i).get_item_info_string());
		}
	}

	/**
	 * Get an item from the inventory
	 * @param index the index of the item in the inventory
	 * @return item object
	 */
	public Item get_item(int index) {
		return inventory.get(index);
	}

	/**
	 * Add a new item to the inventory
	 * @param item
	 */
	public void add_item(Item item) {
		if (inventory.size() < max_space) {
			boolean item_exists = false;
			for (int i = 0; i < inventory.size(); i++) {
				if (get_item(i).get_name() == item.get_name()) {
					get_item(i).change_amount(item.get_amount());
					item_exists = true;
				}
			}
			if (!item_exists) {
				inventory.add(item);
			}
		} else {
			System.out.println("Inventory is full!");
		}
	}

	/**
	 * Remove an item from the inventory
	 * @param index of the item
	 */
	public void remove_item(int index) {
		inventory.remove(index);
	}

	/**
	 * Check if an item at the index has its amount at <=0, if so remove it
	 * @param index
	 */
	public void check_empty(int index) {
		if (get_item(index).get_amount() <= 0) {
			remove_item(index);
		} 
	}
}
