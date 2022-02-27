package sample;



import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class ExternalAdapter implements AdditionalProcessing {
    AdditionalExternalProcessing externalProcessing;
    public ExternalAdapter(AdditionalExternalProcessing externalProcessing){
        this.externalProcessing = externalProcessing;
    }
    @Override
    public void del_proc() {
        String path = "games.xml";
        double size = externalProcessing.del_processing(path);
        System.out.println(size);
    }

    @Override
    public boolean get_proc(List<Game> list) throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        int i =0;
        String delim = "|";
        StringBuilder sb = new StringBuilder();
        while (i< list.size() - 1){
            sb.append(list.get(i));
            sb.append(delim);
            i++;
        }
        sb.append(list.get(i));
        byte[] ciphertext=  externalProcessing.get_processing(sb.toString());
        try (FileWriter writer = new FileWriter("cipher.txt", false)){
            writer.write(String.valueOf(ciphertext));
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        if (ciphertext.length > 0){
            return true;
        }
        return false;
    }
}
