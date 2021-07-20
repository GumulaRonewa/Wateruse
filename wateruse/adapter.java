package com.example.user.wateruse;



import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class adapter extends ArrayAdapter<entry> {

    private Context mContext;
    private List<entry> entryList = new ArrayList<>();

    public adapter(@NonNull Context context,ArrayList<entry> list) {
        super(context, 0 , list);
        mContext = context;
        entryList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        /*if(listItem == null) */
        listItem = LayoutInflater.from(mContext).inflate(R.layout.ent,parent,false);

        entry Entry = entryList.get(position);


        TextView date = (TextView) listItem.findViewById(R.id.date);
        String da=Entry.getDate().substring(0,4)+"-"+Entry.getDate().substring(4,6)+"-"+Entry.getDate().substring(6,8);
        date.setText(da);

       TextView release = (TextView) listItem.findViewById(R.id.total);
       String s=""+Entry.getTotal();
        release.setText(s);
        return listItem;
    }
}