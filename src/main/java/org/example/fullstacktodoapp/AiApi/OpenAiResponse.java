package org.example.fullstacktodoapp.AiApi;

import java.util.List;

public record OpenAiResponse(List<OpenAiChoice> choices) {
    public String getAnswer(){
        return choices().get(0).message().content();
    }
}
