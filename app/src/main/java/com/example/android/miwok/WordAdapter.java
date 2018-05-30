package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by McDermott on 24/05/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mCategoryColour;

    public WordAdapter(@NonNull Context context, @NonNull List<Word> objects) {
        super(context, 0, objects);
    }

    public WordAdapter(@NonNull Context context, @NonNull List<Word> objects, int categoryColour) {
        super(context, 0, objects);
        this.mCategoryColour = categoryColour;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word currentWord = getItem(position);

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTranslationTextView.setText(currentWord.getDefaultTranslation());

        TextView miwokTranslationTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTranslationTextView.setText(currentWord.getMiwokTranslation());

        ImageView translationImageView = (ImageView) listItemView.findViewById(R.id.image);
        translationImageView.setImageResource(currentWord.getImageResourceID());

        if (!currentWord.hasImage()) {
            translationImageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.category_layout);
        int colour = ContextCompat.getColor(getContext(), mCategoryColour);
        textContainer.setBackgroundColor(colour);

        return listItemView;
    }
}
