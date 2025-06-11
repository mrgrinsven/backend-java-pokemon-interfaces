package pokemons.types;

import pokemons.Pokemon;

public interface WaterAttacks {
    void surf(Pokemon name, Pokemon enemy);

    void hydroPump(Pokemon name, Pokemon enemy);

    void hydroCanon(Pokemon name, Pokemon enemy);

    void rainDance(Pokemon name, Pokemon enemy);
}
