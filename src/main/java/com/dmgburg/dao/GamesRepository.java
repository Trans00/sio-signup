package com.dmgburg.dao;

import com.dmgburg.domain.Game;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

import java.io.EOFException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GamesRepository {
    private static List<Game> games = new ArrayList<>();
    public List<Game> getGames() throws Exception {
        return games;
    }

    public void saveGames(List<Game> newGames) throws Exception {
        games = newGames;
    }
}
