package dk.aau.dat.a311b.datchain;

import java.io.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

import static dk.aau.dat.a311b.datchain.RSAgen.Constants.ALGORITHM;
import static dk.aau.dat.a311b.datchain.RSAgen.Constants.PRIVATE_KEY_FILE;
import static dk.aau.dat.a311b.datchain.RSAgen.Constants.PUBLIC_KEY_FILE;

public class RSAgen {
    public class Constants {
        public static final String ALGORITHM = "RSA";
        public static final String PRIVATE_KEY_FILE = "C:/datchain/keys/private.key";
        public static final String PUBLIC_KEY_FILE = "C:/datchain/keys/public.key";

    }

    private static void Keygen() {
        try {
            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
            keyGen.initialize(4096);
            final KeyPair key = keyGen.generateKeyPair();

            File privatekeyFile = new File(PRIVATE_KEY_FILE);
            File publickeyFile = new File(PUBLIC_KEY_FILE);

            if (privatekeyFile.getParentFile() != null) {
                privatekeyFile.getParentFile().mkdirs();
            }
            privatekeyFile.createNewFile();

            if (publickeyFile.getParentFile() != null) {
                publickeyFile.getParentFile().mkdirs();
            }
            publickeyFile.createNewFile();

            ObjectOutputStream privateKeyOS = new ObjectOutputStream(new FileOutputStream(privatekeyFile));
            privateKeyOS.writeObject(key.getPrivate());
            privateKeyOS.close();

            ObjectOutputStream publicKeyOS = new ObjectOutputStream(new FileOutputStream(publickeyFile));
            publicKeyOS.writeObject(key.getPublic());
            publicKeyOS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean keysPresent() {
        File privatekey = new File(PRIVATE_KEY_FILE);
        File publickey = new File(PUBLIC_KEY_FILE);

        if(privatekey.exists() && publickey.exists()) {
            return true;
        }
        return false;
    }

    public static byte[] encrypt(String text, PublicKey key) {
        byte[] cipherText = null;
        try {
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            cipherText = cipher.doFinal(text.getBytes("Unicode"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cipherText;
    }

    public static String decrypt(byte[] text, PrivateKey key) {
        byte[] decryptedtext = null;
        try {
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            decryptedtext = cipher.doFinal(text);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new String(decryptedtext);
    }
}
