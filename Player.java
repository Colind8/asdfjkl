
/**
 * 
 * holds critical player info
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

	public String get_name() {
		return name;
	}

	public int get_xp() {
		return xp;
	}

	public int get_lv() {
		return lv;
	}

	public int get_max_hp() {
		return (10 + (lv * 2));
	}

	public int get_df() {
		return ((lv * 2));
	}
}
