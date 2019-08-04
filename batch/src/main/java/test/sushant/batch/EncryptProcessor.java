package test.sushant.batch;

import org.springframework.batch.item.ItemProcessor;
import test.sushant.util.CaesarCipher;

public class EncryptProcessor implements ItemProcessor<String, String> {

    private Integer key;

    private CaesarCipher cipher;

    public EncryptProcessor(Integer key) {
        this.cipher = new CaesarCipher(key);
    }

    @Override
    public String process(final String s) throws Exception {
        return cipher.encrypt(s);
    }
}
