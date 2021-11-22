package dev.esdras.e104caixasugestoes.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.esdras.e104caixasugestoes.R;

public class AnotacaoViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewAnotacao;
    public TextView textViewDataHora;
    public TextView textViewCategoria;

    public AnotacaoViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewAnotacao = itemView.findViewById(R.id.textViewAnotacao);
        textViewDataHora = itemView.findViewById(R.id.textViewDataHora);
        textViewCategoria = itemView.findViewById(R.id.textViewCategoria);
    }
}
