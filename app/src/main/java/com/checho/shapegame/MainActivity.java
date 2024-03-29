package com.checho.shapegame;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

/**
 * @author Checho
 */
public class MainActivity extends AppCompatActivity {


    private TextView Score;
    private TextView veredicto;

    private Button red;
    private Button green;
    private Button blue;


    private Paint p;
    private Bitmap bm;
    private Canvas c;
    private int d;

    private Random rd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Score = findViewById(R.id.Score);
        veredicto = findViewById(R.id.Veredicto);

        red = findViewById(R.id.Rojo);
        green = findViewById(R.id.Verde);
        blue = findViewById(R.id.Azul);


        ImageView iv = findViewById(R.id.imageView);


        bm = Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
        c = new Canvas(bm);

        this.p=new Paint();
        p.setColor(Color.BLUE);


        red.setBackgroundColor(Color.RED);
        green.setBackgroundColor(Color.GREEN);
        blue.setBackgroundColor(Color.BLUE);



        this.rd=new Random(1);
        iv.setImageBitmap(bm);
        rd();







    }


    private void rd(){

        findViewById(R.id.clayout).setBackgroundColor(Color.rgb(255,255,255));
        c.drawColor(Color.rgb(255,255,255));

        d = rd.nextInt(9);
        int f= rd.nextInt(2);
        float size=c.getHeight()/2f;
        float cx=bm.getWidth()/2f;
        float cy =bm.getHeight()/2f;
        p.setColor(Color.BLACK);




        //c = new Canvas(bm);
        if(d==0)
        {
            p.setColor(Color.RED);
            c = new Canvas(bm);
            c.drawCircle(cx,cy,size,p);
        }
        if(d==1)
        {
            p.setColor(Color.GREEN);
            c.drawCircle(cx,cy,size,p);

        }
        if(d==2)
        {
            p.setColor(Color.BLUE);
            c.drawCircle(cx,cy,size,p);

        }
        if(d==3)
        {
            p.setColor(Color.RED);
            Rect r = new Rect(0, 0,c.getWidth(),c.getHeight());
            c.drawRect(r,p);

        }
        if(d==4)
        {
            p.setColor(Color.GREEN);
            Rect r = new Rect(0, 0,c.getWidth(),c.getHeight());
            c.drawRect(r,p);

        }
        if(d==5)
        {
            p.setColor(Color.BLUE);
            Rect r = new Rect(0, 0,c.getWidth(),c.getHeight());
            c.drawRect(r,p);

        }
        if(d==6)
        {
            p.setColor(Color.RED);
            Point x = new Point(c.getWidth()/2, 0);
            Point y = new Point(0, c.getHeight());
            Point z = new Point(c.getWidth(), c.getHeight());
            Path path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.lineTo(x.x, x.y);
            path.lineTo(y.x, y.y);
            path.lineTo(z.x, z.y);
            path.lineTo(x.x, x.y);
            path.close();

            c.drawPath(path,p);



        }
        if(d==7)
        {
            p.setColor(Color.GREEN);
            Point x = new Point(c.getWidth()/2, 0);
            Point y = new Point(0, c.getHeight());
            Point z = new Point(c.getWidth(), c.getHeight());
            Path path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.lineTo(x.x, x.y);
            path.lineTo(y.x, y.y);
            path.lineTo(z.x, z.y);
            path.lineTo(x.x, x.y);
            path.close();

            c.drawPath(path,p);
        }

        if(d==8)
        {
            p.setColor(Color.BLUE);
            Point x = new Point(c.getWidth()/2, 0);
            Point y = new Point(0, c.getHeight());
            Point z = new Point(c.getWidth(), c.getHeight());
            Path path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.lineTo(x.x, x.y);
            path.lineTo(y.x, y.y);
            path.lineTo(z.x, z.y);
            path.lineTo(x.x, x.y);
            path.close();

            c.drawPath(path,p);


        }

        if(f==0)
        {
            red.setText("ROJO");
            red.setBackgroundColor(Color.RED);

            blue.setText("AZUL");
            blue.setBackgroundColor(Color.BLUE);

            green.setText("VERDE");
            green.setBackgroundColor(Color.GREEN);

        }
        else
        {
            int r = rd.nextInt(255);
            int g = rd.nextInt(255);
            int b = rd.nextInt(255);

            red.setText("CUADRADO");
            red.setBackgroundColor(Color.rgb(r,g,b));

             r = rd.nextInt(255);
             g = rd.nextInt(255);
             b = rd.nextInt(255);
            blue.setText("CIRCULO");
            blue.setBackgroundColor(Color.rgb(r,g,b));

            r = rd.nextInt(255);
            g = rd.nextInt(255);
            b = rd.nextInt(255);
            green.setText("TRIANGULO");
            green.setBackgroundColor(Color.rgb(r,g,b));

        }

        //*/
    }


    public void rojo(View view){


        String but = this.red.getText().toString();

        int s = Integer.parseInt(this.Score.getText().toString());

        if(but.equals("ROJO")) {
            if (p.getColor() == (Color.RED))
                this.Score.setText("" + (s += 10));
            else
                this.Score.setText("" + (s -= 10));
        }
        else if(but.equals("CUADRADO") && (d==3 || d== 4 || d==5) )
            this.Score.setText(""+(s+=10));
        else
            this.Score.setText(""+(s-=10));



        if(s>=100)
        {
            disable();
            veredicto.setTextColor(Color.GREEN);
            this.veredicto.setText("Ganaste!");

        }
        else if(s<=-50)
         {
         veredicto.setTextColor(Color.RED);
         disable();
         this.veredicto.setText("Perdiste!");
        }

        rd();

    }

    public void verde(View view){

        String but = this.green.getText().toString();

        int s = Integer.parseInt(this.Score.getText().toString());

        if(but.equals("VERDE")) {
            if (p.getColor() == (Color.GREEN))
                this.Score.setText("" + (s += 10));
            else
                this.Score.setText("" + (s -= 10));
        }
        else if(but.equals("TRIANGULO") && (d==6 || d== 7 || d==8) )
            this.Score.setText(""+(s+=10));
        else
            this.Score.setText(""+(s-=10));


        if(s>=100)
        {
            veredicto.setTextColor(Color.GREEN);
            disable();
            this.veredicto.setText("Ganaste!");
        }
        else if(s<=-50)
        {
            veredicto.setTextColor(Color.RED);
            disable();
            this.veredicto.setText("Perdiste!");
        }

        rd();

    }

    public void azul(View view){
        String but = this.blue.getText().toString();

        int s = Integer.parseInt(this.Score.getText().toString());
        if(but.equals("AZUL")) {
            if (p.getColor() == (Color.BLUE))
                this.Score.setText("" + (s += 10));
            else
                this.Score.setText("" + (s -= 10));
        }
        else if(but.equals("CIRCULO") && (d==0 || d== 1 || d==2) )
            this.Score.setText(""+(s+=10));
        else
            this.Score.setText(""+(s-=10));

        if(s>=100)
        {
            veredicto.setTextColor(Color.GREEN);
            disable();
            this.veredicto.setText("Ganaste!");
        }
        else if(s<=-50)
        {
            veredicto.setTextColor(Color.RED);
            disable();
            this.veredicto.setText("Perdiste!");
        }


        rd();

    }



    private void disable(){

        this.red.setEnabled(false);
        this.green.setEnabled(false);
        this.blue.setEnabled(false);

    }


}
