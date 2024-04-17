package com.example.rayzal_160420103_hobbyapp.view



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rayzal_160420103_hobbyapp.R
import com.example.rayzal_160420103_hobbyapp.databinding.FragmentRegisterBinding
import com.example.rayzal_160420103_hobbyapp.api.ApiService
import com.example.rayzal_160420103_hobbyapp.api.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.8/api_anmp/") // Use your machine's IP address
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService = retrofit.create(ApiService::class.java)
            val call = apiService.register(username, firstName, lastName, email, password)
            call.enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {
                        val registerResponse = response.body()
                        if (registerResponse?.status == "success") {
                            Toast.makeText(
                                requireContext(),
                                "Registration successful",
                                Toast.LENGTH_SHORT
                            ).show()
                            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                        } else {
                            Toast.makeText(
                                requireContext(),
                                registerResponse?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(requireContext(), "Registration failed", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}