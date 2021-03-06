package com.project.vivian.productos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.vivian.R
import com.project.vivian.model.Producto
import org.w3c.dom.Text

class ProductoViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_producto, parent, false)){

    private var productoImageView : ImageView? = null
    private var textNombreProducto: TextView? = null
    private var textPrecioNumber: TextView? = null
    var cantidad : Int = 1

    init {
        productoImageView = itemView.findViewById(R.id.imgProducto)
        textNombreProducto = itemView.findViewById(R.id.textNombreProducto)
        textPrecioNumber = itemView.findViewById(R.id.textPrecioNumero)
    }

    fun sumarUno() {
        cantidad++
    }

    fun restarUno()  {
        cantidad--
    }

    fun bind(producto: Producto) {
        textNombreProducto?.text = producto.nombre
        textPrecioNumber?.text = producto.precio

        val options = RequestOptions()
            .placeholder(R.drawable.anonymous_image)
            .error(R.drawable.anonymous_image)

        productoImageView?.let {
            Glide.with(it)
                .setDefaultRequestOptions(options)
                .load(producto.imgUrl)
                .into(it)
        }

    }
}