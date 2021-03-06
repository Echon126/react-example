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
        define(['ApiClient'], factory);
    } else if (typeof module === 'object' && module.exports) {
        // CommonJS-like environments that support module.exports, like Node.
        module.exports = factory(require('../ApiClient'));
    } else {
        // Browser globals (root is window)
        if (!root.CInsightGui) {
            root.CInsightGui = {};
        }
        root.CInsightGui.CustomTag = factory(root.CInsightGui.ApiClient);
    }
}(this, function (ApiClient) {
    'use strict';


    /**
     * The CustomTag model module.
     * @module model/CustomTag
     * @version 1.0.0
     */

    /**
     * Constructs a new <code>CustomTag</code>.
     * @alias module:model/CustomTag
     * @class
     */
    var exports = function () {
        var _this = this;


    };

    /**
     * Constructs a <code>CustomTag</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/CustomTag} obj Optional instance to populate.
     * @return {module:model/CustomTag} The populated <code>CustomTag</code> instance.
     */
    exports.constructFromObject = function (data, obj) {
        if (data) {
            obj = obj || new exports();

            if (data.hasOwnProperty('tagId')) {
                obj['tagId'] = ApiClient.convertToType(data['tagId'], 'String');
            }
            if (data.hasOwnProperty('tagName')) {
                obj['tagName'] = ApiClient.convertToType(data['tagName'], 'String');
            }
            if (data.hasOwnProperty('tagIcon')) {
                obj['tagIcon'] = ApiClient.convertToType(data['tagIcon'], 'String');
            }
            if (data.hasOwnProperty('frequency')) {
                obj['frequency'] = ApiClient.convertToType(data['frequency'], 'Number');
            }
            if (data.hasOwnProperty('createTime')) {
                obj['createTime'] = ApiClient.convertToType(data['createTime'], 'Number');
            }
            if (data.hasOwnProperty('lastUseTime')) {
                obj['lastUseTime'] = ApiClient.convertToType(data['lastUseTime'], 'Number');
            }
        }
        return obj;
    }

    /**
     * 标签id
     * @member {String} tagId
     */
    exports.prototype['tagId'] = undefined;
    /**
     * 标签name
     * @member {String} tagName
     */
    exports.prototype['tagName'] = undefined;
    /**
     * 标签icon
     * @member {String} tagIcon
     */
    exports.prototype['tagIcon'] = undefined;
    /**
     * 使用频率
     * @member {Number} frequency
     */
    exports.prototype['frequency'] = undefined;
    /**
     * 创建时间
     * @member {Number} createTime
     */
    exports.prototype['createTime'] = undefined;
    /**
     * 最后使用时间
     * @member {Number} lastUseTime
     */
    exports.prototype['lastUseTime'] = undefined;


    return exports;
}));


