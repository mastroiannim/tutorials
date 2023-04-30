package it.paleocapa.mastroiannim;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerMessageController {

    
    @GetMapping("/messages")
    public String getMessage() {
        return "Hello from Docker!";
    }

    @GetMapping("/")
    public String home() {
        return "Home from Docker!";
    }
}
