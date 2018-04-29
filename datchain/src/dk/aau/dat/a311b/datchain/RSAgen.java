package dk.aau.dat.a311b.datchain;

import me.xdrop.fuzzywuzzy.model.ExtractedResult;

import java.io.*;
import java.security.*;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

import static dk.aau.dat.a311b.datchain.RSAgen.Constants.*;

public class RSAgen {

    class Constants {
        static final String ALGORITHM = "RSA";
        static final int KEYBITLENGTH = 4096;
        static final String PRIVATE_KEY_FILE = "C:/datchain/keys/private.key";
        static final String PUBLIC_KEY_FILE = "C:/datchain/keys/public.key";
    }

    static void Keygen() {
        try {
            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
            keyGen.initialize(KEYBITLENGTH);
            final KeyPair key = keyGen.generateKeyPair();

            File privatekeyFile = new File(PRIVATE_KEY_FILE);
            File publickeyFile = new File(PUBLIC_KEY_FILE);

            if (privatekeyFile.getParentFile() != null) {
                privatekeyFile.getParentFile().mkdirs();
            }
            //how is this meant to work?
            privatekeyFile.createNewFile();

            if (publickeyFile.getParentFile() != null) {
                publickeyFile.getParentFile().mkdirs();
            }
            //how is this meant to work?
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
        //method is misnamed, creates keys and asks if they're present
        File privatekey = new File(PRIVATE_KEY_FILE);
        File publickey = new File(PUBLIC_KEY_FILE);
        return privatekey.exists() && publickey.exists();
    }

    public static byte[] encrypt(String cleartext, PublicKey key) {
        byte[] cipherText = null;
        try {
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            cipherText = cipher.doFinal(cleartext.getBytes("Unicode"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("ERROR: System does not have support for unicode encoding! " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ERROR: System does not have support for RSA-cryptography! " + e.getMessage());
        } catch (InvalidKeyException e) {
            System.out.println("ERROR: Invalid key supplied! " + e.getMessage());
        } catch (IllegalBlockSizeException e) {
            System.out.println("ERROR: Invalid block size of bytes received! " + e.getMessage());
        //catch remaining padding exceptions from Cipher.getInstance
        } catch (Exception e) {
            System.out.println("ERROR: Padding error in initializing instance! " + e.getMessage());
        }
        return cipherText;
    }

    public static String decrypt(byte[] text, PrivateKey key) {
        byte[] decryptedtext = null;
        try {
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            decryptedtext = cipher.doFinal(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //poor null-handling, avoid
        assert decryptedtext != null;

        return new String(decryptedtext);
    }
}
