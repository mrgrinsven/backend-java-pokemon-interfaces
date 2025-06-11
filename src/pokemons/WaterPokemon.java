package pokemons;

import pokemons.types.WaterAttacks;

import java.util.Arrays;
import java.util.List;

public class WaterPokemon extends Pokemon implements WaterAttacks {
    private final String TYPE = "water";
    private final List<String> attacks = Arrays.asList("surf", "hydropump", "hydrocanon", "raindance");

    public WaterPokemon(String name, int level, int hp, String food, String sound) {
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
    public void surf(Pokemon name, Pokemon enemy) {
        int baseDamage = 8;
        String skillName = "surf";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    @Override
    public void hydroPump(Pokemon name, Pokemon enemy) {
        int baseDamage = 7;
        String skillName = "hydropump";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    @Override
    public void hydroCanon(Pokemon name, Pokemon enemy) {
        int baseDamage = 6;
        String skillName = "hydrocanon";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    @Override
    public void rainDance(Pokemon name, Pokemon enemy) {
        int baseDamage = 5;
        String skillName = "raindance";
        if (enemy.getType().equals("electric")) {
            System.out.println("Raindance heeft geen effect");
        }
        else{
            skillAttack(skillName, baseDamage, enemy, name);
        }
    }

    private int damageModifier(int damage, Pokemon enemy) {
        String type = enemy.getType();
        switch (type) {
            case "water" -> {
                return damage;
            }
            case "grass" -> {
                return damage + 5;
            }
            case "electric" -> {
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
