import java.util.Random;

public class Hero {
    public static int heroCount = 0;
    private String name;
    

    private int strength;
    private int dexterity;
    private int constitution;
    private int wisdom;
    private int intelligence;
    private int charisma;
    private int health;
    private int armorClass;
    private boolean isAlive = true;
    private int hitDie;
    private int level;

    public Hero() {
        this.name = "Link";
        this.strength = 0;
        this.dexterity = 0;
        this.constitution = 0;
        this.wisdom = 0;
        this.intelligence = 0;
        this.charisma = 0;
        this.health = rollHealth();
        this.armorClass = 10 + this.dexterity;
        this.level = 5;
        this.isAlive = true;
        this.hitDie = 6;
        heroCount++;
    }

    public Hero(String name, int strength, int dexterity, int constitution, int wisdom, int intelligence,
            int charisma) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.health = rollHealth();
        this.armorClass = 10 + this.dexterity;
        this.level = 5;
        this.isAlive = true;
        this.hitDie = 6;
        heroCount++;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public boolean getAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getHitDie() {
        return hitDie;
    }
    public void setHitDie(int hitDie) {
        this.hitDie = hitDie;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int rollHealth() {
        int hp = this.getLevel() * (this.getHitDie() + this.getConstitution());
        if (hp < 5) {
            hp = 5;
        }
        return hp;
    }

    public void attack(Hero target) {

        if (this.getHealth() > 0) {

            System.out.println(this.getName() + " attacked " + target.getName());
            int damage = 0;
    
            Random rng = new Random();
    
            damage = rng.nextInt(this.getHitDie()) + this.getStrength();
    
            target.setHealth(target.getHealth() - damage);
            System.out.println(target.getName() + " has " + target.getHealth() + " remaining!");
            target.checkAlive();
        } else {
            System.out.println("You are already dead");
        }

    }

    public void stats() {
        System.out.println("-------- Stats --------");
        System.out.println("Name: " + this.getName());
        System.out.println("Stength: " + this.getStrength());
        System.out.println("Dexterity: " + this.getDexterity());
        System.out.println("Constitution: " + this.getConstitution());
        System.out.println("Wisdom: " + this.getWisdom());
        System.out.println("Intelligence: " + this.getIntelligence());
        System.out.println("Charisma: " + this.getCharisma());
        System.out.println("AC: " + this.getArmorClass());
        System.out.println("HP: " + this.getHealth());
        System.out.println("----------------------");
    }

    public void checkAlive() {
        if (this.getHealth() <= 0) {
            this.setAlive(false);
        }
    }





}