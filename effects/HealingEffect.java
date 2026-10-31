package effects;
import characters.Character;

/**
 * 
 * Changes the character's hp a specific amount per turn
 */
public class HealingEffect extends Effect {
	private int hp_per_turn;

	/**
	 * HealingEffect constructor
	 * @param name The name of the effect
	 * @param desc The effect's description
	 * @param turn_length How many turns the effect lasts
	 * @param hp_per_turn The amount of hp to change to the character per turn
	 */
	public HealingEffect(String name, String desc, int turn_length, int hp_per_turn) {
		super(name,desc,turn_length);
		this.hp_per_turn = hp_per_turn;
	}

	/**	
	 * Changes the character's HP by the amount specified.
	 * @see effects.Effect#activate_effect()
	 */
	@Override
	public void activate_effect() {
		System.out.println("Healing!");
		character.change_hp(hp_per_turn);
	}

	
}
