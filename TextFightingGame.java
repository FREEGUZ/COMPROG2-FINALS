import java.util.Scanner;
import java.util.Random;
public class TextFightingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("=== TEXT FIGHTING ARENA ===");
        System.out.println("Choose your Character:");
        System.out.println("1. Shaman");
        System.out.println("2. Death Knight");
        System.out.print("Which Character?: ");
        int choice = sc.nextInt();

        Character player = (choice == 1) ? new Shaman() : new DeathKnight();
        Character enemy = (choice == 1) ? new DeathKnight() : new Shaman();

        System.out.println("\nYou are a " + player.getClass().getSimpleName() +
                           "! Your enemy is a " + enemy.getClass().getSimpleName() + ".");

        
        while (player.isAlive()) {
            System.out.println("\n--- Your Turn ---");
            player.showStatus();
            enemy.showStatus();
            System.out.println("\n1. Basic Attack");
            System.out.println("2. Defend");
            System.out.println("3. Use Potion");
            System.out.println("4. Special 1");
            System.out.println("5. Special 2");
            System.out.print("Choose action: ");
            int action = sc.nextInt();

            switch (action) {
                case 1 -> player.basicAttack(enemy);
                case 2 -> player.defend();
                case 3 -> player.usePotion();
                case 4 -> player.special1(enemy);
                case 5 -> player.special2(enemy);
                default -> System.out.println("Invalid choice!");
            }

            
            if (!enemy.isAlive()) {
                System.out.println(enemy.name + " is defeated!");
                if (rand.nextBoolean()) player.healPotions++;
                else player.manaPotions++;
                System.out.println("You found a potion!");
                enemy = (player instanceof Shaman) ? new DeathKnight() : new Shaman();
                System.out.println("A new enemy appears: " + enemy.name + "!");
                continue;
            }

            
            System.out.println("\n--- Enemy Turn ---");
            int enemyChoice = rand.nextInt(3);
            if (enemyChoice == 0) enemy.basicAttack(player);
            else if (enemyChoice == 1) enemy.special1(player);
            else enemy.special2(player);

          
            if (!player.isAlive()) {
                System.out.println(player.name + " has been defeated... Game Over!");
                break;
            }
        }

        sc.close();
    }
}