package com.example.bugdemo.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.bugdemo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileFragment : Fragment() {
    private lateinit var viewModel: ProfileViewModel
    private lateinit var nameView: TextView
    private lateinit var emailView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameView = view.findViewById(R.id.profileName)
        emailView = view.findViewById(R.id.profileEmail)

        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            val profile = viewModel.loadProfile()
            withContext(Dispatchers.Main) {
                nameView.text = profile?.name ?: "Unknown"
                emailView.text = profile?.email ?: "No email"
                Toast.makeText(requireActivity(), "Profile loaded", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
