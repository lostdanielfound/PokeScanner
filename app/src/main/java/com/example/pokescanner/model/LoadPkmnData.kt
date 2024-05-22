package com.example.pokescanner.model

import com.example.pokescanner.R

class LoadPkmnData {
    fun LoadData(): List<Pkmn> {
        return listOf<Pkmn>(
            Pkmn(1, "Bulbasaur", "Seed Pokemon", listOf<String>("Grass", "Poison"), 0.7, 6.9, "A strange seed was planted on its back at birth. The plant sprouts and grows with this POKéMON.", R.drawable.bulbasaur),
            Pkmn(2, "Ivysaur", "Seed Pokemon", listOf<String>("Grass", "Poison"), 1.0, 13.0, "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs.", R.drawable.ivysaur),
            Pkmn(3, "Venusaur", "Seed Pokemon", listOf<String>("Grass", "Poison"), 2.0, 100.0, "The plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight.", R.drawable.venusaur),
            Pkmn(4, "Charmander", "Lizard Pokemon", listOf<String>("Fire"), 0.6, 8.5, "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.", R.drawable.charmander),
            Pkmn(5, "Charmeleon", "Flame Pokemon", listOf<String>("Fire"), 1.1, 19.0, "When it swings its burning tail, it elevates the temperature to unbearably high levels.", R.drawable.charmeleon),
            Pkmn(6, "Charizard", "Flame Pokemon", listOf<String>("Fire", "Flying"), 1.7, 90.5, "Spits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally. ", R.drawable.charizard),
            Pkmn(7, "Squirtle", "Tiny Turtle Pokemon", listOf<String>("Water"), 0.5, 9.0, "After birth, its back swells and hardens into a shell. Powerfully sprays foam from its mouth.", R.drawable.squirtle),
            Pkmn(8, "Wartortle", "Turtle Pokemon", listOf<String>("Water"), 1.0, 22.5, "Often hides in water to stalk unwary prey. For swimming fast, it moves its ears to maintain balance.", R.drawable.wartortle),
            Pkmn(9, "Blastoise", "Shellfish", listOf<String>("Water"), 1.6, 85.0, "A brutal Pokémon with pressurized water jets on its shell. They are used for high speed tackles.", R.drawable.blastoise),
        )
    }
}