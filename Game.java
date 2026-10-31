import characters.*;
import effects.*;
import items.*;
import java.util.Scanner;

/**
 * 
 * The Main class
 */
public class Game {
	/**
	 * The main method
	 * @param args unused
	 */
	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		Menu menu = new Menu();

		System.out.println("Welcome to The Alchemist!");
		String input = "";
		System.out.println("Enter name: ");
		input = scnr.nextLine();

		Player data = new Player(input);
		data.get_inventory().add_item(new Item("Roses", "Offer a lovely helping of thorns", 10, 
		new HealingEffect("Instant Damage", "damaged", 1, -3)
		));
		data.get_inventory().add_item(new Item("Daisies", "They have a healing aura to them", 3, 
		new HealingEffect("Healing", "healed", 2, 3)
		));
		data.get_inventory().add_item(new Item("Poison Ivy", "It has an anti-healing aura to it", 1, 
		new HealingEffect("Poison", "poisoned", 5, -1)
		));

		Battle battle = new Battle(data, menu);
		battle.add_enemy(new Slime("Slime", "It's sticky", 15, 0, 10, 1));
		battle.get_enemy(0).set_damage(1);
		menu.battle_overview(battle);
		battle.start_battle();

		scnr.close();
	}
}