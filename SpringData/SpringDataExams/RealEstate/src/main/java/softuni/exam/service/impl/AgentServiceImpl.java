package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentSeedDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {

    private static final String AGENTS_FILE_PATH = "src/main/resources/files/json/agents.json";
    private final AgentRepository agentRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;

    public AgentServiceImpl(AgentRepository agentRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, TownService townService) {
        this.agentRepository = agentRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files
                .readString(Path.of(AGENTS_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays
                .stream(gson.fromJson(readAgentsFromFile(), AgentSeedDTO[].class))
                .filter(agentSeedDTO -> {
                    boolean isValid = validationUtil.isValid(agentSeedDTO);

                    Agent agentFromRepository = findAgentByFirstName(agentSeedDTO.getFirstName());
                    if (agentFromRepository != null) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported agent - %s %s",
                                    agentSeedDTO.getFirstName(), agentSeedDTO.getLastName())
                                    : "Invalid agent")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(agentSeedDTO -> {

                    Agent agent = modelMapper.map(agentSeedDTO, Agent.class);
                    Town town = townService.findTownByName(agentSeedDTO.getTown());
                    agent.setTown(town);

                    return agent;
                })
                .forEach(agentRepository::save);

        return sb.toString().trim();
    }

    @Override
    public Agent findAgentByFirstName(String agentFirstName) {
        return agentRepository.findByFirstName(agentFirstName)
                .orElse(null);
    }
}
