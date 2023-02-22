package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import processing.data.*;

public class StarMap extends PApplet {

    ArrayList<Star> stars = new ArrayList<Star>();
    
    public float border;

    void drawGrid()
    {
        stroke(255, 0, 255);
        textAlign(CENTER, CENTER);
        textSize(20);
        for(int i = -5; i <=5; i ++)
        {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }

    void printStars()
    {
        for(Star s:stars)
        {
            System.out.println(s);
        }
    }

    void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
        for(TableRow r:table.rows())
        {
            Star s = new Star(r);
            stars.add(s);
        }
    }

    public void settings() {
        size(800, 800);
    }

    Star first = null;
    Star second = null;



    public void mouseClicked()
    {
        for(Star s:stars)
        {
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

<<<<<<< HEAD
<<<<<<< HEAD
	public void DrawGrid()
	{
		stroke(0, 255, 255);
		float border = width * 0.1f;
		
		int count = 10;
		float gap = (width - (border * 2.0f)) / (float) count;
		for (int i = -5; i <=5; i++)
		{
			float x = border + (gap * (i + 5));
			line(x, border, x, height-border);
			line(border, x, width-border, x);

			textAlign(CENTER, CENTER);
			text(i, x + (gap * 0.5f), gap * 0.5f);

		}
=======
	float map1(float a, float b, float c, float d, float e)
	{
		float r1 = c -b;
		float r2 = e - d;
=======
            if (dist(mouseX, mouseY, x, y) < 20)
            {
                if (first == null)
                {
                    first = s;
                    break;
                }
                else if (second == null)
                {
                    second = s;
                    break;
                } 
                else
                {
                    first = s;
                    second = null;
                    break;
                }
            }
        }
    }
>>>>>>> ea17a3ea1a4624740569d0949200140e12e2341f

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();

<<<<<<< HEAD
		return d + ((howFar / r1) * r2);
>>>>>>> 043d21d1b70f553886277dd4997a9e0376844936
	}
		
	public void draw()
	{	
<<<<<<< HEAD
		strokeWeight(2);
		DrawGrid();
		

=======
		strokeWeight(1);		

		drawGrid();
		displayStars();
>>>>>>> 043d21d1b70f553886277dd4997a9e0376844936
	}

	
}
=======
        border = width * 0.1f;
    }

    public void drawStars()
    {
        for(Star s:stars)
        {
            s.render(this);
        }
    }

    public void draw() 
    {
        background(0);
        drawGrid();
        drawStars();

        if (first != null)
        {

            float x = map(first.getxG(), -5, 5, border, width - border);
            float y = map(first.getyG(), -5, 5, border, height - border);

            if (second != null)
            {
                float x2 = map(second.getxG(), -5, 5, border, width - border);
                float y2 = map(second.getyG(), -5, 5, border, height - border);

                stroke(255, 255, 0);
                line(x, y, x2, y2);

                float dist = dist(first.getxG(), first.getyG(), first.getzG(), second.getxG(), second.getyG(), second.getzG());

                fill(255);
                textAlign(CENTER, CENTER);
                text("Distance between: " + first.getDisplayName() + " and " + second.getDisplayName() + " is " + dist + " parsecs", width / 2, height - (border * 0.5f));
            }
            else
            {
                stroke(255, 255, 0);
                line(x, y, mouseX, mouseY);
            }
        }
    }
}
>>>>>>> ea17a3ea1a4624740569d0949200140e12e2341f
