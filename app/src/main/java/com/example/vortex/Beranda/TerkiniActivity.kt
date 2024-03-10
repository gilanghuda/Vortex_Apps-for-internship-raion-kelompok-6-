package com.example.vortex.Beranda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        imageAdapter.setOnItemClickListener(object : ImageAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val intentdetail = Intent(this@TerkiniActivity, DetailTerkini::class.java)
                startActivity(intentdetail)
            }
        })
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
        binding.btnTerkiniUmkm.setOnClickListener{
            umkmRole()
        }
        binding.btnTerkiniKeuangan.setOnClickListener {
           keuanganRole()
        }

        binding.btnTerkiniInvestasi.setOnClickListener {
          investasiRole()
        }

        binding.btnTerkiniSemuaTopik.setOnClickListener {
            semuaRole()
        }

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val rowTerkiniAdapter =  RowTerkiniAdapter(this, terkinilistrow)
        binding.rvTerkini.layoutManager = layoutManager
        binding.rvTerkini.adapter =  rowTerkiniAdapter
        binding.rvTerkini.isNestedScrollingEnabled = false

        val view = findViewById<View>(R.id.terkini_slider)
        view.isClickable = true
        view.setOnClickListener {
            val intent = Intent(this, DetailTerkini::class.java)
            startActivity(intent)
        }
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
            R.drawable.ivtrkn1, "Pemerintah Bikin Gebrakan, UMKM Diaja..",
            "Berita menggemberikan nih Vortexers!Pemerintah menggandeng UMKM un....",
            "Senin, 11 Maret 2024", "UMKM")
        terkinilistrow.add(trknirow)

        trknirow =  RowTerkiniItem(
            R.drawable.ivtrkn2, "Yuk Cek Rekomendasi Saham Unggulan! ",
            "Nah, buat kalian yang lagi pengen banget nge-boost portofolio saham, pentin....",
            "Selasa, 12 Maret 2024", "Investasi")
        terkinilistrow.add(trknirow)

        trknirow =  RowTerkiniItem(
            R.drawable.ivtrkn3, "Eksklusif! 7 Bank ini Bangkrut",
            "Soal kondisi bank-bank belakangan ini, ada berita gak enak nih. Beberapa bank d.....",
            "Rabu, 13 Maret 2024", "Keuangan")
        terkinilistrow.add(trknirow)

        trknirow =  RowTerkiniItem(
            R.drawable.ivtrkn4, "Intip Nilai Tukar Rupiah ke Dolar AS Hari Ini!",
            "Tau gak, pergerakan nilai tukar Rupiah ke Dolar Amerika Serikat (AS) tuh jadi pe....",
            "Kamis, 14 Maret 2024", "Keuangan")
        terkinilistrow.add(trknirow)

        trknirow =  RowTerkiniItem(
            R.drawable.ivtrkn5, "WOW GOTO Sahamnya Turun di Kuartal 3 Nih!",
            "Buat kalian yang suka ikutanin perkembangan saham, pasti penasara.....",
            "Senin, 15 Maret 2024", "Investasi")
        terkinilistrow.add(trknirow)
    }

    fun semuaRole(){
        terkinilistrow.clear()
        addlistterkinirow()

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val rowTerkiniAdapter =  RowTerkiniAdapter(this, terkinilistrow)
        binding.rvTerkini.layoutManager = layoutManager
        binding.rvTerkini.adapter =  rowTerkiniAdapter
        binding.rvTerkini.isNestedScrollingEnabled = false
    }

    fun umkmRole(){
        terkinilistrow.clear()
        var trknirow =  RowTerkiniItem(
            R.drawable.ivtrkn1, "Pemerintah Bikin Gebrakan, UMKM Diaja..",
            "Berita menggemberikan nih Vortexers!Pemerintah menggandeng UMKM un....",
            "Senin, 11 Maret 2024", "UMKM")
        terkinilistrow.add(trknirow)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val rowTerkiniAdapter =  RowTerkiniAdapter(this, terkinilistrow)
        binding.rvTerkini.layoutManager = layoutManager
        binding.rvTerkini.adapter =  rowTerkiniAdapter
        binding.rvTerkini.isNestedScrollingEnabled = false
    }

    fun keuanganRole(){
        terkinilistrow.clear()
        var trknirow =  RowTerkiniItem(
            R.drawable.ivtrkn3, "Eksklusif! 7 Bank ini Bangkrut",
            "Soal kondisi bank-bank belakangan ini, ada berita gak enak nih. Beberapa bank d.....",
            "Rabu, 13 Maret 2024", "Keuangan")
        terkinilistrow.add(trknirow)

        trknirow =  RowTerkiniItem(
            R.drawable.ivtrkn4, "Intip Nilai Tukar Rupiah ke Dolar AS Hari Ini!",
            "Tau gak, pergerakan nilai tukar Rupiah ke Dolar Amerika Serikat (AS) tuh jadi pe....",
            "Kamis, 14 Maret 2024", "Keuangan")
        terkinilistrow.add(trknirow)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val rowTerkiniAdapter =  RowTerkiniAdapter(this, terkinilistrow)
        binding.rvTerkini.layoutManager = layoutManager
        binding.rvTerkini.adapter =  rowTerkiniAdapter
        binding.rvTerkini.isNestedScrollingEnabled = false
    }
    fun investasiRole(){
        terkinilistrow.clear()
        var trknirow =  RowTerkiniItem(
            R.drawable.ivtrkn2, "Yuk Cek Rekomendasi Saham Unggulan! ",
            "Nah, buat kalian yang lagi pengen banget nge-boost portofolio saham, pentin....",
            "Selasa, 12 Maret 2024", "Investasi")
        terkinilistrow.add(trknirow)

        trknirow =  RowTerkiniItem(
            R.drawable.ivtrkn5, "WOW GOTO Sahamnya Turun di Kuartal 3 Nih!",
            "Buat kalian yang suka ikutanin perkembangan saham, pasti penasara.....",
            "Senin, 15 Maret 2024", "Investasi")
        terkinilistrow.add(trknirow)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val rowTerkiniAdapter =  RowTerkiniAdapter(this, terkinilistrow)
        binding.rvTerkini.layoutManager = layoutManager
        binding.rvTerkini.adapter =  rowTerkiniAdapter
        binding.rvTerkini.isNestedScrollingEnabled = false
    }

    override fun onDestroy() {
        super.onDestroy()
        viewpager2.unregisterOnPageChangeCallback(pageChangeListener)
    }
}