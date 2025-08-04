
package com.ai.chat.models;

import com.ai.settings.state.GeneralSettings;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;

import java.util.List;

public class LanyunMaaSModelFamily implements ModelFamily {

    private final static String DEFAULT_BASE_URL = "https://maas-api.lanyun.net";

    @Override
    public OpenAiChatModel createChatModel(GeneralSettings.AssistantOptions config) {
        var baseUrl = config.isEnableCustomApiEndpointUrl() ? config.getApiEndpointUrl() : getDefaultApiEndpointUrl();
        var apiKey = config.getApiKey();
        var api = new OpenAiApi(baseUrl, apiKey);
        var options = OpenAiChatOptions.builder()
                .withModel(config.getModelName())
                .withTemperature(config.getTemperature())
                .withStreamUsage(config.isEnableStreamOptions())
                .withTopP(config.getTopP())
                .withN(1)
                .build();
        return new OpenAiChatModel(api, options);
    }

    @Override
    public String getDefaultApiEndpointUrl() {
        return DEFAULT_BASE_URL;
    }

    @Override
    public List<String> getCompatibleApiEndpointUrls() {
        return List.of(DEFAULT_BASE_URL);
    }

    @Override
    public String getApiKeysHomepage() {
        return "https://maas.lanyun.net/#/system/apiKey";
    }
}
