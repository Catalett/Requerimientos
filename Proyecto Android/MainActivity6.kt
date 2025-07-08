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

class MainActivity6 : AppCompatActivity() {
    var numero_planta=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val imageViewPlanta23: ImageView = findViewById(R.id.imageView23)
        val imageViewPlanta24: ImageView = findViewById(R.id.imageView24)
        val imageViewPlanta25: ImageView = findViewById(R.id.imageView25)
        val imageViewPlanta26: ImageView = findViewById(R.id.imageView26)
        val imageViewPlanta27: ImageView = findViewById(R.id.imageView27)
        val imageViewPlanta28: ImageView = findViewById(R.id.imageView28)
        val imageViewPlanta29: ImageView = findViewById(R.id.imageView29)
        val imageViewPlanta30: ImageView = findViewById(R.id.imageView30)

        imageViewPlanta23.setOnClickListener {
            numero_planta=23
            dialogoplanta23()
        }

        imageViewPlanta24.setOnClickListener {
            numero_planta=24
            dialogoplanta24()
        }

        imageViewPlanta25.setOnClickListener {
            numero_planta=25
            dialogoplanta25()
        }

        imageViewPlanta26.setOnClickListener {
            numero_planta=26
            dialogoplanta26()
        }

        imageViewPlanta27.setOnClickListener {
            numero_planta=27
            dialogoplanta27()
        }

        imageViewPlanta28.setOnClickListener {
            numero_planta=28
            dialogoplanta28()
        }

        imageViewPlanta29.setOnClickListener {
            numero_planta=29
            dialogoplanta29()
        }

        imageViewPlanta30.setOnClickListener {
            numero_planta=30
            dialogoplanta30()
        }

    }

    private fun dialogoplanta23() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p23, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView49)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView177)
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

    private fun dialogoplanta24() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p24, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView55)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView185)
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

    private fun dialogoplanta25() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p25, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView56)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView191)
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

    private fun dialogoplanta26() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p26, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView57)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView197)
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

    private fun dialogoplanta27() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p27, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView58)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView205)
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

    private fun dialogoplanta28() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p28, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView59)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView208)
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

    private fun dialogoplanta29() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p29, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView60)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView215)
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

    private fun dialogoplanta30() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p30, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView61)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView219)
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