package items;

public class Item {
	private String name;
	private String desc;
	private int amount;
	
	public Item(String name, String desc, int amount) {
		this.name = name;
		this.desc = desc;
		this.amount = amount;
	}

	public String get_name() {
		return name;
	}

	public String get_desc() {
		return desc;
	}

	public int get_amount() {
		return amount;
	}

	public String get_item_info_string() {
		return get_name() + "[" + get_amount() + "]: " + get_desc();
	}
}
