package com.auditorias.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.auditorias.databinding.ActivityMainBinding
import com.auditorias.presentation.adapter.AuditAdapter
import com.auditorias.presentation.viewModel.AuditViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val auditVieModel: AuditViewModel by viewModels()
    private lateinit var auditAdapter: AuditAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeViewModel()
    }

    private fun observeViewModel() {
        auditVieModel.auditDataList.observe(this, Observer { audits ->
            audits?.let {
                binding.recyclerView.layoutManager = LinearLayoutManager(this)
                binding.recyclerView.adapter = AuditAdapter(audits)
            }
        })
    }

}