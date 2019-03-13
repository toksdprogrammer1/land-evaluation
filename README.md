## Encryption

Extract public key certificate from .p12:
 
    openssl pkcs12 -in P12_FILE -nokeys -out OUTPUT_FILE
 
Extract private key in PEM format from .p12:
 
    openssl pkcs12 -in P12_FILE -nodes -nocerts -out OUTPUT_FILE
 
Convert PEM format private key to PKCS8 format:
 
    openssl pkcs8 -topk8 -inform PEM -outform DER -in PEM_FILE  -nocrypt > OUTPUT_FILE
 
Use the PKCS8 format private key in the constructor.
    
    Resource resource = new ClassPathResource("partner-privatekey-pkcs8.key");
    cryptographyInterceptor = new MpqrMesCryptographyOwn(null, resource.getInputStream());
    ApiConfig.addCryptographyInterceptor(cryptographyInterceptor);
