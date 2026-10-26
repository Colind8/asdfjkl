package effects;
import characters.Character;

public class HealingEffect extends Effect {
	private int hp_per_turn;

	public HealingEffect(String name, String desc, int turn_length, Character character, int hp_per_turn) {
		super(name,desc,turn_length,character);
		this.hp_per_turn = hp_per_turn;
	}

	
	@Override
	public void activate_effect() {
		System.out.println("Healing!");
		character.change_hp(hp_per_turn);
	}

	
}
