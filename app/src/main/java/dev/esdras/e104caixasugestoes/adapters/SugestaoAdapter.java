package dev.esdras.e104caixasugestoes.adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.esdras.e104caixasugestoes.R;
import dev.esdras.e104caixasugestoes.model.Sugestao;

public class SugestaoAdapter extends RecyclerView.Adapter<SugestaoViewHolder> {

    List<Sugestao> sugestoes;
    static Map<String, String> map = new HashMap<>();

    List<String> tipo = Arrays.asList("Sugestão", "Elogio", "Comentário", "Reclamação");

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull SugestaoViewHolder holder, int position) {
        Sugestao sugestao = sugestoes.get(position);
        holder.imageViewTipo.setImageResource(sugestao.toResourceId(sugestao.tipo));
        holder.textViewCurso.setText(sugestao.curso);
        holder.textViewTipo.setText(sugestao.toUtf8(sugestao.tipo));
        holder.textViewConteudo.setText(sugestao.conteudo);
        holder.textViewNome.setText(sugestao.aluno);

        // Formatar a data recebida do banco de dados do padrão 2021-11-12 10:30:59 para 12/11/2021
        String dataFormatada = LocalDate.parse(sugestao.data,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        holder.textViewData.setText(dataFormatada);
    }

    @Override
    public int getItemCount() {
        return sugestoes.size();
    }
}
