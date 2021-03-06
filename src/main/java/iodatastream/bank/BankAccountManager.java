package iodatastream.bank;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount account, Path folder) {
        Path path = folder.resolve(account.getAccountNumber() + ".dat");
        try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            os.writeUTF(account.getAccountNumber());
            os.writeUTF(account.getOwner());
            os.writeDouble(account.getBalance());
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file!", e);
        }
    }

    public BankAccount loadAccount(InputStream is) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(is))) {
            return new BankAccount(dis.readUTF(), dis.readUTF(), dis.readDouble());
        } catch (IOException e) {
            throw new IllegalStateException("Cant read data", e);
        }
    }
}
