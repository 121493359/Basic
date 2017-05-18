package basic2.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/18
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    private final Context context;
    private final List<T> mDatas;
    private final LayoutInflater inflater;
    private final int itemLayoutId;

    public CommonAdapter(Context wrap, int itemLayoutId) {
        context = wrap;
        this.itemLayoutId = itemLayoutId;
        inflater = LayoutInflater.from(context);
        mDatas = new ArrayList<>();
    }

    public void updateData(List<T> list) {
        updateData(list, false);
    }

    public void updateData(List<T> list, boolean isMore) {
        if (!isMore)
            mDatas.clear();
        mDatas.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        convert(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();
    }

    private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return ViewHolder.get(context, convertView, parent, itemLayoutId, position);
    }

    public abstract void convert(ViewHolder helper, T item, int position);
}
