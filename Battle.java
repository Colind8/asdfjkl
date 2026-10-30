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

	/**
	 * Constructs the Battle Class
	 */
	public Battle(Player data) {
		turn_index = 0;
		turns = 0;
		player = new PlayerCharacter(data.get_name(), "It's you!", )
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
		if (is_all_enmies_dead()) {
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

	public void start_player_turn() {
		
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
	public boolean is_all_enmies_dead() {
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
