package br.com.labbs.workout.httpclientbattle;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;

public class Jetty implements br.com.labbs.workout.httpclientbattle.shared.HttpClient<Request, Response> {

    private static String JETTY = "Jetty";
    private static HttpClient httpClient = new HttpClient();

    static {
        try {
            httpClient.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getClientName() {
        return JETTY;
    }

    @Override
    public Request newRequest(String url) {
        return httpClient.newRequest(url);
    }

    @Override
    public void addHeaderToRequest(Request request, String key, String value) {
        request.header(key, value);
    }

    @Override
    public Response execRequest(Request request, int request_number) throws Exception {
        return request.send();
    }

    @Override
    public int getResponseStatusCode(Response response) {
        return response.getStatus();
    }
}
