package effects;
import characters.Character;

/**
 * 
 * Effect
 */
public abstract class Effect {
	private String name;
	private String desc;
	private int turn_length;
	protected Character character;

	/**
	 * Creates an Effect
	 * @param name The name of the Effect
	 * @param desc The effect's description
	 * @param turn_length How many turns the effect lasts
	 * @param character What character is assigned to the effect
	 */
	public Effect (String name, String desc, int turn_length, Character character) {
		this.name = name;
		this.desc = desc;
		this.turn_length = turn_length;
		this.character = character;
	}

	/**
	 * Runs whenever it's time to activate the effect.
	 */
	public abstract void activate_effect();

	/**
	 * The name of the effect.
	 * @return name
	 */
	public String get_name() {
		return name;
	}

	/**
	 * The description of the effect.
	 * @return description
	 */
	public String get_desc() {
		return desc;
	}

	/**
	 * The amount of turns until the effect is destroyed.
	 * @return turn_length
	 */
	public int get_turn_length() {
		return turn_length;
	}

	/**
	 * Changes the turn length by the amount. Usually -1 per turn, increasing if the effect is re-applied in some way.
	 * @param amount
	 */
	public void change_length(int amount) {
		turn_length += amount;
	}
}
