/**
 * cInsight-gui
 * The Case Analysis Software
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 */

(function (root, factory) {
    if (false) {
        // AMD. Register as an anonymous module.
        define(['ApiClient', 'model/Error', 'model/ResultSet'], factory);
    } else if (typeof module === 'object' && module.exports) {
        // CommonJS-like environments that support module.exports, like Node.
        module.exports = factory(require('../ApiClient'), require('../model/Error'), require('../model/ResultSet'));
    } else {
        // Browser globals (root is window)
        if (!root.CInsightGui) {
            root.CInsightGui = {};
        }
        root.CInsightGui.ResultsetApi = factory(root.CInsightGui.ApiClient, root.CInsightGui.Error, root.CInsightGui.ResultSet);
    }
}(this, function (ApiClient, Error, ResultSet) {
    'use strict';

    /**
     * Resultset service.
     * @module api/ResultsetApi
     * @version 1.0.0
     */

    /**
     * Constructs a new ResultsetApi.
     * @alias module:api/ResultsetApi
     * @class
     * @param {module:ApiClient} apiClient Optional API client implementation to use,
     * default to {@link module:ApiClient#instance} if unspecified.
     */
    var exports = function (apiClient) {
        this.apiClient = apiClient || ApiClient.instance;


        /**
         * Callback function to receive the result of the createResultSet operation.
         * @callback module:api/ResultsetApi~createResultSetCallback
         * @param {String} error Error message, if any.
         * @param {Object} data The data returned by the service call.
         * @param {String} response The complete HTTP response.
         */

        /**
         * 新增结果集
         * 新增结果集
         * @param {String} caseId 案件id
         * @param {String} resultsetName 结果集名称
         * @param {String} resultsetToken 结果集token
         * @param {String} conditions 检索条件
         * @param {module:api/ResultsetApi~createResultSetCallback} callback The callback function, accepting three arguments: error, data, response
         * data is of type: {@link Object}
         */
        this.createResultSet = function (caseId, resultsetName, resultsetToken, conditions, callback) {
            var postBody = null;

            // verify the required parameter 'caseId' is set
            if (caseId == undefined || caseId == null) {
                throw new Error("Missing the required parameter 'caseId' when calling createResultSet");
            }

            // verify the required parameter 'resultsetName' is set
            if (resultsetName == undefined || resultsetName == null) {
                throw new Error("Missing the required parameter 'resultsetName' when calling createResultSet");
            }

            // verify the required parameter 'resultsetToken' is set
            if (resultsetToken == undefined || resultsetToken == null) {
                throw new Error("Missing the required parameter 'resultsetToken' when calling createResultSet");
            }

            // verify the required parameter 'conditions' is set
            if (conditions == undefined || conditions == null) {
                throw new Error("Missing the required parameter 'conditions' when calling createResultSet");
            }


            var pathParams = {
                'caseId': caseId
            };
            var queryParams = {
                'resultsetName': resultsetName,
                'resultsetToken': resultsetToken,
                'conditions': conditions
            };
            var headerParams = {};
            var formParams = {};

            var authNames = [];
            var contentTypes = [];
            var accepts = ['application/json'];
            var returnType = Object;

            return this.apiClient.callApi(
                '/resultset/{caseId}', 'POST',
                pathParams, queryParams, headerParams, formParams, postBody,
                authNames, contentTypes, accepts, returnType, callback
            );
        }

        /**
         * Callback function to receive the result of the deleteResultSet operation.
         * @callback module:api/ResultsetApi~deleteResultSetCallback
         * @param {String} error Error message, if any.
         * @param {Object} data The data returned by the service call.
         * @param {String} response The complete HTTP response.
         */

        /**
         * 删除结果集
         * 删除结果集
         * @param {String} caseId 案件id
         * @param {String} resultsetId 结果集id
         * @param {module:api/ResultsetApi~deleteResultSetCallback} callback The callback function, accepting three arguments: error, data, response
         * data is of type: {@link Object}
         */
        this.deleteResultSet = function (caseId, resultsetId, callback) {
            var postBody = null;

            // verify the required parameter 'caseId' is set
            if (caseId == undefined || caseId == null) {
                throw new Error("Missing the required parameter 'caseId' when calling deleteResultSet");
            }

            // verify the required parameter 'resultsetId' is set
            if (resultsetId == undefined || resultsetId == null) {
                throw new Error("Missing the required parameter 'resultsetId' when calling deleteResultSet");
            }


            var pathParams = {
                'caseId': caseId,
                'resultsetId': resultsetId
            };
            var queryParams = {};
            var headerParams = {};
            var formParams = {};

            var authNames = [];
            var contentTypes = [];
            var accepts = ['application/json'];
            var returnType = Object;

            return this.apiClient.callApi(
                '/resultset/{caseId}/{resultsetId}', 'DELETE',
                pathParams, queryParams, headerParams, formParams, postBody,
                authNames, contentTypes, accepts, returnType, callback
            );
        }

        /**
         * Callback function to receive the result of the getResultSetDetail operation.
         * @callback module:api/ResultsetApi~getResultSetDetailCallback
         * @param {String} error Error message, if any.
         * @param {Object} data The data returned by the service call.
         * @param {String} response The complete HTTP response.
         */

        /**
         * 查询结果集详情
         * 查询结果集详情
         * @param {String} caseId 案件id
         * @param {String} resultsetId 结果集id
         * @param {module:api/ResultsetApi~getResultSetDetailCallback} callback The callback function, accepting three arguments: error, data, response
         * data is of type: {@link Object}
         */
        this.getResultSetDetail = function (caseId, resultsetId, callback) {
            var postBody = null;

            // verify the required parameter 'caseId' is set
            if (caseId == undefined || caseId == null) {
                throw new Error("Missing the required parameter 'caseId' when calling getResultSetDetail");
            }

            // verify the required parameter 'resultsetId' is set
            if (resultsetId == undefined || resultsetId == null) {
                throw new Error("Missing the required parameter 'resultsetId' when calling getResultSetDetail");
            }


            var pathParams = {
                'caseId': caseId,
                'resultsetId': resultsetId
            };
            var queryParams = {};
            var headerParams = {};
            var formParams = {};

            var authNames = [];
            var contentTypes = [];
            var accepts = ['application/json'];
            var returnType = Object;

            return this.apiClient.callApi(
                '/resultset/{caseId}/{resultsetId}', 'GET',
                pathParams, queryParams, headerParams, formParams, postBody,
                authNames, contentTypes, accepts, returnType, callback
            );
        }

        /**
         * Callback function to receive the result of the selectResultSetList operation.
         * @callback module:api/ResultsetApi~selectResultSetListCallback
         * @param {String} error Error message, if any.
         * @param {Array.<module:model/ResultSet>} data The data returned by the service call.
         * @param {String} response The complete HTTP response.
         */

        /**
         * 查询结果集列表
         * 查询结果集列表，按创建时间倒序排列 top100
         * @param {String} caseId 案件id
         * @param {module:api/ResultsetApi~selectResultSetListCallback} callback The callback function, accepting three arguments: error, data, response
         * data is of type: {@link Array.<module:model/ResultSet>}
         */
        this.selectResultSetList = function (caseId, callback) {
            var postBody = null;

            // verify the required parameter 'caseId' is set
            if (caseId == undefined || caseId == null) {
                throw new Error("Missing the required parameter 'caseId' when calling selectResultSetList");
            }


            var pathParams = {
                'caseId': caseId
            };
            var queryParams = {};
            var headerParams = {};
            var formParams = {};

            var authNames = [];
            var contentTypes = [];
            var accepts = ['application/json'];
            var returnType = [ResultSet];

            return this.apiClient.callApi(
                '/resultset/{caseId}', 'GET',
                pathParams, queryParams, headerParams, formParams, postBody,
                authNames, contentTypes, accepts, returnType, callback
            );
        }
    };

    return exports;
}));
