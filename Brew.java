import java.util.ArrayList;
import effects.*;

import items.*;

/**
 * 
 * Potion creation management system
 */
public class Brew {
	private Inventory inventory;
	private ArrayList<Item> ingredients = new ArrayList<Item>();
	private int flat_damage;

	/**
	 * Construct new Brew
	 * @param inventory reference to player inventory
	 */
	public Brew(Inventory inventory) {
		this.inventory = inventory;
		flat_damage = 1;
	}

	/**
	 * Add item from inventory to the ingredients
	 * @param index of the item in the inventory
	 */
	public void add_ingredient(int index) {
		if (inventory.get_item(index).get_amount() > 0) {
			Item inv = inventory.get_item(index);
			ingredients.add(new Item(inv.get_name(), inv.get_desc(), 1, inv.get_effect()));
			inventory.get_item(index).change_amount(-1);
		}
	}
	
	/**
	 * Remove item from ingredients and add it back to inventory.
	 * @param index of the ingredient
	 */
	public void remove_ingredient(int index) {
		inventory.add_item(ingredients.get(index));
		ingredients.remove(index);
	}

	/**
	 * Get the flat damage.
	 * @return flat_damage
	 */
	public int get_flat() {
		return flat_damage;
	}

	/**
	 * Get the effect at the ingredients' index
	 * @param index of the ingredient
	 * @return Effect
	 */
	public Effect get_ingredient(int index) {
		return ingredients.get(index).get_effect();
	}

	/**
	 * Returns the size of the ingredients list
	 */
	public int get_ingredients_size() {
		return ingredients.size();
	}

	/**
	 * Returns a single-line string of all the ingredients
	 * @return String
	 */
	public String get_ingredients_info() {
		String str = "Ingredients added: ";
		if (get_ingredients_size() == 0) {
			return "[No ingredients added yet]";
		}
		for (int i = 0; i < get_ingredients_size(); i++) {
			str += get_ingredient(i).get_name();
			if (i != get_ingredients_size() - 1) {
				str += ", ";
			}
		}
		return str;
	}

	/**
	 * Returns a multi-line list of all the ingredients
	 * @return String
	 */
	public String get_ingredients_list() {
		String str = "Ingredients: ";
		if (get_ingredients_size() == 0) {
			return "[No ingredients added yet]";
		}
		for (int i = 0; i < get_ingredients_size(); i++) {
			str += i + ". " + get_ingredient(i).get_name();
			str += "\n";
		}
		return str;
	}
}
