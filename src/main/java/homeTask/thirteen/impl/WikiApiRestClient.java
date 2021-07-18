package homeTask.thirteen.impl;

import homeTask.thirteen.model.WikiResponse;

public interface WikiApiRestClient {

    WikiResponse getQuery(String search);
}
