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
    define(['ApiClient'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'));
  } else {
    // Browser globals (root is window)
    if (!root.CInsightGui) {
      root.CInsightGui = {};
    }
    root.CInsightGui.SearchCount = factory(root.CInsightGui.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The SearchCount model module.
   * @module model/SearchCount
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>SearchCount</code>.
   * @alias module:model/SearchCount
   * @class
   */
  var exports = function() {
    var _this = this;






  };

  /**
   * Constructs a <code>SearchCount</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/SearchCount} obj Optional instance to populate.
   * @return {module:model/SearchCount} The populated <code>SearchCount</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('mailCount')) {
        obj['mailCount'] = ApiClient.convertToType(data['mailCount'], 'Number');
      }
      if (data.hasOwnProperty('attachmentCount')) {
        obj['attachmentCount'] = ApiClient.convertToType(data['attachmentCount'], 'Number');
      }
      if (data.hasOwnProperty('mailboxCount')) {
        obj['mailboxCount'] = ApiClient.convertToType(data['mailboxCount'], 'Number');
      }
      if (data.hasOwnProperty('contactCount')) {
        obj['contactCount'] = ApiClient.convertToType(data['contactCount'], 'Number');
      }
      if (data.hasOwnProperty('searchToken')) {
        obj['searchToken'] = ApiClient.convertToType(data['searchToken'], 'String');
      }
    }
    return obj;
  }

  /**
   * 命中邮件数
   * @member {Number} mailCount
   */
  exports.prototype['mailCount'] = undefined;
  /**
   * 命中附件数
   * @member {Number} attachmentCount
   */
  exports.prototype['attachmentCount'] = undefined;
  /**
   * 命中邮箱数
   * @member {Number} mailboxCount
   */
  exports.prototype['mailboxCount'] = undefined;
  /**
   * 命中联系人
   * @member {Number} contactCount
   */
  exports.prototype['contactCount'] = undefined;
  /**
   * 结果集令牌
   * @member {String} searchToken
   */
  exports.prototype['searchToken'] = undefined;



  return exports;
}));


