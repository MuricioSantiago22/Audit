package com.auditorias.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auditorias.R

import com.auditorias.domain.entities.Audit

class AuditAdapter(private var audits: List<Audit>) : RecyclerView.Adapter<AuditViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuditViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_audit, parent, false)
        return AuditViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AuditViewHolder, position: Int) {
        val currentAudit = audits[position]
        holder.render(currentAudit)

    }

    override fun getItemCount() = audits.size



}

