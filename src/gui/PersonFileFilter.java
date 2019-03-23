package gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PersonFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        String name=file.getName();
        String extension=name.substring(name.lastIndexOf(".")+1,name.length());
        if(file.isDirectory())
            return true;
        if(extension==null)
            return false;
        else
        {
            if(extension.equals("per"))
                return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
       return "Person data Files(*.per)";
    }
}
