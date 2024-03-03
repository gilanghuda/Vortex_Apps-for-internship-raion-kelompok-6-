package com.example.vortex.Beranda

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.vortex.R
import com.example.vortex.databinding.FragmentBerandaBinding


class BerandaFragment : Fragment() {
    private lateinit var viewpager2 : ViewPager2
    private lateinit var pageChangeListener: ViewPager2.OnPageChangeCallback
    private lateinit var binding: FragmentBerandaBinding
    private lateinit var rowBerandaAdapter: RowBerandaAdapter
    private lateinit var rowRecyclerView: RecyclerView
    private var berandarowlist = mutableListOf<RowBerandaItem>()
    companion object {
        val imageList = ArrayList<ImageItem>()
    }
    val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(8,0,8,0)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBerandaBinding.inflate(inflater, container, false)
        viewpager2 = binding.imgslider
        addimg()
        val imageAdapter = ImageAdapter()
        binding.imgslider.adapter = imageAdapter
        imageAdapter.submitList(imageList)

        val slideDotLL = binding.slideDotLL
        val dotsImage =  Array(3){ ImageView(context) }

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

        berandarowlist = ArrayList()
        addListBerandaRow()
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val rowBerandaAdapter =  RowBerandaAdapter(BerandaFragment(), berandarowlist)
        binding.rvBeranda.layoutManager = layoutManager
        binding.rvBeranda.adapter =  rowBerandaAdapter
        binding.rvBeranda.isNestedScrollingEnabled = false


        binding.btnTerkini.setOnClickListener{
            val intentterkini = Intent(requireContext(), TerkiniActivity::class.java)
            startActivity(intentterkini)
        }
        return binding.root
    }

    fun addimg() {
        imageList.add(ImageItem(R.drawable.img_1))
        imageList.add(ImageItem(R.drawable.img_1))
        imageList.add(ImageItem(R.drawable.img_1))
    }

    fun addListBerandaRow(){
        var brndrow = RowBerandaItem(R.drawable.owi, "Lorem Ipsum 1", "Lorem ipsum dolor sit amet consectetur. Dolor interdum odio quam sed aliquam.")
        berandarowlist.add(brndrow)

        brndrow = RowBerandaItem(R.drawable.megachan, "Lorem Ipsum 2", "Lorem ipsum dolor sit amet consectetur. Dolor interdum odio quam sed aliquam.")
        berandarowlist.add(brndrow)

        brndrow = RowBerandaItem(R.drawable.owi, "Lorem Ipsum 3", "Lorem ipsum dolor sit amet consectetur. Dolor interdum odio quam sed aliquam.")
        berandarowlist.add(brndrow)

        brndrow = RowBerandaItem(R.drawable.megachan, "Lorem Ipsum 4", "Lorem ipsum dolor sit amet consectetur. Dolor interdum odio quam sed aliquam.")
        berandarowlist.add(brndrow)

        brndrow = RowBerandaItem(R.drawable.owi, "Lorem Ipsum 5", "Lorem ipsum dolor sit amet consectetur. Dolor interdum odio quam sed aliquam.")
        berandarowlist.add(brndrow)
    }
    override fun onDestroy() {
        super.onDestroy()
        viewpager2.unregisterOnPageChangeCallback(pageChangeListener)
    }
}