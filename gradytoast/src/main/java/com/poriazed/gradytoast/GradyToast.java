package com.poriazed.gradytoast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 *  Created by PoriaZed.
 *
 */
public class GradyToast {

    private static final String TAG = "GradyToast";

    private static GradyToast grady;
    private Context context;

    // Toast TextView
    private String  message;
    private int     messageSize = 14;
    private String  messageColor = "#ffffff";
    private String  customMessageColor = "#ffffff";
    private int     typefaceStyle       = Typeface.BOLD;
    private int     messageGravity = Gravity.CENTER;
    private String  typefaceString      = "";
    private boolean messageAllCaps      = false;

    // Toast GradyDuration
    private GradyDuration duration;

    // Toast Type (Primary, Success, Error, etc.)
    private GradyType type;

    // Toast Border Stroke Size
    private int strokeSize = 5;

//    private int gradyPosition;

    // Custom Toast Colors
    private String  customStartColor,
                    customEndColor,
                    customStrokeColor;


    public GradyToast() {
    }

    public GradyToast(Context context) {
        this.context = context;
    }

    public GradyToast(Context context, String message) {
        this.context = context;
        this.message = message;
    }

    public GradyToast(Context context, String message, GradyDuration duration) {
        this.context = context;
        this.message = message;
        this.duration = duration;
    }

    public GradyToast(Context context, String message, GradyDuration duration, GradyType type) {
        this.context = context;
        this.message = message;
        this.duration = duration;
        this.type = type;
    }

    public GradyToast with(Context context) {
        this.context = context;
        return this;
    }

    /**
     * Toast Message
     * @param message
     * @return
     */
    public GradyToast setText(String message) {
        this.message = message;
        return this;
    }

    public GradyToast setTextSize(int MessageSize) {
        this.messageSize = MessageSize;
        return this;
    }

    public GradyToast setTextColor(String MessageColor) {
        this.customMessageColor = MessageColor;
        return this;
    }

    public GradyToast setTextStyle(int MessageTypeface) {
        this.typefaceStyle = MessageTypeface;
        return this;
    }

    public GradyToast setTextGravity(int MessageGravity) {
        this.messageGravity = MessageGravity;
        return this;
    }

    public GradyToast setTextAllCaps(boolean MessageAllCaps) {
        this.messageAllCaps = MessageAllCaps;
        return this;
    }

    public GradyToast setDuration(GradyDuration duration) {
        this.duration = duration;
        return this;
    }

    public GradyToast setType(GradyType type) {
        this.type = type;
        return this;
    }

    public GradyToast setGradyStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
        return this;
    }

    public GradyToast setCustomColors(String startColor, String endColor, String strokeColor) {
        this.customStartColor   = startColor;
        this.customEndColor     = endColor;
        this.customStrokeColor  = strokeColor;
        return this;
    }

    public void show() {
        if (context == null){
            Log.d(TAG, "show: Context Can not be null");
            return;
        }

        if (message == null || message.equals("")){
            Log.d(TAG, "show: Context Can not be null");
            return;
        }

        if (duration == null)
            duration = GradyDuration.SHORT;

        final Toast toast = new Toast(context.getApplicationContext());
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.grady_layout, null);

        TextView tv = layout.findViewById(R.id.text);

        tv.setText(message);
        tv.setTextSize(messageSize);
        tv.setTextColor(Color.parseColor(messageColor));
        tv.setGravity(messageGravity);
        tv.setAllCaps(messageAllCaps);

        if (!typefaceString.isEmpty()) {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(),
                    typefaceString);
            tv.setTypeface(typeface);
        }

        prepareShape(type, tv);

        toast.setDuration(duration == GradyDuration.SHORT ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        toast.setView(layout);

        toast.show();
    }


    /**
     * Prepare shape for showing toast (Toast Message Background)
     * @param type  Type of Toast (PRIMARY, SUCCESS, ERROR,...)
     * @param TextView TextView
     */
    private void prepareShape(GradyType type, TextView TextView) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[] {4, 4, 16, 16, 4, 4, 16, 16});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);

        if (type == null)
            type = GradyType.PRIMARY;

        switch (type) {
            case PRIMARY: {
                gradientDrawable.setColors(new int[] {ColorPalette.start_primary_color,
                        ColorPalette.end_primary_color});
                gradientDrawable.setStroke(strokeSize, ColorPalette.stroke_primary_color);
                TextView.setTextColor(Color.parseColor(messageColor));
            }
            break;

            case SUCCESS: {
                gradientDrawable.setColors(new int[] {ColorPalette.start_success_color,
                        ColorPalette.end_success_color});
                gradientDrawable.setStroke(strokeSize, ColorPalette.stroke_success_color);
                TextView.setTextColor(Color.parseColor(messageColor));
            }
            break;

            case ERROR: {
                gradientDrawable.setColors(new int[] {ColorPalette.start_error_color,
                        ColorPalette.end_error_color});
                gradientDrawable.setStroke(strokeSize, ColorPalette.stroke_error_color);
                TextView.setTextColor(Color.parseColor(messageColor));
            }
            break;

            case WARNING: {
                gradientDrawable.setColors(new int[] {ColorPalette.start_warning_color,
                        ColorPalette.end_warning_color});
                gradientDrawable.setStroke(strokeSize, ColorPalette.stroke_warning_color);
                TextView.setTextColor(Color.parseColor(messageColor));
            }
            break;

            case INFO: {
                gradientDrawable.setColors(new int[] {ColorPalette.start_info_color,
                        ColorPalette.end_info_color});
                gradientDrawable.setStroke(strokeSize, ColorPalette.stroke_info_color);
                TextView.setTextColor(Color.parseColor(messageColor));
            }
            break;

            case LIGHT: {
                gradientDrawable.setColors(new int[] {ColorPalette.start_light_color,
                        ColorPalette.end_light_color});
                gradientDrawable.setStroke(strokeSize, ColorPalette.stroke_light_color);
                TextView.setTextColor(Color.parseColor("#232526"));
            }
            break;

            case DARK: {
                gradientDrawable.setColors(new int[] {ColorPalette.start_dark_color,
                        ColorPalette.end_dark_color});
                gradientDrawable.setStroke(strokeSize, ColorPalette.stroke_dark_color);
                TextView.setTextColor(Color.parseColor(messageColor));
            }
            break;


            case CUSTOM: {
                gradientDrawable.setColors(new int[] {Color.parseColor(customEndColor),
                        Color.parseColor(customStartColor)});
                gradientDrawable.setStroke(strokeSize, Color.parseColor(customStrokeColor));
                TextView.setTextColor(Color.parseColor(customMessageColor));
            }
            break;

            default: {
                gradientDrawable.setColors(new int[] {ColorPalette.start_primary_color,
                        ColorPalette.end_primary_color});
                gradientDrawable.setStroke(strokeSize, ColorPalette.start_primary_color);
                TextView.setTextColor(Color.parseColor(messageColor));
            }
            break;

        }

//        TextView.setBackgroundDrawable(gradientDrawable);
        TextView.setBackground(gradientDrawable);
    }


}
