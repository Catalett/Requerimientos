package com.example.proyectofinal

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class Favoritos {
    private val contadorMaximo = 30

    fun mostrarMenuFavoritos() {
        for (contador in 1..contadorMaximo) {
            val valor = leerFav(contador)
            if (valor == "1") {
                // Agregar lógica para mostrar la planta con el contador correspondiente en el menú de favoritos
                mostrarPlantaFavorita(contador)
            }
        }
    }

    private fun leerFav(numero_planta: Int): String {
        val fileName = "dialogoplanta$numero_planta.txt" // Nombre del archivo a leer
        val inputStream = FileInputStream(File(fileName)) // Abrir el archivo para lectura
        val reader =
            BufferedReader(InputStreamReader(inputStream)) // Crear un lector para leer el archivo

        val valor =
            reader.readLine() ?: "0" // Leer la línea del archivo y asignar "0" si está vacía

        reader.close() // Cerrar el lector

        return valor // Devolver el valor leído como String
    }

    private fun mostrarPlantaFavorita(numero_planta: Int) {
        class Favoritos : AppCompatActivity() {
            private val nombresPlantas: ArrayList<String> = ArrayList()
            private val idsImagenes: ArrayList<Int> = ArrayList()

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.favoritos)

                // Obtener las plantas favoritas y agregarlas al menú
                obtenerPlantasFavoritas()
                mostrarMenuFavoritos()
            }

            private fun obtenerPlantasFavoritas() {
                for (contador in 1..30) {
                    val fileName = "dialogoplanta$contador.txt"
                    val inputStream = FileInputStream(File(fileName))
                    val reader = BufferedReader(InputStreamReader(inputStream))
                    val valor = reader.read().toChar().toString().toInt()
                    reader.close()

                    if (valor == 1) {
                        val nombrePlanta = obtenerNombrePlanta(contador)
                        val imagenResId = obtenerImagenPlanta(contador)

                        nombresPlantas.add(nombrePlanta)
                        idsImagenes.add(imagenResId)
                    }
                }
            }

            private fun mostrarMenuFavoritos() {
                val recyclerView: RecyclerView = findViewById(R.id.recyclerViewFavoritos)
                val layoutManager = LinearLayoutManager(this)
                val adapter = FavoritosAdapter(nombresPlantas, idsImagenes)

                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = adapter
            }

            private fun obtenerNombrePlanta(contador: Int): String {
                val textViewId = resources.getIdentifier("textView$contador", "id", packageName)
                val textView = findViewById<TextView>(textViewId)
                return textView?.text?.toString() ?: "Planta $contador"
            }

            private fun obtenerImagenPlanta(contador: Int): Int {
                val imageViewId = resources.getIdentifier("imageView$contador", "id", packageName)
                val imageView = findViewById<ImageView>(imageViewId)
                return imageView?.tag as? Int ?: R.drawable.agl
            }
        }
    }
}
