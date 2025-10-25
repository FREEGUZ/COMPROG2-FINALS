import java.util.Random;
import java.util.Scanner;
    public class DeathKnight extends Character {
    public DeathKnight() {
        super("Death Knight", 150, 40, 100);
    }

    @Override
    public void special1(Character enemy) {
        if (sp < 30) {
            System.out.println("Not enough SP for Death Strike!");
            return;
        }
        sp -= 30;
        int dmg = rand.nextInt(20) + 15;
        enemy.hp -= dmg;
        int heal = (int)(maxHP * 0.10);
        hp = Math.min(maxHP, hp + heal);
        System.out.println("Death Knight uses Death Strike, dealing " + dmg + " and healing " + heal + " HP!");
    }

    @Override
    public void special2(Character enemy) {
        if (sp < 50) {
            System.out.println("Not enough SP for Icebound Fortitude!");
            return;
        }
        sp -= 50;
        System.out.println("Death Knight uses Icebound Fortitude! Takes less damage next turn.");
    }
}
