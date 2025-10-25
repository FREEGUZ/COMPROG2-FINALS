import java.util.Random;
import java.util.Scanner;
public abstract class Character {
    protected String name;
    protected int maxHP, hp, maxMP, mp, maxSP, sp;
    protected int healPotions = 1;
    protected int manaPotions = 1;
    protected Random rand = new Random();

    public Character(String name, int hp, int mp, int sp) {
        this.name = name;
        this.maxHP = hp;
        this.hp = hp;
        this.maxMP = mp;
        this.mp = mp;
        this.maxSP = sp;
        this.sp = sp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void basicAttack(Character enemy) {
        if (sp < 2) {
            System.out.println(name + " doesn’t have enough SP to attack!");
            return;
        }
        sp -= 2;
        int dmg = rand.nextInt(10) + 5;
        enemy.hp -= dmg;
        System.out.println(name + " attacks and deals " + dmg + " damage!");
    }

    public void defend() {
        if (sp < 3) {
            System.out.println(name + " doesn’t have enough SP to defend!");
            return;
        }
        sp -= 3;
        System.out.println(name + " is defending, reducing next damage!");
    }

    public void usePotion() {
        System.out.println("1. Healing Potion (" + healPotions + ")");
        System.out.println("2. Mana Potion (" + manaPotions + ")");
        System.out.print("Choose potion: ");
        int choice = new java.util.Scanner(System.in).nextInt();

        if (choice == 1 && healPotions > 0) {
            int heal = rand.nextInt(30) + 20;
            hp = Math.min(maxHP, hp + heal);
            healPotions--;
            System.out.println(name + " drinks a Healing Potion and restores " + heal + " HP!");
        } else if (choice == 2 && manaPotions > 0) {
            int restore = rand.nextInt(20) + 10;
            mp = Math.min(maxMP, mp + restore);
            manaPotions--;
            System.out.println(name + " drinks a Mana Potion and restores " + restore + " MP!");
        } else {
            System.out.println("No potions available!");
        }
    }

    public abstract void special1(Character enemy);
    public abstract void special2(Character enemy);

    public void showStatus() {
        System.out.println(name + " | HP: " + hp + "/" + maxHP + 
                           " | MP: " + mp + "/" + maxMP + 
                           " | SP: " + sp + "/" + maxSP);
    }
}
