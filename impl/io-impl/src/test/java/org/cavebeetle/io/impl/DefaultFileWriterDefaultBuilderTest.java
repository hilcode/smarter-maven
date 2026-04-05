package org.cavebeetle.io.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The unit tests for {@code DefaultFileWriter.DefaultBuilder}.
 */
public final class DefaultFileWriterDefaultBuilderTest {
    private DefaultFileWriter.DefaultBuilder builder;

    /**
     * Sets up each unit test.
     */
    @BeforeEach
    public void setUp() {
        builder = new DefaultFileWriter.DefaultBuilder();
    }

    /**
     * Tests that a {@code FileWriter.Builder} successfully creates a new {@code FileWriter} instance.
     *
     * @throws IOException
     *             if something goes wrong.
     */
    @Test
    public final void a_FileWriter_Builder_successfully_creates_a_new_FileWriter_instance() throws IOException {
        final File file = File.createTempFile("dummy", ".ignore");
        assertNotNull(builder.newWriter(file));
    }
}
