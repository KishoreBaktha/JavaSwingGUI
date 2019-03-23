package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener
{
    private JButton addnewbutton;
    private JButton goodbyebutton;
    private StringListener textListener;
    public ToolBar()
    {
        setBorder(BorderFactory.createEtchedBorder());
      addnewbutton=new JButton("Hello");
      goodbyebutton=new JButton("bye");
      //adding left to right-flow layout
      setLayout(new FlowLayout(FlowLayout.LEFT));
      addnewbutton.addActionListener(this);
      goodbyebutton.addActionListener(this);
      add(addnewbutton);
      add(goodbyebutton);
    }
//set listener here
   public void setStringListener(StringListener stringListener)
   {
       this.textListener=stringListener;

   }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked=(JButton)e.getSource();//retreves source of event-who clicked
        if(clicked==addnewbutton)
        {
            if(textListener!=null)
                textListener.textEmitted("Hello\n");
            //textPanel.appendText("hello\n");
        }
       else
        {
            if(textListener!=null)
                textListener.textEmitted("GoodBye\n");
            //textPanel.appendText("goodbye\n");
        }
    }
}
