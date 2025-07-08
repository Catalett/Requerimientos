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

class MainActivity7 : AppCompatActivity() {
    var numero_planta=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)


        val imageViewPlanta13: ImageView = findViewById(R.id.imageView13)
        val imageViewPlanta14: ImageView = findViewById(R.id.imageView14)
        val imageViewPlanta15: ImageView = findViewById(R.id.imageView15)

        imageViewPlanta13.setOnClickListener {
            numero_planta=13
            dialogoplanta13()
        }

        imageViewPlanta14.setOnClickListener {
            numero_planta=14
            dialogoplanta14()
        }

        imageViewPlanta15.setOnClickListener {
            numero_planta=15
            dialogoplanta15()
        }


    }


    private fun dialogoplanta13() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p13, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView31)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView94)
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

    private fun dialogoplanta14() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p14, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView32)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView99)
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

    private fun dialogoplanta15() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p15, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView33)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView105)
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