package lk.my.EventTicketingSystem.service;

import lk.my.EventTicketingSystem.model.Configure;
import lk.my.EventTicketingSystem.repository.ConfigureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigureService {
    private ConfigureRepository configureRepository;

    @Autowired
    public ConfigureService(ConfigureRepository configureRepository) {
        this.configureRepository = configureRepository;
    }

    public String test() {
        return "Backend eka wada yakooo..";
    }

    public Configure addConfigure(Configure configure) {
        return configureRepository.save(configure);
    }
}
