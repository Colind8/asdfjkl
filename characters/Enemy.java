package characters;
import java.util.ArrayList;
import items.Item;

/**
 * 
 * Enemy class that defines the aspects of enemies including their attacks and drops.
 */
public class Enemy extends Character {
	private ArrayList<Item> drops = new ArrayList<Item>();

	public Enemy(String name, String desc, int _a, int _b, int xp, int lv) {
		super(name, desc, _a, _b, xp, lv);
	}
}
