package com.example.exemplobancodados.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exemplobancodados.R;
import com.example.exemplobancodados.model.Aluno;

import java.util.ArrayList;

public class AlunoListAdapter extends RecyclerView.Adapter<AlunoListAdapter.ViewHolder>{

    private ArrayList<Aluno> listaAluno;
    private Context context;
    public AlunoListAdapter(ArrayList<Aluno> listaAluno, Context context){
        this.listaAluno = listaAluno;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.item_list_aluno, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Aluno alunoSelecionado = listaAluno.get(position);
        holder.tvRa.setText(String.valueOf(alunoSelecionado.getRa()));
        holder.tvNome.setText(alunoSelecionado.getNome());
    }

    @Override
    public int getItemCount() {
        return this.listaAluno.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRa;
        TextView tvNome;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvRa = itemView.findViewById(R.id.edRa);
            this.tvNome = itemView.findViewById(R.id.edNome);
        }

    }





}
