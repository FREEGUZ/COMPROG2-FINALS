import java.util.Random;
import java.util.Scanner;
   public class Shaman extends Character {
    public Shaman() {
        super("Shaman", 120, 100, 60);
    }

    @Override
    public void special1(Character enemy) {
        if (mp < 25) {
            System.out.println("Not enough MP for Lightning Bolt Prep!");
            return;
        }
        mp -= 25;
        int dmg = rand.nextInt(20) + 10 + (mp / 10);
        enemy.hp -= dmg;
        System.out.println("Shaman casts Lightning Bolt Prep and deals " + dmg + " magic damage!");
    }

    @Override
    public void special2(Character enemy) {
        if (mp < 30) {
            System.out.println("Not enough MP for Heal!");
            return;
        }
        mp -= 30;
        int heal = rand.nextInt(40) + 10;
        hp = Math.min(maxHP, hp + heal);
        System.out.println("Shaman heals for " + heal + " HP!");
    }
}