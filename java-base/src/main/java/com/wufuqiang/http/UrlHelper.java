package com.wufuqiang.http;

import javax.ws.rs.HttpMethod;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class UrlHelper {

	public static String postURL(String target, String jsonInputString) {

		try {
			// ref: https://www.baeldung.com/httpurlconnection-post
			URL url = new URL(target);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(5));
			conn.setReadTimeout((int) TimeUnit.SECONDS.toMillis(5));
			conn.setRequestMethod(HttpMethod.POST);
			conn.setRequestProperty("Content-Type", "application/json; utf-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);
			conn.connect();


			try(OutputStream os = conn.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}


			if (conn.getResponseCode() == 200) {
				BufferedReader reader =
						new BufferedReader(new InputStreamReader((InputStream) conn.getContent()));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				return sb.toString();
			} else {
				System.out.println("Error fetching url [" + target + "], respone code = " + conn.getResponseCode());
			}
		} catch (Exception e) {
			System.out.println("Error fetching url [" + target + "]"+e);
		}
		return null;
	}
	public static String getURL(String target)
	{
		try {
			URL url = new URL(target);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(5));
			conn.setReadTimeout((int) TimeUnit.SECONDS.toMillis(5));
			conn.setRequestMethod(HttpMethod.GET);
			conn.connect();
			if (conn.getResponseCode() == 200) {
				BufferedReader reader =
						new BufferedReader(new InputStreamReader((InputStream) conn.getContent()));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				return sb.toString();
			} else {
				System.out.println("Error fetching url [" + target + "], respone code = " + conn.getResponseCode());
			}
		} catch (Exception e) {
			System.out.println("Error fetching url [" + target + "]"+e);
		}
		return null;
	}
}
