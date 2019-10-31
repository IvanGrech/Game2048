package Game2048;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainForm extends JFrame implements KeyListener
{
   static int Width=400;
   static int Length=400;
   private JPanel mapView;
   public Map2048 map;
   JTextField keyText;


    MainForm()
    {
        keyText = new JTextField(1);
        keyText.addKeyListener(this);
        map = new Map2048();
        setSize(Width,Length);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        map.SpawnBlock();
     //   map.map[0][0]=2; map.map[0][1]=2;map.map[0][2]=2;
      //  map.map[1][1]=2;map.map[1][3]=2;
        mapView = new MapView(map, Width,Length);
        BorderLayout layout = new BorderLayout();

        setLayout(layout);
        add(mapView);
        keyText.setSize(1,1);
        keyText.grabFocus();
        add(keyText, BorderLayout.SOUTH);
        setVisible(true);
    }


    public static void main(String[] args)
    {
        MainForm mainForm = new MainForm();
    }
    public void keyTyped(KeyEvent e)
    {

    }
    public void keyPressed(KeyEvent e)
    {
        int keyCode= e.getKeyCode();

        switch(keyCode)
        {
            case 38: //UP
                if(!map.Move(Map2048.Direction.UP))return;
                break;

            case 39://RIGHT
                if(!map.Move(Map2048.Direction.RIGHT))return;
                break;
            case 40://DOWN
                if(!map.Move(Map2048.Direction.DOWN))return;
                break;
            case 37://LEFT
                if(!map.Move(Map2048.Direction.LEFT))return;
                break;
        }
        map.SpawnBlock();
        mapView.repaint();
        add(mapView);
    }
    public void keyReleased(KeyEvent e)
    {

    }

}
