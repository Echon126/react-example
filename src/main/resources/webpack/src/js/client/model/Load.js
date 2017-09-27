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
    define(['ApiClient', 'model/Option'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./Option'));
  } else {
    // Browser globals (root is window)
    if (!root.CInsightGui) {
      root.CInsightGui = {};
    }
    root.CInsightGui.Load = factory(root.CInsightGui.ApiClient, root.CInsightGui.Option);
  }
}(this, function(ApiClient, Option) {
  'use strict';




  /**
   * The Load model module.
   * @module model/Load
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>Load</code>.
   * @alias module:model/Load
   * @class
   */
  var exports = function() {
    var _this = this;



  };

  /**
   * Constructs a <code>Load</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/Load} obj Optional instance to populate.
   * @return {module:model/Load} The populated <code>Load</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('pluginName')) {
        obj['pluginName'] = ApiClient.convertToType(data['pluginName'], 'String');
      }
      if (data.hasOwnProperty('options')) {
        obj['options'] = ApiClient.convertToType(data['options'], [Option]);
      }
    }
    return obj;
  }

  /**
   * 插件名称
   * @member {String} pluginName
   */
  exports.prototype['pluginName'] = undefined;
  /**
   * @member {Array.<module:model/Option>} options
   */
  exports.prototype['options'] = undefined;



  return exports;
}));

