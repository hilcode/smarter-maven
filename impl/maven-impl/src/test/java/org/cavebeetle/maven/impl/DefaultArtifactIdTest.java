package org.cavebeetle.maven.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The unit tests for {@code DefaultArtifactId}.
 */
public final class DefaultArtifactIdTest {
    private String artifactIdAsText;
    private DefaultArtifactId artifactId;
    private DefaultArtifactId artifactIdCopy;
    private DefaultArtifactId otherArtifactId;

    /**
     * Sets up each unit test.
     */
    @BeforeEach
    public void setUp() {
        artifactIdAsText = "artifact-id";
        artifactId = new DefaultArtifactId(artifactIdAsText);
        artifactIdCopy = new DefaultArtifactId(artifactIdAsText);
        otherArtifactId = new DefaultArtifactId("...");
    }

    /**
     * Tests that a missing artifact id is not valid.
     */
    @Test
    public final void a_missing_artifact_id_is_not_valid() {
        try {
            @SuppressWarnings("unused")
            var ignored = new DefaultArtifactId(null);
            fail("Expected an IllegalArgumentException.");
        } catch (final IllegalArgumentException e) {
            assertEquals("Missing 'artifactId'.", e.getMessage());
        }
    }

    /**
     * Tests that an empty artifact id is not valid.
     */
    @Test
    public final void an_empty_artifact_id_is_not_valid() {
        try {
            @SuppressWarnings("unused")
            var ignored = new DefaultArtifactId("");
            fail("Expected an IllegalArgumentException.");
        } catch (final IllegalArgumentException e) {
            assertEquals("Missing 'artifactId'.", e.getMessage());
        }
    }

    /**
     * Tests that the provided artifact id is used.
     */
    @Test
    public final void the_provided_artifact_id_is_used() {
        assertSame(artifactIdAsText, artifactId.toString());
    }

    /**
     * Tests that an {@code ArtifactId} has a valid {@code Object#hashCode()} implementation.
     */
    @Test
    public final void an_ArtifactId_has_a_valid_Object_hashCode_implementation() {
        assertEquals(artifactId.hashCode(), artifactId.hashCode());
        assertEquals(artifactId.hashCode(), artifactIdCopy.hashCode());
        assertNotEquals(artifactId.hashCode(), otherArtifactId.hashCode());
        assertNotEquals(artifactIdCopy.hashCode(), otherArtifactId.hashCode());
    }

    /**
     * Tests that an {@code ArtifactId} has a valid {@code Object#equals(Object)} implementation.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public final void an_ArtifactId_has_a_valid_Object_equals_implementation() {
        assertTrue(artifactId.equals(artifactId));
        assertTrue(artifactId.equals(artifactIdCopy));
        assertTrue(artifactIdCopy.equals(artifactId));
        assertFalse(artifactId.equals(otherArtifactId));
        assertFalse(otherArtifactId.equals(artifactId));
        assertFalse(artifactId.equals(null));
        assertFalse(artifactId.equals(new Object()));
    }
}
