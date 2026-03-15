package org.cavebeetle.maven.impl;

import org.cavebeetle.maven.CryptographicHash;
import static org.cavebeetle.maven.CryptographicHashAlgorithm.SHA1;
import org.cavebeetle.maven.InternalApi;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

/**
 * The unit tests for {@code DefaultCryptographicHash.DefaultBuilder}.
 */
public final class DefaultCryptographicHashDefaultBuilderTest
{
    private InternalApi mockInternalApi;
    private DefaultCryptographicHash.DefaultBuilder cryptographicHashBuilder;

    /**
     * Sets up each unit test.
     */
    @BeforeEach
    public void setUp()
    {
        mockInternalApi = mock(InternalApi.class);
        cryptographicHashBuilder = new DefaultCryptographicHash.DefaultBuilder(mockInternalApi);
    }

    /**
     * Tests that a missing {@code InternalApi} is handled correctly.
     */
    @Test
    public final void a_missing_InternalApi_is_handled_correctly()
    {
        try
        {
            @SuppressWarnings("unused")
            var ignored = new DefaultCryptographicHash.DefaultBuilder(null);
            fail("Expected a NullPointerException.");
        }
        catch (final NullPointerException e)
        {
            assertEquals("Missing 'internalApi'.", e.getMessage());
        }
    }

    /**
     * Tests that a missing {@code CryptographicHashAlgorithm} in {CryptographicHash.Builder#newCryptographicHash} is
     * handled correctly.
     */
    @Test
    public final void a_missing_CryptographicHashAlgorithm_in_CryptographicHash_Builder_newCryptographicHash_is_handled_correctly()
    {
        try
        {
            cryptographicHashBuilder.newCryptographicHash(null);
            fail("Expected a NullPointerException.");
        }
        catch (final NullPointerException e)
        {
            assertEquals("Missing 'cryptographicHashAlgorithm'.", e.getMessage());
        }
    }

    /**
     * Tests that creating a new {@code CryptographicHash} returns a {@code CryptographicHash} instance.
     */
    @Test
    public final void creating_a_new_CryptographicHash_returns_a_CryptographicHash_instance()
    {
        final CryptographicHash cryptographicHash = cryptographicHashBuilder.newCryptographicHash(SHA1);
        assertNotNull(cryptographicHash);
    }
}
