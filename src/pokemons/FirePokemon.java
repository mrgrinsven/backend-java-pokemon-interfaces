package pokemons;

import pokemons.types.FireAttacks;

import java.util.Arrays;
import java.util.List;

public class FirePokemon extends Pokemon implements FireAttacks {
    private final String TYPE = "fire";
    private final List<String> attacks = Arrays.asList("inferno", "pyroball", "firelash", "flamethrower");

    public FirePokemon(String name, int level, int hp, String food, String sound) {
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
    public void inferno(Pokemon name, Pokemon enemy) {
        int baseDamage = 8;
        String skillName = "inferno";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    @Override
    public void pyroBall(Pokemon name, Pokemon enemy) {
        int baseDamage = 7;
        String skillName = "pyroball";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    @Override
    public void fireLash(Pokemon name, Pokemon enemy) {
        int baseDamage = 6;
        String skillName = "firelash";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    @Override
    public void flameThrower(Pokemon name, Pokemon enemy) {
        int baseDamage = 5;
        String skillName = "flamethrower";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    private int damageModifier(int damage, Pokemon enemy) {
        String type = enemy.getType();
        switch (type) {
            case "fire" -> {
                return damage;
            }
            case "electric" -> {
                return damage + 5;
            }
            case "water" -> {
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
