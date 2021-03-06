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

(function(root, factory) {
    if (false) {
        // AMD. Register as an anonymous module.
        define(['ApiClient', 'model/Error'], factory);
    } else if (typeof module === 'object' && module.exports) {
        // CommonJS-like environments that support module.exports, like Node.
        module.exports = factory(require('../ApiClient'), require('../model/Error'));
    } else {
        // Browser globals (root is window)
        if (!root.CInsightGui) {
            root.CInsightGui = {};
        }
        root.CInsightGui.AttachmentApi = factory(root.CInsightGui.ApiClient, root.CInsightGui.Error);
    }
}(this, function(ApiClient, Error) {
    'use strict';

    /**
     * Attachment service.
     * @module api/AttachmentApi
     * @version 1.0.0
     */

    /**
     * Constructs a new AttachmentApi.
     * @alias module:api/AttachmentApi
     * @class
     * @param {module:ApiClient} apiClient Optional API client implementation to use,
     * default to {@link module:ApiClient#instance} if unspecified.
     */
    var exports = function(apiClient) {
        this.apiClient = apiClient || ApiClient.instance;


        /**
         * Callback function to receive the result of the getAttachmentDetail operation.
         * @callback module:api/AttachmentApi~getAttachmentDetailCallback
         * @param {String} error Error message, if any.
         * @param {Object} data The data returned by the service call.
         * @param {String} response The complete HTTP response.
         */

        /**
         * 获取附件详情
         * 获取附件详情
         * @param {String} caseId 案件id
         * @param {String} attachmentId 附件id
         * @param {module:api/AttachmentApi~getAttachmentDetailCallback} callback The callback function, accepting three arguments: error, data, response
         * data is of type: {@link Object}
         */
        this.getAttachmentDetail = function(caseId, attachmentId, callback) {
            var postBody = null;

            // verify the required parameter 'caseId' is set
            if (caseId == undefined || caseId == null) {
                throw new Error("Missing the required parameter 'caseId' when calling getAttachmentDetail");
            }

            // verify the required parameter 'attachmentId' is set
            if (attachmentId == undefined || attachmentId == null) {
                throw new Error("Missing the required parameter 'attachmentId' when calling getAttachmentDetail");
            }


            var pathParams = {
                'caseId': caseId,
                'attachmentId': attachmentId
            };
            var queryParams = {
            };
            var headerParams = {
            };
            var formParams = {
            };

            var authNames = [];
            var contentTypes = [];
            var accepts = ['application/json'];
            var returnType = Object;

            return this.apiClient.callApi(
                '/attachment/{caseId}/{attachmentId}', 'GET',
                pathParams, queryParams, headerParams, formParams, postBody,
                authNames, contentTypes, accepts, returnType, callback
            );
        }

        /**
         * Callback function to receive the result of the getAttachmentRelation operation.
         * @callback module:api/AttachmentApi~getAttachmentRelationCallback
         * @param {String} error Error message, if any.
         * @param {Object} data The data returned by the service call.
         * @param {String} response The complete HTTP response.
         */

        /**
         * 相关性分析
         * 附件相关性分析,按照发送时间倒序排列
         * @param {String} caseId 案件id
         * @param {String} attachmentId 附件id
         * @param {module:api/AttachmentApi~getAttachmentRelationCallback} callback The callback function, accepting three arguments: error, data, response
         * data is of type: {@link Object}
         */
        this.getAttachmentRelation = function(caseId, attachmentId, callback) {
            var postBody = null;

            // verify the required parameter 'caseId' is set
            if (caseId == undefined || caseId == null) {
                throw new Error("Missing the required parameter 'caseId' when calling getAttachmentRelation");
            }

            // verify the required parameter 'attachmentId' is set
            if (attachmentId == undefined || attachmentId == null) {
                throw new Error("Missing the required parameter 'attachmentId' when calling getAttachmentRelation");
            }


            var pathParams = {
                'caseId': caseId,
                'attachmentId': attachmentId
            };
            var queryParams = {
            };
            var headerParams = {
            };
            var formParams = {
            };

            var authNames = [];
            var contentTypes = [];
            var accepts = ['application/json'];
            var returnType = Object;

            return this.apiClient.callApi(
                '/attachment/{caseId}/{attachmentId}/mail', 'GET',
                pathParams, queryParams, headerParams, formParams, postBody,
                authNames, contentTypes, accepts, returnType, callback
            );
        }

        /**
         * Callback function to receive the result of the selectAttachmentList operation.
         * @callback module:api/AttachmentApi~selectAttachmentListCallback
         * @param {String} error Error message, if any.
         * @param {Object} data The data returned by the service call.
         * @param {String} response The complete HTTP response.
         */

        /**
         * 获取附件列表
         * 获取附件列表
         * @param {String} caseId 案件id
         * @param {Object} opts Optional parameters
         * @param {String} opts.conditions 检索条件
         * @param {module:api/AttachmentApi~selectAttachmentListCallback} callback The callback function, accepting three arguments: error, data, response
         * data is of type: {@link Object}
         */
        this.selectAttachmentList = function(caseId, opts, callback) {
            opts = opts || {};
            var postBody = null;

            // verify the required parameter 'caseId' is set
            if (caseId == undefined || caseId == null) {
                throw new Error("Missing the required parameter 'caseId' when calling selectAttachmentList");
            }


            var pathParams = {
                'caseId': caseId
            };
            var queryParams = {
                'conditions': opts['conditions']
            };
            var headerParams = {
            };
            var formParams = {
            };

            var authNames = [];
            var contentTypes = [];
            var accepts = ['application/json'];
            var returnType = Object;

            return this.apiClient.callApi(
                '/attachment/{caseId}', 'GET',
                pathParams, queryParams, headerParams, formParams, postBody,
                authNames, contentTypes, accepts, returnType, callback
            );
        }

        /**
         * Callback function to receive the result of the updateAttachmentNotes operation.
         * @callback module:api/AttachmentApi~updateAttachmentNotesCallback
         * @param {String} error Error message, if any.
         * @param {Object} data The data returned by the service call.
         * @param {String} response The complete HTTP response.
         */

        /**
         * 附件批注
         * 附件批注
         * @param {String} caseId 案件id
         * @param {String} attachmentId 附件id
         * @param {String} notes 批注内容
         * @param {module:api/AttachmentApi~updateAttachmentNotesCallback} callback The callback function, accepting three arguments: error, data, response
         * data is of type: {@link Object}
         */
        this.updateAttachmentNotes = function(caseId, attachmentId, notes, callback) {
            var postBody = null;

            // verify the required parameter 'caseId' is set
            if (caseId == undefined || caseId == null) {
                throw new Error("Missing the required parameter 'caseId' when calling updateAttachmentNotes");
            }

            // verify the required parameter 'attachmentId' is set
            if (attachmentId == undefined || attachmentId == null) {
                throw new Error("Missing the required parameter 'attachmentId' when calling updateAttachmentNotes");
            }

            // verify the required parameter 'notes' is set
            if (notes == undefined || notes == null) {
                throw new Error("Missing the required parameter 'notes' when calling updateAttachmentNotes");
            }


            var pathParams = {
                'caseId': caseId,
                'attachmentId': attachmentId
            };
            var queryParams = {
                'notes': notes
            };
            var headerParams = {
            };
            var formParams = {
            };

            var authNames = [];
            var contentTypes = [];
            var accepts = ['application/json'];
            var returnType = Object;

            return this.apiClient.callApi(
                '/attachment/{caseId}/{attachmentId}/notes', 'PUT',
                pathParams, queryParams, headerParams, formParams, postBody,
                authNames, contentTypes, accepts, returnType, callback
            );
        }

        /**
         * Callback function to receive the result of the updateAttachmentTag operation.
         * @callback module:api/AttachmentApi~updateAttachmentTagCallback
         * @param {String} error Error message, if any.
         * @param {Object} data The data returned by the service call.
         * @param {String} response The complete HTTP response.
         */

        /**
         * 附件修改标签
         * 附件修改标签
         * @param {String} caseId 案件id
         * @param {String} attachmentId 附件id
         * @param {String} tags 标签字符串 name1,name2,name3
         * @param {Number} sysTagCount 原始系统标签数目 sys_tag_count
         * @param {module:api/AttachmentApi~updateAttachmentTagCallback} callback The callback function, accepting three arguments: error, data, response
         * data is of type: {@link Object}
         */
        this.updateAttachmentTag = function(caseId, attachmentId, tags, sysTagCount, callback) {
            var postBody = null;

            // verify the required parameter 'caseId' is set
            if (caseId == undefined || caseId == null) {
                throw new Error("Missing the required parameter 'caseId' when calling updateAttachmentTag");
            }

            // verify the required parameter 'attachmentId' is set
            if (attachmentId == undefined || attachmentId == null) {
                throw new Error("Missing the required parameter 'attachmentId' when calling updateAttachmentTag");
            }

            // verify the required parameter 'tags' is set
            if (tags == undefined || tags == null) {
                throw new Error("Missing the required parameter 'tags' when calling updateAttachmentTag");
            }

            // verify the required parameter 'sysTagCount' is set
            if (sysTagCount == undefined || sysTagCount == null) {
                throw new Error("Missing the required parameter 'sysTagCount' when calling updateAttachmentTag");
            }


            var pathParams = {
                'caseId': caseId,
                'attachmentId': attachmentId
            };
            var queryParams = {
                'tags': tags,
                'sysTagCount': sysTagCount
            };
            var headerParams = {
            };
            var formParams = {
            };

            var authNames = [];
            var contentTypes = [];
            var accepts = ['application/json'];
            var returnType = Object;

            return this.apiClient.callApi(
                '/attachment/{caseId}/{attachmentId}/tag', 'PUT',
                pathParams, queryParams, headerParams, formParams, postBody,
                authNames, contentTypes, accepts, returnType, callback
            );
        }
    };

    return exports;
}));
