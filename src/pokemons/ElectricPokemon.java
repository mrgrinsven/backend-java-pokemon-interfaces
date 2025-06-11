package pokemons;

import pokemons.types.ElectricAttacks;

import java.util.Arrays;
import java.util.List;

public class ElectricPokemon extends Pokemon implements ElectricAttacks {
    private final String TYPE = "electric";
    private final List<String> attacks = Arrays.asList("thunderpunch", "electroball", "thunder", "volttackle");

    public ElectricPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    List<String> getAttacks() {
        return this.attacks;
    }

    public void thunderPunch(Pokemon name, Pokemon enemy) {
        int baseDamage = 8;
        String skillName = "thunderpunch";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    public void electroBall(Pokemon name, Pokemon enemy) {
        int baseDamage = 7;
        String skillName = "electroball";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    public void thunder(Pokemon name, Pokemon enemy) {
        int baseDamage = 6;
        String skillName = "thunder";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    public void voltTackle(Pokemon name, Pokemon enemy) {
        int baseDamage = 5;
        String skillName = "volttackle";
        skillAttack(skillName, baseDamage, enemy, name);
    }

    private int damageModifier(int damage, Pokemon enemy) {
        String type = enemy.getType();
        switch (type) {
            case "electric" -> {
                return damage;
            }
            case "fire" -> {
                return damage + 5;
            }
            case "grass" -> {
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
