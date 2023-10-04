package net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HTTPEx {
    public static void main(String[] args) throws IOException {
        URLConnection url = new URL("https://www.google.com").openConnection();
        Scanner scanner = new Scanner(url.getInputStream());
        scanner.useDelimiter("\\Z");
        System.out.println(scanner.nextLine());

        System.out.println();

        Map<String, List<String>> headerFields = url.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }


    }
}
