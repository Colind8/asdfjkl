package items;
import effects.*;

public class Ingredient extends Item {
	private Effect effect = new Effect("Heal","Slightly heals",1);

	public Ingredient () {
		super("Healing Herb", "Boasts a very faint healing aura", 1);
	}
}
