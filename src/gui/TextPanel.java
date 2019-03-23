package gui;

import javax.swing.*;
import java.awt.*;

//panel is grey flat areas
public class TextPanel extends JPanel {
    private JTextArea jTextArea;

  public TextPanel()
  {
   jTextArea=new JTextArea();
   setLayout(new BorderLayout());
   add(new JScrollPane(jTextArea),BorderLayout.CENTER);
  }
  public void appendText(String text)
  {
      jTextArea.append(text);
  }
}
