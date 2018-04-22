package by.bsuir.artemyev.client.impl;

import by.bsuir.artemyev.client.SecurityServiceClient;
import by.bsuir.artemyev.domain.InternalUserDto;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SecurityServiceClientImpl implements SecurityServiceClient {
    private static Logger logger = LogManager.getLogger(SecurityServiceClientImpl.class);

    private static final String SECURITY_SERVICE_HOST = "http://localhost:9092";
    private static final String TOKENS_USER_URL = "/api/v1/tokens/user";

    @Override
    public InternalUserDto getUserByTokenContent(String tokenContent) {
        logger.info("Request to security service for getting user by token content");
        RestTemplate template = new RestTemplate();
        return template.postForObject(SECURITY_SERVICE_HOST + TOKENS_USER_URL, tokenContent, InternalUserDto.class);
    }
}
