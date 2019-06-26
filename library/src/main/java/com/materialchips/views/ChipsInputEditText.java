package com.materialchips.views;


import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

public class ChipsInputEditText extends androidx.appcompat.widget.AppCompatEditText {

    private FilterableListView filterableListView;

    public ChipsInputEditText(Context context) {
        super(context);
    }

    public ChipsInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isFilterableListVisible() {
        return filterableListView != null && filterableListView.getVisibility() == VISIBLE;
    }

    public FilterableListView getFilterableListView() {
        return filterableListView;
    }

    public void setFilterableListView(FilterableListView filterableListView) {
        this.filterableListView = filterableListView;
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            try {
                filterableListView.setVisibility(GONE);
            }catch (Exception e){
                //
            }
            return true;
        }
        return super.onKeyPreIme(keyCode, event);
    }
}
