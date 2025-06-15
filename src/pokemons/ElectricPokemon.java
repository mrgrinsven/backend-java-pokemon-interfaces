package pokemons;

import pokemons.types.ElectricAttacks;

import java.util.Arrays;
import java.util.List;

public class ElectricPokemon extends Pokemon implements ElectricAttacks {
    private static final String TYPE = "electric";
    private final List<String> attacks = Arrays.asList("thunderpunch", "electroball", "thunder", "volttackle");

    public ElectricPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, TYPE);
    }

    public List<String> getAttacks() {
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

        if (enemy instanceof ElectricPokemon) {
            System.out.println("thunder boosts " + enemy.getName() + " 's hp with " + baseDamage + " points");
            enemy.setHp(enemy.getHp() + baseDamage);
            System.out.println(enemy.getName() + " has " + enemy.getHp() + " hp left");
        }
        else {
            skillAttack(skillName, baseDamage, enemy, name);
        }
    }

    public void voltTackle(Pokemon name, Pokemon enemy) {
        int baseDamage = 5;
        String skillName = "volttackle";

        skillAttack(skillName, baseDamage, enemy, name);
    }

    @Override
    int damageModifier(int baseDamage, Pokemon enemy) {
        String type = enemy.getType();
        switch (type) {
            case "electric" -> {
                return baseDamage;
            }
            case "fire" -> {
                return baseDamage + 5;
            }
            case "grass" -> {
                return baseDamage + 8;
            }
            default -> {
                return baseDamage + 10;
            }
        }
    }
}
