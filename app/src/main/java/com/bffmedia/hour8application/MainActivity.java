package com.bffmedia.hour8application;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import java.util.ArrayList;


public class MainActivity extends Activity {
    ListView pieListView;
    ArrayList<Pie> pies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieListView = (ListView) findViewById(R.id.listView);
        pies = makePies();
        PieAdapter adapter = new PieAdapter(this, pies);
        pieListView.setAdapter(adapter);


        pieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        pies.get(position).mName, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public class PieAdapter extends BaseAdapter {
        Context mContext;
        ArrayList<Pie>  mPies;
        LayoutInflater mInflater;
        public PieAdapter(Context c, ArrayList<Pie> pies) {
            mContext = c;
            mPies = pies;
            mInflater = (LayoutInflater) mContext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

        }
        public int getCount() {
            return  mPies.size();
        }
        public Object getItem(int position) {
            return mPies.get(position);
        }
        public long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.pie_view_item, null);
                viewHolder = new ViewHolder();
                viewHolder.textViewName = (TextView) convertView.findViewById(R.id.textViewName);
                viewHolder.textViewDescription = (TextView) convertView.findViewById(R.id.textViewDescription);
                viewHolder.textViewPrice = (TextView) convertView.findViewById(R.id.textViewPrice);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            Pie currentPie = mPies.get(position);
            viewHolder.textViewName.setText(currentPie.mName);
            viewHolder.textViewDescription.setText(currentPie.mDescription);
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String price = formatter.format(currentPie.mPrice);
            viewHolder.textViewPrice.setText(price);
            return convertView;
        }
    }



     private static class ViewHolder {
        public TextView textViewName;
        public TextView textViewDescription;
        public TextView textViewPrice;
     }

    private ArrayList<Pie> makePies(){
        ArrayList<Pie> pies = new ArrayList<Pie>();
        pies.add(new Pie("Apple","An old-fashioned favorite. ", 1.5));
        pies.add(new Pie("Blueberry","Made with fresh Maine blueberries.", 1.5));
        pies.add(new Pie("Cherry","Delicious and fresh made daily.", 2.0));
        pies.add(new Pie("Coconut Cream","A customer favorite.", 2.5));
        return pies;
    }

    private class Pie {
        String mName;
        String mDescription;
        double mPrice;
        public Pie (String name, String description, double price){
            this.mName = name;
            this.mDescription = description;
            this.mPrice = price;
        }
    }


}
