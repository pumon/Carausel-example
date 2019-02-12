package com.example.android.carouselex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Punith on 3/17/2018.
 */

public class Village {
    String vid,vname,popul,constitution,description,district,state;
    ArrayList<String> names;
    Village(String vid,String vname,String popul,String constitution,String description,String district,String state)
    {
        names=new ArrayList<String>();
        names.add("ID\t\t:");
        names.add("NAME\t\t:");
        names.add("POPULATION\t\t:");
        names.add("CONSTITUTION\t\t:");
        names.add("DESCRIPTION\t\t:");
        names.add("DISTRICT\t\t:");
        names.add("STATE\t\t:");
        this.vid=vid;
        this.vname=vname;
        this.popul=popul;
        this.constitution=constitution;
        this.description=description;
        this.district=district;
        this.state=state;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public String getVid() {
        return vid;
    }

    public String getVname() {
        return vname;
    }

    public String getConstitution() {
        return constitution;
    }

    public String getDescription() {
        return description;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

    public String getPopul() {
        return popul;
    }
}

