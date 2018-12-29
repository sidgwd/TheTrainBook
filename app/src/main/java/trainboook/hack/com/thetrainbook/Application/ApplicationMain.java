package trainboook.hack.com.thetrainbook.Application;

import android.app.Application;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatDelegate;

import trainboook.hack.com.thetrainbook.R;
import trainboook.hack.com.thetrainbook.Util.AppConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by SID on 25-Mar-18.
 */

public class ApplicationMain extends Application {
  public static  Typeface TYPEFACE_FONT_REGULAR,TYPEFACE_FONT_LIGHT;

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(AppConfig.APP_FONT_LIGHT)
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        //Added Creash Analytics by siddhesh
        TYPEFACE_FONT_REGULAR = Typeface.createFromAsset(this.getAssets(), "" + AppConfig.APP_FONT_REGULAR);
        TYPEFACE_FONT_LIGHT = Typeface.createFromAsset(this.getAssets(), "" + AppConfig.APP_FONT_LIGHT);

    }
}
