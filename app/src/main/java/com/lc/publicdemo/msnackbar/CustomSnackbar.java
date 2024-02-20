package com.lc.publicdemo.msnackbar;

import android.support.annotation.NonNull;
import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lc.publicdemo.R;

/**
 * @Author: LinChen
 * @Date: 2024/1/11 15:38
 */
public class CustomSnackbar extends BaseTransientBottomBar<CustomSnackbar> {


    /**
     * Constructor for the transient bottom bar.
     *
     * @param parent              The parent for this transient bottom bar.
     * @param content             The content view for this transient bottom bar.
     * @param contentViewCallback The content view callback for this transient bottom bar.
     */
    protected CustomSnackbar(@NonNull ViewGroup parent, @NonNull View content, @NonNull ContentViewCallback contentViewCallback) {
        super(parent, content, contentViewCallback);


        LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_snack, parent);

    }


}
