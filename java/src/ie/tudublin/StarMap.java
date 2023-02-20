package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0);

		smooth();
		
	}

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
	}
		
	public void draw()
	{	
		strokeWeight(2);
		DrawGrid();
		

	}

	
}
