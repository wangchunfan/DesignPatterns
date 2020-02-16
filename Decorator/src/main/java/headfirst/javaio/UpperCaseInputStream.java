package headfirst.javaio;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpperCaseInputStream extends FilterInputStream {

    public UpperCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = in.read();
        return c == -1 ? c : Character.toUpperCase((char) c);
    }
}
