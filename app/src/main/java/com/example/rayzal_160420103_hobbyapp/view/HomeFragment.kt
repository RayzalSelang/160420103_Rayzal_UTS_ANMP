package com.example.rayzal_160420103_hobbyapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rayzal_160420103_hobbyapp.R
import com.example.rayzal_160420103_hobbyapp.databinding.FragmentHomeBinding
import com.example.rayzal_160420103_hobbyapp.viewmodel.NewsViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        newsAdapter = NewsAdapter()
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = newsAdapter
        }

        newsViewModel.newsList.observe(viewLifecycleOwner) { newsList ->
            newsAdapter.submitList(newsList)
        }
        newsAdapter.setOnItemClickListener { news ->
            val bundle = Bundle().apply {
                putParcelable("news", news)
            }
            findNavController().navigate(R.id.action_homeFragment_to_detailBeritaFragment, bundle)
        }
        binding.btnProfil.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profilFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}