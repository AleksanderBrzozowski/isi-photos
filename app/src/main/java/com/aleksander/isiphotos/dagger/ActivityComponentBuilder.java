package com.aleksander.isiphotos.dagger;

/**
 * @author Aleksander
 */

public interface ActivityComponentBuilder<T extends ActivityComponent> {
    T build();
}
