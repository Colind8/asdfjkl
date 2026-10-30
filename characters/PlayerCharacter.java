package characters;

/**
 * 
 * PlayerCharacter
 */
public class PlayerCharacter extends Character {
	
	/**
	 * Creates a character
	 * @param name The name of the character
	 * @param desc The description of the character
	 * @param _a The HP the character starts with
	 * @param _b the DF the character starts with
	 * @param xp the XP the character starts with
	 * @param lv the LV the character starts with
	 */
	public PlayerCharacter(String name, String desc, int _a, int _b, int xp, int lv) {
		super(name, desc, _a, _b, xp, lv);
	}
}
