package br.com.lucolimac

import java.io.ByteArrayOutputStream
import java.nio.charset.StandardCharsets
import java.util.zip.GZIPOutputStream

object CompressFunctions {
    // Define a function that  given a file name with json extension return your content gzip compress it and encode it to base64
    fun compressJsonFileToBase64(fileName: String): String {
        val file = java.io.File(fileName)
        val json = file.readText()
        val jsonBytes = json.toByteArray()

        val byteStream = ByteArrayOutputStream()
        val gzip = GZIPOutputStream(byteStream).apply { bufferedWriter(StandardCharsets.UTF_8) }
        gzip.write(jsonBytes)
        gzip.close()
        val compressedBytes = byteStream.toByteArray()
        return java.util.Base64.getEncoder().encodeToString(compressedBytes)
    }

    // Define a function to decode a base64 string, decompress it and return as string
    fun decompressBase64ToText(base64: String): String {
        val compressedBytes = java.util.Base64.getDecoder().decode(base64)
        val gzip = java.util.zip.GZIPInputStream(compressedBytes.inputStream())
        val text = gzip.reader().readText()
        return text
    }
}

