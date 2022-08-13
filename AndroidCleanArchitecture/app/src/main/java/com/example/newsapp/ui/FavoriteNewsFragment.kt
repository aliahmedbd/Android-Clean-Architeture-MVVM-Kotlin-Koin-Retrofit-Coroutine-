package com.example.newsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsListAdapter
import com.example.newsapp.databinding.FragmentFavoriteNewsBinding
import com.example.newsapp.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavoriteNewsFragment : Fragment() {

    lateinit var binding: FragmentFavoriteNewsBinding
    val viewModel: NewsViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite_news, null, false)
        getSavedArticles()
        return binding.root
    }

    private fun getSavedArticles() {
        val articles = context?.let { viewModel.getSavedArticles(it) }
        binding.rvFavoriteList.layoutManager = LinearLayoutManager(context)
        val adapter = articles?.let { NewsListAdapter(it, R.layout.item_fav_item, {}, {}) }
        binding.rvFavoriteList.adapter = adapter

        if (articles.isNullOrEmpty()) {
            binding.rvFavoriteList.visibility = View.GONE
            binding.txtEmpty.visibility = View.VISIBLE
        } else {
            binding.rvFavoriteList.visibility = View.VISIBLE
            binding.txtEmpty.visibility = View.GONE
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            FavoriteNewsFragment().apply {}
    }


}