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
    root.CInsightGui.MailList = factory(root.CInsightGui.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The MailList model module.
   * @module model/MailList
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>MailList</code>.
   * @alias module:model/MailList
   * @class
   */
  var exports = function() {
    var _this = this;








  };

  /**
   * Constructs a <code>MailList</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/MailList} obj Optional instance to populate.
   * @return {module:model/MailList} The populated <code>MailList</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('mailId')) {
        obj['mailId'] = ApiClient.convertToType(data['mailId'], 'String');
      }
      if (data.hasOwnProperty('from')) {
        obj['from'] = ApiClient.convertToType(data['from'], 'String');
      }
      if (data.hasOwnProperty('subject')) {
        obj['subject'] = ApiClient.convertToType(data['subject'], 'String');
      }
      if (data.hasOwnProperty('sendTime')) {
        obj['sendTime'] = ApiClient.convertToType(data['sendTime'], 'Number');
      }
      if (data.hasOwnProperty('sessionCount')) {
        obj['sessionCount'] = ApiClient.convertToType(data['sessionCount'], 'Number');
      }
      if (data.hasOwnProperty('attachmentCount')) {
        obj['attachmentCount'] = ApiClient.convertToType(data['attachmentCount'], 'Number');
      }
      if (data.hasOwnProperty('tagCount')) {
        obj['tagCount'] = ApiClient.convertToType(data['tagCount'], 'Number');
      }
    }
    return obj;
  }

  /**
   * 邮件id
   * @member {String} mailId
   */
  exports.prototype['mailId'] = undefined;
  /**
   * 发件人邮箱
   * @member {String} from
   */
  exports.prototype['from'] = undefined;
  /**
   * 邮件主题
   * @member {String} subject
   */
  exports.prototype['subject'] = undefined;
  /**
   * 发送时间
   * @member {Number} sendTime
   */
  exports.prototype['sendTime'] = undefined;
  /**
   * 会话数目
   * @member {Number} sessionCount
   */
  exports.prototype['sessionCount'] = undefined;
  /**
   * 附件数目
   * @member {Number} attachmentCount
   */
  exports.prototype['attachmentCount'] = undefined;
  /**
   * 标签数目
   * @member {Number} tagCount
   */
  exports.prototype['tagCount'] = undefined;



  return exports;
}));


