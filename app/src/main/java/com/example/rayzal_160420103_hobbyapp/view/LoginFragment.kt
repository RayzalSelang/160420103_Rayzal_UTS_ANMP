package com.example.rayzal_hobbyapp_160420103.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.rayzal_160420103_hobbyapp.R
import com.example.rayzal_160420103_hobbyapp.databinding.FragmentLoginBinding
import org.json.JSONException
import org.json.JSONObject

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            login(username, password)
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun login(username: String, password: String) {
        val url = "http://192.168.96.76/api_anmp/login.php"

        val requestBody = JSONObject()
        requestBody.put("username", username)
        requestBody.put("password", password)

        val jsonObjectRequest = JsonObjectRequest(
            url, requestBody,
            Response.Listener { response ->
                try {
                    val status = response.getString("status")
                    val message = response.getString("message")

                    if (status == "success") {
                        val userId = response.getInt("user_id")
                        val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                        sharedPreferences.edit().putInt("userId", userId).apply()
                        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    } else {
                        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    Toast.makeText(requireContext(), "Error parsing response", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                error.printStackTrace()
                Toast.makeText(requireContext(), "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )

        Volley.newRequestQueue(requireContext()).add(jsonObjectRequest)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}