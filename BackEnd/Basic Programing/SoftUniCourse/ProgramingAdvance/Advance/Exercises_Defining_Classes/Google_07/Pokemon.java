package JavaAdvance.Exercises_Defining_Classes.Google_07;

public class Pokemon {
    private String pokemonName;
    private String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public void setPokemonType(String pokemonType) {
        this.pokemonType = pokemonType;
    }
}
