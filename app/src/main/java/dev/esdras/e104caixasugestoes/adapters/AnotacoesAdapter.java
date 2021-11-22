package dev.esdras.e104caixasugestoes.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dev.esdras.e104caixasugestoes.R;
import dev.esdras.e104caixasugestoes.model.entity.Anotacao;

public class AnotacoesAdapter extends RecyclerView.Adapter<AnotacaoViewHolder> {

    List<Anotacao> anotacoes = Collections.emptyList();

    @NonNull
    @Override
    public AnotacaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.anotacao_item, parent, false);
        return new AnotacaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnotacaoViewHolder holder, int position) {
        Anotacao anotacao = anotacoes.get(position);
        holder.textViewAnotacao.setText(anotacao.getAnotacao());
        holder.textViewDataHora.setText(anotacao.getData());
        holder.textViewCategoria.setBackgroundResource(getBackgroundColor(anotacao.getCategoria()));
        holder.textViewCategoria.setText(anotacao.getCategoria());
    }

    @Override
    public int getItemCount() {
        return anotacoes.size();
    }

    public void setAnotacoes(List<Anotacao> anotacoes) {
        this.anotacoes = anotacoes;
        notifyDataSetChanged();
    }

    private int getBackgroundColor(String categoria) {
        switch (categoria) {
            case "DIVERSÃO":
                return R.drawable.fundo_postit_azul;
            case "LAZER":
                return R.drawable.fundo_postit_rosa;
            case "TCC":
                return R.drawable.fundo_postit_verde;
            case "TRABALHO":
                return R.drawable.fundo_postit_laranja;
            default:
                return R.drawable.fundo_postit_azul;
        }
    }
}
