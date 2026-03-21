package org.cavebeetle.maven.impl;

import static org.cavebeetle.maven.CryptographicHashAlgorithm.MD2;
import static org.cavebeetle.maven.CryptographicHashAlgorithm.MD5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.cavebeetle.io.InputStream;
import org.cavebeetle.maven.Digest;
import org.cavebeetle.maven.InternalApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The unit tests for {@code DefaultCryptographicHash}.
 */
public final class DefaultCryptographicHashTest {
    private InternalApi mockInternalApi;
    private DefaultCryptographicHash cryptographicHash;

    /**
     * Sets up each unit test.
     */
    @BeforeEach
    public void setUp() {
        mockInternalApi = mock(InternalApi.class);
        cryptographicHash = new DefaultCryptographicHash(mockInternalApi, MD5);
    }

    /**
     * Tests that a missing {@code InternalApi} is handled correctly.
     */
    @Test
    public final void a_missing_InternalApi_is_handled_correctly() {
        try {
            new DefaultCryptographicHash(null, MD2);
            fail("Expected a NullPointerException.");
        } catch (final NullPointerException e) {
            assertEquals("Missing 'internalApi'.", e.getMessage());
        }
    }

    /**
     * Tests that a missing {@code CryptographicHashAlgorithm} is handled correctly.
     */
    @Test
    public final void a_missing_CryptographicHashAlgorithm_is_handled_correctly() {
        try {
            new DefaultCryptographicHash(mockInternalApi, null);
            fail("Expected a NullPointerException.");
        } catch (final NullPointerException e) {
            assertEquals("Missing 'cryptographicHashAlgorithm'.", e.getMessage());
        }
    }

    /**
     * Tests that a missing {@code InputStream} in {@code CryptographicHash#generateDigest} is handled correctly.
     */
    @Test
    public final void a_missing_InputStream_in_CryptographicHash_generateDigest_is_handled_correctly() {
        try {
            cryptographicHash.generateDigest((InputStream) null);
            fail("Expected a NullPointerException.");
        } catch (final NullPointerException e) {
            assertEquals("Missing 'inputStream'.", e.getMessage());
        }
    }

    /**
     * Tests that a {@code Digest} is created from an {@code InputStream}.
     */
    @Test
    @SuppressWarnings("boxing")
    public final void a_Digest_is_created_from_an_InputStream() {
        final InputStream mockInputStream = mock(InputStream.class);
        when(mockInputStream.read(any(byte[].class))).thenReturn(1, -1);
        final Digest mockDigest = mock(Digest.class);
        when(mockInternalApi.newDigest(any(byte[].class))).thenReturn(mockDigest);
        final Digest digest = cryptographicHash.generateDigest(mockInputStream);
        assertSame(mockDigest, digest);
    }
}
