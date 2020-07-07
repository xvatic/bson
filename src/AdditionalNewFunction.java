import sample.AdditionalExternalProcessing;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class AdditionalNewFunction implements AdditionalExternalProcessing {


    @Override
       public double del_processing(String path) {
        File file = new File(path);
        double bytes = file.length();
        double kilobytes = (bytes/1024);
        return kilobytes;
    }

    @Override
    public byte[] get_processing(String text) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        String strKey = "bestkey";
        SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
        Cipher cipher=Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, skeyspec);


        byte[] plaintext = text.getBytes();
        byte[] ciphertext = cipher.doFinal(plaintext);
        return ciphertext;
    }
}
