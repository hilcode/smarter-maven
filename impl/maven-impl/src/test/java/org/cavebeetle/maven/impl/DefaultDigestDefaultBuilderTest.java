package org.cavebeetle.maven.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.cavebeetle.maven.Digest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The unit tests for {@code DefaultDigest.DefaultBuilder}.
 */
public final class DefaultDigestDefaultBuilderTest {
    private DefaultDigest.DefaultBuilder digestBuilder;

    /**
     * Sets up each unit test.
     */
    @BeforeEach
    public void setUp() {
        digestBuilder = new DefaultDigest.DefaultBuilder();
    }

    /**
     * Tests that a missing {@code byte[]} is handled correctly.
     */
    @Test
    public final void a_missing_byte_array_is_handled_correctly() {
        try {
            digestBuilder.newDigest(null);
            fail("Expected a NullPointerException.");
        } catch (final NullPointerException e) {
            assertEquals("Missing 'bytes'.", e.getMessage());
        }
    }

    /**
     * Tests that a {@code Digest} instance is created.
     */
    @Test
    public final void a_Digest_instance_is_created() {
        final byte[] bytes = new byte[0];
        final Digest digest = digestBuilder.newDigest(bytes);
        assertNotNull(digest);
    }
}
