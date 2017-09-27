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
    define(['ApiClient', 'model/Condition'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./Condition'));
  } else {
    // Browser globals (root is window)
    if (!root.CInsightGui) {
      root.CInsightGui = {};
    }
    root.CInsightGui.HistoryDetail = factory(root.CInsightGui.ApiClient, root.CInsightGui.Condition);
  }
}(this, function(ApiClient, Condition) {
  'use strict';




  /**
   * The HistoryDetail model module.
   * @module model/HistoryDetail
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>HistoryDetail</code>.
   * @alias module:model/HistoryDetail
   * @class
   */
  var exports = function() {
    var _this = this;







  };

  /**
   * Constructs a <code>HistoryDetail</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/HistoryDetail} obj Optional instance to populate.
   * @return {module:model/HistoryDetail} The populated <code>HistoryDetail</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('historyId')) {
        obj['historyId'] = ApiClient.convertToType(data['historyId'], 'String');
      }
      if (data.hasOwnProperty('historyName')) {
        obj['historyName'] = ApiClient.convertToType(data['historyName'], 'String');
      }
      if (data.hasOwnProperty('historyPage')) {
        obj['historyPage'] = ApiClient.convertToType(data['historyPage'], 'String');
      }
      if (data.hasOwnProperty('detailId')) {
        obj['detailId'] = ApiClient.convertToType(data['detailId'], 'String');
      }
      if (data.hasOwnProperty('createTime')) {
        obj['createTime'] = ApiClient.convertToType(data['createTime'], 'Number');
      }
      if (data.hasOwnProperty('conditions')) {
        obj['conditions'] = ApiClient.convertToType(data['conditions'], [Condition]);
      }
    }
    return obj;
  }

  /**
   * 操作记录id
   * @member {String} historyId
   */
  exports.prototype['historyId'] = undefined;
  /**
   * 操作记录名称
   * @member {String} historyName
   */
  exports.prototype['historyName'] = undefined;
  /**
   * 操作界面
   * @member {String} historyPage
   */
  exports.prototype['historyPage'] = undefined;
  /**
   * 详情id
   * @member {String} detailId
   */
  exports.prototype['detailId'] = undefined;
  /**
   * 结果集创建时间
   * @member {Number} createTime
   */
  exports.prototype['createTime'] = undefined;
  /**
   * 检索条件
   * @member {Array.<module:model/Condition>} conditions
   */
  exports.prototype['conditions'] = undefined;



  return exports;
}));

