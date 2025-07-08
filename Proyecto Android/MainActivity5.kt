package com.example.proyectofinal

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity5 : AppCompatActivity() {
    var numero_planta=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val btnNext1: Button = findViewById(R.id.button5)
        val imageViewPlanta7: ImageView = findViewById(R.id.imageView7)
        val imageViewPlanta8: ImageView = findViewById(R.id.imageView8)
        val imageViewPlanta9: ImageView = findViewById(R.id.imageView9)
        val imageViewPlanta10: ImageView = findViewById(R.id.imageView10)
        val imageViewPlanta11: ImageView = findViewById(R.id.imageView11)
        val imageViewPlanta12: ImageView = findViewById(R.id.imageView12)

        btnNext1.setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }

        imageViewPlanta7.setOnClickListener {
            numero_planta=7
            dialogoplanta7()
        }

        imageViewPlanta8.setOnClickListener {
            numero_planta=8
            dialogoplanta8()
        }

        imageViewPlanta9.setOnClickListener {
            numero_planta=9
            dialogoplanta9()
        }

        imageViewPlanta10.setOnClickListener {
            numero_planta=10
            dialogoplanta10()
        }

        imageViewPlanta11.setOnClickListener {
            numero_planta=11
            dialogoplanta11()
        }

        imageViewPlanta12.setOnClickListener {
            numero_planta=12
            dialogoplanta12()
        }
    }

    private fun dialogoplanta7() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p7, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView22)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView60)
                val plantImage = imageViewPlantDialog.drawable
                val plantName = textViewPlantDetails.text.toString()

                // Crear el intent de compartir
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "image/*"

                // Agregar la imagen de la planta al intent
                val imageUri = getBitmapUri(plantImage)
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)

                // Agregar el nombre de la planta al mensaje de compartir
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Mira esta planta que me ha gustado, se llama: $plantName")

                // Iniciar la actividad de compartir
                startActivity(Intent.createChooser(shareIntent, "Compartir en"))
            }
        builder.setNegativeButton("Añadir a favoritos") { _, _ ->
            val valorActual = leerFav(numero_planta)
            val nuevoValor = if (valorActual == "0") "1" else "0"
            escribirFav(numero_planta, nuevoValor)
        }

        val dialog = builder.create()
        dialog.show()

        val window = dialog.window
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        window?.setLayout((resources.displayMetrics.widthPixels * 1.0).toInt(), layoutParams.height)
    }

    private fun dialogoplanta8() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p8, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView23)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView65)
                val plantImage = imageViewPlantDialog.drawable
                val plantName = textViewPlantDetails.text.toString()

                // Crear el intent de compartir
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "image/*"

                // Agregar la imagen de la planta al intent
                val imageUri = getBitmapUri(plantImage)
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)

                // Agregar el nombre de la planta al mensaje de compartir
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Mira esta planta que me ha gustado, se llama: $plantName")

                // Iniciar la actividad de compartir
                startActivity(Intent.createChooser(shareIntent, "Compartir en"))
            }
        builder.setNegativeButton("Añadir a favoritos") { _, _ ->
            val valorActual = leerFav(numero_planta)
            val nuevoValor = if (valorActual == "0") "1" else "0"
            escribirFav(numero_planta, nuevoValor)
        }

        val dialog = builder.create()
        dialog.show()

        val window = dialog.window
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        window?.setLayout((resources.displayMetrics.widthPixels * 1.0).toInt(), layoutParams.height)
    }

    private fun dialogoplanta9() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p9, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView24)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView70)
                val plantImage = imageViewPlantDialog.drawable
                val plantName = textViewPlantDetails.text.toString()

                // Crear el intent de compartir
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "image/*"

                // Agregar la imagen de la planta al intent
                val imageUri = getBitmapUri(plantImage)
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)

                // Agregar el nombre de la planta al mensaje de compartir
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Mira esta planta que me ha gustado, se llama: $plantName")

                // Iniciar la actividad de compartir
                startActivity(Intent.createChooser(shareIntent, "Compartir en"))
            }
        builder.setNegativeButton("Añadir a favoritos") { _, _ ->
            val valorActual = leerFav(numero_planta)
            val nuevoValor = if (valorActual == "0") "1" else "0"
            escribirFav(numero_planta, nuevoValor)
        }

        val dialog = builder.create()
        dialog.show()

        val window = dialog.window
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        window?.setLayout((resources.displayMetrics.widthPixels * 1.0).toInt(), layoutParams.height)
    }

    private fun dialogoplanta10() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p10, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView25)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView75)
                val plantImage = imageViewPlantDialog.drawable
                val plantName = textViewPlantDetails.text.toString()

                // Crear el intent de compartir
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "image/*"

                // Agregar la imagen de la planta al intent
                val imageUri = getBitmapUri(plantImage)
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)

                // Agregar el nombre de la planta al mensaje de compartir
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Mira esta planta que me ha gustado, se llama: $plantName")

                // Iniciar la actividad de compartir
                startActivity(Intent.createChooser(shareIntent, "Compartir en"))
            }
        builder.setNegativeButton("Añadir a favoritos") { _, _ ->
            val valorActual = leerFav(numero_planta)
            val nuevoValor = if (valorActual == "0") "1" else "0"
            escribirFav(numero_planta, nuevoValor)
        }

        val dialog = builder.create()
        dialog.show()

        val window = dialog.window
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        window?.setLayout((resources.displayMetrics.widthPixels * 1.0).toInt(), layoutParams.height)
    }

    private fun dialogoplanta11() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p11, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView26)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView80)
                val plantImage = imageViewPlantDialog.drawable
                val plantName = textViewPlantDetails.text.toString()

                // Crear el intent de compartir
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "image/*"

                // Agregar la imagen de la planta al intent
                val imageUri = getBitmapUri(plantImage)
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)

                // Agregar el nombre de la planta al mensaje de compartir
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Mira esta planta que me ha gustado, se llama: $plantName")

                // Iniciar la actividad de compartir
                startActivity(Intent.createChooser(shareIntent, "Compartir en"))
            }
        builder.setNegativeButton("Añadir a favoritos") { _, _ ->
            val valorActual = leerFav(numero_planta)
            val nuevoValor = if (valorActual == "0") "1" else "0"
            escribirFav(numero_planta, nuevoValor)
        }

        val dialog = builder.create()
        dialog.show()

        val window = dialog.window
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        window?.setLayout((resources.displayMetrics.widthPixels * 1.0).toInt(), layoutParams.height)
    }

    private fun dialogoplanta12() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p12, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView27)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView85)
                val plantImage = imageViewPlantDialog.drawable
                val plantName = textViewPlantDetails.text.toString()

                // Crear el intent de compartir
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "image/*"

                // Agregar la imagen de la planta al intent
                val imageUri = getBitmapUri(plantImage)
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)

                // Agregar el nombre de la planta al mensaje de compartir
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Mira esta planta que me ha gustado, se llama: $plantName")

                // Iniciar la actividad de compartir
                startActivity(Intent.createChooser(shareIntent, "Compartir en"))
            }
        builder.setNegativeButton("Añadir a favoritos") { _, _ ->
            val valorActual = leerFav(numero_planta)
            val nuevoValor = if (valorActual == "0") "1" else "0"
            escribirFav(numero_planta, nuevoValor)
        }

        val dialog = builder.create()
        dialog.show()

        val window = dialog.window
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        window?.setLayout((resources.displayMetrics.widthPixels * 1.0).toInt(), layoutParams.height)
    }

    private fun getBitmapUri(drawable: Drawable): Uri {
        val bmp = (drawable as BitmapDrawable).bitmap
        val bmpPath = MediaStore.Images.Media.insertImage(contentResolver, bmp, "Planta", null)
        return Uri.parse(bmpPath)
    }

    private fun escribirFav(numero_planta: Int, valor: String) {
        val fileName = "dialogoplanta$numero_planta.txt" // Nombre del archivo a escribir
        val outputStream = FileOutputStream(File(fileName)) // Abrir el archivo para escritura
        val writer = BufferedWriter(OutputStreamWriter(outputStream)) // Crear un escritor para escribir en el archivo

        writer.write(valor) // Escribir el valor en el archivo

        writer.close() // Cerrar el escritor
    }
    private fun leerFav(numero_planta: Int): String {
        val fileName = "dialogoplanta$numero_planta.txt" // Nombre del archivo a leer
        val inputStream = FileInputStream(File(fileName)) // Abrir el archivo para lectura
        val reader = BufferedReader(InputStreamReader(inputStream)) // Crear un lector para leer el archivo

        val valor = reader.readLine() ?: "0" // Leer la línea del archivo y asignar "0" si está vacía

        reader.close() // Cerrar el lector

        return valor // Devolver el valor leído como String
    }
}