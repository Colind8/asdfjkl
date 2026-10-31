package characters;
import java.util.ArrayList;
import items.Item;

/**
 * 
 * Enemy class that defines the aspects of enemies including their attacks and drops.
 */
public abstract class Enemy extends Character {
	private ArrayList<Item> drops = new ArrayList<Item>();

	/**
	 * Creates the enemy
	 * @param name The name of the character
	 * @param desc The description of the character
	 * @param _a The HP the character starts with
	 * @param _b the DF the character starts with
	 * @param xp the XP the character starts with
	 * @param lv the LV the character starts with
	 */
	public Enemy(String name, String desc, int _a, int _b, int xp, int lv) {
		super(name, desc, _a, _b, xp, lv);
	}

	/**
	 * Adds the item to their drops list. (items received when enemy is killed)
	 * @param item The item to add
	 */
	public void add_drop(Item item) {
		drops.add(item);
	}

	/**
	 * To be implemented: the unique attack
	 * @param character character to apply attack to
	 */
	public abstract void attack(Character character);
}
