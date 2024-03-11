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
import javax.crypto.spec.SecretKeySpec


/**
* Clase para operaciones de cifrado.
* Esta clase proporciona métodos para generar una clave AES y cifrar datos utilizando esta clave.
*/
class Crypto
{
    private val AES_MODE = "AES/CTR/NoPadding"

    fun encryptPassword(password: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hash = digest.digest(password.toByteArray())
        return hash.joinToString("") { "%02x".format(it) }
    }

    /*data class EncryptionResult(val encryptedData: ByteArray, val iv: ByteArray, val authTag: ByteArray)

    fun encryptData(data: ByteArray): EncryptionResult {
        val cipher = Cipher.getInstance(AES_MODE)
        val secretKey = getSecretKey()
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val encryptedData = cipher.doFinal(data)
        val iv = cipher.iv
        val authTag = encryptedData.copyOfRange(encryptedData.size - 256, encryptedData.size)
        return EncryptionResult(encryptedData, iv, authTag)
    }

    fun decryptData(encryptedData: ByteArray, iv: ByteArray, authTag: ByteArray): ByteArray {
        val cipher = Cipher.getInstance(AES_MODE)
        val secretKey = getSecretKey()
        val spec = GCMParameterSpec(256, iv)
        cipher.init(Cipher.DECRYPT_MODE, secretKey, spec)
        cipher.updateAAD(authTag)
        return cipher.doFinal(encryptedData)
    }

    private fun getSecretKey(): SecretKey {
        return SecretKeySpec("A79F0833C46A4D5219E3B23A796F9790C55B1AF4D93C6EF94C1F957A8DC28F".toByteArray(), "AES")
    }*/
}