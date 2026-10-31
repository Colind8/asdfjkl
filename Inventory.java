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
	 * Returns a list of every item as a string
	 * @return string
	 */
	public String print_inventory() {
		String str = "";
		if (inventory.size() == 0) {
			return "[ inventory is empty ]";
		}
		for (int i = 0; i < inventory.size(); i++) {
			str += i + ". " + get_item(i).get_item_info_string() + "\n";
		}
		return str;
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
	 * @param item item object
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
	 * Check if an item at the index has its amount at 0, if so remove it
	 * @param index index of item
	 */
	public void check_empty(int index) {
		if (get_item(index).get_amount() <= 0) {
			remove_item(index);
		} 
	}

	/**
	 * Returns the amount of items in the inventory
	 * @return size
	 */
	public int get_size() {
		return inventory.size();
	}
}
