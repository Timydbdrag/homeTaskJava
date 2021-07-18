package homeTask.thirteen.impl;

import homeTask.thirteen.model.WikiResponse;

import static homeTask.thirteen.ApiServiceGenerator.createService;
import static homeTask.thirteen.ApiServiceGenerator.executeSync;

public class WikiApiRestClientImpl implements WikiApiRestClient {
    private final WikiApiService wikiApiService;

    public WikiApiRestClientImpl() {
        wikiApiService = createService(WikiApiService.class);
    }

    @Override
    public WikiResponse getQuery(String search) {
        return executeSync(wikiApiService.getQuery("query","search","","json",search));
    }
}
