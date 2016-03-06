
import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Timothy
 */
public class SudokuFields extends JTextField
{
    int digit; //the number it would display
    int posX, posY; //the x,y position on the grid

    public SudokuFields(int x, int y, int d) 
    {
        super();
           
        posX = x;
        posY = y;
        digit = d;
        this.setFont(new java.awt.Font("Tempus Sans ITC", 0, 15)); 
        
        if(digit > 0 && digit < 10)
        {
            this.setText(String.valueOf(digit));
            this.setEditable(false);
        }
            
        this.setHorizontalAlignment(JTextField.CENTER);
        Document doc = this.getDocument();
        ((AbstractDocument)doc).setDocumentFilter(new LimitDocumentFilter(1));
        doc.addDocumentListener(new DocumentListener() 
        {
            public void changedUpdate(DocumentEvent e)
            {
                try {
                    digit = Integer.parseInt(doc.getText(0, doc.getLength()));
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
            public void removeUpdate(DocumentEvent e) 
            {
                digit = 0;
            }
            public void insertUpdate(DocumentEvent e) 
            {
                try {
                    digit = Integer.parseInt(doc.getText(0, doc.getLength()));
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }

          });
        

        /** create a black border */
        setBorder(BorderFactory.createLineBorder(Color.black));

        setPreferredSize(new Dimension(20,20));
    }
    

    public int getDigit() { return digit; }

    public void setDigit(int num) { digit = num; }

    public class LimitDocumentFilter extends DocumentFilter 
    {

        private int limit;

        public LimitDocumentFilter(int limit) 
        {
            if (limit <= 0) 
                throw new IllegalArgumentException("Limit can not be <= 0");
            this.limit = limit;
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs) throws BadLocationException 
        {
            String text = fb.getDocument().getText(0,fb.getDocument().getLength());
            text += str;
            int currentLength = fb.getDocument().getLength();
            
            int overLimit = (currentLength + text.length()) - limit - length;
            if (overLimit > 0 && text.matches("\\d")) 
                str = str.substring(0, str.length() - overLimit);
            
            if (str.length() > 0 && text.matches("\\d")) 
                super.replace(fb, offset, length, str, attrs); 
        }

    }
}
