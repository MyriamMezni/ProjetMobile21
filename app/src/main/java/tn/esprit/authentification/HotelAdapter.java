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

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

List<HotelEntity> hotels;
Context context;

    public HotelAdapter(List<HotelEntity> hotels, Context context) {
        this.hotels = hotels;
        this.context = context;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.activity_recyclerview,parent,false);
    return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
    HotelEntity h=hotels.get(position);


    holder.nomHotel.setText(h.getNomHotel());
    holder.adresse.setText(h.getAdresse());
        holder.pension.setText("Pension "+h.getPension());
        holder.nbEtoile.setText(h.getNbEtoile()+" étoiles");
        holder.prix.setText(h.getPrix()+"TND");
        holder.service1.setText(h.getService1());
        holder.service2.setText(h.getService2());
        holder.service3.setText(h.getService3());
        holder.equipements.setText(h.getEquipements());
        holder.note.setText("Note : "+h.getNote());
       holder.bouton.setOnClickListener(view -> {
            UserDatabase userDatabase = UserDatabase.getUserDatabase(context);
                  //UserEntity.user + h.getIdHotel
           final PreferenceDao PreferenceDao = userDatabase.preferenceDao();
           Preference p=new Preference(h.getNomHotel().toString(),UserEntity.user.getName().toString(),h.getAdresse(),null,null);

           PreferenceDao.addHotel(p);
           Toast.makeText(context, "Hotel ajouté", Toast.LENGTH_SHORT).show();





               }
        );

    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class HotelViewHolder extends  RecyclerView.ViewHolder{
        TextView   nomHotel,adresse,pension,nbEtoile,prix,service1, service2,  service3,  equipements,  note;
        Button bouton;
        public HotelViewHolder(View itemView){
            super(itemView);
            nomHotel=(TextView) itemView.findViewById(R.id.nomResto);
            adresse=(TextView)itemView.findViewById(R.id.adresse);
            pension=(TextView) itemView.findViewById(R.id.pension);
            nbEtoile=(TextView) itemView.findViewById(R.id.nbEtoile);
            prix=(TextView) itemView.findViewById(R.id.prix);
            service1=(TextView) itemView.findViewById(R.id.service1);
            service2=(TextView) itemView.findViewById(R.id.service2);
            service3=(TextView) itemView.findViewById(R.id.service3);
            equipements=(TextView) itemView.findViewById(R.id.equipements);
            note=(TextView) itemView.findViewById(R.id.note);
            bouton=itemView.findViewById(R.id.preferencehotel);



        }

    }
}
