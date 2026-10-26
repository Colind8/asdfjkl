package effects;

abstract class Effect {
	private String name;
	private String desc;
	private int turn_length;

	public Effect (String name, String desc, int turn_length) {
		this.name = name;
		this.desc = desc;
		this.turn_length = turn_length;
	}

	public abstract void activate_effect(Character character);

	public String get_name() {
		return name;
	}

	public String get_desc() {
		return desc;
	}

	public int get_turn_length() {
		return turn_length;
	}

	public void reduce_length(int amount) {
		turn_length -= amount;
	}

	public void increase_length(int amount) {
		turn_length += amount;
	}
}
