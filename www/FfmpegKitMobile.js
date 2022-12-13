module.exports = {
  exec: function (cmd, successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "FfmpegKitMobile", "exec", [cmd]);
  },
};
