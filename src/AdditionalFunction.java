import sample.AdditionalProcessing;
import sample.Game;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class AdditionalFunction implements AdditionalProcessing {

    @Override
    public void del_proc() {
        String filename = "/Users/zhenya_rs6/Desktop/bson/games";
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("/Users/zhenya_rs6/Desktop/Additional/arch.zip"));
            FileInputStream fis = new FileInputStream(filename);)
        {
            ZipEntry entry1 = new ZipEntry("games");
            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public boolean get_proc(List<Game> list) {
        boolean state = false;
        XMLEncoder encoder = null;
        final String PATH = "games.xml";
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(PATH)));
        } catch (FileNotFoundException fnf){
            System.out.println("FIle not found");
            state = false;
            return(state);
        }
        assert encoder != null;
        encoder.writeObject(list);
        encoder.close();
        state = true;
        return(state);
    }
}
