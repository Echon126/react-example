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
        define(['ApiClient', 'model/Condition'], factory);
    } else if (typeof module === 'object' && module.exports) {
        // CommonJS-like environments that support module.exports, like Node.
        module.exports = factory(require('../ApiClient'), require('./Condition'));
    } else {
        // Browser globals (root is window)
        if (!root.CInsightGui) {
            root.CInsightGui = {};
        }
        root.CInsightGui.ResultSetDetail = factory(root.CInsightGui.ApiClient, root.CInsightGui.Condition);
    }
}(this, function (ApiClient, Condition) {
    'use strict';


    /**
     * The ResultSetDetail model module.
     * @module model/ResultSetDetail
     * @version 1.0.0
     */

    /**
     * Constructs a new <code>ResultSetDetail</code>.
     * @alias module:model/ResultSetDetail
     * @class
     */
    var exports = function () {
        var _this = this;


    };

    /**
     * Constructs a <code>ResultSetDetail</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/ResultSetDetail} obj Optional instance to populate.
     * @return {module:model/ResultSetDetail} The populated <code>ResultSetDetail</code> instance.
     */
    exports.constructFromObject = function (data, obj) {
        if (data) {
            obj = obj || new exports();

            if (data.hasOwnProperty('resultsetId')) {
                obj['resultsetId'] = ApiClient.convertToType(data['resultsetId'], 'String');
            }
            if (data.hasOwnProperty('resultsetName')) {
                obj['resultsetName'] = ApiClient.convertToType(data['resultsetName'], 'String');
            }
            if (data.hasOwnProperty('resultsetToken')) {
                obj['resultsetToken'] = ApiClient.convertToType(data['resultsetToken'], 'String');
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
     * 结果集id
     * @member {String} resultsetId
     */
    exports.prototype['resultsetId'] = undefined;
    /**
     * 结果集名称
     * @member {String} resultsetName
     */
    exports.prototype['resultsetName'] = undefined;
    /**
     * 结果集token
     * @member {String} resultsetToken
     */
    exports.prototype['resultsetToken'] = undefined;
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

