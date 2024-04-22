package com.example.rayzal_160420103_hobbyapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.rayzal_160420103_hobbyapp.databinding.FragmentDetailBeritaBinding
import com.example.rayzal_160420103_hobbyapp.model.News

class FragmentDetailBerita : Fragment() {

    private var _binding: FragmentDetailBeritaBinding? = null
    private val binding get() = _binding!!

    private lateinit var news: News
    private var currentPage = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBeritaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        news = arguments?.getParcelable("news") ?: News("", "", "", "",emptyList())

        binding.tvTitle.text = news.title
        binding.tvAuthor.text = news.author

        binding.btnPrevPage.setOnClickListener {
            if (currentPage > 0) {
                currentPage--
                updateContent()
            }
        }
        Glide.with(requireContext())
            .load(news.imageUrl)
            .into(binding.ivNewsImage)

        binding.btnNextPage.setOnClickListener {
            if (currentPage < news.content.size - 1) {
                currentPage++
                updateContent()
            }
        }

        updateContent()
    }

    private fun updateContent() {
        if (news.content.isNotEmpty()) {
            binding.tvContent.text = news.content[currentPage]
            binding.btnPrevPage.isEnabled = currentPage > 0
            binding.btnNextPage.isEnabled = currentPage < news.content.size - 1
        } else {
            binding.tvContent.text = "No content available"
            binding.btnPrevPage.isEnabled = false
            binding.btnNextPage.isEnabled = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}