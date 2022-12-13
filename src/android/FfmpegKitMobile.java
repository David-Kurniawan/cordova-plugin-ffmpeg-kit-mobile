package cordova.plugin.ffmpeg.kit.mobile;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import com.arthenica.ffmpegkit.FFmpegKit;
import com.arthenica.ffmpegkit.FFmpegSession;
import com.arthenica.ffmpegkit.FFmpegSessionCompleteCallback;
import com.arthenica.ffmpegkit.ReturnCode;

public class FfmpegKitMobile extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        if (action.equals("exec")) {
            FFmpegKit.executeAsync(data.getString(0), new FFmpegSessionCompleteCallback() {
                @Override
                public void apply(FFmpegSession session) {
                    if (ReturnCode.isSuccess(session.getReturnCode()))
                        callbackContext.success(0);
                    else
                        callbackContext.error(1);
                }
            });
            return true;
        }
        return false;
    }
}
