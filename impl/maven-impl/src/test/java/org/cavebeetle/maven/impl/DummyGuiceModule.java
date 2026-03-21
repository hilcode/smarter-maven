package org.cavebeetle.maven.impl;

import com.google.inject.AbstractModule;
import org.cavebeetle.io.IoApi;

/**
 * A dummy Guice module for testing.
 */
public final class DummyGuiceModule extends AbstractModule {
    @Override
    public void configure() {
        bind(IoApi.class).to(DummyIoApi.class);
    }
}
