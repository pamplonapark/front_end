package com.example.pamplonapark.internal_code

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.Key
import java.security.KeyStore
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec


/**
* Clase para operaciones de cifrado.
* Esta clase proporciona métodos para generar una clave AES y cifrar datos utilizando esta clave.
*/
class Crypto
{
    private val key = "aes_key"

    /**
     * Encryption of the data
     *
     * @param password as ByteArray
     * @return ByteArray of data encrypted
     * */
    fun ByteArray.toHex(): String {
        val hexChars = "0123456789abcdef"
        val result = StringBuilder(size * 2)
        forEach {
            val octet = it.toInt()
            result.append(hexChars[octet shr 4 and 0x0f])
            result.append(hexChars[octet and 0x0f])
        }
        return result.toString()
    }

    fun encryptPassword(password: String): String {
        val messageDigest = MessageDigest.getInstance("SHA-256")
        val hashBytes = messageDigest.digest(password.toByteArray())
        return hashBytes.toHex()
    }

    fun encryptData(data: ByteArray, key: SecretKey): Pair<ByteArray, ByteArray> {
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val iv = cipher.iv
        val encryptedData = cipher.doFinal(data)

        return Pair(iv, encryptedData)
    }

    fun decryptData(encryptedData: ByteArray, key: SecretKey, iv: ByteArray, authTag: ByteArray): ByteArray {
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val ivSpec = GCMParameterSpec(128, iv)
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(), ivSpec)
        cipher.updateAAD(authTag)
        return cipher.doFinal(encryptedData)
    }

    /**
     * Get the secret Key
     *
     * @return SecretKey : The key stored in KeyStore or NULL if no key exists
     * */
    private fun getSecretKey(): Key {
        val keyStore = KeyStore.getInstance("AndroidKeyStore")
        keyStore.load(null)

        return keyStore.getKey(key, null)
    }

    public fun parseToString(bytes : ByteArray): String
    {
        val hexChars = CharArray(bytes.size * 2)
        for (i in bytes.indices) {
            val v = bytes[i].toInt() and 0xFF
            hexChars[i * 2] = "0123456789ABCDEF"[v shr 4]
            hexChars[i * 2 + 1] = "0123456789ABCDEF"[v and 0x0F]
        }
        return String(hexChars)
    }
}