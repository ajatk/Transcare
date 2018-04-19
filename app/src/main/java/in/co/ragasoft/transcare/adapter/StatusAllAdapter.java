package in.co.ragasoft.transcare.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;
import in.co.ragasoft.transcare.R;

/**
 * Created by sam on 4/7/2018.
 */

public class StatusAllAdapter extends RecyclerView.Adapter<StatusAllAdapter.ViewHolder> {

    List<String> list;
    Context context;
    List<int[]> mlist;
    List<String> simlist;
    private int[] imlist;
    public StatusAllAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    /*public StatusAllAdapter(Context context, List<String> list, List<int[]> mlist) {
        this.context = context;
        this.list = list;
        this.mlist = mlist;
    }*/

    public StatusAllAdapter(Context context, List<String> list, int[] images) {
        this.context = context;
        this.list = list;
        this.imlist = images;
}

    public StatusAllAdapter(Context context, List<String> list, List<String> simlist) {
        this.context = context;
        this.list = list;
        this.simlist = simlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.status_all_list_design,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        if(list.get(position).equals(0))
        {
            try {
                holder.viewLine.setVisibility(View.GONE);
                holder.statusText.setText(list.get(0));
               // holder.statusImage.setImageResource(Integer.parseInt(String.valueOf(mlist.get(0))));
            }catch (NumberFormatException e)
            {

            }
        }
        else {
            try {
                holder.viewLine.setVisibility(View.VISIBLE);
                holder.statusText.setText(list.get(position));
                holder.shapeDraw.setBackgroundDrawable(new Triangle(Color.WHITE,6));
                // Glide.with(context).load(images.getImageUrl()[position]).into(holder.recyclerimageView);

               // holder.statusImage.setImageResource(Integer.parseInt(String.valueOf(imlist.length)));
                holder.statusImage.setImageResource(Integer.parseInt(simlist.get(position)));
            } catch (NumberFormatException e) {
                Log.e("<find here excetion>>>", e.getMessage());
            }
        }
    }

    @Override
    public int getItemCount() {

        if(simlist==null){
            return 0;
        } else{
            return simlist.size();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView statusText, viewLine;
        ImageView shapeDraw;
        CircleImageView statusImage;
        public ViewHolder(View itemView) {
            super(itemView);
            shapeDraw = itemView.findViewById(R.id.imageFor_shape);
            statusImage = itemView.findViewById(R.id.status_images);
            viewLine = itemView.findViewById(R.id.topViewLine_onScooter);
            statusText = itemView.findViewById(R.id.status_text);
        }

    }
    public class Triangle extends Drawable {
        private int numberOfSides = 3;
        private Path polygon = new Path();
        private Path temporal = new Path();
        private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        public Triangle(int color, int sides) {
            paint.setColor(color);
            polygon.setFillType(Path.FillType.EVEN_ODD);
            this.numberOfSides = sides;
        }
        @Override
        public void draw(@NonNull Canvas canvas) {
            canvas.drawPath(polygon, paint);
        }

        @Override
        public void setAlpha(int alpha) {
            paint.setAlpha(alpha);
        }

        @Override
        public void setColorFilter(@Nullable ColorFilter cF) {
            paint.setColorFilter(cF);
        }

        @Override
        public int getOpacity() {
            return paint.getAlpha();
        }

        @Override
        protected void onBoundsChange(Rect bounds) {
            super.onBoundsChange(bounds);
            computeHex(bounds);
            invalidateSelf();
        }

        public void computeHex(Rect bounds) {

            final int width = bounds.width();
            final int height = bounds.height();
            final int size = Math.min(width, height);
            final int centerX = bounds.left + (width / 2);
            final int centerY = bounds.top + (height / 2);

            polygon.reset();
            polygon.addPath(createHexagon(size, centerX, centerY));
            polygon.addPath(createHexagon((int) (size * .8f), centerX, centerY));
        }

        private Path createHexagon(int size, int centerX, int centerY) {
            final float section = (float) (2.0 * Math.PI / numberOfSides);
            int radius = size / 2;
            Path polygonPath = temporal;
            polygonPath.reset();
            polygonPath.moveTo((centerX + radius * (float)Math.cos(0)), (centerY + radius
                    * (float)Math.sin(0)));

            for (int i = 1; i < numberOfSides; i++) {
                polygonPath.lineTo((centerX + radius * (float)Math.cos(section * i)),
                        (centerY + radius * (float)Math.sin(section * i)));
            }

            polygonPath.close();
            return polygonPath;
        }
    }
}
