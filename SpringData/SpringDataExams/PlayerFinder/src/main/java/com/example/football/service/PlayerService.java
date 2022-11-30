package com.example.football.service;

import com.example.football.models.entity.Player;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface PlayerService {
    boolean areImported();

    String readPlayersFileContent() throws IOException;

    String importPlayers() throws JAXBException, FileNotFoundException;

    String exportBestPlayers();

    Player findPlayerByEmail(String email);

    List<String> findAllPlayersByBirthdateOrderedByStatShootingDescStatPassingDescStatEnduranceDescPlayerLastName();


}
