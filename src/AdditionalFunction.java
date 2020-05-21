import sample.AdditionalProcessing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class AdditionalFunction implements AdditionalProcessing {

    @Override
    public void del_proc(String param) {
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
}
