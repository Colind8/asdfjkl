package items;
import effects.*;

/**
 * 
 * Holds info about an item
 */
public class Item {
	private String name;
	private String desc;
	private int amount;
	private Effect effect;
	
	/**
	 * Construct new item
	 * @param name name of the item
	 * @param desc description of the item
	 * @param amount amount of the item
	 * @param effect effect object the item applies
	 */
	public Item(String name, String desc, int amount, Effect effect) {
		this.name = name;
		this.desc = desc;
		this.amount = amount;
		this.effect = effect;
	}

	/**
	 * Item name
	 * @return name
	 */
	public String get_name() {
		return name;
	}

	/**
	 * Item Description
	 * @return desc
	 */
	public String get_desc() {
		return desc;
	}

	/**
	 * Item effect
	 * @return effect
	 */
	public Effect get_effect() {
		return effect;
	}

	/**
	 * Item amount
	 * @return amount
	 */
	public int get_amount() {
		return amount;
	}

	/**
	 * Item info string
	 * @return "name [amount]: description"
	 */
	public String get_item_info_string() {
		return get_name() + "[" + get_amount() + "]: " + get_desc();
	}

	/**
	 * Changes the amount of the item by a specific amount
	 * @param amount amount to change amount by
	 */
	public void change_amount(int amount) {
		this.amount += amount;
	}
}
