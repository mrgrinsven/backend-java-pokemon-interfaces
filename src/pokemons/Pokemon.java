package pokemons;

import java.util.Objects;

public abstract class Pokemon {
    private final String name;
    private final int level;
    private int hp;
    private final String food;
    private final String sound;
    private final String type;

    public Pokemon(String name, int level, int hp, String food, String sound, String type) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.food = food;
        this.sound = sound;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHp() {
        return this.hp;
    }

    public String getFood() {
        return this.food;
    }

    public String getSound() {
        return this.sound;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getType() {
        return type;
    }

    abstract int damageModifier(int baseDamage, Pokemon enemy);

    void skillAttack(String skillName, int baseDamage, Pokemon enemy, Pokemon name) {
        int totalDamage = damageModifier(baseDamage, enemy);
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with " + skillName);
        System.out.println(enemy.getName() + " loses " + totalDamage + " hp");
        enemy.setHp(enemy.getHp() - totalDamage);
        System.out.println(enemy.getName() + " has " + enemy.getHp() + " hp left");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return level == pokemon.level && hp == pokemon.hp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, hp);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", type='" + type + '\'' +
                '}';
    }
}
