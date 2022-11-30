package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";
    private final PlayerRepository playerRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final StringBuilder sb;
    private final ValidationUtil validationUtil;
    private final TownService townService;
    private final TeamService teamService;
    private final StatService statService;

    public PlayerServiceImpl(PlayerRepository playerRepository, XmlParser xmlParser, ModelMapper modelMapper, StringBuilder sb, ValidationUtil validationUtil, TownService townService, TeamService teamService, StatService statService) {
        this.playerRepository = playerRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.sb = sb;
        this.validationUtil = validationUtil;
        this.townService = townService;
        this.teamService = teamService;
        this.statService = statService;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files
                .readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {

        xmlParser
                .fromFile(PLAYERS_FILE_PATH, PlayerSeedRootDto.class)
                .getPlayers()
                .stream()
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto);

                    Player playerFromDb = findPlayerByEmail(playerSeedDto.getEmail());

                    if (playerFromDb != null) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported Player %s %s - %s",
                                    playerSeedDto.getFirstName(), playerSeedDto.getLastName(), playerSeedDto.getPosition().name())
                                    : "Invalid Player")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(playerSeedDto -> {

                    Player player = modelMapper.map(playerSeedDto, Player.class);

                    player.setTown(townService.findTownByName(playerSeedDto.getTown().getName()));
                    player.setTeam(teamService.findTeamByName(playerSeedDto.getTeam().getName()));
                    player.setStat(statService.findStatById(playerSeedDto.getStat().getId()));


                    return player;
                })
                .forEach(playerRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportBestPlayers() {
        findAllPlayersByBirthdateOrderedByStatShootingDescStatPassingDescStatEnduranceDescPlayerLastName()
                .forEach(player -> {
                    sb.append(player);
                    sb.append(System.lineSeparator());
                });

        return sb.toString().trim();
    }

    @Override
    public Player findPlayerByEmail(String email) {
        return playerRepository
                .findByEmail(email)
                .orElse(null);
    }

    @Override
    public List<String> findAllPlayersByBirthdateOrderedByStatShootingDescStatPassingDescStatEnduranceDescPlayerLastName() {
        return playerRepository
                .findAllByBirthdateOrderedByStatShootingDescPassingDescEnduranceDescLastNameAsc()
                .stream()
                .map(Player::toString)
                .collect(Collectors.toList());

    }
}
