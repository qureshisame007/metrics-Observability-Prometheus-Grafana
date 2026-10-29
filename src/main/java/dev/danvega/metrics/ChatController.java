package dev.danvega.metrics;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/short")
    public String shortPrompt() {
        return chatClient.prompt()
                .user("when did the first human walk on the moon?")
                .call()
                .content();
    }

    @GetMapping("/long")
    public String longPrompt(){
        return chatClient.prompt()
                .user("write me a 1000 words short story about a robot")
                .call()
                .content();
    }
}
