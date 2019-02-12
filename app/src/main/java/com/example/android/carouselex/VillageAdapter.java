package com.example.android.carouselex;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Punith on 3/8/2018.
 */

public class VillageAdapter extends RecyclerView.Adapter<VillageAdapter.MyViewHolder>{
    Context context;
    Village village;
    Map<String,String> params;
    CollapsingToolbarLayout collapsingToolbarLayout;
    public VillageAdapter(final Context context,Map<String, String> params) {
        this.params=params;
        this.context = context;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView  name,population,constitution,district,state,description;
        public Button mp,institute,program;
        public MyViewHolder(View view) {
            super(view);
            this.name=(TextView)view.findViewById(R.id.name);
            this.population=(TextView)view.findViewById(R.id.population);
            this.constitution=(TextView)view.findViewById(R.id.constitution);
            this.district=(TextView)view.findViewById(R.id.district);
            this.state=(TextView)view.findViewById(R.id.state);
            this.description=(TextView)view.findViewById(R.id.description);
            this.mp=(Button)view.findViewById(R.id.mp);
            this.institute=(Button)view.findViewById(R.id.institute);
            this.program=(Button)view.findViewById(R.id.programs);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = (View) layoutInflater.inflate(R.layout.village_view,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        RequestQueue queue = Volley.newRequestQueue(context);
        collapsingToolbarLayout=(CollapsingToolbarLayout)((Activity) context).findViewById(R.id.collapsing_toolbar);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,context.getString(R.string.url), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    if(!obj.isNull("VNAME"))
                        holder.name.setText(obj.getString("VNAME"));
                    if(!obj.isNull("POPUL"))
                        holder.population.setText(obj.getString("POPUL"));
                    if(!obj.isNull("DISTRICT"))
                        holder.district.setText(obj.getString("DISTRICT"));
                    if(!obj.isNull("STATE"))
                        holder.state.setText(obj.getString("STATE"));
                    if(!obj.isNull("CONSTITUTION"))
                        holder.constitution.setText(obj.getString("CONSTITUTION"));
                    if(!obj.isNull("DESCRIPTION"))
                        holder.description.setText(obj.getString("DESCRIPTION"));
                    if(!obj.isNull("MPNAME"))
                        holder.mp.setText(obj.getString("MPNAME"));
                    //if(!obj.isNull("VNAME")) dont forget to add
                    holder.institute.setText("TEST");
                    holder.program.setText("Test");
                    collapsingToolbarLayout.setTitle(obj.getString("VNAME"));
                } catch (Exception e) {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        } ;
        queue.add(stringRequest);

    }
    @Override
    public int getItemCount() {
        return 1;
    }
}
