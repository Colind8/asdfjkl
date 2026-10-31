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

	/**
	 * Creates an Effect
	 * @param name The name of the Effect
	 * @param desc The effect's description
	 * @param turn_length How many turns the effect lasts
	 */
	public Effect (String name, String desc, int turn_length) {
		this.name = name;
		this.desc = desc;
		this.turn_length = turn_length;
	}

	/**
	 * Runs whenever it's time to activate the effect.
	 * @param character to apply effect to
	 */
	public abstract void activate_effect(Character character);

	/**
	 * Displays information on what the effect did.
	 * @return string
	 */
	public abstract String get_effect_info();

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
	 * @param amount amount to change length by
	 */
	public void change_length(int amount) {
		turn_length += amount;
	}
}
