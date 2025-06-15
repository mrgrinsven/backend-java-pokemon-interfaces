package pokemons;

import pokemons.types.GrassAttacks;

import java.util.Arrays;
import java.util.List;

public class GrassPokemon extends Pokemon implements GrassAttacks {
    private static final String TYPE = "grass";
    private final List<String> attacks = Arrays.asList("leafstorm","solarbeam", "leechseed", "leaveblade");

    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, TYPE);
    }

    public List<String> getAttacks() {
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
        int totalDamage = damageModifier(baseDamage, enemy);
        String skillName = "leechseed";

        skillAttack(skillName, baseDamage, enemy, name);
        System.out.println(skillName + " gains " + totalDamage + " hp");
        name.setHp(name.getHp() + totalDamage);
    }

    @Override
    public void leaveBlade(Pokemon name, Pokemon enemy) {
        int baseDamage = 5;
        String skillName = "leaveblade";

        skillAttack(skillName, baseDamage, enemy, name);
    }

    @Override
    int damageModifier(int baseDamage, Pokemon enemy) {
        String type = enemy.getType();
        switch (type) {
            case "grass" -> {
                return baseDamage;
            }
            case "water" -> {
                return baseDamage + 5;
            }
            case "fire" -> {
                return baseDamage + 8;
            }
            default -> {
                return baseDamage + 10;
            }
        }
    }
}
