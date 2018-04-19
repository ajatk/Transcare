package in.co.ragasoft.transcare;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.PointsGraphSeries;


public class SugarFastingGraph extends Fragment {

   private GraphView graph;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sugar_fasting_graph, container, false);
        graph = view.findViewById(R.id.graph_view);
        getGraphView();

        return view;
    }

    public GraphView getGraphView() {
         graph.setMinimumHeight(10); graph.setMinimumWidth(10);
         graph.setTitleColor(Color.RED);

         graph.setBackgroundResource(R.drawable.scooter);


        PointsGraphSeries<DataPoint> series3 = new PointsGraphSeries<>(new DataPoint[] {

                new DataPoint(2, 3),
                new DataPoint(3, 5),
                new DataPoint(4, 6),
                new DataPoint(5, 7)
        });
        graph.addSeries(series3);
        series3.setShape(PointsGraphSeries.Shape.TRIANGLE);

        series3.setColor(Color.YELLOW);

        PointsGraphSeries<DataPoint> series4 = new PointsGraphSeries<>(new DataPoint[] {

                new DataPoint(2, 3),
                new DataPoint(3, 5),
                new DataPoint(4, 6),
                new DataPoint(5, 7)
        });
        graph.addSeries(series4);
        series4.setColor(Color.GREEN);
        series3.setCustomShape(new PointsGraphSeries.CustomShape() {
            @Override
            public void draw(Canvas canvas, Paint paint, float x, float y, DataPointInterface dataPoint) {
                paint.setStrokeWidth(10);
                canvas.drawLine(x - 20, y - 20, x + 20, y + 20, paint);
                canvas.drawLine(x + 20, y - 20, x - 20, y + 20, paint);
                //canvas.drawBitmap(x,Color.RED,Color.BLUE,paint);

            }
        });

        return graph;
    }



}
