package Game2048;
import java.util.Random;
//this class allows to control the map of 2048 game
public class Map2048
{
    public int map[][];
    public byte width;
    enum Direction{UP,RIGHT,DOWN,LEFT};


    Map2048(byte width)
    {
      this.width=width;
        map = new int [width][width];
        for(int i=0;i<width;i++)
            for(int j=0;j<width;j++)
            {
                map[i][j]=0;
            }


    }

    Map2048()
    {
        width = 4;

        map = new int [width][width];
        for(int i=0;i<width;i++)
        {
            for(int j=0;j<width;j++)
            {
               map[i][j]=0;
            }
        }
    }
    //returns true if blocks can be moved to certain direction
    /**PROBABLY DONT NEED IT (cause the Move func does the same)*/
    boolean CanBeMoved(Direction direction)//0-up,1-right,2-down,3-left
    {

        switch(direction)
        {
            case UP:
            for(int i=1;i<width;i++)
                for(int j=0;j<width;j++)
                {
                 if(map[i][j]!=0 && (map[i-1][j]==0||map[i][j]==map[i-1][j]))return true;
                }
            break;

            case RIGHT:
                for(int i=0;i<width;i++)
                    for(int j=width-2;j>0;j--)
                    {
                        if(map[i][j]!=0 && (map[i][j+1]==0||map[i][j]==map[i][j+1]))return true;
                    }

                break;

            case DOWN:
                for(int i=width-2;i>0;i--)
                    for(int j=0;j<width;j++)
                    {
                        if(map[i][j]!=0 && (map[i+1][j]==0 || map[i][j]==map[i+1][j]))return true;
                    }

                break;

            case LEFT:
                for(int i=0;i<width;i++)
                    for(int j=1;j<width;j++)
                    {
                        if(map[i][j]!=0 && (map[i][j-1]==0|| map[i][j]==map[i][j-1]))return true;
                    }
                break;
        }
        return false;
    }

    //moves the blocks to certain direction
    //if(block which is under consideration not equal to 0 AND the last block in the row(column) in that direction equals to that block
    boolean Move(Direction direction)
    {
        boolean wasMoved =false;
        switch(direction)
        {

            case UP:
                for(int a=0;a<3;a++)
                for(int i=1;i<width;i++)
                    for(int j=0;j<width;j++)
                        if(map[i][j]!=0 && ( map[i-1][j]==0 || map[i][j]==map[i-1][j]))
                        {
                            map[i-1][j]+= map[i][j];
                            map[i][j]=0;
                            wasMoved=true;
                        }
                break;

            case RIGHT:
                for(int a=0;a<3;a++)
                for(int i=0;i<width;i++)
                    for(int j=width-2;j>=0;j--) {

                        if (map[i][j] != 0 && (map[i][j + 1] == 0 || map[i][j + 1] == map[i][j])) {
                            map[i][j + 1] += map[i][j];
                            map[i][j] = 0;
                            wasMoved=true;
                        }
                    }
                break;

            case DOWN:
                for(int a=0;a<3;a++)
                for(int i=width-2;i>=0;i--)
                    for(int j=0;j<width;j++)
                    {
                        if(map[i][j]!=0 && (map[i+1][j]==0 || map[i][j]==map[i+1][j]))
                        {
                            map[i+1][j]+=map[i][j];
                            map[i][j]=0;
                            wasMoved=true;
                        }
                    }
                break;
            case LEFT:
                for(int a=0;a<3;a++)
                for(int i=0;i<width;i++)
                    for(int j=1;j<width;j++)
                    {
                        if(map[i][j]!=0 && (map[i][j-1]==0|| map[i][j]==map[i][j-1]))
                        {
                            map[i][j-1]+=map[i][j];
                            map[i][j]=0;
                            wasMoved=true;
                        }
                    }
                break;
        }
        return wasMoved;
    }


    boolean SpawnBlock()
    {
        outer:
        for(int a=0;a<width;a++) {
            for (int b = 0; b < width; b++) {
                if (map[a][b]==0)break outer;
            }
            return false;
        }
        Random randi= new Random();
        int i; int j;
        do {
            i=randi.nextInt(width);
            j=randi.nextInt(width);
        }while(map[i][j]!=0);
         map[i][j]=2;
         return true;
    }
}
