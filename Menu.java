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
					battle_brew_menu(battle);
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
	 */
	public void battle_brew_menu(Battle battle) {
		boolean valid = false;
		Brew potion = new Brew(battle.get_data().get_inventory());
		System.out.println("1. Add ingredient\n2. Remove Ingredient\n3. Finish Potion\n4. Cancel");
		String input = "";
		while(valid == false) {
			input = scnr.nextLine();
			switch (input) {
				case "1":
					battle_brew_menu(battle);
					break;
				case "2":
					battle_check_menu(battle);
					break;
			}
		}
	}

	public void battle_check_menu(Battle battle) {

	}
}
