
/**
 * 
 * holds critical player info. Used to store important data used for the entire game, like the inventory.
 */
public class Player {
	private int xp;
	private int lv;
	private String name;
	Inventory inventory = new Inventory();

	/**
	 * Creates the player object
	 * @param a player name
	 */
	public Player(String a) {
		xp = 0;
		lv = 0;
		name = a;
	}

	/**
	 * The player's name
	 * @return name
	 */
	public String get_name() {
		return name;
	}

	/**
	 * The player's xp
	 * @return xp
	 */
	public int get_xp() {
		return xp;
	}

	/**
	 * The amount of xp the player needs to level up
	 * @return max xp
	 */
	public int get_max_xp() {
		return 100 + (100 * lv);
	}

	/**
	 * The player's level
	 * @return lv
	 */
	public int get_lv() {
		return lv;
	}

	/**
	 * The player's max hp (caculated from level)
	 * @return max_hp
	 */
	public int get_max_hp() {
		return (10 + (lv * 2));
	}

	/**
	 * The player's max defense (calculated from level)
	 * @return max_df
	 */
	public int get_df() {
		return ((lv * 2));
	}

	/**
	 * Returns the player's inventory
	 * @return inventory
	 */
	public Inventory get_inventory() {
		return inventory;
	}
}
