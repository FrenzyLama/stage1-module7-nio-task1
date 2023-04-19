package com.epam.mjc.nio;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
    public Profile mapToProfile(String input) {
        Map<String, String> profileParameters = getProfileParameters(input);

        Profile profile = new Profile();

        profile.setName(profileParameters.get("Name"));
        if (profileParameters.get("Age") != null) {
            profile.setAge(Integer.parseInt(profileParameters.get("Age")));
        }
        profile.setEmail(profileParameters.get("Email"));
        if (profileParameters.get("Phone") != null) {
            profile.setPhone(Long.parseLong(profileParameters.get("Phone")));
        }
        return profile;
    }

    private Map<String, String> getProfileParameters(String input) {
        String regex = "\n";
        Map<String, String> profileParameters = new HashMap<>();

        String[] keyValueStrings = input.split(regex);

        for (String keyValue : keyValueStrings) {
            String[] separateKeyValue = keyValue.split(":");
            profileParameters.put(separateKeyValue[0], separateKeyValue[1].strip());
        }
        return profileParameters;
    }
}