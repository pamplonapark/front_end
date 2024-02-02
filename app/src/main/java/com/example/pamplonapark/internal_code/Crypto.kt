package com.example.pamplonapark.internal_code

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

class Crypto
{
    private val key = "aes_numeric_value"

    init
    {
        generateAESKey()
    }

    /** Creation of the key (and inserting it in KeyStore)
    *
    * @return Key : Key generated or NULL if already generated
    * */
    private fun generateAESKey(): SecretKey?
    {
        if(this.getSecretKey() == null)
        {
            val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
            val keyGenParameterSpec = KeyGenParameterSpec.Builder(key, KeyProperties.PURPOSE_ENCRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .build()

            keyGenerator.init(keyGenParameterSpec)
            return keyGenerator.generateKey()
        }

        return null;
    }

    /**
     * Encryption of the data
     *
     * @param password as ByteArray
     * @return ByteArray of data encrypted
     * */
    fun encrypt(password: ByteArray): ByteArray
    {
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey())
        return cipher.doFinal(password)
    }

    /**
     * Get the secret Key
     *
     * @return SecretKey : The key stored in KeyStore or NULL if no key exists
     * */
    private fun getSecretKey(): SecretKey {
        val keyStore = KeyStore.getInstance("AndroidKeyStore")
        keyStore.load(null)

        return keyStore.getKey(key, null) as SecretKey
    }
}