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
    define(['ApiClient', 'model/Error', 'model/Plugin'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../model/Error'), require('../model/Plugin'));
  } else {
    // Browser globals (root is window)
    if (!root.CInsightGui) {
      root.CInsightGui = {};
    }
    root.CInsightGui.PluginApi = factory(root.CInsightGui.ApiClient, root.CInsightGui.Error, root.CInsightGui.Plugin);
  }
}(this, function(ApiClient, Error, Plugin) {
  'use strict';

  /**
   * Plugin service.
   * @module api/PluginApi
   * @version 1.0.0
   */

  /**
   * Constructs a new PluginApi. 
   * @alias module:api/PluginApi
   * @class
   * @param {module:ApiClient} apiClient Optional API client implementation to use,
   * default to {@link module:ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;


    /**
     * Callback function to receive the result of the selectPluginOptionList operation.
     * @callback module:api/PluginApi~selectPluginOptionListCallback
     * @param {String} error Error message, if any.
     * @param {Array.<module:model/Plugin>} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * 获取插件列表
     * 功能菜单获取插件列表
     * @param {module:api/PluginApi~selectPluginOptionListCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link Array.<module:model/Plugin>}
     */
    this.selectPluginOptionList = function(callback) {
      var postBody = null;


      var pathParams = {
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
      var returnType = [Plugin];

      return this.apiClient.callApi(
        '/plugin/options', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the updatePluginOptions operation.
     * @callback module:api/PluginApi~updatePluginOptionsCallback
     * @param {String} error Error message, if any.
     * @param {Object} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * 启用/禁用插件
     * 功能菜单启用/禁用插件，pluginIds为要启用的插件id集合，不再此数据中的id将被禁用
     * @param {String} pluginIds 插件id数组
     * @param {module:api/PluginApi~updatePluginOptionsCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link Object}
     */
    this.updatePluginOptions = function(pluginIds, callback) {
      var postBody = null;

      // verify the required parameter 'pluginIds' is set
      if (pluginIds == undefined || pluginIds == null) {
        throw new Error("Missing the required parameter 'pluginIds' when calling updatePluginOptions");
      }


      var pathParams = {
      };
      var queryParams = {
        'pluginIds': pluginIds
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
        '/plugin/options', 'PUT',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
  };

  return exports;
}));
