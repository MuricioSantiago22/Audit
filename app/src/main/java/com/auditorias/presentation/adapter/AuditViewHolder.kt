package com.auditorias.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.auditorias.databinding.ItemAuditBinding
import com.auditorias.domain.entities.Audit

class AuditViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemAuditBinding.bind(view)

    fun render(audit: Audit){
        binding.auditTextView.text = audit.audit
        binding.branchTextView.text = audit.branch
        binding.startDateTextView.text = audit.startDate
    }
}