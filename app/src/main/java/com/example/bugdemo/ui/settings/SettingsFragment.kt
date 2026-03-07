package com.example.bugdemo.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bugdemo.R

class SettingsFragment : Fragment() {
    private lateinit var viewModel: SettingsViewModel
    private lateinit var darkModeSwitch: Switch
    private lateinit var notificationsSwitch: Switch

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[SettingsViewModel::class.java]
        darkModeSwitch = view.findViewById(R.id.switchDarkMode)
        notificationsSwitch = view.findViewById(R.id.switchNotifications)

        darkModeSwitch.isChecked = viewModel.isDarkMode()
        notificationsSwitch.isChecked = viewModel.isNotificationsEnabled()

        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setDarkMode(isChecked)
        }

        notificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setNotificationsEnabled(isChecked)
        }
    }
}
