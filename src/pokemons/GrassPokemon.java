package pokemons;

import pokemons.types.GrassAttacks;

import java.util.Arrays;
import java.util.List;

public class GrassPokemon extends Pokemon implements GrassAttacks {
    private final String TYPE = "grass";
    private final List<String> attacks = Arrays.asList("leafstorm","solarbeam", "leechseed", "leaveblade");

    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    List<String> getAttacks() {
        return this.attacks;
    }

    @Override
    public void leafStorm(Pokemon name, Pokemon enemy) {
        int baseDamage = 8;
        String skillName = "leafstorm";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    @Override
    public void solarBeam(Pokemon name, Pokemon enemy) {
        int baseDamage = 7;
        String skillName = "solarbeam";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    @Override
    public void leechSeed(Pokemon name, Pokemon enemy) {
        int baseDamage = 6;
        String skillName = "leechseed";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    @Override
    public void leaveBlade(Pokemon name, Pokemon enemy) {
        int baseDamage = 5;
        String skillName = "leaveblade";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    private int damageModifier(int damage, Pokemon enemy) {
        String type = enemy.getType();
        switch (type) {
            case "grass" -> {
                return damage;
            }
            case "water" -> {
                return damage + 5;
            }
            case "fire" -> {
                return damage + 8;
            }
            default -> {
                return damage + 10;
            }
        }
    }

    private void skillAttack(String skillName, int baseDamage, Pokemon enemy, Pokemon name) {
        int totalDamage = damageModifier(baseDamage, enemy);
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with " + skillName + ".");
        System.out.println(enemy.getName() + " loses " + totalDamage + " hp");
        enemy.setHp(enemy.getHp() - totalDamage);
        System.out.println(enemy.getName() + " has " + enemy.getHp() + " hp left.");
    }
}
