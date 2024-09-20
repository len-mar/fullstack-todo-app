package org.example.fullstacktodoapp.AiApi;

import java.util.List;

public record OpenAIRequest(String model, List<OpenAiMessage> messages, double temperature) {
}
