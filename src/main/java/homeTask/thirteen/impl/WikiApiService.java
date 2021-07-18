package homeTask.thirteen.impl;

import homeTask.thirteen.model.WikiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WikiApiService {

    @GET("/w/api.php?")
    Call<WikiResponse> getQuery(@Query("action") String action,
                                @Query("list") String list,
                                @Query("utf8") String utf8,
                                @Query("format") String format,
                                @Query("srsearch") String search);

}
