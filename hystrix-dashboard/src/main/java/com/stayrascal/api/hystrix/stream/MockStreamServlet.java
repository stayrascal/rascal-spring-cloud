package com.stayrascal.api.hystrix.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.Charset;

public class MockStreamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(MockStreamServlet.class);

    public MockStreamServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("file");
        if (filename == null) {
            filename = "hystrix.stream";
        } else {
            filename = filename.replaceAll("\\.\\.", "");
            filename = filename.replaceAll("/", "");
        }
        int delay = 500;
        String delayArg = req.getParameter("delay");
        if (delayArg != null) {
            delay = Integer.parseInt(delayArg);
        }

        int batch = 1;
        String batchArg = req.getParameter("batch");
        if (batchArg != null) {
            batch = Integer.parseInt(batchArg);
        }

        String data = getFileFromPackage(filename);
        String lines[] = data.split("\n");

        resp.setContentType("text/event-stream");
        resp.setCharacterEncoding("UTF-8");

        int batchCount = 0;
        for (; ; ) {
            for (String line : lines) {
                line = line.trim();
                if (line.length() > 0) {
                    try {
                        resp.getWriter().print(line);
                        resp.getWriter().print("");
                        resp.getWriter().flush();
                        batchCount++;
                    } catch (Exception e) {
                        logger.warn("Exception writting mock data to output.", e);
                        return;
                    }
                    if (batchCount == batch) {
                        try {
                            Thread.sleep(delay);
                        } catch (InterruptedException e) {
                            // ignore
                        }
                        //reset
                        batchCount = 0;
                    }
                }
            }
        }

    }

    private String getFileFromPackage(String filename) {
        try {
            String file = "/" + this.getClass().getPackage().getName().replace('.', '/') + "/" + filename;
            InputStream is = this.getClass().getResourceAsStream(file);
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                StringWriter stringWriter = new StringWriter();
                int c = -1;
                while ((c = in.read()) > -1) {
                    stringWriter.write(c);
                }
                return stringWriter.toString();
            } finally {
                is.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not find file: " + filename, e);
        }
    }
}
