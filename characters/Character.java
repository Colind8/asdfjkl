package characters;
import effects.*;
import java.util.ArrayList;

/**
 * 
 * Character class for defining all aspects of characters including the player and enemies
 */
public class Character {
	private String name;
	private String desc;
	private int xp, lv;
	private int hp, df;
	private int max_hp;
	private int max_df;
	private int dmg, dex;
	private ArrayList<Effect> effects = new ArrayList<Effect>();

	/**
	 * Creates a character
	 * @param name The name of the character
	 * @param desc The description of the character
	 * @param _a The HP the character starts with
	 * @param _b the DF the character starts with
	 * @param xp the XP the character starts with
	 * @param lv the LV the character starts with
	 */
	public Character(String name, String desc, int _a, int _b, int xp, int lv) {
		max_hp = _a;
		max_df = _b;
		hp = max_hp;
		df = max_df;
		this.xp = xp;
		this.lv = lv;
		set_dexterity(20);
	}

	/**
	 * This determines the maximum amount of health a character can have
	 * @return max_hp
	 */
	public int get_max_hp() {
		return max_hp;
	}

	/**
	 * This determines the maximum amount of defense a character can have
	 * @return max_df
	 */
	public int get_max_df() {
		return max_df;
	}

	/**
	 * This returns the amount of XP the character has.
	 * 
	 * For the player, they collect this from enemies.
	 * For enemies, they will drop this.
	 * @return xp
	 */
	public int get_xp() {
		return xp;
	}

	/**
	 * This returns the character's level. Level determines how strong the character is.
	 * @return lv
	 */
	public int get_lv() {
		return lv;
	}

	/**
	 * AKA Hit Points, represents the character's health.
	 * @return hp
	 */
	public int get_hp() {
		return hp;
	}

	/**
	 * AKA Defense, the amount of resistence a character has to attacks.
	 * @return df
	 */
	public int get_df() {
		return df;
	}

	/**
	 * Set the damage using a formula (base )
	 * @param base Amount of damage when at level zero
	 */
	public void set_damage(int base) {
		dmg = (int) Math.round(base + (Math.pow(lv,1.15)));
	}

	/**
	 * Set dexterity directly
	 * @param dex max 20
	 */
	public void set_dexterity(int dex) {
		this.dex = dex;
	}

	/**
	 * Changes HP by this amount.
	 * @param amount
	 */
	public void change_hp(int amount) {
		hp += amount;
	}

	/**
	 * Changes Defense by this amount.
	 * @param amount
	 */
	public void change_df(int amount) {
		df += amount;
	}

	/**
	 * Adds the provided effect to the character's active effects.
	 * @param effect
	 */
	public void add_effect(Effect effect) {
		effects.add(effect);
	}

	/**
	 * Removes the provided effect from the character's active effects.
	 * @param name The name of the Effect that needs to be removed
	 */
	public void remove_effect(String name) {
		for (int i = 0; i < effects.size(); i++) {
			if (effects.get(i).get_name() == name) {
				effects.remove(i);
			}
		}
	}
}
