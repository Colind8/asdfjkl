import java.util.ArrayList;
import characters.*;
import items.Item;

/**
 * Controls the battle logic. After being initialized, enemies must be added with add_enemy().
 * 
 */
public class Battle {
	private int turn_index;
	private int turns;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>(); 
	private PlayerCharacter player;
	private Player data;
	private Menu menu;

	/**
	 * Construct the battle class
	 * @param data player data for player battle object
	 */
	public Battle(Player data, Menu menu) {
		turn_index = 0;
		turns = 0;
		player = new PlayerCharacter(data.get_name(), "It's you!", data.get_max_hp(), data.get_df(), data.get_xp(), data.get_lv());
		this.menu = menu;
		this.data = data;
	}

	/** 
	 * Returns the amount of turns that have passed.
	 * @return turns
	 */
	public int get_turn_count() {
		return turns;
	}

	/**
	 * Get the amount of enemies in the battle
	 * @return enemy count
	 */
	public int get_enemy_count() {
		return enemies.size();
	}

	/**
	 * Returns the enemy at the index
	 * @param index index of enemy
	 * @return enemy object
	 */
	public Enemy get_enemy(int index) {
		return enemies.get(index);
	}

	/**
	 * Returns data object
	 * @return data
	 */
	public Player get_data() {
		return data;
	}

	public String get_player_info() {
		return player.get_name() + " --- " + player.get_hp() + "/" + player.get_max_hp() + "hp";
	}

	/** 
	 * Adds an enemy to the battle.
	 */
	public void add_enemy(Enemy enemy) {
		enemies.add(enemy);
	}

	/**
	 * Ends a turn
	 */
	public void end_turn() {
		if (is_all_enemies_dead()) {
			end_battle();
		}
		if (turn_index > enemies.size() + 1) {
			turns++;
			turn_index = 0;
			start_player_turn();
		} else {
			turn_index++;
			start_enemy_turn();
		}
	}

	/**
	 * Initiates the battle.
	 */
	public void start_battle() {
		start_player_turn();
	}

	/**
	 * Begins the turn of whoever is next.
	 */
	public void start_enemy_turn() {
		if (is_enemy_dead(turn_index + 1)) {
			end_turn();
		}
	}

	/**
	 * Begins the player's turn
	 */
	public void start_player_turn() {
		menu.battle_player_menu(this);
	}

	public void begin_brew() {
		Brew potion = new Brew(get_data().get_inventory());
		menu.battle_brew_menu(this, potion);
	}

	/** Ends the battle */
	public void end_battle() {

	}

	/**
	 * Returns true if the enemy is dead
	 * @param index Index of the enemy
	 * @return boolean
	 */
	public boolean is_enemy_dead(int index) {
		return (enemies.get(index).get_hp() <= 0);
	}

	/**
	 * Returns true if all enemies are dead.
	 * @return boolean
	 */
	public boolean is_all_enemies_dead() {
		boolean check = true;
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).get_hp() > 0) {
				check = false;
				break;
			}
		}
		return check;
	}
}
