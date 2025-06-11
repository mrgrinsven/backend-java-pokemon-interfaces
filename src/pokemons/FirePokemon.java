package pokemons;

import pokemons.types.FireAttacks;

import java.util.Arrays;
import java.util.List;

public class FirePokemon extends Pokemon implements FireAttacks {
    private static final String TYPE = "fire";
    private final List<String> attacks = Arrays.asList("inferno", "pyroball", "firelash", "flamethrower");

    public FirePokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, TYPE);
    }

    public List<String> getAttacks() {
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

    @Override
    int damageModifier(int baseDamage, Pokemon enemy) {
        String type = enemy.getType();
        switch (type) {
            case "fire" -> {
                return baseDamage;
            }
            case "electric" -> {
                return baseDamage + 5;
            }
            case "water" -> {
                return baseDamage + 8;
            }
            default -> {
                return baseDamage + 10;
            }
        }
    }
}
