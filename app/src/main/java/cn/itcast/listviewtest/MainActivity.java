package cn.itcast.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] data={"Cherry","Pear","Peach","Watermelon","Hami melon","Grape","Mango","Strawberry","Pineapple","Orange","Pitaya","Banana","Apple"};
    private int[] icons={R.drawable.cr,R.drawable.pe,R.drawable.pc,R.drawable.wm,R.drawable.hm,R.drawable.gp,
            R.drawable.mg,R.drawable.st,R.drawable.pa,R.drawable.og,R.drawable.pt,R.drawable.bn,R.drawable.ap};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=(ListView) findViewById(R.id.lv);
        MyBaseAdapter mAdapter =new MyBaseAdapter();
        mListView.setAdapter(mAdapter);

    }
    class MyBaseAdapter extends BaseAdapter{
        public int getCount(){
            return data.length;
        }
        @Override
        public Object getItem(int position) {
            return data[position];
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            ViewHolder holder;
            if(convertView==null){
                convertView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_item,parent,false);
                holder=new ViewHolder();
                holder.mTextView=(TextView)convertView.findViewById(R.id.item_tv);
                holder.imageView=(ImageView)convertView.findViewById(R.id.item_image);
                convertView.setTag(holder);
            }else{
                holder =(ViewHolder) convertView.getTag();
            }
            holder.mTextView.setText(data[position]);
            holder.imageView.setBackgroundResource(icons[position]);
            return convertView;
        }
        class ViewHolder{
            TextView mTextView;
            ImageView imageView;
        }
    }
}
