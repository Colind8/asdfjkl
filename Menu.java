import java.util.Scanner;

/**
 * 
 * Controls all console input/output
 */
public class Menu {
	Scanner scnr = new Scanner(System.in);

	public Menu() {

	}

	/**
	 * Displays the battle overview, including the amount of enemies, and their names and levels.
	 * @param battle battle object
	 */
	public void battle_overview(Battle battle) {
		String overview = "";
		overview = "Encounter with " + battle.get_enemy_count() + " enemies.\n";
		for (int i = 0; i < battle.get_enemy_count(); i++) {
			overview += battle.get_enemy(i).get_name() + " [" + battle.get_enemy(i).get_lv() + "]\n";
		}
		System.out.println(overview);
		System.out.println("<Press ENTER to begin>");
		scnr.nextLine();
	}

	/**
	 * Displays the player's main battle menu. Which leads to the brewing and check menus.
	 * @param battle battle object
	 */
	public void battle_player_menu(Battle battle) {
		boolean valid = false;
		System.out.println(battle.get_player_info());
		System.out.println("1. Brew Potion\n2. Check\nEnter num: ");
		String input = "";
		while(valid == false) {
			input = scnr.nextLine();
			switch (input) {
				case "1":
					battle.begin_brew();
					valid = true;
					break;
				case "2":
					battle_check_menu(battle);
					valid = true;
					break;
			}
		}
	}

	/**
	 * Displays the brewing menu
	 * @param battle
	 * @param potion
	 */
	public void battle_brew_menu(Battle battle, Brew potion) {
		boolean valid = false;
		String input = "";
		while(valid == false) {
			System.out.println(potion.get_ingredients_info());
			System.out.println("1. Add ingredient\n2. Remove Ingredient\n3. Finish Potion\n4. Cancel");
			input = scnr.nextLine();
			switch (input) {
				case "1":
					battle_brew_add(battle, potion);
					valid = true;
					break;
				case "2":
					break;
				case "3":
					battle_brew_finish(battle, potion);
					valid = true;
					break;
				case "4":
					battle_player_menu(battle);
					valid = true;
					break;
			}
		}
	}

	/**
	 * Menu for adding an ingredient to the potion
	 * @param battle
	 * @param potion
	 */
	public void battle_brew_add(Battle battle, Brew potion) {
		int input = -1;
		boolean valid = false;
		while(valid == false) {
			System.out.println(battle.get_data().get_inventory().print_inventory());
			System.out.println("Enter the id of the item you want to add. Type '-1' to cancel.");
			input = scnr.nextInt();
			if ((input >= 0) && (input < battle.get_data().get_inventory().get_size())) {
				potion.add_ingredient(input);
				valid = true;
			} else if (input == -1) {
				valid = true;
			}
		}
		scnr.nextLine();
		battle_brew_menu(battle, potion);
	}

	/**
	 * Menu for choosing who to apply the potion to
	 * @param battle
	 * @param potion
	 */
	public void battle_brew_finish(Battle battle, Brew potion) {
		int input = -1;
		boolean valid = false;
		while(valid == false) {
			System.out.println(battle.get_battle_character_list());
			System.out.println("Enter the id of the character you want to throw the potion on.");
			input = scnr.nextInt();
			if ((input >= 1) && (input < battle.get_enemy_count() + 1)) {
				potion.apply(battle.get_enemy(input - 1));
				valid = true;
			} else if (input == 0) {
				potion.apply(battle.get_player());
				valid = true;
			}
		}
		scnr.nextLine();
		battle.end_turn();
	}

	/**
	 * Show the check menu
	 * @param battle
	*/
	public void battle_check_menu(Battle battle) {
		int input = -1;
		boolean valid = false;
		while(valid == false) {
			System.out.println(battle.get_battle_character_list());
			System.out.println("Enter the id of the character you want to view the statistics of.");
			input = scnr.nextInt();
			if ((input >= 1) && (input < battle.get_enemy_count() + 1)) {
				System.out.println(battle.get_enemy_status(input - 1));
				valid = true;
			} else if (input == 0) {
				System.out.println(battle.get_player_status());
				valid = true;
			}
		}
		scnr.nextLine();
		battle_player_menu(battle);
	}

	/**
	 * Display the start of the enemy's turn
	 * @param enemy Enemy name string
	 */
	public void battle_enemy_ready(String enemy) {
		System.out.println(enemy + "'s turn!");
		scnr.nextLine();
	}

	/**
	 * Display effects applied to enemy
	 * @param str effects
	 */
	public void battle_enemy_effect(String str) {
		System.out.println(str);
	}

	/**
	 * Display enemy attack / damage
	 * @param enemy Enemy name
	 * @param dmg Enemy damage
	 */
	public void battle_enemy_attack(String enemy, int dmg) {
		System.out.println(enemy + " dealt " + dmg + " damage.");
		scnr.nextLine();
	}

	/**
	 * Display start of player's turn
	 * @param player name
	 */
	public void battle_player_ready(String player) {
		System.out.println(player + "'s turn!");
		scnr.nextLine();
	}

	/**
	 * Display effects applied to player
	 * @param str effects
	 */
	public void battle_player_effect(String str) {
		System.out.println(str);
	}

	/**
	 * End the battle, showing the player victorious
	 * @param player name
	 */
	public void battle_over_playerwins(String player) {
		System.out.println("Battle complete! " + player + " wins!");
		scnr.nextLine();
	}

	/**
	 * End the battle, showing the player lost
	 * @param player name
	 */
	public void battle_over_playerloses(String player) {
		System.out.println("Battle over. " + player + " has died!");
		scnr.nextLine();
	}
}
