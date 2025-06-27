package s14

import org.jsoup.Jsoup
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File

fun main() {
    val url = "https://refactoring.guru/ru/refactoring/smells" // replace with your target URL

    try {
        // --- 1. Download HTML page using Jsoup ---
        val doc = Jsoup.connect(url).get()
        println("Page downloaded successfully.")

        // --- 2. Extract <img> tags ---
        val images = doc.select("img")
        println("Found ${images.size} images.")

        // --- 3. OkHttpClient setup ---
        val client = OkHttpClient()

        // --- 4. Download each image ---
        for ((index, img) in images.withIndex()) {
            val src = img.absUrl("src")
            if (src.isNotEmpty()) {
                println("Downloading image: $src")

                val request = Request.Builder().url(src).build()
                client.newCall(request).execute().use { response ->
                    if (response.isSuccessful) {
                        val bytes = response.body!!.bytes()
                        val filename = "image_$index.jpg"
                        File(filename).writeBytes(bytes)
                        println("Saved as $filename")
                    } else {
                        println("Failed to download: $src")
                    }
                }
            }
        }

        println("All images processed.")
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
