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
    root.CInsightGui.UseTag = factory(root.CInsightGui.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The UseTag model module.
   * @module model/UseTag
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>UseTag</code>.
   * @alias module:model/UseTag
   * @class
   */
  var exports = function() {
    var _this = this;




  };

  /**
   * Constructs a <code>UseTag</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/UseTag} obj Optional instance to populate.
   * @return {module:model/UseTag} The populated <code>UseTag</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('typeName')) {
        obj['typeName'] = ApiClient.convertToType(data['typeName'], 'String');
      }
      if (data.hasOwnProperty('typeType')) {
        obj['typeType'] = ApiClient.convertToType(data['typeType'], 'String');
      }
      if (data.hasOwnProperty('typeIcon')) {
        obj['typeIcon'] = ApiClient.convertToType(data['typeIcon'], 'String');
      }
    }
    return obj;
  }

  /**
   * 标签名称
   * @member {String} typeName
   */
  exports.prototype['typeName'] = undefined;
  /**
   * 标签类型
   * @member {String} typeType
   */
  exports.prototype['typeType'] = undefined;
  /**
   * 标签图标名称
   * @member {String} typeIcon
   */
  exports.prototype['typeIcon'] = undefined;



  return exports;
}));


