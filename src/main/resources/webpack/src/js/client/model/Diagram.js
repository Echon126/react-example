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
    root.CInsightGui.Diagram = factory(root.CInsightGui.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The Diagram model module.
   * @module model/Diagram
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>Diagram</code>.
   * @alias module:model/Diagram
   * @class
   */
  var exports = function() {
    var _this = this;




  };

  /**
   * Constructs a <code>Diagram</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/Diagram} obj Optional instance to populate.
   * @return {module:model/Diagram} The populated <code>Diagram</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('date')) {
        obj['date'] = ApiClient.convertToType(data['date'], 'String');
      }
      if (data.hasOwnProperty('inboxCount')) {
        obj['inboxCount'] = ApiClient.convertToType(data['inboxCount'], 'Number');
      }
      if (data.hasOwnProperty('outboxCount')) {
        obj['outboxCount'] = ApiClient.convertToType(data['outboxCount'], 'Number');
      }
    }
    return obj;
  }

  /**
   * 日期
   * @member {String} date
   */
  exports.prototype['date'] = undefined;
  /**
   * 收件数
   * @member {Number} inboxCount
   */
  exports.prototype['inboxCount'] = undefined;
  /**
   * 发件数
   * @member {Number} outboxCount
   */
  exports.prototype['outboxCount'] = undefined;



  return exports;
}));

