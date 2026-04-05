package org.cavebeetle.maven;

import com.google.inject.AbstractModule;
import org.cavebeetle.io.impl.IoGuiceModule;
import org.cavebeetle.maven.impl.MavenGuiceModule;

/**
 * The Guice module describing the required bindings.
 */
public final class GuiceModule extends AbstractModule {
    @Override
    public void configure() {
        install(new MavenGuiceModule());
        install(new IoGuiceModule());
    }
}
