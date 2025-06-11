package pokemons;

import pokemons.types.WaterAttacks;

import java.util.Arrays;
import java.util.List;

public class WaterPokemon extends Pokemon implements WaterAttacks {
    private static final String TYPE = "water";
    private final List<String> attacks = Arrays.asList("surf", "hydropump", "hydrocanon", "raindance");

    public WaterPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, TYPE);
    }

    public List<String> getAttacks() {
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

        if (enemy instanceof ElectricPokemon) {
            System.out.println("raindance has no effect on " + enemy.getName());
            System.out.println(enemy.getName() + " has " + enemy.getHp() + " hp left");
        }
        else if (enemy instanceof GrassPokemon) {
            System.out.println("raindance boosts " + enemy.getName() + " 's hp with " + baseDamage + " points");
            enemy.setHp(enemy.getHp() + baseDamage);
            System.out.println(enemy.getName() + " has " + enemy.getHp() + " hp left");
        }
        else {
            skillAttack(skillName, baseDamage, enemy, name);
        }
    }

    @Override
    int damageModifier(int baseDamage, Pokemon enemy) {
        String type = enemy.getType();
        switch (type) {
            case "water" -> {
                return baseDamage;
            }
            case "grass" -> {
                return baseDamage + 5;
            }
            case "electric" -> {
                return baseDamage + 8;
            }
            default -> {
                return baseDamage + 10;
            }
        }
    }
}
