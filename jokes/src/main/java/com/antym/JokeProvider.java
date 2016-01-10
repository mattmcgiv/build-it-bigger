package com.antym;

import java.util.ArrayList;
import java.util.Random;

public class JokeProvider {

    public static String getJoke() {
        ArrayList<String> jokes = new ArrayList<String>();
        jokes.add("A skeleton walks into a bar and says, \"Gimme a beer and a mop.\"");
        jokes.add("Why didn't the skeleton go to the party?\n" +
                "He had no body to go with.\n");
        jokes.add("Q: Why wouldn't the skeleton jump off the cliff?\n" +
                "A: Because he didn't have the guts.");

        Random random = new Random();
        return jokes.get(random.nextInt(jokes.size()));

    }
}
