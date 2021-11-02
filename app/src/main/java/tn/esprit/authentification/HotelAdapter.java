package tn.esprit.authentification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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


    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class HotelViewHolder extends  RecyclerView.ViewHolder{
        TextView   nomHotel,adresse;
        public HotelViewHolder(View itemView){
            super(itemView);
            nomHotel=(TextView) itemView.findViewById(R.id.nomHotel);
            adresse=(TextView)itemView.findViewById(R.id.adresse);


        }

    }
}
