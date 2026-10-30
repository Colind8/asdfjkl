package characters;

public class Slime extends Enemy {
	/**
	 * Creates the enemy
	 * @param name The name of the character
	 * @param desc The description of the character
	 * @param _a The HP the character starts with
	 * @param _b the DF the character starts with
	 * @param xp the XP the character starts with
	 * @param lv the LV the character starts with
	 */
	public Slime(String name, String desc, int _a, int _b, int xp, int lv) {
		super(name, desc, _a, _b, xp, lv);
	}

	public void attack(Character character) {
		character.change_hp(-get_dmg());
		System.out.println(character.get_name() + " slimed for " + get_dmg() + " damage!");
	}
}
