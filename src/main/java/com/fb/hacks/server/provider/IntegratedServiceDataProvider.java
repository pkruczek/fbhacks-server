package com.fb.hacks.server.provider;

import java.util.Set;

public interface IntegratedServiceDataProvider {
    Set<String> getInterests(String userId);
}
