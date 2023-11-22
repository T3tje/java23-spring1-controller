package de.neuefische.java23spring1controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
public class Message {

    private List<Message> messages = new ArrayList<>();

    private String message;
    private String name;
    private String id;

    @PostMapping("/api/message")
    public String addMessage(@RequestBody Message message) {
        messages.add(message);
        return getMessages().toString();
    }

    @GetMapping("/api/messages")
    public String returnMessages() {
        return messages.toString();
    }

    @DeleteMapping("api/messages")
    public String deleteMessage(@RequestParam String id) {
        Message messageToRemove = null;

        for (Message message : messages) {
            if (message.getId().equals(id)) {
                messageToRemove = message;
                break;
            }
        }

        if (messageToRemove != null) {
            messages.remove(messageToRemove);
            return messages.toString();
        } else {
            return "Message mit der ID: " + id + " nicht gefunden";
        }
    }
}
