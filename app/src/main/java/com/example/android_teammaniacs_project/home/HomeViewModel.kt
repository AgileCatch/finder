package com.example.android_teammaniacs_project.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_teammaniacs_project.data.Category
import com.example.android_teammaniacs_project.data.Video
import com.example.android_teammaniacs_project.retrofit.CategoryModel
import com.example.android_teammaniacs_project.retrofit.PopularVideoModel
import com.example.android_teammaniacs_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.atomic.AtomicLong

class HomeViewModel(private val apiService: RetrofitInterface) : ViewModel() {

    //인기 영상을 위한 LiveData 선언
    private val _popularList: MutableLiveData<List<Video>> = MutableLiveData()
    val popularList: LiveData<List<Video>> get() = _popularList

    //카테고리별 영상을 위한 LiveData 선언
    private val _categoryUpperVideoList: MutableLiveData<List<Video>> = MutableLiveData()
    val categoryUpperVideoList: LiveData<List<Video>> get() = _categoryUpperVideoList

    private val _categoryBelowVideoList: MutableLiveData<List<Video>> = MutableLiveData()
    val categoryBelowVideoList: LiveData<List<Video>> get() = _categoryBelowVideoList

    //카테고리 목록을 받기 위한 LiveData 선언
    private val _categoryListUpper: MutableLiveData<List<Category>> = MutableLiveData()
    val categoryListUpper: LiveData<List<Category>> get() = _categoryListUpper

    private val _categoryListBelow: MutableLiveData<List<Category>> = MutableLiveData()
    val categoryListBelow: LiveData<List<Category>> get() = _categoryListBelow

    private val popularResultList = ArrayList<Video>()
    private val categoryVideoResultUpperList = ArrayList<Video>()
    private val categoryVideoResultBelowList = ArrayList<Video>()
    private val categoryResultList = ArrayList<Category>()
    private val categoryUpperResultList = ArrayList<Category>()
    private val categoryBelowResultList = ArrayList<Category>()

    private val idGenerate = AtomicLong(1L)

    //Popular Video 받는 API 연동 / 받은 후 Video List 에 데이터 추가
    fun setBanner(key: String, part: String, chart: String, maxResults: Int) {
        apiService.getVideoList(key, part, chart, maxResults)
            ?.enqueue(object : Callback<PopularVideoModel> {
                override fun onResponse(
                    call: Call<PopularVideoModel>,
                    response: Response<PopularVideoModel>
                ) {
                    popularResultList.clear()
                    for (i in response.body()?.items!!) {
                        Log.d("channelid", i.snippet.channelId)
                        popularResultList.add(
                            Video(
                                i.snippet.thumbnails.high.url,
                                i.snippet.title,
                                i.snippet.channelId,
                                i.snippet.publishedAt,
                                i.snippet.channelTitle,
                                i.snippet.description
                            )
                        )
                    }
                    _popularList.value = popularResultList
                }

                override fun onFailure(call: Call<PopularVideoModel>, t: Throwable) {

                }

            })
    }

    //카테고리 별 Video 받는 API 연동 / 받은 후 Video List 에 데이터 추가
    fun getCategoryVideo(
        key: String,
        part: String,
        chart: String,
        maxResults: Int,
        videoCategoryId: String,
        viewLocation : String
    ) {
        apiService.getCategoryVideoList(key, part, chart, maxResults, videoCategoryId)
            ?.enqueue(object : Callback<PopularVideoModel> {
                override fun onResponse(
                    call: Call<PopularVideoModel>,
                    response: Response<PopularVideoModel>
                ) {
                    if(viewLocation == "upper") {
                        categoryVideoResultUpperList.clear()
                        for (i in response.body()?.items!!) {
                            categoryVideoResultUpperList.add(
                                Video(
                                    i.snippet.thumbnails.high.url,
                                    i.snippet.title,
                                    i.snippet.channelId,
                                    i.snippet.publishedAt,
                                    i.snippet.channelTitle,
                                    i.snippet.description
                                )
                            )
                        }
                        Log.d("upper", "upper")
                        _categoryUpperVideoList.value = categoryVideoResultUpperList
                    }

                    else if(viewLocation == "below") {
                        categoryVideoResultBelowList.clear()
                        for (i in response.body()?.items!!) {
                            categoryVideoResultBelowList.add(
                                Video(
                                    i.snippet.thumbnails.high.url,
                                    i.snippet.title,
                                    i.snippet.channelId,
                                    i.snippet.publishedAt,
                                    i.snippet.channelTitle,
                                    i.snippet.description
                                )
                            )
                        }
                        Log.d("below", "below")
                        _categoryBelowVideoList.value = categoryVideoResultBelowList
                    }
                }

                override fun onFailure(call: Call<PopularVideoModel>, t: Throwable) {

                }

            })
    }

    //카테고리 리스트 받는 API 연동 / 받은 후 List에 데이터 추가
    fun getCategory(key: String, part: String, regionCode: String) {
        apiService.getCategoryList(key, part, regionCode)
            ?.enqueue(object : Callback<CategoryModel> {
                override fun onResponse(
                    call: Call<CategoryModel>,
                    response: Response<CategoryModel>
                ) {
                    for (i in response.body()?.items!!) {
                        if (i.snippet.assignable && i.id != "27" && i.id !="19") {
                            categoryResultList.add(
                                Category(
                                    i.id,
                                    i.snippet.title
                                )
                            )
                        }
                    }
                    val middleIndex = categoryResultList.size / 2
                    categoryUpperResultList.addAll(categoryResultList.subList(0,middleIndex))
                    categoryBelowResultList.addAll(categoryResultList.subList(middleIndex,categoryResultList.size))

                    _categoryListUpper.value = categoryUpperResultList
                    _categoryListBelow.value = categoryBelowResultList
                }

                override fun onFailure(call: Call<CategoryModel>, t: Throwable) {

                }

            })
    }

}
