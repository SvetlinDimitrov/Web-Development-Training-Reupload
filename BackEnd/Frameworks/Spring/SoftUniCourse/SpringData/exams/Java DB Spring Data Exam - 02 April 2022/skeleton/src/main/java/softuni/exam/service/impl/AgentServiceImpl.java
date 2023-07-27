package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.exam.models.dto.AgentsImportDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.Validate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final static String PATH_FILE = "src/main/resources/files/json/agents.json";

    public AgentServiceImpl(AgentRepository agentRepository, TownRepository townRepository, Gson gson) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() != 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(PATH_FILE));
    }

    @Override
    @Transactional
    public String importAgents() throws IOException {
        StringBuilder builder = new StringBuilder();

        Arrays.stream(gson.fromJson(readAgentsFromFile() , AgentsImportDto[].class))
                .forEach(a->{
                    if(!Validate.checkIfItsValid(a) ||
                    agentRepository.findByEmail(a.getEmail()).isPresent() ||
                    agentRepository.findByFirstName(a.getFirstName()).isPresent() ||
                    townRepository.findByTownName(a.getTown()).isEmpty()){
                        builder.append("Invalid agent")
                                .append(System.lineSeparator());
                        return;
                    }
                    agentRepository.save(toAgent(a));
                    builder.append(String.format("Successfully imported agent - %s %s",
                                    a.getFirstName(),
                                    a.getLastName()))
                            .append(System.lineSeparator());


                });

        return builder.toString();
    }
    private Agent toAgent(AgentsImportDto agentsImportDto){
        return new Agent()
                .setEmail(agentsImportDto.getEmail())
                .setFirstName(agentsImportDto.getFirstName())
                .setLastName(agentsImportDto.getLastName())
                .setTown(townRepository.findByTownName(agentsImportDto.getTown()).orElseThrow());
    }
}
