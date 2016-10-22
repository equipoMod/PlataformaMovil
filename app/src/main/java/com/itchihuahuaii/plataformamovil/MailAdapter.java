package com.itchihuahuaii.plataformamovil;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by usuario1 on 10/22/2016.
 */

public class MailAdapter extends ArrayAdapter<Mails>{
    Context mycontext;
    int mylayoutResourceID;
    Mails mydata[] = null;

    public MailAdapter(Context context,int layoutResourceID,Mails[] data){
        super(context,layoutResourceID,data);
        this.mycontext=context;
        this.mylayoutResourceID=layoutResourceID;
        this.mydata=data;
    }


    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        MailAdapterHolder holder = null;

        if(row==null){
            LayoutInflater inflater = ((Activity)mycontext).getLayoutInflater();
            row=inflater.inflate(mylayoutResourceID,parent,false);

            holder = new MailAdapterHolder();
            holder.imagen=(ImageView) row.findViewById(R.id.mail_image);
            holder.textView =(TextView)row.findViewById(R.id.mail_texto);
            row.setTag(holder);
        }else{
            holder=(MailAdapterHolder)row.getTag();
        }
        Mails mails = mydata[position];
        holder.textView.setText(mails.title);
        holder.imagen.setImageResource(mails.icon);

        return row;
    }

    static class MailAdapterHolder{
        ImageView imagen;
        TextView textView;
    }

}
