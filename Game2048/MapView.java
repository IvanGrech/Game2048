package Game2048;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MapView extends JPanel
{
    int Width;
    int Length;
    Map2048 map;

    MapView(Map2048 newMap, int newWidth, int newLength)
    {
        map=newMap;
        this.Width= newWidth;
        this.Length = newLength;
    }


   public void paintComponent(Graphics g)//Draws a Map of Blocks
    {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        for(int i=0, wDistance=0,lDistance=0;i<map.width;i++, lDistance+=this.Length/6) {

            for (int j = 0 ; j < map.width; j++,wDistance+=this.Width/6 ) {
                switch(map.map[i][j])
                {
                    case 0: g.setColor(Color.LIGHT_GRAY);break;
                    case 2: g.setColor(Color.YELLOW);break;
                    case 4: g.setColor(Color.ORANGE);break;
                    case 8: g.setColor(Color.RED);break;
                    case 16: g.setColor(Color.CYAN); break;
                    case 32: g.setColor(Color.BLUE); break;
                    case 64: g.setColor(Color.PINK); break;
                    case 128: g.setColor(Color.MAGENTA);break;

                }
                //g.setColor(Color.ORANGE);
                g.fillRect(this.Width / 8 + wDistance, this.Length / 8 + lDistance, this.Width / 8, this.Length / 8);
                g.setColor(Color.BLACK);
                g.drawString( Integer.toString(map.map[i][j]),this.Width / 8 + wDistance +this.Width / 16   -Integer.toString(map.map[i][j]).length()*4 , this.Length / 8 + lDistance + this.Length / 16 );
            }
            wDistance =0;
        }
    }

}
