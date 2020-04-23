package org.example;

import com.amazonaws.encryptionsdk.AwsCrypto;
import com.amazonaws.encryptionsdk.kms.KmsMasterKeyProvider;

public class AwsEncryptionHandler {

    private static String keyArn = "arn:aws:kms:us-east-2:593048859716:key/acf68106-8b24-4a5e-a932-d65d56fe636e";
    private static String data = "hello world";

    final AwsCrypto crypto = new AwsCrypto();
    KmsMasterKeyProvider prov;


    public AwsEncryptionHandler(String keyARN) {
        prov = new KmsMasterKeyProvider(keyARN);
    }

    public String encryptData(String plainText) {
        return crypto.encryptString(prov, plainText).getResult();
    }

    public String decryptData(String chiperText) {
        return crypto.decryptString(prov, chiperText).getResult();
    }

    public static void main(String args[]) {

            AwsEncryptionHandler awsEncryptionHandler = new AwsEncryptionHandler(keyArn);

        String chiperText = awsEncryptionHandler.encryptData(data);
        System.out.println("Encrypted Data: " + chiperText);
                System.out.println("decrypted Data: " + awsEncryptionHandler.decryptData(" AYADeDJ9eOP80jTWlgYqqpyv+boAXwABABVhd3MtY3J5cHRvLXB1YmxpYy1rZXkAREF6K1V6UGhiUHlQazB4UFNGZFpYQlBVNUQrVG5ndkNNZ3UwbFVhd0w0L3JzVGt0aWFleGxSd2lPVlNXcFRQSWR5UT09AAEAB2F3cy1rbXMAS2Fybjphd3M6a21zOnVzLWVhc3QtMjo1OTMwNDg4NTk3MTY6a2V5L2FjZjY4MTA2LThiMjQtNGE1ZS1hOTMyLWQ2NWQ1NmZlNjM2ZQC4AQIBAHikJOEA29iMC0K0AmX8HS9jWW/0sUWqMud0aRbQLaGVrAHGbnqtYPlZm29ByIrhNB2PAAAAfjB8BgkqhkiG9w0BBwagbzBtAgEAMGgGCSqGSIb3DQEHATAeBglghkgBZQMEAS4wEQQMS6fzPnNkQquVMLweAgEQgDs9Y/E+q27vPTAuAyrl8vSLD+ZfKBRGthAoscSR9rKGYcCMV7Zor0xDG6U1WONEforeohGTAEnreFpR4AIAAAAADAAAEAAAAAAAAAAAAAAAAADwrsFE4o0QXzvJHahiwIac/////wAAAAEAAAAAAAAAAAAAAAEAAAALaochYE2l/6D+nj5/pP2Fmmcvo2kseMyQUBT7AGcwZQIxAIbCfSMVzskiYv/s9F/jojHtci3u0zVMKs4TxWqmToL/6Jwno3tnuVpH5+cvz6PgZwIwUGr1RRNS8oalpej9A2xDLMZ+VvtDf4R7k7HK7t7dZdrso9DKGoN5Foos2flhD9CX"));


    }

}