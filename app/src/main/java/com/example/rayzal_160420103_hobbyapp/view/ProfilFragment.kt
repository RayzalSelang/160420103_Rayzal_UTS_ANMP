package com.example.rayzal_160420103_hobbyapp.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rayzal_160420103_hobbyapp.R
import com.example.rayzal_160420103_hobbyapp.api.ApiService
import com.example.rayzal_160420103_hobbyapp.api.UpdateProfileResponse
import com.example.rayzal_160420103_hobbyapp.databinding.FragmentProfilBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProfilFragment : Fragment() {
    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!isUserAuthenticated()) {
            findNavController().navigate(R.id.action_profilFragment_to_loginFragment)
            return
        }

        binding.btnSave.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val password = binding.etPassword.text.toString()

            updateProfile(firstName, lastName, password)
        }

        binding.btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun updateProfile(firstName: String, lastName: String, password: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.8/api_anmp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        val call = apiService.updateProfile(getUserId(), firstName, lastName, password)
        call.enqueue(object : Callback<UpdateProfileResponse> {
            override fun onResponse(
                call: Call<UpdateProfileResponse>,
                response: Response<UpdateProfileResponse>
            ) {
                if (response.isSuccessful) {
                    val updateProfileResponse = response.body()
                    if (updateProfileResponse?.status == "success") {
                        Toast.makeText(requireContext(), updateProfileResponse.message, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(requireContext(), updateProfileResponse?.message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Update profile failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UpdateProfileResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun logout() {
        val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()

        findNavController().navigate(R.id.action_profilFragment_to_loginFragment)
        findNavController().popBackStack(R.id.main_navigation, true)
    }

    private fun getUserId(): Int {
        val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getInt("userId", -1)
    }

    private fun isUserAuthenticated(): Boolean {
        val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.contains("userId")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}