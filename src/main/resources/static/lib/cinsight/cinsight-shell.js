/**
 * cInsight浏览器注入脚本
 * @type {{selectFileAndFolder: Window.cInsight.selectFileAndFolder, uiComplete: Window.cInsight.uiComplete, uiExit: Window.cInsight.uiExit, exportAttachment: Window.cInsight.exportAttachment, openAttachment: Window.cInsight.openAttachment}}
 */
window.cInsight = {
    /**
     * 弹出选择文件/文件夹对话框
     * @param callback 结果回调函数，参数1=成功结果，参数2=错误结果
     */
    selectFileAndFolder: function (callback) {
        if(!window.cefQuery) return;

        window.cefQuery({
            request: "cmd:selectFileAndFolder",
            onSuccess: function (response) {
                callback(response);
            },
            onFailure: function (response) {
                callback(null, response);
            }
        });
    },

    /**
     * 通知浏览器界面页准备完毕
     * @param callback 结果回调函数，参数1=成功结果，参数2=错误结果
     */
    uiComplete: function (callback) {
        if(!window.cefQuery) return;

        window.cefQuery({
            request: "cmd:uiComplete",
            onSuccess: function (response) {
                callback(response);
            },
            onFailure: function (response) {
                callback(null, response);
            }
        });

    },

    /**
     * 通知浏览器关闭界面
     */
    uiExit: function () {
        if(!window.cefQuery) return;

        window.cefQuery({
            request: "cmd:uiExit",
            onSuccess: function (response) {
                callback(response);
            },
            onFailure: function (response) {
                callback(null, response);
            }
        });

    },

    /**
     * 导出附件文件
     * @param fileName 要导出的默认文件名
     * @param callback 结果回调函数，参数1=成功结果，参数2=错误结果
     */
    exportAttachment: function (fileName, callback) {
        if(!window.cefQuery) return;

        window.cefQuery({
            request: "cmd:exportFile$$" + fileName,
            onSuccess: function (response) {
                callback(response);
            },
            onFailure: function (response) {
                callback(null, response);
            }
        });

    },

    /**
     * 调用OS默认的关联程序打开文件
     * @param filePath 要打开的文件绝对路径
     * @param callback 结果回调函数，参数1=成功结果，参数2=错误结果
     */
    openAttachment: function (filePath, callback) {
        if(!window.cefQuery) return;

        window.cefQuery({
            request: "cmd:openFile$$" + filePath,
            onSuccess: function (response) {
                callback(response);
            },
            onFailure: function (response) {
                callback(null, response);
            }
        });

    }
};