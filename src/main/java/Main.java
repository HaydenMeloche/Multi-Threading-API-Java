import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        /*
         * This example project does threading with API calls to improve performance. (Rather than running them synchronously)
         * It artificially sleeps the 2nd API by 3 seconds to show how this example waits until all threads are complete to continue working
         *
         * There are many ways to handle threading this is one way of doing so
         */

        threadedAPI call1 = new threadedAPI(false);
        threadedAPI call2 = new threadedAPI(true);
        threadedAPI call3 = new threadedAPI(false);

        ExecutorService es = Executors.newCachedThreadPool();

        System.out.println("Threads starting");

        //add each runnable class to the executor
        es.execute(call1);
        es.execute(call2);
        es.execute(call3);

        es.shutdown(); //stops executor for accepting anymore

        try {

            //this one line puts a stop in and waits for all threads in the executor service to finish
            //Uncommenting this line will cause the app to crash because the code will try and access values before the API finishes returning them
            boolean finished = es.awaitTermination(30, TimeUnit.SECONDS);

            System.out.println("Threads finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //just showing that data is accessible
        long time1 = call1.getResponse().getCurrentFileTime();
        long time2 = call2.getResponse().getCurrentFileTime();
        long time3 = call2.getResponse().getCurrentFileTime();
        System.out.println("Call 1 data: " + time1);
        System.out.println("Call 2 data: " + time2);
        System.out.println("Call 3 data: " + time3);


    }




}

