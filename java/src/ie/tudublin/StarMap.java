package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{
	ArrayList<Star> stars = new ArrayList<Star>();

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		
		smooth();

		loadStars();
		printStars();
	}

	void printStars()
	{
		for(int i = 0 ; i < stars.size() ; i ++)
		{
			println(stars.get(i));
		}
	}

	void displayStars()
	{
		for(int i = 0 ; i < stars.size() ; i ++)
		{
			stars.get(i).render(this);
		}
	}

	public void loadStars()
	{
		Table table = loadTable("HabHYG15ly.csv", "header");
 		for(TableRow r:table.rows())
 		{
 			Star s = new Star(r);
 			stars.add(s);
 		}
	}

	public void drawGrid()
	{
		stroke(0, 255, 255);
		float border = width * 0.1f;

		for(int i = -5 ; i <= 5 ; i ++)
		{
			float x = map(i, -5, 5, border, width - border);
			line(x, border, x, height - border);
			line(border, x, width - border, x);

			textAlign(CENTER, CENTER);
			text(i, x, border * 0.5f);
			text(i, border * 0.5f, x);
		}

		//float f = map(5, 0, 10, 100, 200);
		//float f1 = map1(5, 0, 10, 100, 200);
		
	}

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

		float howFar = a - b;

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
