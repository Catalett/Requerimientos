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

class MainActivity3 : AppCompatActivity() {
    var numero_planta=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btnNext: Button = findViewById(R.id.button6)
        val imageViewPlanta1: ImageView = findViewById(R.id.imageView1)
        val imageViewPlanta2: ImageView = findViewById(R.id.imageView2)
        val imageViewPlanta3: ImageView = findViewById(R.id.imageView3)
        val imageViewPlanta4: ImageView = findViewById(R.id.imageView4)
        val imageViewPlanta5: ImageView = findViewById(R.id.imageView5)
        val imageViewPlanta6: ImageView = findViewById(R.id.imageView6)

        btnNext.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }

        imageViewPlanta1.setOnClickListener {
            numero_planta=1
            dialogoplanta1()
        }

        imageViewPlanta2.setOnClickListener {
            numero_planta=2
            dialogoplanta2()
        }

        imageViewPlanta3.setOnClickListener {
            numero_planta=3
            dialogoplanta3()
        }

        imageViewPlanta4.setOnClickListener {
            numero_planta=4
            dialogoplanta4()
        }

        imageViewPlanta5.setOnClickListener {
            numero_planta=5
            dialogoplanta5()
        }

        imageViewPlanta6.setOnClickListener {
            numero_planta=6
            dialogoplanta6()
        }
    }

    private fun dialogoplanta1() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p1, null)


        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView10)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView36)
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

        // Configurar la imagen y el texto en el diálogo
        val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView10)
        val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView11)

        dialog.show()

        val window = dialog.window
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        window?.setLayout((resources.displayMetrics.widthPixels * 1.0).toInt(), layoutParams.height)
    }

    private fun dialogoplanta2() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p2, null)


        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView6)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView35)
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

        // Configurar la imagen y el texto en el diálogo
        val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView6)
        val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView9)

        dialog.show()

        val window = dialog.window
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        window?.setLayout((resources.displayMetrics.widthPixels * 1.0).toInt(), layoutParams.height)
    }

    private fun dialogoplanta3() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p3, null)


        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView9)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView31)
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

        // Configurar la imagen y el texto en el diálogo
        val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView9)
        val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView21)

        dialog.show()

        val window = dialog.window
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        window?.setLayout((resources.displayMetrics.widthPixels * 1.0).toInt(), layoutParams.height)
    }

    private fun dialogoplanta4() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p4, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView11)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView34)
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

    private fun dialogoplanta5() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p5, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView14)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView43)
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

    private fun dialogoplanta6() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_p6, null)

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Aceptar", null)
            .setNeutralButton("Compartir") { _, _ ->
                // Obtener la imagen de la planta y su nombre
                val imageViewPlantDialog: ImageView = dialogView.findViewById(R.id.imageView15)
                val textViewPlantDetails: TextView = dialogView.findViewById(R.id.textView48)
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

