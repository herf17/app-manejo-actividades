package com.example.inge.pestanas;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PestañasAdaptador extends FragmentStateAdapter {
    int idProy;
    public PestañasAdaptador(@NonNull Fragment fragment,int idp) {
        super(fragment);
        this.idProy = idp;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return ObjetivosPricipalesFragment.newInstance(idProy);
            default:
                return ColaboradoresFragment.newInstance(idProy);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
