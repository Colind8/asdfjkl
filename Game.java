import characters.*;
import effects.*;
import items.*;
import java.util.Scanner;

public class Game {
	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);

		System.out.println("Welcome to The Alchemist!");
		String input = "";
		System.out.println("Enter name: ");
		input = scnr.nextLine();

		Player data = new Player(input);
		data.inventory.add_item(new Item("Roses", "Offer a lovely helping of thorns", 10));
		data.inventory.add_item(new Item("Daisies", "They have a healing aura to them", 3));
		data.inventory.add_item(new Item("Poison Ivy", "It has an anti-healing aura to it", 1));

		Battle battle = new Battle(data);
	}
}