package tn.esprit.authentification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReservationRestoAdapter extends RecyclerView.Adapter<ReservationRestoAdapter.HotelViewHolder> {

    List<reservationrestaurant> hotels;
    Context context;

    public ReservationRestoAdapter(List<reservationrestaurant> hotels, Context context) {
        this.hotels = hotels;
        this.context = context;
    }

    @NonNull
    @Override
    public ReservationRestoAdapter.HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.recyclereservationresto,parent,false);
        return new ReservationRestoAdapter.HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationRestoAdapter.HotelViewHolder holder, int position) {
        reservationrestaurant h=hotels.get(position);
        holder.nomrestaurant.setText("Nom du restaurant :"+h.getNomRestoReservation());
        holder.heure.setText(" pour "+h.getHeurerepas());
        holder.jour.setText("à "+h.getJour());
        holder.nbPersonne.setText("Le :"+ h.getNbPersonne());
        holder.adresserestaurant.setText(" à "+h.getAdresse());

    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class HotelViewHolder extends  RecyclerView.ViewHolder{
        TextView nomrestaurant,  heure,jour,nbPersonne,adresserestaurant;

        public HotelViewHolder(View itemView){
            super(itemView);

            nomrestaurant=(TextView) itemView.findViewById(R.id.nomrestaurant);
            System.out.println(nomrestaurant);
            heure=(TextView) itemView.findViewById(R.id.heure);
            jour=(TextView) itemView.findViewById(R.id.jour);
            nbPersonne=(TextView) itemView.findViewById(R.id.nbPersonne);
            adresserestaurant=(TextView) itemView.findViewById(R.id.adresserestaurant);


        }

    }
}
