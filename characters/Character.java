package characters;

public class Character {
	private int xp;
	private int lv;
	private int df;
	private int hp;
	private int max_hp;
	private int max_df;

	public Character(int _a, int _b) {
		max_hp = _a;
		max_df = _b;
		hp = max_hp;
		df = max_df;
		xp = 0;
		lv = 0;
	}

	public int get_max_hp() {
		return max_hp;
	}

	public int get_max_df() {
		return max_df;
	}

	public int get_hp() {
		return hp;
	}

	public void change_hp(int amount) {
		hp += amount;
	}
}
