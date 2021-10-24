package dev.esdras.e104caixasugestoes.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.esdras.e104caixasugestoes.R;

public class SugestaoViewHolder extends RecyclerView.ViewHolder {

    ImageView imageViewTipo;
    TextView textViewTipo;
    TextView textViewConteudo;
    TextView textViewCurso;
    TextView textViewNome;
    TextView textViewData;

    public SugestaoViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageViewTipo = itemView.findViewById(R.id.imageViewTipo);
        this.textViewConteudo = itemView.findViewById(R.id.textViewConteudo);
        this.textViewTipo = itemView.findViewById(R.id.textViewTipo);
        this.textViewCurso = itemView.findViewById(R.id.textViewCurso);
        this.textViewNome = itemView.findViewById(R.id.textViewNome);
        this.textViewData = itemView.findViewById(R.id.textViewData);
    }
}
