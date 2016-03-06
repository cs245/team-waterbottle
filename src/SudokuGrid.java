
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Timothy
 */
public class SudokuGrid extends JPanel
{
    private Scanner sc;
    private String path;
    private int w = 9, h = 9;
    private boolean found;
    private SudokuFields[][] fields;
    GridBagConstraints c;
    
    SudokuGrid() 
    {
        super(new GridBagLayout());
        path = "grid.txt";
       
        try {
            sc = new Scanner(new File(path));
            found = true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            found = false;
        }
        buildBoard();
        
        setBorder(BorderFactory.createLineBorder(Color.black)); 
        sc.close();
    }
    
    public SudokuFields[][] getFields()
    {
        return fields;
    }
    public int getW()
    {
        return w;
    }
    public int getH()
    {
        return h;
    }
    public void buildBoard()
    {
        if(found)
        {
            w = sc.nextInt();
            h = sc.nextInt();
        }
        fields = new SudokuFields[w][h];
        c = new GridBagConstraints();
        
        for (int j=0; j<w; j++) {
            for (int i=0; i<h; i++) 
            {
                c.weightx = 1.0;
                c.weighty = 1.0;
                c.fill = GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = j;
                if(found)
                    fields[i][j] = new SudokuFields(i, j, sc.nextInt());
                else
                    fields[i][j] = new SudokuFields(i, j, 0);
                add(fields[i][j], c);
            }
        }
    }
    
}
