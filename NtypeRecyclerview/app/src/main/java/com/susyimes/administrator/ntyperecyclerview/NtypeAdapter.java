package com.susyimes.administrator.ntyperecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Susyimes on 2016/7/25 0025.
 */
public class NtypeAdapter extends RecyclerView.Adapter<NtypeAdapter.ViewHolder> {
    private Context mContext;
    private List<String> list_topview;
    private List<String> list_item;
    private List<String> list_title;
    private List<String> list_img;
    private List<String> list_describe;
    private List<List<String>> list_type;
    private List<List<List<String>>> list_positon;
    private List<String> list_count;
    private String ASSETPATH="file:///android_asset/";
    private int anInt;

    public NtypeAdapter(Context context,List<List<List<String>>> list_positon,List<String> list_count) {

        this.mContext=context;
        this.list_type=list_type;
        this.list_positon=list_positon;
        this.list_count=list_count;
        this.anInt=anInt;
       // list_positon=new ArrayList<>();
//        Log.i("xxx",list_positon.toString()+"");
       if (list_positon.size()!=0)
       Log.i("kkk",list_positon.toString()+"");


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (viewType==0){
            View v = LayoutInflater.from(mContext).inflate(R.layout.item_top, viewGroup, false);

            return new TopViewHolder(v);
        }else  if (viewType==1){
            View v = LayoutInflater.from(mContext).inflate(R.layout.item_line, viewGroup, false);

            return new LineViewHolder(v);
        }else if (viewType==2){
            View v = LayoutInflater.from(mContext).inflate(R.layout.item_four, viewGroup, false);

            return new FourViewHolder(v);

        }else {
            View v = LayoutInflater.from(mContext).inflate(R.layout.item_list, viewGroup, false);

            return new ListViewHolder(v);
        }
    }
    public NtypeAdapter(Context context,List<String> list_topview,List<String> list_item,List<String> list_title,List<String> list_img,List<String> list_describe) {

        this.mContext=context;
        this.list_topview=list_topview;
        this.list_item=list_item;
        this.list_title=list_title;
        this.list_img=list_img;
        this.list_describe=list_describe;

    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else if (position==1||position==6){
            return 1;
        }else if (position==2||position==3||position==4||position==5){
            return 2;
        }else if (position==4){
            return 4;
        }else {
            return 4;
        }

    }




    public class  ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {

        }
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int i=0;
        if (holder.getItemViewType()==0){
            TopViewHolder topholder = (TopViewHolder) holder;
            Glide.with(mContext).load(ASSETPATH+list_positon.get(0).get(0).get(0)+".jpg").centerCrop().into(topholder.img);
            Log.i("picc",ASSETPATH+list_positon.get(0).get(0).get(0));
          //  Glide.with(mContext).load(ASSETPATH+list_img.get(0)).centerCrop().into(topholder.img);

            //this 0,just to show simple , u can create a list to include listpositon.get(0).get(i) to viewpager
        }else if (holder.getItemViewType()==1){
            LineViewHolder lineholder= (LineViewHolder) holder;

            if (i==0){
                lineholder.tv.setText(list_positon.get(1).get(0).get(0));
                i+=1;
            }else {
                lineholder.tv.setText(list_positon.get(3).get(0).get(0));
            }
        }else if (holder.getItemViewType()==2){
            FourViewHolder fourViewHolder= (FourViewHolder) holder;
            i=position-2;
            Glide.with(mContext).load(ASSETPATH+list_positon.get(2).get(0).get(i)+".jpg").centerCrop().into(fourViewHolder.imageView);
            fourViewHolder.textView.setText(list_positon.get(2).get(1).get(i));
        }else {
            ListViewHolder listViewHolder= (ListViewHolder) holder;
          i=position-7;
            Glide.with(mContext).load(ASSETPATH+list_positon.get(4).get(0).get(i)+".jpg").centerCrop().into(listViewHolder.imageView);
            listViewHolder.tv1.setText(list_positon.get(4).get(1).get(i));
            listViewHolder.tv2.setText(list_positon.get(4).get(2).get(i));

        }
    }


    @Override
    public int getItemCount() {

        return list_count.size();
    }

    private class TopViewHolder extends ViewHolder {
        ImageView img;

        public TopViewHolder(View v) {
            super(v);
            img= (ImageView) v.findViewById(R.id.img1);
            //try XXX.setOnclicklistner(this) then on next method work this OB.or U want to have more type clicklistener try interface .
        }

        @Override
        public void onClick(View v) {
            super.onClick(v);
        }
    }

    private class LineViewHolder extends ViewHolder {
        TextView tv;
        public LineViewHolder(View v) {
            super(v);
            tv= (TextView) v.findViewById(R.id.txt_line);
        }

        @Override
        public void onClick(View v) {
            super.onClick(v);
        }
    }

    private class FourViewHolder extends ViewHolder {
        ImageView imageView;
        TextView textView;
        public FourViewHolder(View v) {
            super(v);
            imageView= (ImageView) v.findViewById(R.id.img1);
            textView= (TextView) v.findViewById(R.id.tv1);
        }

        @Override
        public void onClick(View v) {
            super.onClick(v);
        }
    }

    private class ListViewHolder extends ViewHolder {
        ImageView imageView;
        TextView tv1;
        TextView tv2;

        public ListViewHolder(View v) {
            super(v);
            imageView= (ImageView) v.findViewById(R.id.img1);
            tv1= (TextView) v.findViewById(R.id.tv1);
            tv2= (TextView) v.findViewById(R.id.tv2);
        }

        @Override
        public void onClick(View v) {
            super.onClick(v);
        }
    }
}
