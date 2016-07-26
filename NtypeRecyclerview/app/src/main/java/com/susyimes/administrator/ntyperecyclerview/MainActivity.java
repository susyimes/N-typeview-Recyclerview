package com.susyimes.administrator.ntyperecyclerview;

import android.os.Handler;
import android.os.Message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Susyimes on 2016/7/25 0024.
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NtypeAdapter ntypeadapter;
    private List<String> list_topview;
    private List<String> list_item;
    private List<String> list_title;
    private List<String> list_img;
    private List<String> list_describe;
    private List<String> list_count;
    private List<List<String>> list_type0,list_type1,list_type2,list_type3,list_type4;
    private List<List<List<String>>> list_positon;
    private List<Map<String,List<String>>> listallin;
    private Map<String,List<String>> listall;
    private String ASSETPATH="file:///android_asset/";
    private int anInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        initData();


    }



    private void initView() {
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);


        list_topview=new ArrayList<>();
        list_item=new ArrayList<>();
        list_title=new ArrayList<>();
        list_img=new ArrayList<>();
        list_describe=new ArrayList<>();
        list_topview=new ArrayList<>();
        list_type0=new ArrayList<>();
        list_type1=new ArrayList<>();
        list_type2=new ArrayList<>();
        list_type3=new ArrayList<>();
        list_type4=new ArrayList<>();

        //u can use N *list or use list<list<list>>
        //like listimg1  listimg2 listimg3 to define 5 or more api souce data
        list_positon=new ArrayList<List<List<String>>>();
        list_count=new ArrayList<>();

        ntypeadapter=new NtypeAdapter(getBaseContext(),list_positon,list_count);




    }

    private void initData() {

        GridLayoutManager manager = new GridLayoutManager(getBaseContext(), 2);

        //item's span
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position==2||position==3||position==4||position==5){
                    return 1;
                }else {
                    return 2;
                }
            }
        });
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(ntypeadapter);






        new Thread() {
            @Override
            public void run() {

                Message msg = handler.obtainMessage();

                msg.what = 1;
                handler.sendMessage(msg);

            }
        }.start();


    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {

                for (int i=0;i<2;i++){

                    list_topview.add("a"+(i+1));

                }
                for (int i=0;i<4;i++){
                    list_item.add("item"+i);
                    list_title.add("title"+i);

                }


                //network api one
                list_type0.add(0,list_topview);
                list_positon.add(0,list_type0);


               // list_type.clear();


                //network api two
                list_type1.add(0,list_item);
                list_positon.add(1,list_type1);
                //list_type.clear();


                //network api three
                list_type2.add(0,list_img);
                list_type2.add(1,list_title);
                list_positon.add(2,list_type2);
               // list_type.clear();
                list_type3.add(0,list_item);
                list_positon.add(3,list_type3);
                //list_type.clear();
                // oganize otherlist
                list_title.clear();
                for (int i=0;i<9;i++){

                    list_img.add("a"+(i+1));
                    list_title.add("title"+i);
                    list_describe.add("xxxxxx"+i);

                }
                list_type4.add(0,list_img);
                list_type4.add(1,list_title);
                list_type4.add(2,list_describe);
                list_positon.add(4,list_type4);
                for (int i=0;i<(list_positon.get(4).get(0).size() - 1 + list_positon.size() + 3);i++){
                    list_count.add("a");
                }


                anInt=10;
                Log.i("xxxxxoo",list_positon.toString()+"");
                Log.i("zzz",list_positon.get(3).toString());
                ntypeadapter.notifyDataSetChanged();
            }

        }
    };

}
