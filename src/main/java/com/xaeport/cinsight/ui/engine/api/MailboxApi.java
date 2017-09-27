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
import com.xaeport.cinsight.ui.engine.model.Mailbox;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailboxApi {
    private ApiClient apiClient;

    public MailboxApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MailboxApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for getMailboxDetail */
    private com.squareup.okhttp.Call getMailboxDetailCall(String mailboxId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/mailbox/{mailboxId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "mailboxId" + "\\}", apiClient.escapeString(mailboxId.toString()));

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
    private com.squareup.okhttp.Call getMailboxDetailValidateBeforeCall(String mailboxId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'mailboxId' is set
        if (mailboxId == null) {
            throw new ApiException("Missing the required parameter 'mailboxId' when calling getMailboxDetail(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getMailboxDetailCall(mailboxId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 邮箱详情
     * 返回邮箱详情
     * @param mailboxId 邮箱ID (required)
     * @return List&lt;Mailbox&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Mailbox> getMailboxDetail(String mailboxId) throws ApiException {
        ApiResponse<List<Mailbox>> resp = getMailboxDetailWithHttpInfo(mailboxId);
        return resp.getData();
    }

    /**
     * 邮箱详情
     * 返回邮箱详情
     * @param mailboxId 邮箱ID (required)
     * @return ApiResponse&lt;List&lt;Mailbox&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Mailbox>> getMailboxDetailWithHttpInfo(String mailboxId) throws ApiException {
        com.squareup.okhttp.Call call = getMailboxDetailValidateBeforeCall(mailboxId, null, null);
        Type localVarReturnType = new TypeToken<List<Mailbox>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * 邮箱详情 (asynchronously)
     * 返回邮箱详情
     * @param mailboxId 邮箱ID (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getMailboxDetailAsync(String mailboxId, final ApiCallback<List<Mailbox>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getMailboxDetailValidateBeforeCall(mailboxId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Mailbox>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for listMailBox */
    private com.squareup.okhttp.Call listMailBoxCall(String conditions, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/mailbox".replaceAll("\\{format\\}","json");

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
    private com.squareup.okhttp.Call listMailBoxValidateBeforeCall(String conditions, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = listMailBoxCall(conditions, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 邮箱列表
     * 返回所有的邮箱列表
     * @param conditions 检索条件 (optional)
     * @return List&lt;Mailbox&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Mailbox> listMailBox(String conditions) throws ApiException {
        ApiResponse<List<Mailbox>> resp = listMailBoxWithHttpInfo(conditions);
        return resp.getData();
    }

    /**
     * 邮箱列表
     * 返回所有的邮箱列表
     * @param conditions 检索条件 (optional)
     * @return ApiResponse&lt;List&lt;Mailbox&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Mailbox>> listMailBoxWithHttpInfo(String conditions) throws ApiException {
        com.squareup.okhttp.Call call = listMailBoxValidateBeforeCall(conditions, null, null);
        Type localVarReturnType = new TypeToken<List<Mailbox>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * 邮箱列表 (asynchronously)
     * 返回所有的邮箱列表
     * @param conditions 检索条件 (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call listMailBoxAsync(String conditions, final ApiCallback<List<Mailbox>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = listMailBoxValidateBeforeCall(conditions, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Mailbox>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}