package com.example.android_teammaniacs_project.home

import android.R
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.android_teammaniacs_project.data.Video
import com.example.android_teammaniacs_project.databinding.FragmentHomeBinding
import com.example.android_teammaniacs_project.detail.VideoDetailActivity
import com.example.android_teammaniacs_project.myVideoPage.MyVideoFragment


class HomeFragment : Fragment() {
    companion object {
        fun newInstance() = HomeFragment()
        val HOME_VIDEO_POSITION = "home_video_position"
        val HOME_VIDEO_MODEL = "home_video_model"
    }

//    private val recyclerViewAdapter by lazy {
//        HomeBannerAdapter(onClickItem= { position, video ->
//            val intent = Intent(context, VideoDetailActivity::class.java)
//            intent.apply {
//                putExtra(HomeFragment.HOME_VIDEO_POSITION,position)
//                putExtra(HomeFragment.HOME_VIDEO_MODEL,video)
//            }
//            startActivity(intent)
//        }
//        )
//        HomeVideoAdapter(onClickItem= { position, video ->
//            val intent = Intent(context, VideoDetailActivity::class.java)
//            intent.apply {
//                putExtra(HomeFragment.HOME_VIDEO_POSITION,position)
//                putExtra(HomeFragment.HOME_VIDEO_MODEL,video)
//            }
//            startActivity(intent)
//        })
//    }


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var contexts: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contexts = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //리사이클러뷰에 대한 초기화 필요
        setupRecyclerView()
        initView()
    }

    private fun initView()= with(binding) {
        //임시 스피너
        val arraySpinner = arrayOf(
            "Gaming", "Sports", "Comedy", "Short Movies", "Entertainment"
        )
        val s = binding?.homeSpinner
        val spinnerAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            contexts,
            R.layout.simple_spinner_item, arraySpinner
        )
        spinnerAdapter.setDropDownViewResource(R.layout.simple_spinner_item)
//        adapter.viewre setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        s?.adapter = spinnerAdapter
    }


    private fun setupRecyclerView()= with(binding) {

        //임의로 uri 넣어둠
        val testData = mutableListOf<Video>()
        testData.add(
            Video(
                Uri.parse("https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F241%2F2022%2F07%2F01%2F0003218781_001_20220701115801485.jpg&type=sc960_832"),
                "STAYC",
                "https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F241%2F2022%2F07%2F01%2F0003218781_001_20220701115801485.jpg&type=sc960_832"
            )
        )
        testData.add(
            Video(
                Uri.parse("https://search.pstatic.net/sunny/?src=https%3A%2F%2Fimg.theqoo.net%2Fimg%2FVFgJV.png&type=a340"),
                "NewJeans",
                "https://search.pstatic.net/sunny/?src=https%3A%2F%2Fimg.theqoo.net%2Fimg%2FVFgJV.png&type=a340"
            )
        )
        testData.add(
            Video(
                Uri.parse("https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F5095%2F2022%2F07%2F09%2F0000974046_001_20220709084001248.jpg&type=sc960_832"),
                "aespa",
                "https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F5095%2F2022%2F07%2F09%2F0000974046_001_20220709084001248.jpg&type=sc960_832"
            )
        )

        //홈배너 어댑터 설정
        val adapter = HomeBannerAdapter(onClickItem= { position, video ->
            val intent = Intent(context, VideoDetailActivity::class.java)
            intent.apply {
                putExtra(HomeFragment.HOME_VIDEO_POSITION,position)
                putExtra(HomeFragment.HOME_VIDEO_MODEL,video)
            }
            startActivity(intent)
        })
        adapter.list = testData as ArrayList<Video>
        adapter.notifyDataSetChanged()
        binding?.rvHomeBanner?.adapter = adapter



        //어댑터 2,3 설정
        val adapter2 = HomeVideoAdapter(onClickItem= { position, video ->
            val intent = Intent(context, VideoDetailActivity::class.java)
            intent.apply {
                putExtra(HomeFragment.HOME_VIDEO_POSITION,position)
                putExtra(HomeFragment.HOME_VIDEO_MODEL,video)
            }
            startActivity(intent)
        })
        adapter2.list = testData as ArrayList<Video>
        adapter2.notifyDataSetChanged()
        binding?.rvHomeSection1?.adapter = adapter2

        val adapter3 = HomeVideoAdapter(onClickItem= { position, video ->
            val intent = Intent(context, VideoDetailActivity::class.java)
            intent.apply {
                putExtra(HomeFragment.HOME_VIDEO_POSITION,position)
                putExtra(HomeFragment.HOME_VIDEO_MODEL,video)
            }
            startActivity(intent)
        })
        adapter3.list = testData as ArrayList<Video>
        adapter3.notifyDataSetChanged()
        binding?.rvHomeSection2?.adapter = adapter3
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}