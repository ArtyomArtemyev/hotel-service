package by.bsuir.artemyev.client;

import by.bsuir.artemyev.domain.InternalUserDto;

public interface SecurityServiceClient {
    InternalUserDto getUserByTokenContent(String tokenContent);
}
