package com.example.pamplonapark.internal_code

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.Key
import java.security.KeyStore
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec
import java.util.Base64
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec

class Crypto
{
    fun generateAESKey(): Key
    {
        val keyGenerator = KeyGenerator.getInstance("AES")
        keyGenerator.init(256, SecureRandom())
        return keyGenerator.generateKey()
    }

    fun encrypt(text: String, key: Key): String {
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val encryptedBytes = cipher.doFinal(text.toByteArray())
        return Base64.getEncoder().encodeToString(encryptedBytes)
    }



    fun main() {
        val originalText = "Hello, AES-256 encryption!"

        // Generate a random AES key
        val aesKey = generateAESKey()

        // Encrypt the text
        val encryptedText = encrypt(originalText, aesKey)
        println("Encrypted Text: $encryptedText")

        // Decrypt the text
        val decryptedText = decrypt(encryptedText, aesKey)
        println("Decrypted Text: $decryptedText")
    }

    /*private val keystoreAlias = "MyKeystoreAlias"

    init {
        createSecretKey()
    }

    private fun createSecretKey() {
        val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")

        val keyGenParameterSpec = KeyGenParameterSpec.Builder(
            keystoreAlias,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .build()

        keyGenerator.init(keyGenParameterSpec)
        keyGenerator.generateKey()
    }

    fun getSecretKey(): SecretKey {
        val keyStore = KeyStore.getInstance("AndroidKeyStore")
        keyStore.load(null)

        return keyStore.getKey(keystoreAlias, null) as SecretKey
    }

    fun encryptData(data: ByteArray): ByteArray {
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey())
        return cipher.doFinal(data)
    }

    fun decryptData(encryptedData: ByteArray, iv: ByteArray): ByteArray {
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val spec = GCMParameterSpec(128, iv)
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(), spec)
        r*/
}