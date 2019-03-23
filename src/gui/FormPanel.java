package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class FormPanel extends JPanel
{
    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton submit;
    private FormListener formListener;
    private JList ageList;
    private JComboBox empCombo;
    private JCheckBox citizen;
    private JTextField taxfield;
    private JLabel taxLabel;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;
    public FormPanel()
    {
        nameLabel=new JLabel("Name:");
        occupationLabel=new JLabel("Occupation:");
        nameField=new JTextField(10);//10 CHARACTERS WIDE
        occupationField=new JTextField(10);
        submit=new JButton("Submit");
        //set mnemonics
        submit.setMnemonic(KeyEvent.VK_S);
        nameLabel.setDisplayedMnemonic(KeyEvent.VK_N); //focus on textfield name
        nameLabel.setLabelFor(nameField);
        ageList=new JList();
        empCombo=new JComboBox();
       citizen=new JCheckBox();
       taxfield=new JTextField(10);
       taxLabel=new JLabel("Your Tax ID");
      maleRadio=new JRadioButton("male");
      femaleRadio=new JRadioButton("female");
      genderGroup=new ButtonGroup();
   maleRadio.setSelected(true);
   maleRadio.setActionCommand("male");
   femaleRadio.setActionCommand("female");
      //set up gender radios
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

       //set up tax id
        taxLabel.setEnabled(false);
        taxfield.setEnabled(false);
       citizen.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               boolean isTicked=citizen.isSelected();
                   taxLabel.setEnabled(isTicked);
                   taxfield.setEnabled(isTicked);
           }
       });


        //set up list box
        DefaultListModel ageModel=new DefaultListModel();
        ageModel.addElement(new AgeCategory(0,"Under 18"));
        ageModel.addElement(new AgeCategory(1,"18-65"));
        ageModel.addElement(new AgeCategory(2,"Over 65"));
        ageList.setModel(ageModel);
        ageList.setPreferredSize(new Dimension(110,66));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);

        //set up combo box
        DefaultComboBoxModel empModel=new DefaultComboBoxModel();
        empModel.addElement("employed");
        empModel.addElement("self-employed");
        empModel.addElement("unemployed");
        empCombo.setModel(empModel);
        empCombo.setSelectedIndex(0);
        empCombo.setEditable(true);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameField.getText();
                String occupation=occupationField.getText();
                AgeCategory agelimit=(AgeCategory)ageList.getSelectedValue();
                String empCat=(String)empCombo.getSelectedItem();
                boolean indiancitizen=citizen.isSelected();
                String taxId=taxfield.getText();
                System.out.println(agelimit.getId());
                System.out.println(empCat);
                String genderCommand=genderGroup.getSelection().getActionCommand();
                FormEvent formEvent=new FormEvent(this,name,occupation,agelimit.getId(),empCat,taxId,indiancitizen,genderCommand);
                if(formListener!=null)
                {
                    formListener.formEventOccured(formEvent);
                }
            }
        });
        Dimension dim=getPreferredSize();
        //Border Layout accepts width,not height
        System.out.println(dim);
        dim.width=400;
        setPreferredSize(dim);
        Border innerborder=BorderFactory.createTitledBorder("Add person");
        Border outerborder=BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerborder,innerborder));
        layoutComponents();
    }
    public void layoutComponents()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.gridy=0;
        //First row

        gbc.weightx=1;//space with respect to other weights
        gbc.weighty=0.1;
        gbc.gridx=0;
        gbc.fill=GridBagConstraints.NONE;//horizontal or veertical- to take space in cell
        gbc.anchor=GridBagConstraints.LAST_LINE_END;
        gbc.insets=new Insets(0,0,0,5);
        add(nameLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        gbc.insets=new Insets(0,0,0,0);
        gbc.anchor=GridBagConstraints.LAST_LINE_START;
        add(nameField,gbc);

        //second row
        gbc.gridy++;
        gbc.weightx=1;//space with respect to other weights
        gbc.weighty=0.1;
        gbc.gridx=0;
        gbc.anchor=GridBagConstraints.LAST_LINE_END;
        gbc.insets=new Insets(0,0,0,5);
        add(occupationLabel,gbc);

        gbc.gridy=1;
        gbc.gridx=1;
        gbc.insets=new Insets(0,0,0,0);
        gbc.anchor=GridBagConstraints.LAST_LINE_START;
        add(occupationField,gbc);
        gbc.gridy++;
        //Third row
        gbc.weightx=1;//space with respect to other weights
        gbc.weighty=0.2;



        gbc.gridx=0;
        gbc.anchor=GridBagConstraints.FIRST_LINE_END;
        gbc.insets=new Insets(0,0,0,5);
        add(new JLabel("Age:"),gbc);

        gbc.gridx=1;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
    //    gbc.insets=new Insets(0,0,0,0);
        add(ageList,gbc);

         //fourth row
        gbc.gridy++;
        gbc.weightx=1;//space with respect to other weights
        gbc.weighty=0.5;

        gbc.gridx=0;
        gbc.insets=new Insets(0,0,0,5);
        gbc.anchor=GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Employee Category:"),gbc);

        gbc.gridx=1;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
        gbc.insets=new Insets(0,0,0,0);
        add(empCombo,gbc);


      //fifth row

        gbc.gridy++;
        gbc.weightx=1;//space with respect to other weights
        gbc.weighty=0.2;

        gbc.gridx=0;
        gbc.insets=new Insets(0,0,0,5);
        gbc.anchor=GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Indian Citizen:"),gbc);

        gbc.gridx=1;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
        gbc.insets=new Insets(0,0,0,0);
        add(citizen,gbc);

        //sixth row
        gbc.gridy++;
        gbc.weightx=1;//space with respect to other weights
        gbc.weighty=0.2;

        gbc.gridx=0;
        gbc.insets=new Insets(0,0,0,5);
        gbc.anchor=GridBagConstraints.FIRST_LINE_END;
        add(taxLabel,gbc);

        gbc.gridx=1;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
        gbc.insets=new Insets(0,0,0,0);
        add(taxfield,gbc);

        //seventh row
        gbc.gridy++;
        gbc.weightx=1;//space with respect to other weights
        gbc.weighty=0.2;

        gbc.gridx=0;
        gbc.insets=new Insets(0,0,0,5);
        gbc.anchor=GridBagConstraints.LINE_END;
        add(new JLabel("Gender:"),gbc);

        gbc.gridx=1;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
        gbc.insets=new Insets(0,0,0,0);
        add(maleRadio,gbc);

        //eigth row

        gbc.gridy++;
        gbc.weightx=1;//space with respect to other weights
        gbc.weighty=0.2;

        gbc.gridx=1;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
        gbc.insets=new Insets(0,0,0,0);
        add(femaleRadio,gbc);

        //ninth row
        gbc.weightx=1;//space with respect to other weights
        gbc.weighty=2.0;
        gbc.gridx=1;
        gbc.gridy++;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(submit,gbc);
    }
    public void setFormListener(FormListener listener)
    {
        this.formListener=listener;
    }
}
class AgeCategory
{
    private int id;
    private String text;
    public AgeCategory(int id,String text)
    {
        this.id=id;
        this.text=text;
    }
    public String toString()
    {
        return text;
    }
    public int getId()
    {
        return id;
    }
}
