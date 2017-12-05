package com.playground.dkkovalev.customtiles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.style.layers.RasterLayer
import com.mapbox.mapboxsdk.style.sources.RasterSource
import com.mapbox.mapboxsdk.style.sources.TileSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this, BuildConfig.MAPBOX_TOKEN)
        setContentView(R.layout.activity_main)
        view_map.onCreate(savedInstanceState)
        view_map.getMapAsync { mapboxMap ->
            run {
                val source = RasterSource("stamen-watercolor", TileSet("tileSet",
                        "https://stamen-tiles.a.ssl.fastly.net/watercolor/{z}/{x}/{y}.jpg"),
                        256)
                val layer = RasterLayer("stamen-watercolor", source.id)
                mapboxMap.addSource(source)
                mapboxMap.addLayer(layer)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        view_map.onStart()
    }
}
