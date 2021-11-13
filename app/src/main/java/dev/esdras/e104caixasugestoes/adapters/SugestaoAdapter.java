package dev.esdras.e104caixasugestoes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.esdras.e104caixasugestoes.R;
import dev.esdras.e104caixasugestoes.model.Sugestao;

public class SugestaoAdapter extends RecyclerView.Adapter<SugestaoViewHolder> {

    List<Sugestao> sugestoes;

    public SugestaoAdapter(List<Sugestao> sugestoes) {
        this.sugestoes = sugestoes;
    }

    @NonNull
    @Override
    public SugestaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sugestao_item, parent, false);
        return new SugestaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SugestaoViewHolder holder, int position) {
        Sugestao sugestao = sugestoes.get(position);
        holder.imageViewTipo.setImageResource(sugestao.toResourceId(sugestao.tipo));
        holder.textViewCurso.setText(sugestao.curso);
        holder.textViewTipo.setText(sugestao.tipo);
        holder.textViewConteudo.setText(sugestao.conteudo);
        holder.textViewNome.setText(sugestao.aluno);
        holder.textViewData.setText(sugestao.data);
    }

    @Override
    public int getItemCount() {
        return sugestoes.size();
    }
}
