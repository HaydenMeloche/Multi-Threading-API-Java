import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class threadedAPI implements Runnable {
    private TimeResponse response = null;
    private boolean delay = false;

    /**
     * Constructor to tell the class if it should artificially delay itself after the API call is made
     * (For demo purposes)
     * @param delay
     */
    public threadedAPI(boolean delay) {
        this.delay = delay;
    }

    /**
     * Runs must be implemented in runnables
     * Makes API call and sets property with the result
     */
    @Override
    public void run() {
        HttpURLConnection con = null;
        String url = "http://worldclockapi.com/api/json/est/now";
        TimeResponse response = null;
        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

            response =  new ObjectMapper().readValue(content.toString(), TimeResponse.class); //convert json string to object

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (null != con) con.disconnect();

            this.response = response;

            //Setting an artificial delay to test if code is waiting for all threads to finish
            if (delay) {
                try {
                    Thread.sleep(3000); //3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public TimeResponse getResponse() {
        return response;
    }
}
