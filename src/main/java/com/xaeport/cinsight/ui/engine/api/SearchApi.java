/*
 * 案件分析引擎
 * 案件分析引擎
 *
 * OpenAPI spec version: 1.0.0
 * Contact: cinsight@xaeport.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.xaeport.cinsight.ui.engine.api;

import com.google.gson.reflect.TypeToken;
import com.xaeport.cinsight.ui.engine.*;
import com.xaeport.cinsight.ui.engine.model.Search;
import com.xaeport.cinsight.ui.engine.model.SearchDetail;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchApi {
    private ApiClient apiClient;

    public SearchApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SearchApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for getSearchDetail */
    private com.squareup.okhttp.Call getSearchDetailCall(String searchToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/search/{searchToken}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "searchToken" + "\\}", apiClient.escapeString(searchToken.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getSearchDetailValidateBeforeCall(String searchToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'searchToken' is set
        if (searchToken == null) {
            throw new ApiException("Missing the required parameter 'searchToken' when calling getSearchDetail(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getSearchDetailCall(searchToken, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 检索
     * 
     * @param searchToken 查询令牌 (required)
     * @return SearchDetail
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SearchDetail getSearchDetail(String searchToken) throws ApiException {
        ApiResponse<SearchDetail> resp = getSearchDetailWithHttpInfo(searchToken);
        return resp.getData();
    }

    /**
     * 检索
     * 
     * @param searchToken 查询令牌 (required)
     * @return ApiResponse&lt;SearchDetail&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SearchDetail> getSearchDetailWithHttpInfo(String searchToken) throws ApiException {
        com.squareup.okhttp.Call call = getSearchDetailValidateBeforeCall(searchToken, null, null);
        Type localVarReturnType = new TypeToken<SearchDetail>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * 检索 (asynchronously)
     * 
     * @param searchToken 查询令牌 (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getSearchDetailAsync(String searchToken, final ApiCallback<SearchDetail> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getSearchDetailValidateBeforeCall(searchToken, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SearchDetail>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for search */
    private com.squareup.okhttp.Call searchCall(String conditions, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/search".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (conditions != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "conditions", conditions));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call searchValidateBeforeCall(String conditions, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = searchCall(conditions, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 检索
     * 
     * @param conditions 检索条件 (optional)
     * @return Search
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Search search(String conditions) throws ApiException {
        ApiResponse<Search> resp = searchWithHttpInfo(conditions);
        return resp.getData();
    }

    /**
     * 检索
     * 
     * @param conditions 检索条件 (optional)
     * @return ApiResponse&lt;Search&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Search> searchWithHttpInfo(String conditions) throws ApiException {
        com.squareup.okhttp.Call call = searchValidateBeforeCall(conditions, null, null);
        Type localVarReturnType = new TypeToken<Search>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * 检索 (asynchronously)
     * 
     * @param conditions 检索条件 (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchAsync(String conditions, final ApiCallback<Search> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = searchValidateBeforeCall(conditions, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Search>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
