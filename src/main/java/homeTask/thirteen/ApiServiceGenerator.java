package homeTask.thirteen;

import homeTask.thirteen.client.WikiApiError;
import homeTask.thirteen.client.WikiApiException;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

public class ApiServiceGenerator {

    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();
    private static final OkHttpClient sharedClient;

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();
    }

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_URL)
                .addConverterFactory(converterFactory);

            retrofitBuilder.client(sharedClient);

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                WikiApiError apiError = getWikiApiError(response);
                throw new WikiApiException(apiError);
            }
        } catch (IOException e) {
            throw new WikiApiException(e);
        }
    }

    public static WikiApiError getWikiApiError(Response<?> response) throws IOException,
            WikiApiException {
        return errorBodyConverter.convert(response.errorBody());
    }

    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, WikiApiError> errorBodyConverter =
            (Converter<ResponseBody, WikiApiError>)converterFactory.responseBodyConverter(
                    WikiApiError.class, new Annotation[0], null);
}
