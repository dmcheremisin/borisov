package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.config.ProphetProperties;
import org.example.consts.ProfileConstants;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(ProfileConstants.WINTER_IS_HERE)
@RequiredArgsConstructor
public class WhiteListBasedProphetService implements ProphetService {

    private final ProphetProperties prophetProperties;

    @Override
    public boolean willSurvive(String name) {
        return prophetProperties.getPossiblyReturnMoney().contains(name);
    }

}

