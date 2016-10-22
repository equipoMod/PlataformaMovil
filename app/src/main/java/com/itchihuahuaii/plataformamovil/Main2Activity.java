package com.itchihuahuaii.plataformamovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView)findViewById(R.id.mail_list);

        Mails[] mails = new Mails[]{
                new Mails(R.drawable.homework_icon,"Tarea Moviles"),
                new Mails(R.drawable.homework_icon,"Tarea Administracion"),
                new Mails(R.drawable.homework_icon,"Presentacion Software"),
                new Mails(R.drawable.homework_icon,"Tarea Gestion"),

        };

        MailAdapter adapter = new MailAdapter(this,R.layout.listview_item_row,mails);

        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        listView.addHeaderView(header);
        listView.setAdapter(adapter);
    }
}
