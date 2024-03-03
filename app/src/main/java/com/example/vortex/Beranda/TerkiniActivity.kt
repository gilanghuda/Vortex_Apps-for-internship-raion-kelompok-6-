package com.example.vortex.Beranda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.vortex.R
import com.example.vortex.databinding.ActivityTerkiniBinding

class TerkiniActivity : AppCompatActivity() {
    private lateinit var viewpager2 : ViewPager2
    private lateinit var pageChangeListener: ViewPager2.OnPageChangeCallback
    private lateinit var binding: ActivityTerkiniBinding
    private lateinit var rowTerkiniAdapter: RowTerkiniAdapter
    private lateinit var rowRecyclerView: RecyclerView
    private var terkinilistrow = mutableListOf<RowTerkiniItem>()
    companion object {
        val imageterkiniList = ArrayList<ImageItem>()
    }
    val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(8,0,8,0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerkiniBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewpager2 = binding.terkiniSlider
        addimgslider()
        val imageAdapter = ImageAdapter()
        binding.terkiniSlider.adapter = imageAdapter
        imageAdapter.submitList(imageterkiniList)

        val slideDotLL = binding.slideDotLL
        val dotsImage =  Array(3){ ImageView(this) }

        dotsImage.forEach {
            it.setImageResource(
                R.drawable.non_active_dot
            )
            slideDotLL.addView(it,params)
        }

        dotsImage[0].setImageResource(R.drawable.active_dot)

        pageChangeListener = object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                dotsImage.mapIndexed { index, imageView ->
                    if (position == index){
                        imageView.setImageResource(
                            R.drawable.active_dot
                        )
                    }else{
                        imageView.setImageResource(R.drawable.non_active_dot)
                    }
                }
                super.onPageSelected(position)
            }
        }
        viewpager2.registerOnPageChangeCallback(pageChangeListener)
        terkinilistrow = ArrayList()
        addlistterkinirow()
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val rowTerkiniAdapter =  RowTerkiniAdapter(this, terkinilistrow)
        binding.rvTerkini.layoutManager = layoutManager
        binding.rvTerkini.adapter =  rowTerkiniAdapter
        binding.rvTerkini.isNestedScrollingEnabled = false

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
    fun addimgslider(){
        imageterkiniList.add(ImageItem(R.drawable.testerkini))
        imageterkiniList.add(ImageItem(R.drawable.testerkini))
        imageterkiniList.add(ImageItem(R.drawable.testerkini))
    }

    fun addlistterkinirow(){
        var trknirow =  RowTerkiniItem(
            R.drawable.megachan, "Pemerintah Ajak UMKM Transformasi Digital 1",
            "Lorem ipsum dolor sit amet consectetur. Dolor interdum odio quam sed.......",
            "Senin, 11 Maret 2024")
        terkinilistrow.add(trknirow)

        trknirow =  RowTerkiniItem(
            R.drawable.owi, "Pemerintah Ajak UMKM Transformasi Digital 2",
            "Lorem ipsum dolor sit amet consectetur. Dolor interdum odio quam sed.......",
            "Selasa, 12 Maret 2024")
        terkinilistrow.add(trknirow)

        trknirow =  RowTerkiniItem(
            R.drawable.megachan, "Pemerintah Ajak UMKM Transformasi Digital 3",
            "Lorem ipsum dolor sit amet consectetur. Dolor interdum odio quam sed.......",
            "Rabu, 13 Maret 2024")
        terkinilistrow.add(trknirow)

        trknirow =  RowTerkiniItem(
            R.drawable.owi, "Pemerintah Ajak UMKM Transformasi Digital 4",
            "Lorem ipsum dolor sit amet consectetur. Dolor interdum odio quam sed.......",
            "Kamis, 14 Maret 2024")
        terkinilistrow.add(trknirow)

        trknirow =  RowTerkiniItem(
            R.drawable.megachan, "Pemerintah Ajak UMKM Transformasi Digital 5",
            "Lorem ipsum dolor sit amet consectetur. Dolor interdum odio quam sed.......",
            "Senin, 15 Maret 2024")
        terkinilistrow.add(trknirow)
    }
    override fun onDestroy() {
        super.onDestroy()
        viewpager2.unregisterOnPageChangeCallback(pageChangeListener)
    }
}