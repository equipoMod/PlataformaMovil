package com.itchihuahuaii.plataformamovil;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FragmentMisCursos extends Fragment {

    private AppBarLayout appBar;
    private TabLayout pestanas;
    private ViewPager viewPager;

    public FragmentMisCursos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_paginado,container,false);

        if(savedInstanceState==null){
            insertarTabs(container);

            viewPager=(ViewPager)view.findViewById(R.id.pager);
            llenarViewPager(viewPager);
            pestanas.setupWithViewPager(viewPager);
        }
        return view;
    }

    private void insertarTabs(ViewGroup container){
        View padre = (View) container.getParent();
        appBar=(AppBarLayout)padre.findViewById(R.id.appbar);
        pestanas = new TabLayout(getActivity());
        pestanas.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#FFFFFF"));
        appBar.addView(pestanas);
    }

    private void llenarViewPager(ViewPager viewPager){
        AdaptadorSecciones adapter = new AdaptadorSecciones(getFragmentManager());
        adapter.addFragment(new FragmentTareas(),"Mis tareas");
        adapter.addFragment(new FragmentCursos(),"Mis cursos");
        adapter.addFragment(new FragmentArchivos(),"Mis archivos");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBar.removeView(pestanas);
    }

    public class AdaptadorSecciones extends FragmentStatePagerAdapter{

        List<Fragment> fragments = new ArrayList<>();
        List<String> titulos = new ArrayList<>();

        public AdaptadorSecciones(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
        @Override
        public int getCount() {
            return  fragments.size();
        }
        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            titulos.add(title);
        }



        @Override
        public CharSequence getPageTitle(int position) {
            return titulos.get(position);
        }
    }



}
