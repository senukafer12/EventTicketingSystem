package lk.my.EventTicketingSystem.controller;

import lk.my.EventTicketingSystem.model.Configure;
import lk.my.EventTicketingSystem.service.ConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConfigureController {

    @Autowired
    private ConfigureService configureService;

    public ConfigureController(ConfigureService configureService) {
        this.configureService = configureService;
    }

    @GetMapping("/test")
    public ResponseEntity<Object> test() {
        return ResponseEntity.ok(configureService.test());
    }

    @PostMapping("/add-configure")
    public ResponseEntity<Configure> addConfigure(@RequestBody Configure configure) {
        // Use configure object directly

        // Save the configuration using your service
        Configure savedConfig = configureService.addConfigure(configure);

        return new ResponseEntity<>(savedConfig, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Configure> addConfiguration(@RequestBody Configure configure) {
        configureService.addConfigure(configure);
        return ResponseEntity.ok(configure);
    }
}
