package tn.esprit.authentification;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestoAdapter  extends RecyclerView.Adapter<RestoAdapter.RestoViewHolder> {




    List<RestoEntity> restos;
    Context context;

    public RestoAdapter(List<RestoEntity> restos, Context context) {
        this.restos = restos;
        this.context = context;
    }

    @NonNull
    @Override
    public RestoAdapter.RestoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_recycerviewresto,parent,false);
        return new RestoAdapter.RestoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestoAdapter.RestoViewHolder holder, int position) {
        RestoEntity h=restos.get(position);


        holder.nomResto.setText(h.getNomResto());
        holder.adresse.setText(h.getAdresse());
        holder.cuisine.setText(h.getCuisine());
        holder.ouvert.setText(h.getOuvert());
        holder.budget.setText(h.getBudget());
        holder.note.setText(h.getNote());
        holder.bouton.setOnClickListener(view -> {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(context);
                    //UserEntity.user + h.getIdHotel
                    final PreferencesRestoDao userDao = userDatabase.preferencesRestoDao();

                    PreferencesRestoEntity p=new PreferencesRestoEntity(h.getNomResto().toString(),h.getAdresse(),UserEntity.user.getName().toString(),null,null);
                    userDao.addHotel(p);
                    Toast.makeText(context, "Restaurant ajouté", Toast.LENGTH_SHORT).show();

                });

        holder.reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.getContext().startActivity(new Intent(v.getContext(), ActivityReservationResto.class).putExtra("nomReso",holder.nomResto.getText()).putExtra("adresse",holder.adresse.getText()));
            }
        });



    }


    @Override
    public int getItemCount() {
        return restos.size();
    }

    public class RestoViewHolder extends  RecyclerView.ViewHolder{
        TextView nomResto,  adresse,  cuisine,  ouvert,  budget,  note;
        Button bouton,reserver;
        public RestoViewHolder(View itemView){
            super(itemView);
            nomResto=(TextView) itemView.findViewById(R.id.nomResto);
            adresse= (TextView) itemView.findViewById(R.id.adresse);
            cuisine=(TextView) itemView.findViewById(R.id.cuisine);
            ouvert=(TextView) itemView.findViewById(R.id.ouvert);
            budget=(TextView) itemView.findViewById(R.id.budget);
            note=(TextView) itemView.findViewById(R.id.note);
            bouton=itemView.findViewById(R.id.preferencehotel);
            reserver=itemView.findViewById(R.id.reserver);



        }

    }
}
