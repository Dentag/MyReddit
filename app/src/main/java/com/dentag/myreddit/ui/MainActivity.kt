package com.dentag.myreddit.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.dentag.myreddit.databinding.ActivityMainBinding
import com.dentag.myreddit.ui.list.PostAdapter
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@ExperimentalPagingApi
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @Inject
    lateinit var mainViewModel: MainViewModel

    private val postAdapter by lazy { PostAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        appComponent.inject(this)
        initRV()
        subscribe()
    }

    private fun subscribe() {
        addRepeatingJob(Lifecycle.State.STARTED) {
            mainViewModel.posts.collectLatest(postAdapter::submitData)
        }
    }

    private fun initRV() {
        with(binding.RV) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}