import characters.*;
import effects.*;
import items.*;
import java.util.Scanner;

public class Game {
	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		Menu menu = new Menu();

		System.out.println("Welcome to The Alchemist!");
		String input = "";
		System.out.println("Enter name: ");
		input = scnr.nextLine();

		Player data = new Player(input);
		data.inventory.add_item(new Item("Roses", "Offer a lovely helping of thorns", 10, 
		new HealingEffect("Instant Damage", "Damages a small amount", 1, -2)
		));
		data.inventory.add_item(new Item("Daisies", "They have a healing aura to them", 3, 
		new HealingEffect("Healing", "Heals a small amount", 2, 2)
		));
		data.inventory.add_item(new Item("Poison Ivy", "It has an anti-healing aura to it", 1, 
		new HealingEffect("Poison", "Deals a small amount of damage per turn", 2, -1)
		));

		Battle battle = new Battle(data, menu);
		battle.add_enemy(new Slime("Slime", "It's sticky", 15, 0, 10, 1));
		menu.battle_overview(battle);
		battle.start_battle();

		scnr.close();
	}
}