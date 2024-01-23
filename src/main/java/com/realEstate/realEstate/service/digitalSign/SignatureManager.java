package com.realEstate.realEstate.service.digitalSign;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class SignatureManager {
    private static final String SIG_STAMP = "_SIGNATURED";
    private static final String EXTENTION = ".txt";
    private MyKeyPair myKeyPair;
    private DigitalSign digitSign;

    public SignatureManager() {
        myKeyPair = new MyKeyPair();
        digitSign = new DigitalSign();
    }

    public boolean generateAndSaveKeyPair(String path, String privateKeyName, String publicKeyName) {
        boolean result = false;
        if(myKeyPair.generateKeyPair()) {
            try {
                myKeyPair.saveKeyPair(path, privateKeyName, publicKeyName);
                result = true;
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                System.err.println("폴더 경로를 찾을 수 없음");
                result = false;
            }

        }

        return result;
    }

    public void signAndSaveFile(String dataFilename, String keyFilename, String fileSavePath, String signedFileName)
            throws InvalidKeyException, FileNotFoundException, ClassCastException {
        PrivateKey privateKey = myKeyPair.restorePrivateKey(keyFilename);

        byte [] signature = digitSign.sign(dataFilename, privateKey);

        if(signedFileName.equals("")) {

            File file = new File(dataFilename);
            System.out.println(file.getName());
            String [] splited = file.getName().split("\\.");
            System.out.println(splited[0]);
            signedFileName = splited[0] + SIG_STAMP;
        }
        fileSavePath = fileSavePath + "/" + signedFileName + EXTENTION;

//		생성한 전자서명 쓰기
        digitSign.writeFile(fileSavePath, signature);
    }

    public boolean verify(String dataFilename, String sigFilename, String keyFilename)
            throws InvalidKeyException, FileNotFoundException, ClassCastException {

        PublicKey publicKey = myKeyPair.restorePublicKey(keyFilename);

        return digitSign.verify(dataFilename, publicKey, sigFilename);
    }

}