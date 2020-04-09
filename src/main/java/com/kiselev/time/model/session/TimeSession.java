package com.kiselev.time.model.session;

import com.kiselev.time.model.profile.Profile;
import lombok.Data;

@Data
public class TimeSession {

    private Profile profile;

    public boolean hasProfile() {
        return profile != null;
    }

    public boolean hasNoProfile() {
        return profile == null;
    }
}
