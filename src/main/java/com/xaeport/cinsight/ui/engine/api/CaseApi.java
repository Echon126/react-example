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
import com.xaeport.cinsight.ui.engine.model.CaseInfo;
import com.xaeport.cinsight.ui.engine.model.ResponseData;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaseApi {
    private ApiClient apiClient;

    public CaseApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CaseApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for activateCaseById */
    private com.squareup.okhttp.Call activateCaseByIdCall(String caseId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/case/activate/{caseId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "caseId" + "\\}", apiClient.escapeString(caseId.toString()));

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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call activateCaseByIdValidateBeforeCall(String caseId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'caseId' is set
        if (caseId == null) {
            throw new ApiException("Missing the required parameter 'caseId' when calling activateCaseById(Async)");
        }
        
        
        com.squareup.okhttp.Call call = activateCaseByIdCall(caseId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 激活案件
     * 激活指定的案件并装载案件数据
     * @param caseId 案件信息ID (required)
     * @return ResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResponseData activateCaseById(String caseId) throws ApiException {
        ApiResponse<ResponseData> resp = activateCaseByIdWithHttpInfo(caseId);
        return resp.getData();
    }

    /**
     * 激活案件
     * 激活指定的案件并装载案件数据
     * @param caseId 案件信息ID (required)
     * @return ApiResponse&lt;ResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResponseData> activateCaseByIdWithHttpInfo(String caseId) throws ApiException {
        com.squareup.okhttp.Call call = activateCaseByIdValidateBeforeCall(caseId, null, null);
        Type localVarReturnType = new TypeToken<ResponseData>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * 激活案件 (asynchronously)
     * 激活指定的案件并装载案件数据
     * @param caseId 案件信息ID (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call activateCaseByIdAsync(String caseId, final ApiCallback<ResponseData> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = activateCaseByIdValidateBeforeCall(caseId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResponseData>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for createCase */
    private com.squareup.okhttp.Call createCaseCall(String caseId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/case".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (caseId != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseId", caseId));

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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createCaseValidateBeforeCall(String caseId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'caseId' is set
        if (caseId == null) {
            throw new ApiException("Missing the required parameter 'caseId' when calling createCase(Async)");
        }
        
        
        com.squareup.okhttp.Call call = createCaseCall(caseId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 新建案件
     * 创建一个新的案件
     * @param caseId 案件编号 (required)
     * @return ResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResponseData createCase(String caseId) throws ApiException {
        ApiResponse<ResponseData> resp = createCaseWithHttpInfo(caseId);
        return resp.getData();
    }

    /**
     * 新建案件
     * 创建一个新的案件
     * @param caseId 案件编号 (required)
     * @return ApiResponse&lt;ResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResponseData> createCaseWithHttpInfo(String caseId) throws ApiException {
        com.squareup.okhttp.Call call = createCaseValidateBeforeCall(caseId, null, null);
        Type localVarReturnType = new TypeToken<ResponseData>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * 新建案件 (asynchronously)
     * 创建一个新的案件
     * @param caseId 案件编号 (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createCaseAsync(String caseId, final ApiCallback<ResponseData> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createCaseValidateBeforeCall(caseId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResponseData>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for deactivateCaseById */
    private com.squareup.okhttp.Call deactivateCaseByIdCall(String caseId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/case/deactivate/{caseId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "caseId" + "\\}", apiClient.escapeString(caseId.toString()));

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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deactivateCaseByIdValidateBeforeCall(String caseId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'caseId' is set
        if (caseId == null) {
            throw new ApiException("Missing the required parameter 'caseId' when calling deactivateCaseById(Async)");
        }
        
        
        com.squareup.okhttp.Call call = deactivateCaseByIdCall(caseId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 关闭案件
     * 关闭指定的案件并释放已装载的数据
     * @param caseId 案件信息ID (required)
     * @return ResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResponseData deactivateCaseById(String caseId) throws ApiException {
        ApiResponse<ResponseData> resp = deactivateCaseByIdWithHttpInfo(caseId);
        return resp.getData();
    }

    /**
     * 关闭案件
     * 关闭指定的案件并释放已装载的数据
     * @param caseId 案件信息ID (required)
     * @return ApiResponse&lt;ResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResponseData> deactivateCaseByIdWithHttpInfo(String caseId) throws ApiException {
        com.squareup.okhttp.Call call = deactivateCaseByIdValidateBeforeCall(caseId, null, null);
        Type localVarReturnType = new TypeToken<ResponseData>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * 关闭案件 (asynchronously)
     * 关闭指定的案件并释放已装载的数据
     * @param caseId 案件信息ID (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deactivateCaseByIdAsync(String caseId, final ApiCallback<ResponseData> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deactivateCaseByIdValidateBeforeCall(caseId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResponseData>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for deleteCaseById */
    private com.squareup.okhttp.Call deleteCaseByIdCall(String caseId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/case/{caseId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "caseId" + "\\}", apiClient.escapeString(caseId.toString()));

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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteCaseByIdValidateBeforeCall(String caseId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'caseId' is set
        if (caseId == null) {
            throw new ApiException("Missing the required parameter 'caseId' when calling deleteCaseById(Async)");
        }
        
        
        com.squareup.okhttp.Call call = deleteCaseByIdCall(caseId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 删除案件
     * 删除指定的案件信息
     * @param caseId 案件编号 (required)
     * @return ResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResponseData deleteCaseById(String caseId) throws ApiException {
        ApiResponse<ResponseData> resp = deleteCaseByIdWithHttpInfo(caseId);
        return resp.getData();
    }

    /**
     * 删除案件
     * 删除指定的案件信息
     * @param caseId 案件编号 (required)
     * @return ApiResponse&lt;ResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResponseData> deleteCaseByIdWithHttpInfo(String caseId) throws ApiException {
        com.squareup.okhttp.Call call = deleteCaseByIdValidateBeforeCall(caseId, null, null);
        Type localVarReturnType = new TypeToken<ResponseData>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * 删除案件 (asynchronously)
     * 删除指定的案件信息
     * @param caseId 案件编号 (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteCaseByIdAsync(String caseId, final ApiCallback<ResponseData> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteCaseByIdValidateBeforeCall(caseId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResponseData>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for listCase */
    private com.squareup.okhttp.Call listCaseCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/case".replaceAll("\\{format\\}","json");

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
    private com.squareup.okhttp.Call listCaseValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = listCaseCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 案件列表
     * 返回所有案件, 按&lt;最后查看时间&gt;倒序排列 
     * @return List&lt;CaseInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<CaseInfo> listCase() throws ApiException {
        ApiResponse<List<CaseInfo>> resp = listCaseWithHttpInfo();
        return resp.getData();
    }

    /**
     * 案件列表
     * 返回所有案件, 按&lt;最后查看时间&gt;倒序排列 
     * @return ApiResponse&lt;List&lt;CaseInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<CaseInfo>> listCaseWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = listCaseValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<List<CaseInfo>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * 案件列表 (asynchronously)
     * 返回所有案件, 按&lt;最后查看时间&gt;倒序排列 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call listCaseAsync(final ApiCallback<List<CaseInfo>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = listCaseValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<CaseInfo>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
