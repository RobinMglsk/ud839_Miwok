package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RobinMglsk on 5/07/2018.
 */
class WordAdapter extends ArrayAdapter<Word> {

    int mBackgroundColor;

    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColor){
        super(context, 0, words);
        mBackgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView text1 = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        text1.setText(currentWord.getMiwokTranslation());

        TextView text2 = (TextView) listItemView.findViewById(R.id.default_text_view);
        text2.setText(currentWord.getDefaultTranslation());

        ImageView icon = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        if(currentWord.hasImage()){
            icon.setVisibility(View.VISIBLE);
            icon.setImageResource(currentWord.getImageResourceId());
        }else{
            icon.setVisibility(View.GONE);
        }

        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        listItemView.setBackgroundColor(color);

        return listItemView;
    }

}
