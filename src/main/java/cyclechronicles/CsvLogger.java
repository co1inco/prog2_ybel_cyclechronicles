package cyclechronicles;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class CsvLogger extends Handler {

    private PrintWriter _writer;

    public CsvLogger(String fileName) throws FileNotFoundException {
        _writer = new PrintWriter(fileName);
        _writer.println("level;method;class;message");
    }

    public CsvLogger() throws FileNotFoundException  {
        this("log.csv");
    }

    @Override
    public void publish(LogRecord record) {
        _writer.println(record.getLevel() + ";"
            + record.getSourceMethodName() + ";"
            + record.getSourceClassName() + ";"
            + record.getMessage());
    }

    @Override
    public void flush() {
        _writer.flush();
    }

    @Override
    public void close() throws SecurityException {
        _writer.close();
    }
}
