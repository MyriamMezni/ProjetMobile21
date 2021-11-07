package tn.esprit.authentification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PreferencesRestoAdapter  extends RecyclerView.Adapter<PreferencesRestoAdapter.PreferenceViewHolder> {




    List<PreferencesRestoEntity> preferences;
    Context context;

    public PreferencesRestoAdapter(List<PreferencesRestoEntity> preferences, Context context) {
        this.preferences = preferences;
        this.context = context;
    }

    @NonNull
    @Override
    public PreferencesRestoAdapter.PreferenceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_recyclepreferenceresto,parent,false);
        return new PreferencesRestoAdapter.PreferenceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder, int position) {
        PreferencesRestoEntity h=preferences.get(position);

        holder.nomRestoo.setText("Nom Restaurant : "+h.getNomResto());
        holder.nomUser.setText("Nom Utilisateur :"+h.getNomUser());
        holder.adr.setText("Adresse:"+h.getAdresse());

      /*  holder.bouton.setOnClickListener(view -> {
            UserDatabase userDatabase = UserDatabase.getUserDatabase(context);
                  //UserEntity.user + h.getIdHotel

*/
    }


    @Override
    public int getItemCount() {
        return preferences.size();
    }

    public class PreferenceViewHolder extends  RecyclerView.ViewHolder{
        TextView nomRestoo,  nomUser,adr;
        Button bouton;
        public PreferenceViewHolder(View itemView){
            super(itemView);
            nomRestoo=(TextView) itemView.findViewById(R.id.heure);
            nomUser=(TextView) itemView.findViewById(R.id.nomrestaurant);
            adr=(TextView) itemView.findViewById(R.id.adresserestaurant);

            bouton=itemView.findViewById(R.id.preferencehotel);



        }

    }
}
