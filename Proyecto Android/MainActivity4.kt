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

class MainActivity4 : AppCompatActivity() {
    var numero_planta=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val imageViewPlanta16: ImageView = findViewById(R.id.imageView16)
        val imageViewPlanta17: ImageView = findViewById(R.id.imageView17)
        val imageViewPlanta18: ImageView = findViewById(R.id.imageView18)
        val imageViewPlanta19: ImageView = findViewById(R.id.imageView19)
        val imageViewPlanta20: ImageView = findViewById(R.id.imageView20)
        val imageViewPlanta21: ImageView = findViewById(R.id.imageView21)
        val imageViewPlanta22: ImageView = findViewById(R.id.imageView22)

        val btn4: Button = findViewById(R.id.button4)

        btn4.setOnClickListener {

            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        imageViewPlanta16.setOnClickListener {
            numero_planta=16
            dialogoplanta16()
        }

        imageViewPlanta17.setOnClickListener {
            numero_planta=17
            dialogoplanta17()
        }

        imageViewPlanta18.setOnClickListener {
            numero_planta=18
            dialogoplanta18()
        }

        imageViewPlanta19.setOnClickListener {
            numero_planta=19
            dialogoplanta19()
        }

        imageViewPlanta20.setOnClickListener {
            numero_planta=20
            dialogoplanta20()
        }

        imageViewPlanta21.setOnClickListener {
            numero_planta=21
            dialogoplanta21()
        }

        imageViewPlanta22.setOnClickListener {
            numero_planta=22
            dialogoplanta22()
        }

    }

    private fun dialogoplanta16() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p16, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView3)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView117)
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

    private fun dialogoplanta17() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p17, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView35)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView125)
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

    private fun dialogoplanta18() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p18, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView41)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView130)
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

    private fun dialogoplanta19() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p19, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView42)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView137)
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

    private fun dialogoplanta20() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p20, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView43)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView145)
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

    private fun dialogoplanta21() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p21, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView44)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView152)
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

    private fun dialogoplanta22() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p22, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView45)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView160)
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



